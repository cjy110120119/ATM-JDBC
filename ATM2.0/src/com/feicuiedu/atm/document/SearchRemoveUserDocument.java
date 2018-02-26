package com.feicuiedu.atm.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 查询已销户账户业务
 * @author 曹景玉
 *
 */
public class SearchRemoveUserDocument {

	/**
	 * 查询方法
	 * @return list
	 */
	public List<Map<String,String>> scarchRemoveDocument(){
		
		Propertie proper = new Propertie();
		Properties prop = proper.getProp();
		String sql = prop.getProperty("queryuser");
		HandleDatabase hdb = new HandleDatabase();
		sql = sql.replaceAll("@", "userid,name,cardid,sex,account,amount,state");
		List<Map<String,String>> list = hdb.queryData(sql,"2");
		return list;
	}
	
}
