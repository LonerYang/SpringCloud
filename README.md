学习SpringCloud过程中写的Demo
#一、涉及到的组件
1、Eureka
2、Ribbon
3、Feign
4、Hystrix
5、Zuul
6、Config
#二、碰到的坑和注意的点
1、使用服务名称调用服务一定要加@LoadBalanced注解
2、版本对应SpringCloud：Dalston.SR4 + SpringBoot：1.5.2.RELEASE
3、Ribbon的负载均衡RetryRule策略测试无效	
