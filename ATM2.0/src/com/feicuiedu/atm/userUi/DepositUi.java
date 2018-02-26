package com.feicuiedu.atm.userUi;

import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userDocument.OperateMoney;

/**
 * 存款页面
 * @author 曹景玉
 *
 */
public class DepositUi {

	private Propertie proper = new Propertie();
	private String str;
	private Properties prop;
	private String amo;
	private Scanner sca = new Scanner(System.in);
	
	/**
	 * 存款方法
	 * @param account 账户登录时输入的账号
	 */
	public void depositMonry(String account){
		
		prop = proper.getProp();
		str = prop.getProperty("a33");
		System.out.println(str);
		amo = sca.next();
		
		OperateMoney dd = new OperateMoney();
		Double amount = Double.valueOf(amo);
		//传入金额,账户,还有状态(即存款还是取款,存款为1,取款为2)
		if(dd.operateMoney(amount,account,1)){
			
			str = prop.getProperty("a34");
			System.out.println(str);
			
		}
		
	}
}
