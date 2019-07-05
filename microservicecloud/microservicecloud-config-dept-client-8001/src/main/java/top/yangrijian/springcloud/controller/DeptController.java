package top.yangrijian.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.yangrijian.springcloud.entity.Dept;
import top.yangrijian.springcloud.service.DeptService;

import java.util.List;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/7/2
 */
@RestController
public class DeptController {
	@Autowired
	private DeptService service;
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		//获取Eureka中所有的服务实例
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		//获取服务名称为MICROSERVICECLOUD-DEPT的实例
		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		//拿到实例中的所有元素
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
