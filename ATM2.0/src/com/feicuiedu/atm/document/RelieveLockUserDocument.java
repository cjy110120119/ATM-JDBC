package com.feicuiedu.atm.document;

import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ��������˻�
 * @author �ܾ���
 *
 */
public class RelieveLockUserDocument {

	/**
	 * ��������˻�
	 * @param account  Ҫ����������˻�
	 * @return true  �����ɹ�  false  ����ʧ��
	 */
	public boolean relieveLock(String account){
		
		Propertie proper = new Propertie();
		Properties prop = proper.getProp();
		String sql = prop.getProperty("update");
		HandleDatabase hdb = new HandleDatabase();
		int input = hdb.connectDatabase(sql,"1",account);
		if(input != 0){
			return true;
		}
			
		return false;
	}
}
