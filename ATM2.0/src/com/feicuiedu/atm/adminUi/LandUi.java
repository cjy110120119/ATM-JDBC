package com.feicuiedu.atm.adminUi;

import java.util.Properties;
import java.util.Scanner;

import com.feicuiedu.atm.tool.Propertie;
import com.feicuiedu.atm.userUi.UserLandUi;

/**
 * ��¼����
 * 
 * @author �ܾ���
 *
 */
public class LandUi {

	private Propertie proper;
	private Scanner sca = new Scanner(System.in);
	private Properties prop = new Properties();

	/*
	 * �ж�����ͨ�û���¼���ǹ���Ա��¼(1.��ͨ�û���¼ 2.����Ա��¼)
	 */
	public void landWay() {

		proper = new Propertie();
		prop = proper.getProp();

		while (true) {

			String str = prop.getProperty("a");// (1.��ͨ�û���¼ 2.����Ա��¼)
			System.out.println(str);

			String input = sca.next();

			// ��½�ɹ�,��ʾ�����˵�
			if ("1".equals(input)) {//��ͨ�û���¼

				UserLandUi ulu = new UserLandUi();
				ulu.userLand();
				
			} else if ("2".equals(input)) {//����Ա��¼

				AdminLandUi alu = new AdminLandUi();
				alu.adminLand();
				alu.menu();
			}else {
			
				//��������,����
				str = prop.getProperty("a44");
				System.out.println(str);
			}

		}

	}
}

	