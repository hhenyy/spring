package board1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import board1.model.Board;
import board1.model.ReplyBoard;
import board1.service.BoardService;
import board1.service.ReplyBoardService;

@Controller
public class ReplyBoardController {
	@Autowired
	private ReplyBoardService rbs;
	@Autowired
	private BoardService bs;

	//댓글 목록 
	@RequestMapping("/slist/num/{num}")
	public String slist(@PathVariable int num, Model model) {
		Board board = bs.select(num);           //부모글 상세정보
		List<ReplyBoard> slist = rbs.list(num); //댓글 목록
		model.addAttribute("slist", slist);
		model.addAttribute("board", board);
		return "slist";
	}

	//댓글 저장 
	@RequestMapping("/sInsert")
	public String sInsert(ReplyBoard rb, Model model) {
		rbs.insert(rb);
		return "redirect:slist/num/" + rb.getBno(); //bno:부모글의 num값 
	}

	//댓글 삭제 
	@RequestMapping("/repDelete")
	public String delete(ReplyBoard rb, Model model) {
		rbs.delete(rb.getRno()); //rno값으로만 삭제가능하지만 다시 돌아갈떄 bno값 필요  //rno : 댓글 글번호값 (최대값에 1증가된값으로 저장되게 처리) 
		return "redirect:slist/num/" + rb.getBno(); //삭제후 다시돌아갈때 bno값을 전달시켜서 slist로 요청(댓글목록) 
	}

	
	//댓글 수정 
	@RequestMapping("/repUpdate")
	public String repUpdate(ReplyBoard rb, Model model) {
		rbs.update(rb);
		return "redirect:slist/num/" + rb.getBno();
	}
}