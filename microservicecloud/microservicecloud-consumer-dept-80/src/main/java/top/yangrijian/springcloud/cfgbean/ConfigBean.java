package top.yangrijian.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/7/2
 */
@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * 这里能被@ComponentScan扫描到，所有是针对全局的Ribbon客户端
	 * @return
	 */
//	@Bean
	public IRule iRule() {
		//默认使用的就是轮询算法实现负载均衡
//		return new RoundRobinRule();
		//使用随机算法实现负载均衡
//		return new RandomRule();
		//如果服务都正常就使用轮询算法，如果某个服务down掉了，在指定时间内重试不成功，之后就会去找可用的服务
		RetryRule retryRule = new RetryRule();
		retryRule.setMaxRetryMillis(5);
		return retryRule;
	}
}
