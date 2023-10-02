package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminAuthenticator")
public class AdminAuthenticator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        if(name.equals("admin") && password.equals("admin")){
            HttpSession session=req.getSession();
            session.setAttribute("adminlogin","true");
            req.getRequestDispatcher("AdminHome").forward(req,resp);
        }else{
            req.getRequestDispatcher("AdminError").forward(req,resp);
        }
    }
}
