package com.feicuiedu.atm.document;

import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 重置密码业务
 * @author 曹景玉
 *
 */
public class ResetPasswordDocument {	
	
	private Properties prop;
	
	/**
	 * 重置密码业务
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
