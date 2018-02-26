package com.feicuiedu.atm.userUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userDocument.TransMoney;

/**
 * 转账界面
 * @author 曹景玉
 *
 */
public class TransMoneyUi {

	private Propertie proper = new Propertie();
	private String str;
	private Properties prop;
	private String amount;
	private String taccount;
	private Scanner sca = new Scanner(System.in);
	/**
	 * 转账方法
	 * @param account 传入的账户(用户登录的账户)
	 */
	public void transMoney(String account){
		
		prop = proper.getProp();
		double balance;
	    while(true){
	    	
	    	str = prop.getProperty("a38");
		    System.out.println(str);
		    taccount = sca.next();
		    
		    LandDocument ld = new LandDocument();
		    List<Map<String,String>> list = ld.accountVerify(taccount);
		    String acco = list.get(0).get("account");
		    //判断对方账户是否存在
		    if(!(list == null || list.isEmpty())){
		    	
		    	str = prop.getProperty("a39");
		    	System.out.println(str);
		    	amount = sca.next();
		    	balance = Double.valueOf(amount);
		    	break;
		    }else if(acco.equals(account)){
		    	
		    	str = prop.getProperty("a47");
		    	System.out.println(str);
		    }else{
		    	
		    	str = prop.getProperty("a3");
		    	System.out.println(str);
		    }
	    }
	    
	    TransMoney tm = new TransMoney();
	    //调用转账方法
	   if( tm.transMoney(account, taccount, balance)){
		   
		   str = prop.getProperty("a40");
		   System.out.println(str);
	   }
		
	}
}
