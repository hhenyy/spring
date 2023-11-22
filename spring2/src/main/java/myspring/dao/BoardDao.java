package myspring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.model.Board;

@Mapper //생략가능
public interface BoardDao {
   //추상메서드
	public int insert(Board board);

	public int getCount();

	public List<Board> getBoardList(int page);

	public void updatecount(int no);

	public Board getBoard(int no);

	public int update(Board board);

	public int delete(int no);


}
