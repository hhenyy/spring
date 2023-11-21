package myBatis2.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import myBatis2.model.Dept;
import myBatis2.model.Emp;
import myBatis2.service.DeptService;
import myBatis2.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService es;
	@Autowired
	private DeptService ds;
    //@Autowired 한번에 같이 쓸수없고 따로따로 써야함
	
	//각 부서에 소속된 사원목록 구하기
	@RequestMapping("empList.do")
	public String empList(int deptno, Model model) {
		Dept dept = ds.select(deptno); //부서 상세 정보
		List<Emp> list = es.list(deptno); //각 부서의 직원 목록 
		model.addAttribute("dept", dept);
		model.addAttribute("list", list);
		return "emp/empList";
	}

	//사원 등록 폼
	@RequestMapping("empInsertForm.do")
	public String empInsertForm(Model model) {
		List<Dept> deptList = ds.list(); //부서 목록
		List<Emp> empList = es.empList(); // 사원 목록
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		return "emp/empInsertForm";
	}

	//사번 중복검사
	@RequestMapping("dupCheck.do")
	public String dupCheck(int empno, Model model) {
		System.out.println("empno:"+empno);
		Emp emp = es.select(empno);
		String msg = "";
		if (emp != null) //중복 사번
			msg = "이미 있는 데이터입니다";
		else             //중복되지 않는 사번
			msg = "사용 가능한 사번 입니다";
		model.addAttribute("msg", msg);
		return "emp/dupCheck"; 
		//웹브라우저에 출력되는 결과가 콜백함수로 리턴됨.
	}

	//사원등록
	@RequestMapping("empInsert.do")
//	public String empInsert(Emp emp, String hiredate1, Model model) {
	public String empInsert(Emp emp, Model model) {
//		emp.setHiredate(Date.valueOf(hiredate1)); // String -> Date 형변환
		int result = es.insert(emp);
		model.addAttribute("result", result);
		model.addAttribute("deptno", emp.getDeptno());
		return "emp/empInsert";
	}

	//사원 상세 정보 구하기
	@RequestMapping("empView.do")
	public String empView(int empno, Model model) {
		Emp emp = es.select(empno);
		model.addAttribute("emp", emp);
		return "emp/empView";
	}

	//회원 삭제
	@RequestMapping("empDelete.do")
	public String empDelete(int empno, Model model) {
		Emp emp = es.select(empno);
		int result = es.delete(empno);
		model.addAttribute("result", result);
		model.addAttribute("deptno", emp.getDeptno());
		return "emp/empDelete";
	}

	//사원 수정폼에 필요한 정보구하기
	@RequestMapping("empUpdateForm.do")
	public String empUpdateForm(int empno, Model model) {
		Emp emp = es.select(empno);
		List<Dept> deptList = ds.list();
		model.addAttribute("emp", emp);
		model.addAttribute("deptList", deptList);
		return "emp/empUpdateForm";
	}

	//사원 정보 수정
	@RequestMapping("empUpdate.do")
	public String empUpdate(Emp emp, Model model) {
		int result = es.update(emp);
		model.addAttribute("deptno", emp.getDeptno());
		model.addAttribute("result", result);
		return "emp/empUpdate";
	}

	//전체 직원 목록
	@RequestMapping("empAllList.do")
	public String empAllList(Model model) {
		List<Emp> list = es.empAllList();
		model.addAttribute("list", list);
		return "emp/empAllList";
	}
}


