package com.feicuiedu.atm.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * ��ѯ�������˻�ҵ��
 * @author �ܾ���
 *
 */
public class SearchRemoveUserDocument {

	/**
	 * ��ѯ����
	 * @return list
	 */
	public List<Map<String,String>> scarchRemoveDocument(){
		
		Propertie proper = new Propertie();
		Properties prop = proper.getProp();
		String sql = prop.getProperty("queryuser");
		HandleDatabase hdb = new HandleDatabase();
		sql = sql.replaceAll("@", "userid,name,cardid,sex,account,amount,state");
		List<Map<String,String>> list = hdb.queryData(sql,"2");
		return list;
	}
	
}
