package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;

import com.feicuiedu.atm.document.SearchLockUserDocument;

/**
 * ��ѯ�����˻�����
 * @author �ܾ���
 *
 */
public class SearchLockUserUi {

	/**
	 * ��ѯ�����˻�
	 */
	public void searchLockUser(){
		
		SearchLockUserDocument slud  = new SearchLockUserDocument();
		List<Map<String,String>> list = slud.searchLockUser();
		

		for (Map<String, String> m : list) {
			for (String k : m.keySet()) {

			}
			String gender = m.get("sex");
			if (gender.equals("1")) {

				m.put("sex", "��");
			} else if (gender.equals("2")) {

				m.put("sex", "Ů");
			}
			
			String sta = m.get("state");
			if(sta.equals("3")){
				
				m.put("state", "������");
			}
			for (String k : m.keySet()) {
				System.out.println(k + " : " + m.get(k));
			}

		}
	}
}
