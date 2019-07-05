package top.yangrijian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import top.yangrijian.springcloud.cfgbean.AvoidScan;
import top.yangrijian.springcloud.cfgbean.MyRule;

/**
 * 消费者服务
 * |@RibbonClient(name = "microservicecloud-provider-dept", configuration = MyRule.class)
 *  	对microservicecloud-provider-dept服务使用的负载均衡策略是经过MyRule所配置的
 *
 * @author Yang
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-PROVIDER-DEPT", configuration = MyRule.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidScan.class})})
public class ConsumerDept80 {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerDept80.class, args);
	}
}
