package com.feicuiedu.atm.handleData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �������ݿ�
 * 
 * @author �ܾ���
 *
 */
public class HandleDatabase {

	/**
	 * ����=����,����,
	 * 
	 * @param sql
	 *            �����sql���
	 * @param args
	 *            ����Ĳ���
	 * @return ����intֵ,Ӱ���˼���
	 */
	public int  connectDatabase(String sql, String... args) {

		Connection conn = null;
		try {
			// ע������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// ��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt;
		try {
			// �õ�ִ��SQL����Statement����
			stmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {

				stmt.setString(i + 1, args[i]);
			}
			// ִ��SQL���, ���ؽ��
			
			
				//int input =	stmt.executeUpdate();
				
				return stmt.executeUpdate();
				
				
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	/**
	 * ��ѯ����,�������ж�,�˺�����,Ҳ�����ڲ�ѯ�˻�
	 * 
	 * @param sql
	 *            ����Ĳ�ѯ���
	 * @param args
	 *            ����
	 * @return ����list ����
	 */
	public List<Map<String, String>> queryData(String sql, String... args) {

		Connection conn = null;
		ResultSet set = null;
		List<Map<String, String>> list = new ArrayList<>();
		try {
			// ע������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// ��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null ;
		try {
			// �õ�ִ��SQL����Statement����
			stmt = conn.prepareStatement(sql);
			// ��sql�����?�ĸ���
			for (int i = 0; i < args.length; i++) {

				stmt.setString(i + 1, args[i]);
			}
			// ���ؽ����
			set = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (set.next()) {
				// ���������map��
				Map<String, String> map = new HashMap<>();
				for (int i = 0; i < set.getMetaData().getColumnCount(); i++) {
					String column = set.getMetaData().getColumnName(i + 1);
					String value = set.getString(column);
					map.put(column, value);
				}
				// ��map��ӵ�������
				list.add(map);
			}

			set.close();
			stmt.close();
		  conn.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// ���ؼ���list
		return list;
	}

	/**
	 * ��ѯ���userid
	 */
	public int queryMaxId(String sql) {

		Connection conn = null;
		ResultSet set = null;
		try {
			// ע������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// ��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt;

		try {
			// �õ�ִ��SQL����Statement����
			stmt = conn.prepareStatement(sql);
			
			set = stmt.executeQuery();
			while (set.next()) {

				int maxid = set.getInt("max(userid)");
				return maxid;
			}
			
			stmt.close();
			set.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	/**
	 * ������� ��������
	 */
	public boolean insertDatabase(String sql, int maxid, String sex, int state, double amount, Date birthdate,
			String account, String password, String name, String cardid, String address, String remark) {

		Connection conn = null;
		try {
			// ע������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// ��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt;

		try {
			// �õ�ִ��SQL����Statement����
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,maxid);
			stmt.setString(2, sex); 
			stmt.setInt(3,state); 
			stmt.setDouble(4, amount); 
			stmt.setDate(5,new java.sql.Date(birthdate.getTime())); 
			stmt.setString(6, account); 
			stmt.setString(7, password); 
			stmt.setString(8,name);
			stmt.setString(9,cardid);
			stmt.setString(10,address);
			stmt.setString(11, remark); 
			int result = stmt.executeUpdate();
			if(result != 0){
				
				return true;
			}
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * ���¼���в����¼
	 */
	public boolean insertRecode(String sql,String account,Date time,int type,double amount,String ts_account,double before_amount,double after_amount){
		
		Connection conn = null;
		try {
			// ע������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// ��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt;

		try {
			// �õ�ִ��SQL����Statement����
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,account);
			stmt.setObject(2,time); 
			stmt.setInt(3,type); 
			stmt.setDouble(4, amount); 
			stmt.setString(5, ts_account); 
			stmt.setDouble(6, before_amount); 
			stmt.setDouble(7,after_amount);
			int result = stmt.executeUpdate();
			if(result != 0){
				
				return true;
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
