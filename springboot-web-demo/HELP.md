# 1.1.5 springboot进行web开发

* 拦截器 - 拦截请求
    * 实现HandlerInterceptor接口，定义一个拦截器
    * 实现WebMvcConfigurer接口，注册拦截器，别忘记@Configuration
   
* 实现WebMvcConfigurer接口，实现根目录跳转到登录页面
    