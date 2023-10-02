package servlet;

import database.BabyDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBabyName")
public class DeleteBabyName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        int id=Integer.parseInt(sid);
        int status=BabyDb.delete(id);
        resp.sendRedirect("ViewBabyName");
    }
}
