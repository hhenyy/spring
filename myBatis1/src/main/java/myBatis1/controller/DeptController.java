package myBatis1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myBatis1.model.Dept;
import myBatis1.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService ds;
	//인터페이스나 구현클래스로 주입 둘다 가능

	@RequestMapping("deptList.do")
	public String list(Model model) {
		List<Dept> list = ds.list(); //값을 list에 저장
		model.addAttribute("list", list);
		//값이있을때 model객체 사용 (model에 값을 저장해서 가져감)
		//items값이 key값으로 들어감 
		return "deptList";
	}

	//부서 상세정보
	@RequestMapping("deptView.do")
	//@RequestParam("deptno"):전달되는 변수명과 받는 변수명이 같으면 생략가능. 값을받아주고 형변환도 자동으로 처리
	public String deptView(@RequestParam("deptno") int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "deptView";
	}

	//수정 폼 
	@RequestMapping("deptUpdateForm.do")
	public String deptUpdateForm(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "deptUpdateForm";
	}

	//수정
	@RequestMapping("deptUpdate.do")
	//@ModelAttribute 이름값들이 같을 떄 생략가능 
	public String deptUpdate(@ModelAttribute Dept dept, Model model) {
		int result = ds.update(dept);
		model.addAttribute("result", result);
		return "deptUpdate";
	}

	//부서정보 삭제
	@RequestMapping("deptDelete.do")
	//@RequestParam("deptno") 변수명들이 같을 떄 생략가능
	public String deptDelete(@RequestParam("deptno") int deptno, Model model) {
		int result = ds.delete(deptno);
		model.addAttribute("result", result);
		return "deptDelete";
	}
}