package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ezen.springdb.dto.BoardDTO;

public interface BoardMapper {
	// DTO의 필드명과 DB의 컬럼명이 같아야 한다.
	
	@Select("SELECT * FROM board ORDER BY board_id DESC")
	List<BoardDTO> getAll();
	
	@Select("SELECT * FROM board WHERE board_id = #{board_id}")
	BoardDTO get(Integer board_id);
	
	@Insert("INSERT INTO board VALUES(board_id_seq.nextval, "
			+ "#{writer_id}, #{writer_pw}, #{write_title}, #{write_content}, sysdate, 0, 0, 0)")
	Integer add(BoardDTO board);
	
	@Update("UPDATE board SET write_title = #{write_title}, write_content = #{write_content} WHERE board_id = #{board_id}")
	Integer update(BoardDTO board);
	
	@Delete("DELETE FROM board WHERE board_id = #{board_id}")
	Integer delete(BoardDTO board);
	
	@Update("UPDATE board SET write_view = write_view + 1 WHERE board_id = #{board_id}")
	Integer increaseView(Integer board_id);
	
	@Update("UPDATE board SET write_view = write_view - 1 WHERE board_id = #{board_id}")
	Integer decreaseView(Integer board_id);
	
	@Update("UPDATE board SET write_recommend = write_recommend + 1 WHERE board_id = #{board_id}")
	Integer increaseRecommend(Integer board_id);
	
	@Update("UPDATE board SET write_not_recommend = write_not_recommend + 1 WHERE board_id = #{board_id}")
	Integer increaseNotRecommend(Integer board_id);
	
}
