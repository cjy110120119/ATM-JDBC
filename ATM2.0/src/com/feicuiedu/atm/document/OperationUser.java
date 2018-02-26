package com.feicuiedu.atm.document;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ����
 * 
 * @author �ܾ���
 *
 */
public class OperationUser {

	private Propertie proper;
	private Properties prop;
	private HandleDatabase hdb;
	/**
	 * �ж����֤���Ƿ������ݿ��д���
	 * 
	 * @param cardid
	 * @return
	 */
	public boolean cardExist(String cardid) {

		LandDocument ld = new LandDocument();
		List<Map<String,String>> list = ld.accountVerify(cardid);
		if (!(list == null || list.isEmpty())) {

			return false;
		} else {

			return true;

		}
	}

	/**
	 * ���� �����ݿ��в�������
	 * 
	 * @param sex
	 *            ���� �Ա�
	 * @param amount
	 *            ���� ���
	 * @param birthdate
	 *            ���� ��������
	 * @param args
	 *            String���͵Ĳ���
	 * @return
	 */
	public boolean openBusiness(String sex, int state, Double amount, Date birthdate, String account, String password,
			String name, String cardid, String address, String remark) {
		
		proper = new Propertie();
		prop = proper.getProp();
		int maxid = queryId()+1;
		
		String sql = prop.getProperty("insert");
		
		hdb = new HandleDatabase();
		boolean bln  =hdb.insertDatabase(sql, maxid,sex,state,amount,birthdate,account,password,name,cardid,address,remark);
		if(bln){
			
			return true;
		}
		return false;
		
	}
	/**
	 * ����id�����ֵ
	 */
	public int queryId() {

		proper = new Propertie();
		prop = proper.getProp();
		String sql = prop.getProperty("maxid");
		
		hdb = new HandleDatabase();
		
		int maxid = hdb.queryMaxId(sql);
		
		return maxid;

	}

}
