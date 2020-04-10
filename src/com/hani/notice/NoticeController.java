package com.hani.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        noticeService = new NoticeService();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//한글 처리(Encoding) - 꺼내기전에 코딩(=맨위에 코딩)
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
				
			//pathInfo
			String command = request.getPathInfo();
				
			//Method 형식
			String method = request.getMethod();
				
			//Forward(true), redirect(false) 선택
			boolean check = true;
				
			//path(경로명(URL)) 담을 변수
			String path = "";
			
			try {
				
			
			if(command.equals("/noticeList")) {
				
				ArrayList<NoticeDTO> ar = noticeService.noticeList();
				request.setAttribute("list", ar);
				
				path = "../WEB-INF/views/notice/noticeList.jsp";
				
			}else if(command.equals("/noticeAdd")) {
				
			}else if(command.equals("/noticeSelect")) {
				
			}else if(command.equals("/noticeUpdate")) {
				
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
