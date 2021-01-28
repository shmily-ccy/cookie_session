package com.mashibing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        //String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object name = session.getAttribute("name");
        out.write("<html>");
        out.write("<head>");
        out.write("<body>");
        out.write("<h1>欢迎"+name+"登录成功</h1>");
        out.write("</body>");
        out.write("</head>");
        out.write("</html>");
    }
}
