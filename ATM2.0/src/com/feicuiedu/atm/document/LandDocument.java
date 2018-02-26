package com.feicuiedu.atm.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ��¼ҵ��
 * @author �ܾ���
 *
 */
public class LandDocument {
	

	private static Properties prop;
	private static List<Map<String, String>> list;//�˺��ж���ȷ��ʹ��
	
	/**
	 * �ж�������˺��Ƿ����,���ڷ���true,���򷵻�false
	 * @param account  ������˻�
	 * @return true/false
	 */
	public List<Map<String, String>> accountVerify(String account){
		
		
		Propertie proper = new Propertie();
		prop = proper.getProp();
		
		String sql = prop.getProperty("query");//sql���
		
		//����HandleDatabase����
		HandleDatabase db = new HandleDatabase();
		//���÷���,����sql���,account,���� ���֤��(��ͨ�û��������֤�ŵ�¼)
		list = db.queryData(sql, account, account);
		
	    return list;	
	}
	/**
	 * �ж���������������ݿ��и��˻��������Ƿ���ȫ��ͬ
	 * @param password  ���������
	 * @return true/false
	 */
	public boolean passwordVerify(String password){
		
		if(password.equals(list.get(0).get("password"))){
			//������ͬ,����true
			return true;
		}else{
			//���벻ͬ,����false
			return false;
		}
	}
}
