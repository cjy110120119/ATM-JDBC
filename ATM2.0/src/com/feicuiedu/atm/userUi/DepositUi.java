package com.feicuiedu.atm.userUi;

import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userDocument.OperateMoney;

/**
 * ���ҳ��
 * @author �ܾ���
 *
 */
public class DepositUi {

	private Propertie proper = new Propertie();
	private String str;
	private Properties prop;
	private String amo;
	private Scanner sca = new Scanner(System.in);
	
	/**
	 * ����
	 * @param account �˻���¼ʱ������˺�
	 */
	public void depositMonry(String account){
		
		prop = proper.getProp();
		str = prop.getProperty("a33");
		System.out.println(str);
		amo = sca.next();
		
		OperateMoney dd = new OperateMoney();
		Double amount = Double.valueOf(amo);
		//������,�˻�,����״̬(������ȡ��,���Ϊ1,ȡ��Ϊ2)
		if(dd.operateMoney(amount,account,1)){
			
			str = prop.getProperty("a34");
			System.out.println(str);
			
		}
		
	}
}
