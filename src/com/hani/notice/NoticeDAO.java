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
		String sql = "SELECT * FROM NOTICE ORDER BY RDATE DESC";
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
	
	//2. SelectOne
		public NoticeDTO noticeSelect(long nnum) throws Exception{
			NoticeDTO noticeDTO = null;
			
			Connection con = DBConnect.getConnect();
			
			String sql = "SELECT * FROM NOTICE WHERE NNUM = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			 st.setLong(1, nnum);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				noticeDTO = new NoticeDTO();
				
				noticeDTO.setNnum(rs.getLong("nnum"));
				noticeDTO.setTitle(rs.getString("title"));
				noticeDTO.setWriter(rs.getString("writer"));
				noticeDTO.setRdate(rs.getDate("rdate"));
				noticeDTO.setViews(rs.getLong("views"));
				noticeDTO.setContenst(rs.getString("contenst"));
				

			}else {
				
			}
			
			rs.close();
			st.close();
			con.close();
			
			return noticeDTO;
			
		}
		
		//3. Update
		
		public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
			Connection con = DBConnect.getConnect();
			
			String sql = "UPDATE NOTICE SET TITLE =? ,CONTENST=? WHERE NNUM=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, noticeDTO.getTitle());
			st.setString(2, noticeDTO.getContenst());
			st.setLong(3, noticeDTO.getNnum());
			
			int result = st.executeUpdate();
			
			st.close();
			con.close();
			
			
			return result;
		
		}
		
		//4. Insert
		public int noticeAdd(NoticeDTO noticeDTO) throws Exception {
			Connection con = DBConnect.getConnect();
			
			String sql = "INSERT INTO NOTICE VALUES(NOTICE_SEQ.nextval, ?, ?,'admin',SYSDATE,0)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, noticeDTO.getTitle());
			st.setString(2, noticeDTO.getContenst());

			
			int result = st.executeUpdate();
			
			st.close();
			con.close();
			
			
			return result;
		}
		
		//5. Delete
		public int noticeDelete(int num) throws Exception{

			
			Connection con = DBConnect.getConnect();
			
			String sql = "DELETE FROM NOTICE WHERE NNUM = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, num);
			
			int result = st.executeUpdate();
			
			
			st.close();
			con.close();
			
			return result;
			
			
		}

}
