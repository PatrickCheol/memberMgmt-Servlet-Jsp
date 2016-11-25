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

import spms.dao.MemberDao;
import spms.dao.MessageDao;
import spms.vo.Member;
import spms.vo.Message;
import spms.vo.Board;
import spms.dao.BoardDao;
// MemberDao 사용  
@WebServlet("/BoardWrite")
public class BoardWrite extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/div_page/Board_Write.jsp");
		rd.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			request.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html; charset=UTF-8");

			memberDao.AddPoint(new Member().setName(request.getParameter("name")));
			request.setAttribute("members", memberDao.selectList());

			ServletContext sc2 =  this.getServletContext();
			Connection conn2 = (Connection) sc2.getAttribute("conn");
			

			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(conn2);
			
		
			boardDao.insert(new Board().setName(request.getParameter("name")).setText(request.getParameter("text")));
			response.sendRedirect("mainpage");
		} catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
