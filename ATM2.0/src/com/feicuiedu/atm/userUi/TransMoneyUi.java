package com.feicuiedu.atm.userUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userDocument.TransMoney;

/**
 * ת�˽���
 * @author �ܾ���
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
	 * ת�˷���
	 * @param account ������˻�(�û���¼���˻�)
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
		    //�ж϶Է��˻��Ƿ����
		    if(!(list == null || list.isEmpty())){
		    	
		    	str = prop.getProperty("a39");
		    	System.out.println(str);
		    	amount = sca.next();
		    	balance = Double.valueOf(amount);
		    	break;
		    }else{
		    	
		    	str = prop.getProperty("a3");
		    	System.out.println(str);
		    }
	    }
	    
	    TransMoney tm = new TransMoney();
	    //����ת�˷���
	   if( tm.transMoney(account, taccount, balance)){
		   
		   str = prop.getProperty("a40");
		   System.out.println(str);
	   }
		
	}
}
