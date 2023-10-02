package servlet;

import database.BabyDb;
import entity.Baby;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddBabyName")
public class AddBabyName extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add Baby</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("navigation.html").include(req, resp);
        out.print(" <a href='ViewBabyName' class='btn btn-primary' role='button'>View Baby Names</a> ");
        out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
        String name= req.getParameter("name");
        String meaning= req.getParameter("meaning");
        String sex= req.getParameter("sex");
        String religion= req.getParameter("religion");

        Baby baby=new Baby();
        baby.setName(name);
        baby.setMeaning(meaning);
        baby.setSex(sex);
        baby.setReligion(religion);
        int status= BabyDb.save(baby);
        if(status>0){
            out.print("<h3>Baby added successfully</h3>");
            req.getRequestDispatcher("addbabynameform.html").include(req,resp);
        }else{
            out.print("<h3>Unable to add baby</h3>");
        }
        //req.getRequestDispatcher("footer.html").include(req, resp);

        out.close();


    }
}
