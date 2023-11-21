package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository dao;

	public Board insert(Board board) {
		// TODO Auto-generated method stub
		return dao.save(board);
	}

	public long getCount() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	public List<Board> getList(int page) {
		// TODO Auto-generated method stub
		return dao.findAll(page);
	}

	public Board getContent(int no) {
		// TODO Auto-generated method stub
		return dao.findByNo(no);
	}

	public Board update(Board board) {
		// TODO Auto-generated method stub
		return dao.save(board);
	}

	public void delete(Board board) {
		// TODO Auto-generated method stub
		dao.delete(board);
	}

}
