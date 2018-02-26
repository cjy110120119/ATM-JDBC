package com.feicuiedu.atm.userDocument;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 修改金额
 * @author 曹景玉
 *
 */
public class OperateMoney {

	private Propertie proper = new Propertie();
	private Properties prop;
	// 以下参数是用于插入记录
	private int type;// 业务类型
	private double amount;// 业务执行变动的金额
	private double before_amount;// 业务执行前的余额
	private double after_amount;// 业务执行后的余额

	/**
	 * 存取款业务
	 * 
	 * @param balance
	 *            输入的金额
	 * @param account
	 *            传入的账号
	 * @param parm
	 *            用来判断是存款还是取款,不用用户输入
	 * @return true 存款成功 / false 存款失败
	 */
	public boolean operateMoney(double balance, String account, int parm) {

		prop = proper.getProp();
		String sql = prop.getProperty("queryamount");
		HandleDatabase hdb = new HandleDatabase();
		// 创建List集合,接收返回的数据,先将该账户的余额查询出来
		List<Map<String, String>> list = hdb.queryData(sql, account);
		Double amo = 0.0;
		if (!(list == null || list.isEmpty())) {
			amo = Double.valueOf(list.get(0).get("amount"));
			before_amount = amo;// 记录表中的业务执行前的余额
		}
		if (parm == 1) {// 存款

			amo = amo + balance;
			after_amount = amo;// 记录表中的业务执行后的余额
			type = 1;
			amount = balance;
		} else if (parm == 2) {// 取款

			type = 2;

			// 判断当前余额是否大于要取出的金额
			if (amo >= balance) {

				amo = amo - balance;
				after_amount = amo;
				amount = -balance;
			} else {// 当前金额小于要取出的金额

				return false;
			}
		}
		// 调用操作数据库的方法,更改数据库数据
		String str_amo = Double.toString(amo);
		sql = prop.getProperty("updateamount");
		int input = hdb.connectDatabase(sql, str_amo, account);
		
		//判断数据库修改是否成功
		if (input != 0) {

			//向数据库中的记录表添加记录
			Date time = new Date();
			sql = prop.getProperty("insertrecord");
			
			//判断插入是否成功
			if (hdb.insertRecode(sql, account, time, type, amount, "", before_amount, after_amount)) {

				return true;
			}
		}
		

	
		return false;
	}
}
