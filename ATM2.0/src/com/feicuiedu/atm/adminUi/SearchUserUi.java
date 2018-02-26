package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;

import com.feicuiedu.atm.document.SearchUserDocument;

/**
 * 查询普通用户
 * @author 曹景玉
 *
 */
public class SearchUserUi {

	/**
	 * 查询方法
	 */
	public void seachUser(){
		
		SearchUserDocument sud = new SearchUserDocument();
		
        List<Map<String,String>> list = sud.searchDocument();
        
        for (Map<String, String> m : list)  
        {  
          for (String k : m.keySet())  
          {  
        	 
          } 
          String gender = m.get("sex");
          if(gender.equals("1")){

        	  m.put("sex", "男");
          }else if(gender.equals("2")){
        	  
        	  m.put("sex", "女");
          }
          for (String k : m.keySet())  
          {  
        	  System.out.println(k + " : " + m.get(k)); 
          } 
           
         
          
      
        }

	}
}
