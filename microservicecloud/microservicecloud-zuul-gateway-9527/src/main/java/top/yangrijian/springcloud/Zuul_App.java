package top.yangrijian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_App {
	public static void main(String[] args) {
		SpringApplication.run(Zuul_App.class, args);
	}
}
