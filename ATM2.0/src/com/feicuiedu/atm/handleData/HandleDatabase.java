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
 * 操作数据库
 * 
 * @author 曹景玉
 *
 */
public class HandleDatabase {

	/**
	 * 用于=开户,销户,
	 * 
	 * @param sql
	 *            传入的sql语句
	 * @param args
	 *            传入的参数
	 * @return 返回int值,影响了几行
	 */
	public int  connectDatabase(String sql, String... args) {

		Connection conn = null;
		try {
			// 注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// 创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt;
		try {
			// 得到执行SQL语句的Statement对象
			stmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {

				stmt.setString(i + 1, args[i]);
			}
			// 执行SQL语句, 返回结果
			
			
				//int input =	stmt.executeUpdate();
				
				return stmt.executeUpdate();
				
				
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	/**
	 * 查询方法,可用于判断,账号密码,也可用于查询账户
	 * 
	 * @param sql
	 *            传入的查询语句
	 * @param args
	 *            参数
	 * @return 返回list 集合
	 */
	public List<Map<String, String>> queryData(String sql, String... args) {

		Connection conn = null;
		ResultSet set = null;
		List<Map<String, String>> list = new ArrayList<>();
		try {
			// 注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// 创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null ;
		try {
			// 得到执行SQL语句的Statement对象
			stmt = conn.prepareStatement(sql);
			// 看sql语句中?的个数
			for (int i = 0; i < args.length; i++) {

				stmt.setString(i + 1, args[i]);
			}
			// 返回结果集
			set = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (set.next()) {
				// 将结果放入map中
				Map<String, String> map = new HashMap<>();
				for (int i = 0; i < set.getMetaData().getColumnCount(); i++) {
					String column = set.getMetaData().getColumnName(i + 1);
					String value = set.getString(column);
					map.put(column, value);
				}
				// 将map添加到集合中
				list.add(map);
			}

			set.close();
			stmt.close();
		  conn.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// 返回集合list
		return list;
	}

	/**
	 * 查询最大userid
	 */
	public int queryMaxId(String sql) {

		Connection conn = null;
		ResultSet set = null;
		try {
			// 注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// 创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt;

		try {
			// 得到执行SQL语句的Statement对象
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
	 * 开户完成 插入数据
	 */
	public boolean insertDatabase(String sql, int maxid, String sex, int state, double amount, Date birthdate,
			String account, String password, String name, String cardid, String address, String remark) {

		Connection conn = null;
		try {
			// 注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// 创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt;

		try {
			// 得到执行SQL语句的Statement对象
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
	 * 向记录表中插入记录
	 */
	public boolean insertRecode(String sql,String account,Date time,int type,double amount,String ts_account,double before_amount,double after_amount){
		
		Connection conn = null;
		try {
			// 注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// 创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt;

		try {
			// 得到执行SQL语句的Statement对象
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
