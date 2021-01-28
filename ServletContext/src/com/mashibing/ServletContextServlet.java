package com.mashibing;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servletContent:
 * 作用：解决不同用户的数据共享问题
 * 特点：
 *  1，由服务器创建
 *  2，所有用户共享同一个servletContent对象
 *  3,所有的servlet都可以访问到同一个servletcontext中的属性
 *  4，每一个web项目对应的是一个servletcontext
 * 用法：其他用途
 * 1 获取web.xml中配置的公共属性(全局属性的配置，使用servletconfig获取每个servlet中单独的属性配置)
 * 2 获取某个文件的绝对路径
 * 3，获取项目的虚拟路径名称
 */
public class ServletContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletcontext对象:this:当前的servlet对象
        ServletContext context = this.getServletContext();//一般第一种用的多
        ServletContext servletContext = this.getServletConfig().getServletContext();
        ServletContext servletContext1 = request.getSession().getServletContext();
        System.out.println(context==servletContext);
        System.out.println(context==servletContext1);
        System.out.println(servletContext==servletContext1);
        //向servletcontext中设置属性值
        context.setAttribute("111","zhangsan");
        //从web.xml中获取参数值
        System.out.println(context.getInitParameter("beijing"));
        System.out.println(context.getInitParameter("china"));
        //获取文件的绝对路径
        String path = context.getRealPath("web.xml");
        System.out.println(path);
        //返回web项目的上下文路径：在部署项目时配置的虚拟的项目名称
        String contextPath = context.getContextPath();
        System.out.println(contextPath);
    }
}
