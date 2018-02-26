package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.document.ResetPasswordDocument;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 重置密码界面
 * @author 曹景玉
 *
 */
public class ResetPasswordUi {

	private Properties prop;
	private Scanner sca = new Scanner(System.in);
	private String str;
	private String account;
	
	/**
	 * 重置密码方法
	 */
	public void resetPassword(){
		
		
		Propertie proper = new Propertie();
	    prop = proper.getProp();
	  while(true){
		  
		  str = prop.getProperty("a1");
			System.out.println(str);
		    account = sca.next();
			LandDocument ld = new LandDocument();
			List<Map<String,String>> list = ld.accountVerify(account);
			if(!(list == null || list.isEmpty())){
			
				break;
			}else{
				
				 str = prop.getProperty("a3");
				 System.out.println(str);
			}
	  }
		
		str = prop.getProperty("a28");
		System.out.println(str);
		String password = sca.next();
		
		ResetPasswordDocument rpd = new ResetPasswordDocument();
		if(rpd.ResetPasswprd(password,account)){
			
			str =prop.getProperty("a29");
			System.out.println(str);
		}else{
			
			str = prop.getProperty("a30");
			System.out.println(str);
		}
	}
	
}
