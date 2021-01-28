package com.mashibing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    /**
     * 接收客户端发送的请求,返回登录页面,登录页面中html有form表单需要提交的servlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        System.out.println("接收到客户端的请求,返回响应的登录页面");

        String str=(String)request.getAttribute("str")==null?"":(String)request.getAttribute("str");
        System.out.println(str);

        //获取响应的输出流对象
        response.setContentType("text/html");//设置响应编码
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<body>");
        out.write("<font color='red' size='20px'>"+str+"</font>");
        out.write("<form action='login' method='get'>");
        out.write("用户名:<input type='text' name='name' value=''><br/>");
        out.write("密码:<input type='text' name='pwd' value=''><br/>");
        out.write("<input type='submit' valur='login' >");
        out.write("</form>");
        out.write("</body>");
        out.write("</head>");
        out.write("</html>");
    }
}
