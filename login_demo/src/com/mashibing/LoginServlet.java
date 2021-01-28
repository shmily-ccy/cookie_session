package com.mashibing;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 请求转发的好处就是每个servlet都能做自己的事,做一些相应的处理
 *
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        //获取请求数据
        String name=request.getParameter("name");
        String pwd = request.getParameter("pwd");
        //封装对象 数据库的操作，省去
       /* User user=new User(name,pwd);
        User check = userService.check(user);
        System.out.println(check);*/

        if(name.equals("zhangsan") && pwd.equals("1111")){
            //response.getWriter().write("成功");
           //request.getRequestDispatcher("hello").forward(request,response);
            //重定向:如果用户提交的是表单数据,就要用重定向,防止用户重复提交,比如说转账,网络反应慢,一直重复请求,如果是请求转发,后台请求一直发生,如果用
            //重定向,已经换到新的地址了,request,response都是新的了
            HttpSession session = request.getSession();
            session.setAttribute("name","zhangsan");
            response.sendRedirect("hello");

        }else {
            response.setCharacterEncoding("gbk");
            //response.getWriter().write("失败");
            //设置成当登录失败的时候,依然返回登录页面
            //获取响应的输出流对象
            response.setContentType("text/html");//设置响应编码
            /*PrintWriter out = response.getWriter();
            out.write("<html>");
            out.write("<head>");
            out.write("<body>");
            out.write("<form action='login' method='get'>");
            out.write("用户名:<input type='text' name='name' value=''><br/>");
            out.write("密码:<input type='text' name='pwd' value=''><br/>");
            out.write("<input type='submit' valur='login' >");
            out.write("</form>");
            out.write("</body>");
            out.write("</head>");
            out.write("</html>");*/
            //请求转发:转发到了page对应的servlet里(这里也可以写成相应的jsp页面):就由paseservlet进行处理,响应给前端,所以此后的代码逻辑处理的就没有意义了,用return进行处理
            //注意:请求servlet的时候,写相对路径,同时后续不需要逻辑代码的处理

            //请求转发:
            /**
             * 1,客户端只发送一次请求
             * 2,浏览器的地址栏地址没有变化
             * 3,请求过程只有一个request和response
             * 4,过程中所涉及的几个servlet共享一个request和response
             * 5,对客户端透明,客户端不需要知道服务端做了哪些操作
             */

            request.setAttribute("str","用户名或者密码错误");
            request.getRequestDispatcher("page").forward(request,response);
            //System.out.println("java is easy");
            return;//停掉当前服务
        }
    }
}
