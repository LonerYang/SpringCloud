package top.yangrijian.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yangrijian.springcloud.entity.Dept;
import top.yangrijian.springcloud.mapper.DeptMapper;
import top.yangrijian.springcloud.service.DeptService;

import java.util.List;

/**
 * @author Yang
 */
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public boolean add(Dept dept) {
		return deptMapper.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptMapper.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptMapper.findAll();
	}

}

