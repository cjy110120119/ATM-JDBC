package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;

import com.feicuiedu.atm.document.SearchRemoveUserDocument;

/**
 * 查询已销户界面
 * 
 * @author 曹景玉
 *
 */
public class SearchRemoveUserUi {

	/**
	 * 查询已销户账户
	 */
	public void searchRemove() {

		SearchRemoveUserDocument srud = new SearchRemoveUserDocument();
		List<Map<String, String>> list = srud.scarchRemoveDocument();
		for (Map<String, String> m : list) {
			for (String k : m.keySet()) {

			}
			String gender = m.get("sex");
			if (gender.equals("1")) {

				m.put("sex", "男");
			} else if (gender.equals("2")) {

				m.put("sex", "女");
			}
			String sta = m.get("state");
			if(sta.equals("2")){
				
				m.put("state", "已销户");
			}
			for (String k : m.keySet()) {
				System.out.println(k + " : " + m.get(k));
			}

		}
	}

}
