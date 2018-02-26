package com.feicuiedu.atm.userDocument;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * �޸Ľ��
 * @author �ܾ���
 *
 */
public class OperateMoney {

	private Propertie proper = new Propertie();
	private Properties prop;
	// ���²��������ڲ����¼
	private int type;// ҵ������
	private double amount;// ҵ��ִ�б䶯�Ľ��
	private double before_amount;// ҵ��ִ��ǰ�����
	private double after_amount;// ҵ��ִ�к�����

	/**
	 * ��ȡ��ҵ��
	 * 
	 * @param balance
	 *            ����Ľ��
	 * @param account
	 *            ������˺�
	 * @param parm
	 *            �����ж��Ǵ���ȡ��,�����û�����
	 * @return true ���ɹ� / false ���ʧ��
	 */
	public boolean operateMoney(double balance, String account, int parm) {

		prop = proper.getProp();
		String sql = prop.getProperty("queryamount");
		HandleDatabase hdb = new HandleDatabase();
		// ����List����,���շ��ص�����,�Ƚ����˻�������ѯ����
		List<Map<String, String>> list = hdb.queryData(sql, account);
		Double amo = 0.0;
		if (!(list == null || list.isEmpty())) {
			amo = Double.valueOf(list.get(0).get("amount"));
			before_amount = amo;// ��¼���е�ҵ��ִ��ǰ�����
		}
		if (parm == 1) {// ���

			amo = amo + balance;
			after_amount = amo;// ��¼���е�ҵ��ִ�к�����
			type = 1;
			amount = balance;
		} else if (parm == 2) {// ȡ��

			type = 2;

			// �жϵ�ǰ����Ƿ����Ҫȡ���Ľ��
			if (amo >= balance) {

				amo = amo - balance;
				after_amount = amo;
				amount = -balance;
			} else {// ��ǰ���С��Ҫȡ���Ľ��

				return false;
			}
		}
		// ���ò������ݿ�ķ���,�������ݿ�����
		String str_amo = Double.toString(amo);
		sql = prop.getProperty("updateamount");
		int input = hdb.connectDatabase(sql, str_amo, account);
		
		//�ж����ݿ��޸��Ƿ�ɹ�
		if (input != 0) {

			//�����ݿ��еļ�¼����Ӽ�¼
			Date time = new Date();
			sql = prop.getProperty("insertrecord");
			
			//�жϲ����Ƿ�ɹ�
			if (hdb.insertRecode(sql, account, time, type, amount, "", before_amount, after_amount)) {

				return true;
			}
		}
		

	
		return false;
	}
}
