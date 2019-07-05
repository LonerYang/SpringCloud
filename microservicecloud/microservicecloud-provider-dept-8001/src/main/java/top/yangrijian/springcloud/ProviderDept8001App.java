package top.yangrijian.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * |@EnableEurekaClient 启动后会自动注册近eureka服务中
 * |@EnableDiscoveryClient //服务发现
 * @author Yang
 */
@SpringBootApplication
@MapperScan(basePackages = "top.yangrijian.springcloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderDept8001App {
	public static void main(String[] args) {
		SpringApplication.run(ProviderDept8001App.class, args);
	}
}
