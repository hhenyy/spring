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
		Board board = bs.select(num);
		List<ReplyBoard> slist = rbs.list(num);
		model.addAttribute("slist", slist);
		model.addAttribute("board", board);
		return "slist";
	}

	//댓글 저장
	@RequestMapping("/sInsert")
	public String sInsert(ReplyBoard rb, Model model) {
		rbs.insert(rb);
		return "redirect:slist/num/" + rb.getBno();
	}

	//댓글 삭제
	@RequestMapping("/repDelete")
	public String delete(ReplyBoard rb, Model model) {
		rbs.delete(rb.getRno());
		return "redirect:slist/num/" + rb.getBno();
	}

	//댓글 수정
	@RequestMapping("/repUpdate")
	public String repUpdate(ReplyBoard rb, Model model) {
		rbs.update(rb);
		return "redirect:slist/num/" + rb.getBno();
	}
}