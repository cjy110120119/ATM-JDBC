package com.feicuiedu.atm.document;

import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 注销账户业务
 * @author 曹景玉
 *
 */
public class RemoveUser {

	/**
	 * 注销账户
	 * 
	 * @param account
	 *            要注销的账户
	 * @return
	 */
	public boolean removeUser(String account) {

		Properties prop;
		Propertie proper = new Propertie();
		prop = proper.getProp();

		String sql = prop.getProperty("update");

		HandleDatabase hdb = new HandleDatabase();
		int line = hdb.connectDatabase(sql, "2", account);
		if (line == 0) {

			return false;
		}
		return true;
	}
}
