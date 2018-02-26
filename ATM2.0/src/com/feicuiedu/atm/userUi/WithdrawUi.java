package com.feicuiedu.atm.userUi;

import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userDocument.OperateMoney;

/**
 * ȡ��ҳ��
 * @author �ܾ���
 *
 */
public class WithdrawUi {

	private Propertie proper = new Propertie();
	private String str;
	private Properties prop;
	private double amount;
	private Scanner sca = new Scanner(System.in);
	
	/**
	 * ȡ��
	 * @param account  �û���¼ʱ��������˺�
	 */
	public void withdrawMoney(String account){
		
		prop = proper.getProp();
		while(true){
			
			str = prop.getProperty("a35");
			System.out.println(str);
			String input = sca.next();
			
			//�ж�������ַ����Ƿ����Ҫ��
			if(!input.matches("^[0-9]{0,}$")){
				
				str = prop.getProperty("a42");
				System.out.println(str);
				
			}else{
				//����Ҫ��,����ת��Ϊdouble��
				amount = Double.valueOf(input);
				break;
			}
		}
		
        OperateMoney dd = new OperateMoney();
		
        //���ô�.ȡ���,������,�˻�,״̬��(1.���   2.ȡ��)
		if(dd.operateMoney(amount,account,2)){
			
			str = prop.getProperty("a36");
			System.out.println(str);
			
		}else{
			
			str = prop.getProperty("a37");
			System.out.println(str);
		}
	}
}
