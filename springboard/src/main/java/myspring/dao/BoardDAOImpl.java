package myspring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.model.BoardBean;

@Repository
public class BoardDAOImpl implements BoardDao{

	@Autowired
	private SqlSession session;

	
	/* 게시판 저장 */
	public void insertBoard(BoardBean b) throws Exception {
		session.insert("Test.board_insert", b);
	}

	
	/* 게시물 목록  */
	public List<BoardBean> getBoardList(int page) throws Exception {
		List<BoardBean> list = session.selectList("Test.board_list", page);

		return list;
	}

	
	/* 게시판 총 갯수  */
	public int getListCount() throws Exception {
		int count = 0;	
		count = ((Integer) session.selectOne("Test.board_count")).intValue();

		return count;
	}

	
	/* 게시판 글내용보기  */
	public BoardBean getBoardCont(int board_num) throws Exception {
		return (BoardBean) session.selectOne("Test.board_cont",board_num);
	}

	
	/* 게시판 조회수 증가  */
	public void boardHit(int board_num) throws Exception {
		session.update("Test.board_hit", board_num);		
	}

	
	/* 게시물 수정  */
	public void boardEdit(BoardBean b) throws Exception {
		session.update("Test.board_edit", b);		
	}

	
	/* 게시물 삭제  */
	public void boardDelete(int board_num) throws Exception {
		session.delete("Test.board_del", board_num);				
	}

	
	/* 답변글 출력번호 증가  */
	public void refEdit(BoardBean b) throws Exception {
		session.update("Test.board_Level", b);		
	}

	
	/* 답변글 저장  */
	public void boardReplyOk(BoardBean b) throws Exception {
		session.insert("Test.board_reply", b);		
	}

}
