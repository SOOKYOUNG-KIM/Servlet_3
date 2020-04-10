package com.hani.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hani.point.PointDTO;
import com.hani.util.DBConnect;

public class NoticeDAO {
	
	//1.List
	public ArrayList<NoticeDTO> noticeList() throws Exception {
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		
		//1. DB 연결
		Connection con = DBConnect.getConnect();
		//2. SQL문 작성
		String sql = "SELECT * FROM NOTICE ORDER BY RDATE ASC";
		//3. SQL 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 값 넣어주기
		//5. 최종 전송 후 결과 처리
		
		ResultSet rs = st.executeQuery();
		
		//	PointDTO pointDTO = new PointDTO(); -> 여기에 적으면 한개에 계속 갱신해서 함. 반복문안에 넣어줘야 새로만들고 여러개 만든다.
		while(rs.next()) {
			
			NoticeDTO noticeDTO = new NoticeDTO();
			
			noticeDTO.setNnum(rs.getLong("nnum"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setContenst(rs.getString("contenst"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setRdate(rs.getDate("rdate"));
			noticeDTO.setViews(rs.getLong("views"));
		
			
			ar.add(noticeDTO);
			
			
		}
			
		//6. 자원해제
		rs.close();
		st.close();
		con.close();
	
		return ar;
	}

}
