package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Board;

@Repository
public interface BoardRepository extends CrudRepository<Board, Integer>{

//	public Board save(Board board);				// 글작성, 글수정 
//	public long count();						// 글 갯수 
//	public void delete(Board board);			// 글삭제 
	public Board findByNo(int no);				// 상세 정보
	
	// JPQL
	@Query(value="select * from boards order by no desc limit :start, 10", nativeQuery = true)
	public List<Board> findAll(@Param("start")  int start);		// 전체 목록 검색	
}
