public class Session理论 {
    /**
     * 解决的问题：同一用户发送不同请求的数据共享问题
     * 1 session中存放的是公共数据
     * 2 session是基于cookie的，session是保存在服务器端的，cookie是保存在浏览器端的，我们将用户的登录信息保存在session中，也就是
     * 保存在服务器端，如果保存在cookie中，用户的信息就被暴露，所以在用户进行第一次请求的时候，调用对应的servlet进行处理，服务器会创建session对象，session
     * 对对象中的key为jsessionid来做唯一标识session，
     * 将用户的登录信息存储到session的value中，然后将session的jsessionid添加到cookie中，返回给浏览器（该信息是临时的存储，浏览器关闭后也就会失效），session的时间可以设置为30分钟，不能让这些数据永久的存在服务器端，占用内存，
     * 浏览器进行二次请求的时候，携带cookie中的信息，服务器接收到请求，调用对应的servlet进行请求处理，然后通过cookie中的jsessionid去获取session中的value，来判断用户是否失效，同时session 也可以
     * 重新开始计时，重新来一遍30分钟的倒计时。
     *
     */
}
