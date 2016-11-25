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
import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;

// MemberDao 사용  
@WebServlet("/mainpage")
public class MainPage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession(true);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(session != null && session.getAttribute("member")==null){
				out.println("<script language='javascript'>"); 
				out.println("alert('로그인한 사용자만 이용 가능합니다');"); 
				out.println("history.go(-1);"); 
				out.println("</script>"); 
				out.close();
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
				RequestDispatcher rd = request.getRequestDispatcher("/div_page/Main.jsp");
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
