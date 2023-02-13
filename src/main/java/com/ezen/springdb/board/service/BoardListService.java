package com.ezen.springdb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.springdb.dto.BoardDTO;

public interface BoardListService {

	BoardDTO clickTitle(Integer board_id, HttpServletRequest request, HttpServletResponse response);
	
//	Member clickWriterName();
	
}
