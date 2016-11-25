package spms.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;

// MemberDao 사용  
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession(true);
			if(session != null && session.getAttribute("member")==null){
				RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInForm.jsp");
				rd.forward(request, response);
			}
			else{	
				ServletContext sc = this.getServletContext();
				Connection conn = (Connection) sc.getAttribute("conn");
				MemberDao memberDao = new MemberDao();
				memberDao.setConnection(conn);		
				request.setAttribute("members", memberDao.selectList());
				response.setContentType("text/html; charset=UTF-8");
				RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
