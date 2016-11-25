package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import spms.vo.Board;
import spms.dao.BoardDao;
// MemberDao 사용  
@WebServlet("/Boardlist")
public class BoardList extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{

			
			ServletContext sc =  this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(conn);		
			request.setAttribute("boards", boardDao.BoardList());
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/div_page/Board_List.jsp");
			rd.forward(request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

}
