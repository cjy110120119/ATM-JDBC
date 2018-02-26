package com.feicuiedu.atm.userDocument;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 转账业务
 * 
 * @author 曹景玉
 *
 */
public class TransMoney {

	private Propertie proper = new Propertie();
	private Properties prop;
	private String str_amo;
	private String str_tamo;

	private double before_amount;// 转账前余额
	private double after_amount;// 转账后余额
	private double after_tamount;// 转账后对方账户余额

	/**
	 * 转账方法
	 * 
	 * @param account
	 *            用户登录的账户
	 * @param taccount
	 *            要转账的目标账户
	 * @param balance
	 *            转账金额
	 * @return
	 */
	public boolean transMoney(String account, String taccount, double balance) {

		prop = proper.getProp();

		String sql = prop.getProperty("queryamount");
		HandleDatabase hdb = new HandleDatabase();
		// 先取出当前账户的余额
		List<Map<String, String>> list = hdb.queryData(sql, account);
		Double amo = 0.0;
		if (!(list == null || list.isEmpty())) {
			amo = Double.valueOf(list.get(0).get("amount"));
			before_amount = amo;
		}
		if (amo >= balance) {

			amo = amo - balance;
			after_amount = amo;
			str_amo = Double.toString(amo);
		} else {

			return false;
		}
		// 取出对方账户
		sql = prop.getProperty("queryamount");
		List<Map<String, String>> tlist = hdb.queryData(sql, taccount);
		Double tamo = 0.0;
		if (!(tlist == null || tlist.isEmpty())) {

			tamo = Double.valueOf(tlist.get(0).get("amount"));
			tamo = tamo + balance;
			after_tamount = tamo;
			str_tamo = Double.toString(tamo);
		}

		// 更改user_表中的值
		sql = prop.getProperty("updateamount");
		int input = hdb.connectDatabase(sql, str_amo, account);

		sql = prop.getProperty("updateamount");
		int input2 = hdb.connectDatabase(sql, str_tamo, taccount);

		if (input != 0 && input2 != 0) {

			// 向记录表中插入数据
			Date time = new Date();
			sql = prop.getProperty("insertrecord");
			hdb.insertRecode(sql, account, time, 3, -balance, taccount, before_amount, after_amount);

			if (hdb.insertRecode(sql, taccount, time, 4, balance, account, tamo, after_tamount)) {

				return true;
			}
			
		}
		return false;
	}
}
