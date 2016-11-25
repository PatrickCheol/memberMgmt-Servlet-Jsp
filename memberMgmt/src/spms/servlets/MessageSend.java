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
// MemberDao 사용  
@WebServlet("/message")
public class MessageSend extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			System.out.println();
			
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			request.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html; charset=UTF-8");
			memberDao.AddPoint(new Member().setName(request.getParameter("name")));
			

			

			MessageDao messageDao = new MessageDao();
			messageDao.setConnection(conn);
			
			
		
			messageDao.insert(new Message().setNo(Integer.parseInt(request.getParameter("no")))
					.setTitle(request.getParameter("title")).setContent(request.getParameter("content")).setName(request.getParameter("name")));
			response.sendRedirect("Viewinfo?no="+request.getParameter("no"));
		} catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
