package com.mashibing;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session
 * 作用：解决相同用户发送不同请求时的数据共享问题
 * 特点：
 *      1，服务器端存储共享数据的技术
 *      2，session 需要依赖cookie技术
 *      3，每个用户对应一个独立的session 对象
 *      4，每个session 对象的有效时长是30分钟
 *      5,每次关闭浏览器的时候，重新请求都会开启一个新的session 对象，因为返回的jsessionid是保存在浏览器内存中，是临时的cookie，所以关闭之后就会自然消失
 */
public class SessionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //因为response中文字段，所以要进行响应编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("接收到get请求");
        HttpSession session = request.getSession();//session虽然依赖cookie，但是我们不用new Cookie，然后将session数据放进去，session底层会将其数据放到
        //cookie中，所以，我们在获取了session对象的时候，response中就已经有了session的jsessionid数据了
        //设置session的会话有效时长
        //session.setMaxInactiveInterval(5);//单位是秒，就是每5秒就会生成新的session 对象

        System.out.println(session.getId());
        //设置session 强制失效
       // session.invalidate();
        //向session 中存放数据
        session.setAttribute("111","张三");
        response.getWriter().write("学习session");
    }
}
