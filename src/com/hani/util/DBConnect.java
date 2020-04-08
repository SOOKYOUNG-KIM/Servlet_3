package com.hani.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnect() throws Exception{
		//1. 로그인 정보 4가지
		
		//login deny
		//1. ID/PW가 틀렸을 경우
		//2. DB에 해당유저가 생성되지 않은 경우
		//2. 유저의 권한이 부여되지 않은 경우
		
		String user = "user02";
		String password = "user02";
		
		//not Connect
		//1. IP, Port, xe 정보가 틀린경우
		//2. 물리적으로 연결이 안되거나, 서버가 종료된 경우
		//3. Listener문제, DB 재시동
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		
		//class not found
		//1. driver명이 틀린 경우
		//2. jdbc(ojdbc6.jar)가 없는 경우
		String driver = "oracle.jdbc.driver.OracleDriver";
				
		//2. 드라이버를 메모리에 로딩
		Class.forName(driver);
		
		//3. 로그인 Connection 객체 반환
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con; 
	}

}