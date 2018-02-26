package com.feicuiedu.atm.document;

import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 解除锁定账户
 * @author 曹景玉
 *
 */
public class RelieveLockUserDocument {

	/**
	 * 解除锁定账户
	 * @param account  要解除锁定的账户
	 * @return true  解锁成功  false  解锁失败
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
