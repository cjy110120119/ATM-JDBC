package com.feicuiedu.atm.userDocument;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ת��ҵ��
 * 
 * @author �ܾ���
 *
 */
public class TransMoney {

	private Propertie proper = new Propertie();
	private Properties prop;
	private String str_amo;
	private String str_tamo;

	private double before_amount;// ת��ǰ���
	private double after_amount;// ת�˺����
	private double after_tamount;// ת�˺�Է��˻����

	/**
	 * ת�˷���
	 * 
	 * @param account
	 *            �û���¼���˻�
	 * @param taccount
	 *            Ҫת�˵�Ŀ���˻�
	 * @param balance
	 *            ת�˽��
	 * @return
	 */
	public boolean transMoney(String account, String taccount, double balance) {

		prop = proper.getProp();

		String sql = prop.getProperty("queryamount");
		HandleDatabase hdb = new HandleDatabase();
		// ��ȡ����ǰ�˻������
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
		// ȡ���Է��˻�
		sql = prop.getProperty("queryamount");
		List<Map<String, String>> tlist = hdb.queryData(sql, taccount);
		Double tamo = 0.0;
		if (!(tlist == null || tlist.isEmpty())) {

			tamo = Double.valueOf(tlist.get(0).get("amount"));
			tamo = tamo + balance;
			after_tamount = tamo;
			str_tamo = Double.toString(tamo);
		}

		// ����user_���е�ֵ
		sql = prop.getProperty("updateamount");
		int input = hdb.connectDatabase(sql, str_amo, account);

		sql = prop.getProperty("updateamount");
		int input2 = hdb.connectDatabase(sql, str_tamo, taccount);

		if (input != 0 && input2 != 0) {

			// ���¼���в�������
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
