package com.feicuiedu.atm.document;

import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * �����˻�
 * @author �ܾ���
 *
 */
public class LockUserDocument {

	/**
	 * �û���¼�����������3������
	 * @param account  �û��˻�
	 * @return true ������  false  ����ʧ��
	 */
	public boolean lockUser(String account){
		
		Propertie proper = new Propertie();
		Properties prop = proper.getProp();
		String sql = prop.getProperty("update");
		HandleDatabase hdb = new HandleDatabase();
		int input =  hdb.connectDatabase(sql,"3",account);
		if(input != 0){
			return true;
		}
		
		return false;
		
	}
}
