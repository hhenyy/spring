package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	@RequestMapping("boardform")
	public String hello() {
		return "boardform";
	}

	@RequestMapping("boardinsert")
	public String boardinsert(Board board) {

		Board result = service.insert(board);
		System.out.println("result:" + result);

		return "redirect:boardlist";
	}

	@RequestMapping("boardlist")
	public String boardlist(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		System.out.println("boardlist in");
		System.out.println("page:" + page);

		int limit = 10;

		int listcount = (int)service.getCount();
		
		int start = (page-1) * limit;    // 각 page별 추출할 시작번호 : 0, 10, 20...

		List<Board> boardlist = service.getList(start);
		System.out.println("listcount:" + listcount);
		System.out.println("boardlist:" + boardlist);

		// 총페이지
		int pageCount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);

		int startPage = ((page - 1) / 10) * limit + 1;  // 1, 11, 21...
		int endPage = startPage + 10 - 1; 				// 10, 20, 30...

		if (endPage > pageCount)
			endPage = pageCount;

		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		return "boardlist";
	}

	@RequestMapping("boardcontent")
	public String boardcontent(int no, int page, Model model) {

		Board board = service.getContent(no);
		System.out.println("board:" + board);

		model.addAttribute("board", board);
		model.addAttribute("page", page);

		return "boardcontent";
	}

	@RequestMapping("boardupdateform")
	public String boardupdateform(int no, int page, Model model) {
		Board board = service.getContent(no);
		System.out.println("board:" + board);

		model.addAttribute("board", board);
		model.addAttribute("page", page);

		return "boardupdateform";
	}

	@RequestMapping("boardupdate")
	public String boardupdate(Board board, int page) {
		Board result = service.update(board);
		System.out.println("result:" + result);

		return "redirect:boardcontent?no=" + board.getNo()+"&page="+page;
	}

	@RequestMapping("boarddeleteform")
	public String boarddeleteform(int no, int page, Model model) {
		Board board = service.getContent(no);
		System.out.println("board:" + board);

		model.addAttribute("board", board);
		model.addAttribute("page", page);

		return "boarddeleteform";
	}

	@RequestMapping("boarddelete")
	public String boarddelete(Board board, int page) {
		service.delete(board);

		return "redirect:boardlist?page="+page;
	}

}
