package com.feicuiedu.atm.userUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userDocument.QueryInfomation;

/**
 * �鿴������Ϣ
 * @author �ܾ���
 *
 */
public class QueryInfoUi {

	private Propertie proper = new Propertie();
	private Properties prop;
	private String str;
	private Scanner sca = new Scanner(System.in);
	
	/**
	 * ��ѯ����
	 * @param acco  ��ǰ�û��˻�
	 */
	public void queryInfo(String acco){
		
		prop = proper.getProp();
		str = prop.getProperty("a43");
		System.out.println(str);
		int input = sca.nextInt();
		QueryInfomation qi = new QueryInfomation();
		List<Map<String,String>> list;
		if(input == 1){
			
			
			list = qi.queryInfomation(1,acco);	
			String birthday = list.get(0).get("birthday");
			String password = list.get(0).get("password");
			String amount = list.get(0).get("amount");
			String address = list.get(0).get("address");
			String cardid = list.get(0).get("cardid");
			String name = list.get(0).get("name");
			String remark = list.get(0).get("remark");
			String userid = list.get(0).get("userid");
			String account = list.get(0).get("account");
			
			String sex  = list.get(0).get("sex");
			if("1".equals(sex)){
				
				sex = "��";
			}else if("2".equals(sex)){
				
				sex = "Ů";
			}
			String state = list.get(0).get("state");
			
			if("1".equals(state)){
				
				state = "����";
			}else if("2".equals(state)){
				
				state = "������";
			}else if("3".equals(state)){
				
				state = "������";
			}
			
			System.out.println("��� :"+userid);
			System.out.println("�˻��� :"+account);
			System.out.println("���� :"+password);
			System.out.println("������ :"+name);
			System.out.println("�Ա� :"+sex);
			System.out.println("���֤�� :"+cardid);
			System.out.println("��ַ :"+address);
			System.out.println("���� :"+birthday);
			System.out.println("�˻���� :"+amount);
			System.out.println("��ǰ״̬ :"+state);
			System.out.println("��ע :"+remark);
			
			
		}else{
			

			list = qi.queryInfomation(2, acco);
			System.out.println(list);
		}
		
	}
}
