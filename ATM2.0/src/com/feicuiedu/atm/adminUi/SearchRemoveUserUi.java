package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;

import com.feicuiedu.atm.document.SearchRemoveUserDocument;

/**
 * ��ѯ����������
 * 
 * @author �ܾ���
 *
 */
public class SearchRemoveUserUi {

	/**
	 * ��ѯ�������˻�
	 */
	public void searchRemove() {

		SearchRemoveUserDocument srud = new SearchRemoveUserDocument();
		List<Map<String, String>> list = srud.scarchRemoveDocument();
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
			if(sta.equals("2")){
				
				m.put("state", "������");
			}
			for (String k : m.keySet()) {
				System.out.println(k + " : " + m.get(k));
			}

		}
	}

}
