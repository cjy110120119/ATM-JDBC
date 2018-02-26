package com.feicuiedu.atm.document;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.feicuiedu.atm.handleData.HandleDatabase;
import com.feicuiedu.atm.tool.Propertie;

/**
 * 开户
 * 
 * @author 曹景玉
 *
 */
public class OperationUser {

	private Propertie proper;
	private Properties prop;
	private HandleDatabase hdb;
	/**
	 * 判断身份证号是否在数据库中存在
	 * 
	 * @param cardid
	 * @return
	 */
	public boolean cardExist(String cardid) {

		LandDocument ld = new LandDocument();
		List<Map<String,String>> list = ld.accountVerify(cardid);
		if (!(list == null || list.isEmpty())) {

			return false;
		} else {

			return true;

		}
	}

	/**
	 * 开户 向数据库中插入数据
	 * 
	 * @param sex
	 *            参数 性别
	 * @param amount
	 *            参数 余额
	 * @param birthdate
	 *            参数 出生日期
	 * @param args
	 *            String类型的参数
	 * @return
	 */
	public boolean openBusiness(String sex, int state, Double amount, Date birthdate, String account, String password,
			String name, String cardid, String address, String remark) {
		
		proper = new Propertie();
		prop = proper.getProp();
		int maxid = queryId()+1;
		
		String sql = prop.getProperty("insert");
		
		hdb = new HandleDatabase();
		boolean bln  =hdb.insertDatabase(sql, maxid,sex,state,amount,birthdate,account,password,name,cardid,address,remark);
		if(bln){
			
			return true;
		}
		return false;
		
	}
	/**
	 * 查找id的最大值
	 */
	public int queryId() {

		proper = new Propertie();
		prop = proper.getProp();
		String sql = prop.getProperty("maxid");
		
		hdb = new HandleDatabase();
		
		int maxid = hdb.queryMaxId(sql);
		
		return maxid;

	}

}
