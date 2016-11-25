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
import spms.dao.BoardDao;

// MemberDao 사용  
@WebServlet("/DeleteList")
public class DeBoard extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession(true);
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");

			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(conn);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			 
			String name2 = request.getParameter("name");
			String mem_name = request.getParameter("mem_name");
			
			if (name2.equals(mem_name)){
				boardDao.delete(Integer.parseInt(request.getParameter("no")));
				System.out.println("su");
			}
			else{
				out.println("<script language='javascript'>"); 
				out.println("alert('작성자가 아니면 지울수 없습니다.');"); 
				out.println("history.go(-1);"); 
				out.println("</script>"); 
				out.close();
			}
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
