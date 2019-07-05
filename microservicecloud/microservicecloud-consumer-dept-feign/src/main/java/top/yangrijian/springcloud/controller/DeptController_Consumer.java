package top.yangrijian.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yangrijian.springcloud.entity.Dept;
import top.yangrijian.springcloud.service.DeptClientService;

import java.util.List;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/7/2
 */
@RestController
public class DeptController_Consumer {
//	private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-PROVIDER-DEPT";

	@Autowired
	private DeptClientService service = null;

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list()
	{
		return this.service.list();
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Object add(Dept dept)
	{
		return this.service.add(dept);
	}

}
