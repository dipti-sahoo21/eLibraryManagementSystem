package com.olms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.olms.bean.BookBean;
import com.olms.dao.BookDao;

/**
 * Servlet implementation class ViewBook
 */
@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel = 'icon' href ='images/lib.png' type = 'image/x-icon'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("</head>");
		out.println("<body class='bg-info'>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		
		List<BookBean> list=BookDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
		for(BookBean bean:list){
			out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublisher()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td><td><a href='DeleteBook?callno="+bean.getCallno()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}

}
