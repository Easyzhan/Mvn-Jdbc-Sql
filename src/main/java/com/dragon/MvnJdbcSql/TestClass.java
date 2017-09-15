package com.dragon.MvnJdbcSql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.dragon.utils.PropertiesUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

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
		while (rSet.next()) {
			System.out.println(rSet.getString("cid")+":>"+rSet.getString("cname"));

		}
		
	}
}
