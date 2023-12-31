package myBatis3.service;

import java.util.List;

import myBatis3.model.Emp;

public interface EmpService {
	List<Emp> list(int deptno);

	Emp select(int empno);

	int insert(Emp emp);

	int delete(int empno);

	int update(Emp emp);

	List<Emp> empList();

	List<Emp> empAllList();
}