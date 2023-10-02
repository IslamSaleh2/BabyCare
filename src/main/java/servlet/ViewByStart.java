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
import java.util.List;

@WebServlet("/ViewByStart")
public class ViewByStart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String start=req.getParameter("start");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Baby by "+start.toUpperCase()+"</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("navigation.html").include(req, resp);
        out.print(" <a href='ViewBabyNameByReligion?religion=hindu' class='btn btn-primary' role='button'>Hindu</a> ");
        out.print(" <a href='ViewBabyNameByReligion?religion=muslim' class='btn btn-primary' role='button'>Muslim</a> ");
        out.print(" <a href='ViewBabyNameByReligion?religion=sikh' class='btn btn-primary' role='button'>Sikh</a> ");
        out.print(" <a href='ViewBabyNameByReligion?religion=christian' class='btn btn-primary' role='button'>Christian</a> ");
        req.getRequestDispatcher("atoz.html").include(req, resp);

        out.println("<h1>View Baby Names by "+start.toUpperCase()+"</h1>");
        List<Baby> list= BabyDb.getRecordsByStart(start);

        out.print("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Id</th><th>Name</th><th>Meaning</th><th>Sex</th><th>Religion</th></tr>");
        for(Baby b:list){
            out.println("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getMeaning()+"</td><td>"+b.getSex()+"</td><td>"+b.getReligion()+"</td></tr>");
        }
        out.println("</table>");
        req.getRequestDispatcher("footer.html").include(req, resp);
        out.close();
    }
}
