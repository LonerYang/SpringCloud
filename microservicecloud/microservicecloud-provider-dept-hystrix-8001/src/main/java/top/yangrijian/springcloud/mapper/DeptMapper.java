package top.yangrijian.springcloud.mapper;
import top.yangrijian.springcloud.entity.Dept;

import java.util.List;

public interface DeptMapper {
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}