package com.feicuiedu.atm.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 查询锁定账户业务
 * @author 曹景玉
 *
 */
public class SearchLockUserDocument {

	/**
	 * 查询锁定账户业务
	 * @return list
	 */
	public List<Map<String,String>> searchLockUser(){
		
		Propertie proper = new Propertie();
		Properties prop = proper.getProp();
		String sql = prop.getProperty("queryuser");
		HandleDatabase hdb = new HandleDatabase();
		sql = sql.replaceAll("@", "userid,name,cardid,sex,account,amount,state");
		List<Map<String,String>> list = hdb.queryData(sql,"3");
		return list;
	}
}
