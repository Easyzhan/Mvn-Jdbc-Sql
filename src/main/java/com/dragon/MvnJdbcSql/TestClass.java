package com.dragon.MvnJdbcSql;

import java.sql.*;
import java.util.*;
import org.junit.Test;

import com.dragon.utils.PropertiesUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestClass {

	@Test
	public void testConnSql() {
		System.out.println("测试方法走起来了");
	}
	

	@Test
	public void readDataFromSqlByJdbc() throws Exception{

	//注册驱动
	DriverManager.registerDriver(new Driver());
	
	//获取链接
	Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/day07", "root", "123");
	
	//编写 sql 语句
	String sql = "select * from category";
	
	//创建语句执行者
	PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
	
	//设置参数
	
	//执行 sql
	ResultSet rSet = statement.executeQuery();
	
	//处理结果
	while (rSet.next()) {
		System.out.println(rSet.getString("cid")+"::"+rSet.getString("cname"));
	}
	//释放资源
	rSet.close();
	statement.close();
	conn.close();
}

	@Test
	public void testProperties() throws Exception {

		Connection connection = (Connection) PropertiesUtils.getConnection();
		String sql = "select * from category";
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet rSet = statement.executeQuery();
		
		JSONArray jArray = new JSONArray();
//		HashMap map = new HashMap();//通常用

		// 获取列数  
		   ResultSetMetaData metaData = rSet.getMetaData();  
//		   int columnCount = metaData.getColumnCount();  
		    
		while (rSet.next()) {
			System.out.println(rSet.getString("cid")+":>"+rSet.getString("cname"));

	        JSONObject jsonObj = new JSONObject();  
	         
	        // 遍历每一列  
	        for (int i = 1; i <= rSet.getMetaData().getColumnCount(); i++) {  
	            String columnName =metaData.getColumnLabel(i);  
	            String value = rSet.getString(columnName);  
	            jsonObj.put(columnName, value);  
	        }   
	        jArray.add(jsonObj);
		}
		HashMap<String,Object>  map = new HashMap<String, Object>();//泛型 map
		map.put("list", jArray);
		map.put("code", "2001");
		map.put("success", true);
		JSONObject mapJson = JSONObject.fromObject(map);
		System.out.println(mapJson);
		
	}
 
}
