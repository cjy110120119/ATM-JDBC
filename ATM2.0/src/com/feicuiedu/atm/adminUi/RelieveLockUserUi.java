package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.document.RelieveLockUserDocument;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 解锁账户界面
 * @author 曹景玉
 *
 */
public class RelieveLockUserUi {

	private Properties prop;
	private String str;
	private Scanner sca;
	private String account;
	
	/**
	 * 解锁账户方法
	 */
	public void RelieveLock(){
		
		Propertie proper = new Propertie();
		prop = proper.getProp();
		 while(true){
			 str = prop.getProperty("a1");
			 System.out.println(str);
			 sca = new Scanner(System.in);
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
		 RelieveLockUserDocument rlud = new RelieveLockUserDocument();
		 if(rlud.relieveLock(account)){
			 
			 str = prop.getProperty("a26");
			 System.out.println(str);
		 }else{
			 
			 str = prop.getProperty("a27");
			 System.out.println(str);
		 }
	}
}
