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

import spms.dao.MemberDao;
import spms.vo.Member;

// MemberDao 사용  
@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");

			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);

			Member member = memberDao.selectOne(Integer.parseInt(request.getParameter("no")));

			request.setAttribute("member", member);

			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdateForm.jsp");
			rd.forward(request, response);

		} catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
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
			
			memberDao.update(new Member().setNo(Integer.parseInt(request.getParameter("no")))
					.setName(request.getParameter("name")).setEmail(request.getParameter("email")));

			response.sendRedirect("list");

		} catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
