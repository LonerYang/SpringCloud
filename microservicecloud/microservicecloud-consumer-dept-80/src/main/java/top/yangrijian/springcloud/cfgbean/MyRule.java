package top.yangrijian.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/7/3
 */
@Configuration
@AvoidScan
public class MyRule {

	@Bean
	public IRule ribbonRule() {
		//这里不能被@ComponentScan扫描到，所以可以用来配置调用某个服务时使用的负载均衡策略
		//Ribbon默认是轮询，我定义为随机
		return new RoundRobinFiveRule();
	}
}