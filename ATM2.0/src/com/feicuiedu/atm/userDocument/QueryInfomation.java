package com.feicuiedu.atm.userDocument;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ��ѯҵ���¼
 * @author �ܾ���
 *
 */
public class QueryInfomation {

	private Propertie proper = new Propertie();
	private Properties prop;
	private List<Map<String,String>> list;
	
	/**
	 * ��ѯ��¼
	 * @param input ״̬��(1.������Ϣ   2.��¼��Ϣ)
	 * @param account
	 * @return
	 */
	public List<Map<String,String>> queryInfomation(int input,String account){

		prop = proper.getProp();
		HandleDatabase hdb = new HandleDatabase();
		String sql = null ;
		if(input == 1){
			
			sql = prop.getProperty("query");
			list = hdb.queryData(sql,account,account);
		}else{
			
			sql = prop.getProperty("queryrecord");
			list = hdb.queryData(sql,account);
		}
		
		return list;
	}

}
