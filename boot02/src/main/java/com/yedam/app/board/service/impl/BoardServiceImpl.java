package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service // bean 등록 => @Transcational 사용가능한 게 서비스 뿐
public class BoardServiceImpl implements BoardService{
	private BoardMapper boardMapper;
	
	@Autowired // DI
	BoardServiceImpl(BoardMapper boardMapper){
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<BoardVO> findBoardList() {
		return boardMapper.selectAllList();
	}

	@Override
	public BoardVO findBoard(BoardVO boardVO) {
		return boardMapper.selectInfo(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}
	
	
}
