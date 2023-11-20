package myBatis3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myBatis3.model.Emp;

//@Mapper
public interface EmpDao {
	List<Emp> list(int deptno);

	List<Emp> empList();

	Emp select(int empno);

	int insert(Emp emp);

	int delete(int empno);

	int update(Emp emp);

	List<Emp> empAllList();
}