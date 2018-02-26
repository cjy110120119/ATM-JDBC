package com.feicuiedu.atm.adminUi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.OperationUser;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 管理员界面 开户
 * 
 * @author 曹景玉
 *
 */
public class OperationUserUi {
	
	private String input;
	private String str;
	private Scanner sca = new Scanner(System.in);
	private Properties prop;
	private String sex;
	private String birthday;
	private String password;
	private String address;
	private String remark;
	private Date birthdate;
	private String account;
	private String cardid;

	/**
	 * 开户
	 */
	public void openUser() {

		Propertie proper = new Propertie();
		prop = proper.getProp();

		str = prop.getProperty("a7");
		System.out.println(str);

		String name = sca.next();

		// 调用方法判断身份证号是否存在
		while (true) {

			str = prop.getProperty("a8");
			System.out.println(str);
			cardid = sca.next();

			if (cardid.matches("[0-9]{18}")) {

				
				OperationUser ob = new OperationUser();

				//身份证号已存在
				if (ob.cardExist(cardid)) {

					break;
				} else {

					str = prop.getProperty("a16");
					System.out.println(str);
				}
			}else{
				
				str = prop.getProperty("a41");
				System.out.println(str);
			}
			
		}

		/**
		 * 选择性别,(1.男 2.女)
		 */
		while (true) {

			str = prop.getProperty("a9");
			System.out.println(str);

			input = sca.next();
			if ("1".equals(input)) {

				sex = "01";
				break;
			} else if ("2".equals(input)) {

				sex = "02";
				break;
			} else {

				str = prop.getProperty("a17");
				System.out.println(str);
			}
		}

		/**
		 * 出生日期
		 */
		while (true) {

			str = prop.getProperty("a10");
			System.out.println(str);
			birthday = sca.next();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				birthdate = sdf.parse(birthday);
				break;
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		/**
		 * 地址
		 */
		while (true) {

			str = prop.getProperty("a11");
			System.out.println(str);
			address = sca.next();
			if (address.length() <= 50) {
				break;
			} else {

				str = prop.getProperty("a18");
				System.out.println(str);
			}
		}

		/**
		 * 备注
		 */
		while (true) {

			str = prop.getProperty("a12");
			System.out.println(str);
			remark = sca.next();

			if (remark.length() <= 200) {

				break;
			} else {

				str = prop.getProperty("a13");
				System.out.println(str);
			}

		}

		double amount = 0.0;

		// BC18 + 性别(男01:女02) + 出生日期 + 4位随机号

		int rand = (int) ((Math.random() * 9 + 1) * 1000);

		String[] bir = birthday.split("-");
		StringBuilder sb = new StringBuilder();
		for (String s : bir) {

			sb.append(s);
		}
		account = "BC18" + sex + sb.toString() + rand;

		/**
		 * 判断初始密码是否符合
		 */
		while (true) {

			str = prop.getProperty("a14");
			System.out.println(str);

			password = sca.next();
			if (password.matches("[a-z0-9]{6}")) {

			} else {

				str = prop.getProperty("a19");
				System.out.println(str);

			}

			str = prop.getProperty("a15");
			System.out.println(str);

			String password2 = sca.next();

			if (password2.matches("[a-z0-9]{6}") && password.equals(password2)) {

				break;
			} else {

				str = prop.getProperty("a20");
				System.out.println(str);
			}

		}

		int state = 1;

		OperationUser ou = new OperationUser();
		
		if (ou.openBusiness(sex, state, amount, birthdate, account, password, name, cardid, address, remark)) {

			str = prop.getProperty("a21");
			System.out.println(str);
		}
	}
}
