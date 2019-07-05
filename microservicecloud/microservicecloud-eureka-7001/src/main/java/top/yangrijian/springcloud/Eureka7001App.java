package top.yangrijian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer服务器端启动类,接受其它微服务注册进来
 * @author  Yang
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7001App {
	public static void main(String[] args) {
		SpringApplication.run(Eureka7001App.class, args);
	}
}
