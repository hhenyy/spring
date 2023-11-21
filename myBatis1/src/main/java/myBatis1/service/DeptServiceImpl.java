package myBatis1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import myBatis1.dao.DeptDao;
import myBatis1.model.Dept;

@Service
// 콘트롤러와 dao사이에서 메서드를 이용해서 값전달하고 리턴받는 역할밖에 하지않음.
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dd;

	public List<Dept> list() {
		return dd.list();
	}

	//부서 상세정보 
	public Dept select(int deptno) {
		return dd.select(deptno);
	}

	public int update(Dept dept) {
		return dd.update(dept);
	}

	public int delete(int deptno) {
		return dd.delete(deptno);
	}
}