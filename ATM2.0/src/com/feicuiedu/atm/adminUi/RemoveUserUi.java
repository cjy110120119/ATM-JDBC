package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.document.RemoveUser;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ע���˻�����
 * @author �ܾ���
 *
 */
public class RemoveUserUi {

	private Scanner sca;
	private Properties prop ;
	private String str;
	private String account;
	/**
	 * ע���˻�����
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
			//��ѯ�˻��Ƿ����
			if(!(list == null || list.isEmpty())){
				
				break;
			}else{
				
				str = prop.getProperty("a3");
				System.out.println(str);
			}
		}
		RemoveUser ru = new RemoveUser();
		//�����Ƿ�ɹ�
		if(ru.removeUser(account)){
		 
			str = prop.getProperty("a23");
			System.out.println(str);
			
		}else{	
			
			str = prop.getProperty("a24");
			System.out.println(str);
		}

		

	}
}
