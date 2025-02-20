package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	public List<BoardVO> selectAllList();
	public BoardVO selectInfo(BoardVO boardVO);
	public int insertBoard(BoardVO boardVO);
}
