package com.feicuiedu.atm.document;

import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 锁定账户
 * @author 曹景玉
 *
 */
public class LockUserDocument {

	/**
	 * 用户登录输入密码错误3次锁定
	 * @param account  用户账户
	 * @return true 已锁定  false  锁定失败
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
