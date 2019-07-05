package top.yangrijian.springcloud.cfgbean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 每个微服务轮询5次才换下一个微服务
 * @author Yang
 * @version 1.0
 * @time 2019/7/3
 */
public class RoundRobinFiveRule extends AbstractLoadBalancerRule {

	/**
	 * 微服务总共被调用的次数
	 */
	private int total = 0;

	/**
	 * 当前提供微服务的下标
	 */
	private int currentIndex = 0;

	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;

		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();

			int serverCount = allList.size();
			if (serverCount == 0) {
				/*
				 * No servers. End regardless of pass, because subsequent passes
				 * only get more restrictive.
				 */
				return null;
			}

			/**
			 * 主要的处理逻辑
			 */
			if (total < 5) {
				server = upList.get(currentIndex);
				total++;
			} else {
				//当服务调用了第五次之后，就会进入到这里，这时候server为null，上面死循环会继续，就满足我们的需求了
				currentIndex++;
				total = 0;
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}

			if (server == null) {
				/*
				 * The only time this should happen is if the server list were
				 * somehow trimmed. This is a transient condition. Retry after
				 * yielding.
				 */
				Thread.yield();
				continue;
			}

			if (server.isAlive()) {
				return (server);
			}

			// Shouldn't actually happen.. but must be transient or a bug.
			server = null;
			Thread.yield();
		}

		return server;

	}

	protected int chooseRandomInt(int serverCount) {
		return ThreadLocalRandom.current().nextInt(serverCount);
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {

	}
}
