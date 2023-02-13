package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ezen.springdb.dto.Reply;

public interface ReplyMapper {
	
	@Select("SELECT * FROM reply WHERE board_id = #{board_id} ORDER BY reply_id")
	List<Reply> getAll(Integer board_id);
	
	@Insert("INSERT INTO reply VALUES(reply_id_seq.NEXTVAL, #{commenter_id}, #{commenter_pw}, #{reply_content}, sysdate, #{board_id})")
	Integer write(Reply reply);
	
}
