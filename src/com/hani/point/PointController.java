package com.hani.point;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        // TODO Auto-generated constructor stub
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
		
		if(command.equals("/pointList")) {
			check = true;
			path = "../WEB-INF/views/point/pointList.jsp";
			
		}else if(command.equals("/pointAdd")) {
			if(method.equals("POST")) {
				
			}else {
				check = true;
				path = "../WEB-INF/views/point/pointAdd.jsp";
			}
			
		}else if(command.equals("/pointMod")) {
			if(method.equals("POST")) {
				
			}else {
				check = true;
				path = "../WEB-INF/views/point/pointMod.jsp";
			}
			
		}else if(command.equals("/pointSelect")) {
			check = true;
			path = "../WEB-INF/views/point/pointSelect.jsp";
			
		}else if(command.equals("/pointDelete")) {
			System.out.println("Delete");
			
		}else {
			System.out.println("ETC");
		}
		
		//어디로 보낼지 결정
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			response.sendRedirect(path);
		}
		
		
		
	}//

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
