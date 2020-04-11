package com.hani.notice;

import java.util.ArrayList;

public class NoticeService {
	
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	//1. List
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		return noticeDAO.noticeList();
	}
	
	//2. Select
	public NoticeDTO noticeSelect(long nnum) throws Exception{
		return noticeDAO.noticeSelect(nnum);
	}
	
	//3. Update
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeUpdate(noticeDTO);
	}
	
	//4. Insert
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeAdd(noticeDTO);
	}

}
