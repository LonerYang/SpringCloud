package top.yangrijian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaServer
public class Config_Git_EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(Config_Git_EurekaServerApplication.class, args);
	}
}
