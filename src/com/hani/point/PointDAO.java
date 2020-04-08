package com.hani.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hani.util.DBConnect;

public class PointDAO {
	
	//DAO (Data Access Object)
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception {
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();	//arraylist는 한개만 생성하면 됨.
		
		//1. DB 연결
		Connection con = DBConnect.getConnect();
		//2. SQL문 작성
		String sql = "SELECT * FROM POINT ORDER BY NUM ASC";
		//3. SQL 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 값 넣어주기
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		//	PointDTO pointDTO = new PointDTO(); -> 여기에 적으면 한개에 계속 갱신해서 함. 반복문안에 넣어줘야 새로만들고 여러개 만든다.
		while(rs.next()) {
			
			PointDTO pointDTO = new PointDTO();
			
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			ar.add(pointDTO);
			
		}
			
			
		//6. 자원해제
		rs.close();
		st.close();
		con.close();
	
		return ar;
	}
	
	//2. SelectOne
	public PointDTO pointSelect(int num) throws Exception{
		PointDTO pointDTO = null;
		
		Connection con = DBConnect.getConnect();
		
		String sql = "SELECT * FROM POINT WHERE NUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		 st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			pointDTO = new PointDTO();
			
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			

		}else {
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return pointDTO;
		
	}
	
	//3. Insert
	
	//4. Update
	
	//5. Delete
	public int pointDelete(int num) throws Exception{

		
		Connection con = DBConnect.getConnect();
		
		String sql = "DELETE FROM POINT WHERE NUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		
		
		st.close();
		con.close();
		
		return result;
		
		
	}

}
