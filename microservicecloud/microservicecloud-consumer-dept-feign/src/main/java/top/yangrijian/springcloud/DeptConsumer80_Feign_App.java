package top.yangrijian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 消费者服务
 * |@RibbonClient(name = "microservicecloud-provider-dept", configuration = MyRule.class)
 *  	对microservicecloud-provider-dept服务使用的负载均衡策略是经过MyRule所配置的
 * |@EnableFeignClients开启Feign客户端
 * @author Yang
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DeptConsumer80_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}
