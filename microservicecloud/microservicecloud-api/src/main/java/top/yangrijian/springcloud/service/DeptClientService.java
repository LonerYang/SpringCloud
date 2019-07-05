package top.yangrijian.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.yangrijian.springcloud.entity.Dept;

import java.util.List;

/**
 * 客户端调用指定的服务失败时，去调用DeptClientServiceFallbackFactory类中的处理方法
 * @author Yang
 * @version 1.0
 * @time 2019/7/3
 */
@FeignClient(value = "MICROSERVICECLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	@RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
	Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list",method = RequestMethod.GET)
	List<Dept> list();

	@RequestMapping(value = "/dept/add",method = RequestMethod.POST)
	boolean add(Dept dept);
}
