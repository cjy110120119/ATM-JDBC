package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.document.LandDocument;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ����Ա��¼
 * @author �ܾ���
 *
 */
public class AdminLandUi {

	private Properties prop;
	private Scanner sca = new Scanner(System.in);
	private Propertie proper = new Propertie();
	/**
	 * admin��¼
	 */
	public void adminLand() {

		LandDocument landdocument = new LandDocument();// ����LandDocument ����

		String account;
		aa: while (true) {

			
			prop = proper.getProp();// ���÷���
			String str = prop.getProperty("a1");// �������˺�
			System.out.println(str);
			account = sca.next();// �����˺�

			List<Map<String,String>> list = landdocument.accountVerify(account);
			// �жϷ���ֵ�Ƿ�Ϊtrue
			if (!(list == null || list.isEmpty())& account.equals("admin")) {

				while (true) {

					str = prop.getProperty("a2");
					System.out.println(str);
					String password = sca.next();

					// �ж����������ķ���ֵ
					if (landdocument.passwordVerify(password)) {

						// ����ֵΪtrue
						str = prop.getProperty("a4");// ��¼�ɹ�
						System.out.println(str);
						break aa;// ���������ѭ��
					} else {

						// ����ֵΪfalse
						str = prop.getProperty("a5");// �������,����������
						System.out.println(str);
					}
				}
			} else {
				// ����ֵΪfalse
				str = prop.getProperty("a3");// �޴��û�
				System.out.println(str);
			}
		}
	}

	

	/**
	 * admin�˵�
	 */
	public void menu() {

		String str;
		String input;
		while (true) {

			prop = proper.getProp();// ���÷���
			str = prop.getProperty("a6");
			System.out.println(str);
			input = sca.next();

			if ("1".equals(input)) {//����

				OperationUserUi ouu = new OperationUserUi();
				ouu.openUser();
			} else if ("2".equals(input)) {//����

				RemoveUserUi ruu = new RemoveUserUi();
				ruu.removeUser();
			} else if ("3".equals(input)) {//��ѯ��ͨ�û�

				SearchUserUi suu = new SearchUserUi();
				suu.seachUser();
			} else if ("4".equals(input)) {//��ѯ�������˻�

				SearchRemoveUserUi sruu = new SearchRemoveUserUi();
				sruu.searchRemove();
			} else if ("5".equals(input)) {//��ѯ�������˻�

				SearchLockUserUi sluu = new SearchLockUserUi();
				sluu.searchLockUser();
			} else if ("6".equals(input)) {//�����˻�

				RelieveLockUserUi rluu = new RelieveLockUserUi();
				rluu.RelieveLock();
			} else if ("7".equals(input)) {//�޸�����

				ResetPasswordUi rpu = new ResetPasswordUi();
				rpu.resetPassword();
			} else if ("8".equals(input)) {//�˳�

				break;
			}else{
				
				str = prop.getProperty("a17");
				System.out.println(str);
			}
		}
	}
}

