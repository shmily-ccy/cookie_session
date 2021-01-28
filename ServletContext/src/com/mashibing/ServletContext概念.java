package com.mashibing;

public class ServletContext概念 {
    /**
     * 实现数据共享，不同用户访问的都是一个对象，获取的数据也是一样的
     * 1 每一个web应用程序都有一个与之对应的servletcontext（servlet API提供servletContext接口来表示servlet 上下文）
     * 2 一个web应用程序的所有的servlet都可以访问servletContext
     * 3 servletContext对象是web服务器中的一个已知路径的根
     * 4 servletContext原理：由服务器tomcat 创建，一个项目只有一个对象，不管在项目的任意位置进行获取得到的都是同一个对象，那么不同
     * 用户发起的请求获取到的也就是同一个对象了，该对象由用户共同拥有
     */
}
