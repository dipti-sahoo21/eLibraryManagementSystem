package com.olms.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.olms.bean.LibrarianBean;
import com.olms.dao.LibrarianDao;

/**
 * Servlet implementation class EditLibrarian
 */
@WebServlet("/EditLibrarian")
public class EditLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLibrarian() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		LibrarianBean bean=new LibrarianBean(id,name, email, password, mobile);
		LibrarianDao.update(bean);
		response.sendRedirect("ViewLibrarian");
		
		
	}

}
