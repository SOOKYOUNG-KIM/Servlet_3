package com.hani.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hani.util.DBConnect;
import com.sun.org.apache.regexp.internal.recompile;

public class MemberDAO {
	
	//1.Join(insert)
	public int memberAdd(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setInt(4, memberDTO.getAge());
		st.setString(5, memberDTO.getPhone());
		st.setString(6, memberDTO.getEmail());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	//2. Login DB check(select)
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnect.getConnect();
		
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PW=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setAge(rs.getInt("age"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
		}else {
			memberDTO = null;
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
	}
	
	//3. Delete()
	public int memberDelete(String id) throws Exception {
		Connection con = DBConnect.getConnect();
		
		String sql = "DELETE MEMBER WHERE ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	//4.Update()
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnect.getConnect();
		
		String sql = "UPDATE MEMBER SET PW=? ,NAME =? ,AGE=? ,PHONE=?, EMAIL=? WHERE ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getPw());
		st.setString(2, memberDTO.getName());
		st.setInt(3, memberDTO.getAge());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		st.setString(6, memberDTO.getId());
		
		int result = st.executeUpdate();
		

		st.close();
		con.close();
		
		
		return result;
	}


}
