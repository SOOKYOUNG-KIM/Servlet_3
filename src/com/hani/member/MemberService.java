package com.hani.member;

public class MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberService(){
		this.memberDAO = new MemberDAO();
	}
	
	//1. Insert()
	public int memberAdd(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberAdd(memberDTO);
	}
	
	//2. Login()
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}

}
