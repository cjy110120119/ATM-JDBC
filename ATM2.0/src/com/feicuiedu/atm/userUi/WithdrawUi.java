package com.feicuiedu.atm.userUi;

import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userDocument.OperateMoney;

/**
 * 取款页面
 * @author 曹景玉
 *
 */
public class WithdrawUi {

	private Propertie proper = new Propertie();
	private String str;
	private Properties prop;
	private double amount;
	private Scanner sca = new Scanner(System.in);
	
	/**
	 * 取款
	 * @param account  用户登录时所输入的账号
	 */
	public void withdrawMoney(String account){
		
		prop = proper.getProp();
		while(true){
			
			str = prop.getProperty("a35");
			System.out.println(str);
			String input = sca.next();
			
			//判断输入的字符串是否符合要求
			if(!input.matches("^[0-9]{0,}$")){
				
				str = prop.getProperty("a42");
				System.out.println(str);
				
			}else{
				//符合要求,将其转换为double型
				amount = Double.valueOf(input);
				break;
			}
		}
		
        OperateMoney dd = new OperateMoney();
		
        //调用存.取款方法,传入金额,账户,状态码(1.存款   2.取款)
		if(dd.operateMoney(amount,account,2)){
			
			str = prop.getProperty("a36");
			System.out.println(str);
			
		}else{
			
			str = prop.getProperty("a37");
			System.out.println(str);
		}
	}
}
