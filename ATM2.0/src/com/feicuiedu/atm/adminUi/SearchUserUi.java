package com.feicuiedu.atm.adminUi;

import java.util.List;
import java.util.Map;

import com.feicuiedu.atm.document.SearchUserDocument;

/**
 * ��ѯ��ͨ�û�
 * @author �ܾ���
 *
 */
public class SearchUserUi {

	/**
	 * ��ѯ����
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

        	  m.put("sex", "��");
          }else if(gender.equals("2")){
        	  
        	  m.put("sex", "Ů");
          }
          for (String k : m.keySet())  
          {  
        	  System.out.println(k + " : " + m.get(k)); 
          } 
           
         
          
      
        }

	}
}
