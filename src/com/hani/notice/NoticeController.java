package com.hani.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hani.point.PointDTO;

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
				if(method.equals("POST")) {
					
					NoticeDTO noticeDTO = new NoticeDTO();
					
					noticeDTO.setTitle(request.getParameter("title"));
					noticeDTO.setContenst(request.getParameter("contenst"));
					noticeDTO.setWriter(request.getParameter("writer"));

					HttpSession session = request.getSession();
					session.setAttribute("dto", noticeDTO);
					
					int result = noticeService.noticeAdd(noticeDTO);
					System.out.println(result);
					String msg = "등록에 실패 했습니다.";
						if(result>0) {
							msg = "등록에 성공 하였습니다";
						}
						
					request.setAttribute("result", msg);
					request.setAttribute("path", "./noticeList");
					
					path = "../WEB-INF/views/common/result.jsp";
					
					
				}else {
					
					path = "../WEB-INF/views/notice/noticeAdd.jsp";
				}
			}else if(command.equals("/noticeSelect")) {

				long nnum = Integer.parseInt(request.getParameter("nnum"));
				
				NoticeDTO noticeDTO = noticeService.noticeSelect(nnum);
				
				HttpSession session = request.getSession();
				session.setAttribute("dto", noticeDTO);
				
				path = "../WEB-INF/views/notice/noticeSelect.jsp";
				
			}else if(command.equals("/noticeUpdate")) {
				
				if(method.equals("POST")) {
					
					
					NoticeDTO noticeDTO = new NoticeDTO();
					
					noticeDTO.setContenst(request.getParameter("contenst"));
					noticeDTO.setTitle(request.getParameter("title"));
					
					int result = noticeService.noticeUpdate(noticeDTO);
					
					String msg = "수정에 실패 했습니다.";
						if(result > 0) {
							msg = "수정에 성공 하였습니다.";
							request.setAttribute("path", "./noticeSelect?num="+noticeDTO.getNnum());
						}else {
							request.setAttribute("path", "./noticetList");
							
						}
						
						request.setAttribute("result", msg);
				
					
					path = "../WEB-INF/views/common/result.jsp";
					
				}else {
					path = "../WEB-INF/views/notice/noticeUpdate.jsp";
				}
				
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
