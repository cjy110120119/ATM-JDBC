package com.feicuiedu.atm.document;

import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ��������ҵ��
 * @author �ܾ���
 *
 */
public class ResetPasswordDocument {	
	
	private Properties prop;
	
	/**
	 * ��������ҵ��
	 * @param password
	 * @param account
	 * @return
	 */
	public boolean ResetPasswprd(String password,String account){
		
		Propertie proper = new Propertie();
	    prop = proper.getProp();
		String sql = prop.getProperty("updatepassword");
		HandleDatabase hdb = new HandleDatabase();
		int input =  hdb.connectDatabase(sql,password,account);
	    if(input != 0){
	    	
	    	return true;
	    }
	    return false;
	}
}
