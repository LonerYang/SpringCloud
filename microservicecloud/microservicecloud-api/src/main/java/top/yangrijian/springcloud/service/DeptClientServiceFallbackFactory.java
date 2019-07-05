package top.yangrijian.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import top.yangrijian.springcloud.entity.Dept;

import java.util.List;

/**
 * 不要忘记添加@Component
 * @author Yang
 * @version 1.0
 * @time 2019/7/4
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id)
						.setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}
}

