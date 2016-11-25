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
import spms.vo.Member;

// MemberDao 사용  
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberForm.jsp");
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
			request.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html; charset=UTF-8");
			StringBuffer enc = new StringBuffer();
			
			///////////////////////////////////////////////////////////비밀번호 암호화
			try { 
	            byte[] digest = java.security.MessageDigest.getInstance("MD5").digest(request.getParameter("password").getBytes());
	            for (int i = 0; i < digest.length; i++) {
	                enc.append(Integer.toString((digest[i] & 0xf0) >> 4, 16));
	                enc.append(Integer.toString(digest[i] & 0x0f, 16));
	            }
	        } catch(java.security.NoSuchAlgorithmException ne) {
	            ne.printStackTrace();
	        }
			///////////////////////////////////////////////////////////////
			memberDao.insert(new Member().setEmail(request.getParameter("email"))
					.setPassword(enc.toString()).setName(request.getParameter("name")).setSex(request.getParameter("sex"))
					.setPnum(request.getParameter("p_num")).setHobby(request.getParameter("hobby")).setAge(Integer.parseInt(request.getParameter("age"))));
			PrintWriter out = response.getWriter();
			out.println("<script> alert('asdasd');");
			response.sendRedirect("../auth/login");

		} catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
