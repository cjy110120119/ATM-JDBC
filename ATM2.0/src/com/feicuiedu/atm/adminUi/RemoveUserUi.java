package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.document.RemoveUser;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 注销账户界面
 * @author 曹景玉
 *
 */
public class RemoveUserUi {

	private Scanner sca;
	private Properties prop ;
	private String str;
	private String account;
	/**
	 * 注销账户方法
	 */
	public void removeUser(){

		sca = new Scanner(System.in);
		Propertie proper = new Propertie();
		prop = proper.getProp();
		
		
		while(true){
			str = prop.getProperty("a1");
			System.out.println(str);
		    account = sca.next();
			
			LandDocument ld = new LandDocument();
			List<Map<String,String>> list = ld.accountVerify(account);
			//查询账户是否存在
			if(!(list == null || list.isEmpty())){
				
				break;
			}else{
				
				str = prop.getProperty("a3");
				System.out.println(str);
			}
		}
		RemoveUser ru = new RemoveUser();
		//销户是否成功
		if(ru.removeUser(account)){
		 
			str = prop.getProperty("a23");
			System.out.println(str);
			
		}else{	
			
			str = prop.getProperty("a24");
			System.out.println(str);
		}

		

	}
}
