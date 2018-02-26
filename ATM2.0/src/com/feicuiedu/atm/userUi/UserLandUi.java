package com.feicuiedu.atm.userUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.document.LockUserDocument;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 普�?�用户登录界�??
 * @author 曹景�??
 *
 */
public class UserLandUi {


	private Scanner sca = new Scanner(System.in);
	private String str;
	private LandDocument landdocument = new LandDocument();//创建对象
	private Propertie proper = new Propertie();
	private Properties  prop = proper.getProp();
	/**
	 * 普�?�用户登�??
	 */
	public boolean userLand() {

		
		String account;
		
		bb: while (true) {

			str = prop.getProperty("a1");// 请输入账�??
			System.out.println(str);
			account = sca.next();// 输入的账�??

			List<Map<String,String>> list = landdocument.accountVerify(account);
			String state = list.get(0).get("state");
			//验证输入的账号在数据库中是否存在
			if (!(list == null || list.isEmpty()) & !account.equals("admin") & (!"2".equals(state)) & (!"3".equals(state))) {

				
				int count = 0;
				while (true) {

					str = prop.getProperty("a2");
					System.out.println(str);
					String password = sca.next();
					

					// 判断密码是否正确
					if (landdocument.passwordVerify(password)) {

						// 正确,登录成功
						str = prop.getProperty("a4");
						System.out.println(str);
						menu(account);
						break bb;
					} else {

						// 返回值为false
						str = prop.getProperty("a5");//密码错误,重新输入
						System.out.println(str);
						if (count == 2) {

							LockUserDocument lud = new LockUserDocument();
							lud.lockUser(account);
							str = prop.getProperty("a31");
							System.out.println(str);
							return false;
						}
						count++;

					}
				}

			}else if(state.equals("2")){
				
				str = prop.getProperty("a45");
				System.out.println(str);
				
			}else if(state.equals("3")){
				
				str = prop.getProperty("a46");
				System.out.println(str);
			} else{
				
				// 返回值false
				str = prop.getProperty("a3");// 无此用户,重新输入
				System.out.println(str);
			}
			
		}
		return true;

	}
	
	/**
	 * 用户菜单
	 * @param account 传入的普通用户账�??
	 */
	public void menu(String account){

		String input;
		while (true) {

			str = prop.getProperty("a32");
			System.out.println(str);
			input = sca.next();

			if ("1".equals(input)) {//存款

				DepositUi du = new DepositUi();
				du.depositMonry(account);
				
			} else if ("2".equals(input)) {//取款

				WithdrawUi wu = new WithdrawUi();
				wu.withdrawMoney(account);
			} else if ("3".equals(input)) {//转账

				TransMoneyUi tmu = new TransMoneyUi();
				tmu.transMoney(account);
				
			} else if ("4".equals(input)) {//查看个人信息
				
				QueryInfoUi qiu = new QueryInfoUi();
				qiu.queryInfo(account);
				
			} else if ("5".equals(input)) {//�??�??

				break;
			}else{
				
				str = prop.getProperty("a17");
				System.out.println(str);
			}
		}
	}
}
