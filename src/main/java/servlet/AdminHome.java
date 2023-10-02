package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }
protected void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    PrintWriter out=response.getWriter();
    request.getRequestDispatcher("header.html").include(request,response);
    out.println("<h1> Admin Home </h1>");
    out.print(" <a href='AddBabyNameForm' class='btn btn-primary' role='button'>Add Baby Name</a> ");
    out.print(" <a href='ViewBabyName' class='btn btn-primary' role='button'>View Baby Names</a> ");
    out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");

    request.getRequestDispatcher("footer.html").include(request, response);

}


}
