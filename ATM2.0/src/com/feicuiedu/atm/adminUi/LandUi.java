package com.feicuiedu.atm.adminUi;

import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userUi.UserLandUi;

/**
 * 登录界面
 * 
 * @author 曹景玉
 *
 */
public class LandUi {

	private Propertie proper;
	private Scanner sca = new Scanner(System.in);
	private Properties prop = new Properties();

	/*
	 * 判断是普通用户登录还是管理员登录(1.普通用户登录 2.管理员登录)
	 */
	public void landWay() {

		proper = new Propertie();
		prop = proper.getProp();

		while (true) {

			String str = prop.getProperty("a");// (1.普通用户登录 2.管理员登录)
			System.out.println(str);

			String input = sca.next();

			// 登陆成功,显示操作菜单
			if ("1".equals(input)) {//普通用户登录

				UserLandUi ulu = new UserLandUi();
				ulu.userLand();
				
			} else if ("2".equals(input)) {//管理员登录

				AdminLandUi alu = new AdminLandUi();
				alu.adminLand();
				alu.menu();
			}else {
			
				//输入有误,返回
				str = prop.getProperty("a44");
				System.out.println(str);
			}

		}

	}
}

	