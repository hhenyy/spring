package myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myspring.model.Board;
import myspring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	// 글작성 폼 (db연동이 필요하지않아 서비스로 가지않고 바로 modelandview로)
	@RequestMapping("boardform.do")
	public String boardform() {
		return "board/boardform";
	}
	
	// 글작성
	//page변수로 선택된값이 전달되고 전달되지않은면 defaultValue으로 설정된 1이 기본값
	@RequestMapping("boardwrite.do")
	public String boardwrite(@ModelAttribute Board board,
							 Model model) {

		int result = service.insert(board);//insert() 잘 실행시 result=1
		if(result == 1) System.out.println("글작성 성공");
		
		model.addAttribute("result", result);
		
		return "board/insertresult";
	}
	
	// 글목록
	@RequestMapping("boardlist.do")
	public String boardlist(@RequestParam(value="page",defaultValue="1") int page,
							Model model) {
		
//		int page = 1; (이코드는 쓰지않고 @RequestParam에서 작성)
		int limit = 10;  //1페이지의 글갯수
		
		// page = 1, startRow=1,  endRow=10
		// page = 2, startRow=11, endRow=20
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		//총데이터 갯수
		int listcount = service.getCount();
		System.out.println("listcount:"+ listcount);
		
		List<Board> boardlist = service.getBoardList(page);
		System.out.println("boardlist:"+ boardlist);
		
		// 총페이지
		int pageCount=listcount/limit+((listcount%10==0)?0:1);
		
		int startPage = ((page-1)/10) * limit + 1;	//1,11,21..
		int endPage = startPage + 10 -1;			//10,20,30..
				
		if(endPage > pageCount)
			endPage = pageCount;
		
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);		
		
		return "board/boardlist";
	}
	
	//상세 페이지 : 조회수 1 증가 + 상세정보 구하기
	//@RequestParam:전달변수명과 이름이 일치하면 생략가능
	@RequestMapping("boardcontent.do")
	public String boardcontent(@RequestParam("no") int no, String page, Model model) {
		
		service.updatecount(no); //조회수 1증가
		Board board=service.getBoard(no); //상세정보 구하기
	    //내용 줄바꿈 적용 :el로 치환시 함수라이브러리 불러와야해서 자바코드에서 하는게 더 편함
		String content = board.getContent().replace("\n", "<br>");
		
		model.addAttribute("board", board);
		model.addAttribute("content", content);
		model.addAttribute("page", page);
		
		return "board/boardcontent"; 
	}
	
	//수정폼
	@RequestMapping("boardupdateform.do")
	public String boardupdateform(@RequestParam("no") int no, 
			String page, Model model){
		
		Board board=service.getBoard(no); //상세정보 구하기
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		
		return "board/boardupdateform";
	}
	
	//글 수정
	@RequestMapping("boardupdate.do")
	public String boardupdate(@ModelAttribute Board board, 
			                  @RequestParam("page") String page,
			                  Model model){
		//no는 hidden객체로 값넘겻지만 값을 안받아도 board에 있어서?
		// 아니면 hidden으로 받는거라 requestparam으로안받는지? 그런거면 왜 page는받느지
		int result=0;
		Board db=service.getBoard(board.getNo());
		if(db.getPasswd().equals(board.getPasswd())) {//비번일치
			result=service.update(board);
		}else {  //비번불일치
			result=-1;
		}
		model.addAttribute("result", result);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		//상세페이지로 가게되면 board가 필요하지만 목록으로 갈떄는 필요x
	 return "board/updateresult";
		
	}
	
	//삭제폼
	//비번입력칸만 있기때문에 service까지 갈필요없음
	@RequestMapping("boarddeleteform.do")
	public String boarddeleteform() {
		return "board/boarddeleteform";
	}
	
	//글삭제
	@RequestMapping("boarddelete.do")
	//board에 no값과 passwd만 저장됨.
	public String boarddelete(@ModelAttribute Board board,
			@RequestParam("page") String page,
			Model model) {
		int result=0;
		Board db= service.getBoard(board.getNo());
		if(db.getPasswd().equals(board.getPasswd())) { //비번 일치시
			result=service.delete(board.getNo());
		}else { //비번 불일치시
			result=-1;
		}
		model.addAttribute("result", result);
		model.addAttribute("page", page); //원래페이지로돌아갈떄 필요
	
		return "board/deleteresult";
	}
	
	}


