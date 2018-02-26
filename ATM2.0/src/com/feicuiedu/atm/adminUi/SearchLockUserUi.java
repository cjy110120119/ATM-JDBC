package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;

import com.feicuiedu.atm.document.SearchLockUserDocument;

/**
 * 查询锁定账户界面
 * @author 曹景玉
 *
 */
public class SearchLockUserUi {

	/**
	 * 查询锁定账户
	 */
	public void searchLockUser(){
		
		SearchLockUserDocument slud  = new SearchLockUserDocument();
		List<Map<String,String>> list = slud.searchLockUser();
		

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
			if(sta.equals("3")){
				
				m.put("state", "已锁定");
			}
			for (String k : m.keySet()) {
				System.out.println(k + " : " + m.get(k));
			}

		}
	}
}
