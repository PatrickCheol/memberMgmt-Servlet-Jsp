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
import spms.vo.Member;

// MemberDao 사용
@WebServlet("/auth/login")
public class LogInServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInForm.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");

			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			StringBuffer enc = new StringBuffer();
			try { 
	            byte[] digest = java.security.MessageDigest.getInstance("MD5").digest(request.getParameter("password").getBytes());
	            for (int i = 0; i < digest.length; i++) {
	                enc.append(Integer.toString((digest[i] & 0xf0) >> 4, 16));
	                enc.append(Integer.toString(digest[i] & 0x0f, 16));
	            }
	        } catch(java.security.NoSuchAlgorithmException ne) {
	            ne.printStackTrace();
	        }

			Member member = memberDao.exist(request.getParameter("email"),enc.toString());
			String email = request.getParameter("email");
			if (member != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("member", member);
				response.sendRedirect("../mainpage");

			} else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInFail.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e)
		{
			throw new ServletException(e);

		}
	}
}
