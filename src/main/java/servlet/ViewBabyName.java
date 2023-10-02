package servlet;

import database.BabyDb;
import entity.Baby;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewBabyName")
public class ViewBabyName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Baby</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("navigation.html").include(req, resp);
        out.print(" <a href='ViewBabyNameByReligion?religion=hindu' class='btn btn-primary' role='button'>Hindu</a> ");
        out.print(" <a href='ViewBabyNameByReligion?religion=muslim' class='btn btn-primary' role='button'>Muslim</a> ");
        out.print(" <a href='ViewBabyNameByReligion?religion=sikh' class='btn btn-primary' role='button'>Sikh</a> ");
        out.print(" <a href='ViewBabyNameByReligion?religion=christian' class='btn btn-primary' role='button'>Christian</a> ");

        HttpSession session= req.getSession(false);

        if(session==null && session.getAttribute("adminlogin")==null){

        }else{
            out.print(" <a href='AddBabyNameForm' class='btn btn-primary' role='button'>Add Baby Name</a> ");
            out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
        }
        req.getRequestDispatcher("atoz.html").include(req, resp);
        out.println("<h1>View Baby Names</h1>");

        List<Baby> list= BabyDb.getAllRecords();
        out.print("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Id</th><th>Name</th><th>Meaning</th><th>Sex</th><th>Religion</th><th>Delete</th></tr>");
        for(Baby b:list){
            out.println("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getMeaning()+"</td><td>"+b.getSex()+"</td><td>"+b.getReligion()+"</td>");

            if(session==null||session.getAttribute("adminlogin")==null){
                out.println("<td>Delete</td>");

            }else{
                out.println("<td><a href='DeleteBabyName?id="+b.getId()+"'>Delete</a></td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        req.getRequestDispatcher("footer.html").include(req, resp);
        out.close();
    }



}
