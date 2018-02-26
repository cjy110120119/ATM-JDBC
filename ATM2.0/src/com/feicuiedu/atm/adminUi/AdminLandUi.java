package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 管理员登录
 * @author 曹景玉
 *
 */
public class AdminLandUi {

	private Properties prop;
	private Scanner sca = new Scanner(System.in);
	private Propertie proper = new Propertie();
	/**
	 * admin登录
	 */
	public void adminLand() {

		LandDocument landdocument = new LandDocument();// 创建LandDocument 对象

		String account;
		aa: while (true) {

			
			prop = proper.getProp();// 调用方法
			String str = prop.getProperty("a1");// 请输入账号
			System.out.println(str);
			account = sca.next();// 接收账号

			List<Map<String,String>> list = landdocument.accountVerify(account);
			// 判断返回值是否为true
			if (!(list == null || list.isEmpty())& account.equals("admin")) {

				while (true) {

					str = prop.getProperty("a2");
					System.out.println(str);
					String password = sca.next();

					// 判断输入密码后的返回值
					if (landdocument.passwordVerify(password)) {

						// 返回值为true
						str = prop.getProperty("a4");// 登录成功
						System.out.println(str);
						break aa;// 跳出最外层循环
					} else {

						// 返回值为false
						str = prop.getProperty("a5");// 密码错误,请重新输入
						System.out.println(str);
					}
				}
			} else {
				// 返回值为false
				str = prop.getProperty("a3");// 无此用户
				System.out.println(str);
			}
		}
	}

	

	/**
	 * admin菜单
	 */
	public void menu() {

		String str;
		String input;
		while (true) {

			prop = proper.getProp();// 调用方法
			str = prop.getProperty("a6");
			System.out.println(str);
			input = sca.next();

			if ("1".equals(input)) {//开户

				OperationUserUi ouu = new OperationUserUi();
				ouu.openUser();
			} else if ("2".equals(input)) {//销户

				RemoveUserUi ruu = new RemoveUserUi();
				ruu.removeUser();
			} else if ("3".equals(input)) {//查询普通用户

				SearchUserUi suu = new SearchUserUi();
				suu.seachUser();
			} else if ("4".equals(input)) {//查询已销户账户

				SearchRemoveUserUi sruu = new SearchRemoveUserUi();
				sruu.searchRemove();
			} else if ("5".equals(input)) {//查询已锁定账户

				SearchLockUserUi sluu = new SearchLockUserUi();
				sluu.searchLockUser();
			} else if ("6".equals(input)) {//解锁账户

				RelieveLockUserUi rluu = new RelieveLockUserUi();
				rluu.RelieveLock();
			} else if ("7".equals(input)) {//修改密码

				ResetPasswordUi rpu = new ResetPasswordUi();
				rpu.resetPassword();
			} else if ("8".equals(input)) {//退出

				break;
			}else{
				
				str = prop.getProperty("a17");
				System.out.println(str);
			}
		}
	}
}

