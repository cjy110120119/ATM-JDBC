package com.feicuiedu.atm.userUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userDocument.QueryInfomation;

/**
 * 查看个人信息
 * @author 曹景玉
 *
 */
public class QueryInfoUi {

	private Propertie proper = new Propertie();
	private Properties prop;
	private String str;
	private Scanner sca = new Scanner(System.in);
	
	/**
	 * 查询方法
	 * @param acco  当前用户账户
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
				
				sex = "男";
			}else if("2".equals(sex)){
				
				sex = "女";
			}
			String state = list.get(0).get("state");
			
			if("1".equals(state)){
				
				state = "正常";
			}else if("2".equals(state)){
				
				state = "已销户";
			}else if("3".equals(state)){
				
				state = "已锁定";
			}
			
			System.out.println("编号 :"+userid);
			System.out.println("账户名 :"+account);
			System.out.println("密码 :"+password);
			System.out.println("开户名 :"+name);
			System.out.println("性别 :"+sex);
			System.out.println("身份证号 :"+cardid);
			System.out.println("地址 :"+address);
			System.out.println("生日 :"+birthday);
			System.out.println("账户余额 :"+amount);
			System.out.println("当前状态 :"+state);
			System.out.println("备注 :"+remark);
			
			
		}else{
			

			list = qi.queryInfomation(2, acco);
			System.out.println(list);
		}
		
	}
}
