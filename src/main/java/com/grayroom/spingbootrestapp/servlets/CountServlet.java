package com.grayroom.spingbootrestapp.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CountServlet", urlPatterns = {"","/"})
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        Integer count = (Integer) session.getAttribute("count");
        if (count == null)
            count = 1;
        else
            count++;
        session.setAttribute("count",count);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }

}
