package com.feicuiedu.atm.userDocument;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 查询业务记录
 * @author 曹景玉
 *
 */
public class QueryInfomation {

	private Propertie proper = new Propertie();
	private Properties prop;
	private List<Map<String,String>> list;
	
	/**
	 * 查询记录
	 * @param input 状态码(1.开户信息   2.记录信息)
	 * @param account
	 * @return
	 */
	public List<Map<String,String>> queryInfomation(int input,String account){

		prop = proper.getProp();
		HandleDatabase hdb = new HandleDatabase();
		String sql = null ;
		if(input == 1){
			
			sql = prop.getProperty("query");
			list = hdb.queryData(sql,account,account);
		}else{
			
			sql = prop.getProperty("queryrecord");
			list = hdb.queryData(sql,account);
		}
		
		return list;
	}

}
