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
@WebServlet("/Viewmessage")
public class ViewMessage extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			System.out.println("Viewmessageddd");
			
			
			ServletContext sc =  this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");
			MessageDao messageDao = new MessageDao();
			messageDao.setConnection(conn);		
			request.setAttribute("messages", messageDao.ViewMessage(Integer.parseInt(request.getParameter("no"))));
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/div_page/ViewMessage.jsp");
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
