package com.mashibing;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * servletConfig:
 * 作用：方便每一个servlet获取单独的属性配置
 * 特点：每一个servlet单独拥有一个servletConfig对象
 */
public class ServletConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        System.out.println(config.getInitParameter("china"));

        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String key=initParameterNames.nextElement();
            String value=config.getInitParameter(key);
            System.out.println(key+"==="+value);
        }
    }
}
