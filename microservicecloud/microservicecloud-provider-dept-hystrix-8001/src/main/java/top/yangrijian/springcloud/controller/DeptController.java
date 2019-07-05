package top.yangrijian.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.yangrijian.springcloud.entity.Dept;
import top.yangrijian.springcloud.service.DeptService;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/7/2
 */
@RestController
public class DeptController {
	@Autowired
	private DeptService service = null;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = this.service.get(id);
		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}
		return dept;
	}

	/**
	 * 服务熔断机制触发的时候调用的方法
	 * @param id
	 * @return
	 */
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id)
				.setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
}
