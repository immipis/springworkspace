package com.yedam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;



@Controller // 라우팅
public class BoardController {
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 전체조회 기능
	@GetMapping("boardList") // 1) url + method
	public String boardList(Model model) { // 2-1을 수행하기 위해 model을 사용
		List<BoardVO> list = boardService.findBoardList();// 2) service
		model.addAttribute("boards", list);// 2-1) service의 결과를 view에 전달
		return "board/list"; // 3) View
		// ViewResolver : 경로생성
		// prefix, classpath :/templates/
		// suffix, .html
		// prefix + retrun + suffix
		// classpath:/templates/board/list.html
	}
	
	@GetMapping("boardInfo")
	public String empInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.findBoard(boardVO);// 2) Service
		model.addAttribute("board", findVO);// 2-1) Service의 결과를 view에 전달
		return "board/info";// 3) View
	}
	
	// 등록 페이지와 처리 컨트롤 필요
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/insert";
	}
	
	// 등록 - 처리 일반적으로 form 활용 => queryString
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		int bno = boardService.insertBoardInfo(boardVO);
		return "redirect:boardInfo?bno=" + bno;
	}
	
	
		
}
