package com.feicuiedu.atm.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 查询普通账户(没有被锁定的)
 * @author 曹景玉
 *
 */
public class SearchUserDocument {

	private Properties prop;
	/**
	 * 查询普通用户业务
	 * @return  list
	 */
	public List<Map<String,String>> searchDocument(){
		
		Propertie proper = new Propertie();
		prop = proper.getProp();
		
		HandleDatabase hdb = new HandleDatabase();
		String sql = prop.getProperty("queryuser");
		sql = sql.replaceAll("@", "userid,name,cardid,sex,account,amount");
		List<Map<String,String>> list = hdb.queryData(sql, "1");
		
		return list;
		
	} 
}
