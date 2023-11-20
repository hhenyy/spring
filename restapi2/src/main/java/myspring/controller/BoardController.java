package myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myspring.model.Board;
import myspring.service.BoardServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardServiceImpl service;

	// 글작성 폼
	@GetMapping("/boardform")
	public String boardform() {
		return "board/boardform";
	}

	// 글작성
	@PostMapping("/boardwrite")
//	@ResponseBody
	public String boardwrite(Board board, Model model) {
		int result = service.insert(board);
		System.out.println("result:" + result);

		model.addAttribute("result", result);

//		return "board/insertresult";
		return "redirect:/board/boardlist/page/1";
		
//		return result;
	}

	// 글목록
	@GetMapping("/boardlist/{page}")
	@ResponseBody
	public List<Board> boardlist(@PathVariable("page") int page, Model model) {
//	public String boardlist(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		
		System.out.println("boardlist 진입");
		// int page = 1;
		int limit = 10;

		// page =1 startRow=1, endRow=10
		// page =2 startRow=11, endRow=20
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int listcount = service.getCount();
		System.out.println("listcount:" + listcount);

		List<Board> boardlist = service.getBoardList(page);
		System.out.println("boardlist:" + boardlist);

		// 총 페이지
		int pageCount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);

		int startPage = ((page - 1) / 10) * limit + 1; 		// 1, 11, 21..
		int endPage = startPage + 10 - 1; 			   		// 10, 20, 30..

		if (endPage > pageCount)
			endPage = pageCount;

		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		return boardlist;
//		return "board/boardlist1";

	}

	// 상세페이지 : 조회수 1증가 + 상세정보 구하기
	@GetMapping("/boardcontent/{no}/{page}")
	@ResponseBody
	public Board boardcontent(@PathVariable("no") int no, 
							  @PathVariable("page") String page, 
							  Model model) {
		
		System.out.println("상세 페이지 진입");
		System.out.println("no:"+no);
		System.out.println("page:"+page);

		service.updatecount(no); // 조회수 1증가
		Board board = service.getBoard(no); // 상세정보 구하기
		String content = board.getContent().replace("\n", "<br>");

		model.addAttribute("board", board);
		model.addAttribute("content", content);
		model.addAttribute("page", page);

		return board;
//		return "board/boardcontent";
	}

	// 수정 폼
	@GetMapping("/updateform/{no}/{page}")
	@ResponseBody
	public Board boardupdateform(@PathVariable("no") int no, 
								 @PathVariable("page") String page, 
								 Model model) {
		System.out.println("수정폼 진입");
		System.out.println("no:"+no);
		System.out.println("page:"+page);
		
		Board board = service.getBoard(no); // 상세정보 구하기
		model.addAttribute("board", board);
		model.addAttribute("page", page);

		return board;
//		return "board/boardupdateform";
	}

	// 글수정
	@PutMapping("/boardupdate/{page}")
	@ResponseBody
	public Integer boardupdate(/* @PathVariable("no") int no, */
							  @PathVariable("page") String page, 
							  Board board, 
							  Model model) {
		System.out.println("수정폼에서 진입");
		int result = 0;
		Board old = service.getBoard(board.getNo());
		if (old.getPasswd().equals(board.getPasswd())) { // 비번일치
			result = service.update(board);
		} else { // 비번 불일치
			result = -1;
		}
		model.addAttribute("result", result);
		model.addAttribute("board", board);
		model.addAttribute("page", page);

		return result;
//		return "board/updateresult";
	}

	// 삭제 폼
	@GetMapping("/boarddeleteform")
	public String boarddeleteform() {
		return "board/boarddeleteform";
	}

	// 글삭제
	@DeleteMapping("/boarddelete")
	public String boarddelete(@RequestBody Board board, String page, Model model) {
		int result = 0;
		Board old = service.getBoard(board.getNo());
		if (old.getPasswd().equals(board.getPasswd())) { // 비번일치
			result = service.delete(board.getNo());
		} else { // 비번불일치
			result = -1;
		}
		model.addAttribute("result", result);
		model.addAttribute("page", page);

		return "board/deleteresult";
	}

}
