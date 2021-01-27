package com.mashibing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        String str=(String)session.getAttribute("111");//如果我们第一次请求的时候，操作的就是获取session 中的数据
        //这时数据是不存在，而session 对象是有的，str为null,但是如果我们的是第二次请求，就会有携带的jsessionid,这样的话，就可以找到对应的session，
        //也就可以获取都里面存储的数据
        System.out.println(str);
        response.getWriter().write(str);
    }
}
