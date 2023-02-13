package com.ezen.springdb.board.mapper;

import com.ezen.springdb.dto.BoardDTO;

// Mapper는 테이블 또는 DTO 단위로 작성
public interface ServiceBoardMapper {
	
	BoardDTO get(Integer board_id);
	
	Integer plusView(Integer board_id);
	
}
