package com.hani.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        this.memberService = new MemberService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 처리(Encoding) - 꺼내기전에 코딩(=맨위에 코딩)
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getPathInfo();
		
		String method = request.getMethod();
		
		boolean check = true;
		
		String path = "";
		
		try {
		
		if(command.equals("/memberJoin")) {
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setEmail(request.getParameter("email"));
				
				int result = memberService.memberAdd(memberDTO);
				
				check = false;
				path = "../";
				
				
			}else {
				
				path="../WEB-INF/views/member/memberJoin.jsp";
			}
			
		}else if(command.equals("/memberLogin")) {
			
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				
				memberDTO = memberService.memberLogin(memberDTO);
				
			
				if(memberDTO != null) {
					
					HttpSession session = request.getSession();
					session.setAttribute("member", memberDTO);
					check = false;
					path = "../";
					
				}else {
					request.setAttribute("result", "로그인 실패!");
					request.setAttribute("path", "./memberLogin");
					path = "../WEB-INF/views/common/result.jsp";
				}
				
				
			}else {
				path="../WEB-INF/views/member/memberLogin.jsp";
				
			}
			
		}else if(command.equals("/memberLogout")) {
			HttpSession session = request.getSession();
			//session.removeAttribute("member");
			
			session.invalidate();
			check = false;
			path = "../";
			
		}else if(command.equals("/memberPage")) {
			
			MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
			
				memberDTO = memberService.memberLogin(memberDTO);
			
				System.out.println(memberDTO);
				
				request.setAttribute("dto", memberDTO);
				path = "../WEB-INF/views/member/memberPage.jsp";
			
			
			
			
		}else if(command.equals("/memberUpdate")) {
			
		}else {
			System.out.println("ETC");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//어디로 보낼지 결정
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			response.sendRedirect(path);
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
