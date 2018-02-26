package com.feicuiedu.atm.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 登录业务
 * @author 曹景玉
 *
 */
public class LandDocument {
	

	private static Properties prop;
	private static List<Map<String, String>> list;//账号判断正确后使用
	
	/**
	 * 判断输入的账号是否存在,存在返回true,否则返回false
	 * @param account  输入的账户
	 * @return true/false
	 */
	public List<Map<String, String>> accountVerify(String account){
		
		
		Propertie proper = new Propertie();
		prop = proper.getProp();
		
		String sql = prop.getProperty("query");//sql语句
		
		//创建HandleDatabase对象
		HandleDatabase db = new HandleDatabase();
		//调用方法,传入sql语句,account,或者 身份证号(普通用户可用身份证号登录)
		list = db.queryData(sql, account, account);
		
	    return list;	
	}
	/**
	 * 判断输入的密码与数据库中该账户的密码是否完全相同
	 * @param password  输入的密码
	 * @return true/false
	 */
	public boolean passwordVerify(String password){
		
		if(password.equals(list.get(0).get("password"))){
			//密码相同,返回true
			return true;
		}else{
			//密码不同,返回false
			return false;
		}
	}
}
