package myBatis3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myBatis3.model.Dept;

//@Mapper
public interface DeptDao {
	List<Dept> list();

	int insert(Dept dept);

	Dept select(int deptno);

	int update(Dept dept);

	int delete(int deptno);
}