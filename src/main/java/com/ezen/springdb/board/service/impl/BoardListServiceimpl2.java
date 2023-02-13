package com.ezen.springdb.board.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springdb.board.mapper.ServiceBoardMapper;
import com.ezen.springdb.board.service.BoardListService;
import com.ezen.springdb.dto.BoardDTO;

@Service
public class BoardListServiceimpl2 implements BoardListService{
	
	@Autowired
	ServiceBoardMapper mapper;
	
	@Override
	public BoardDTO clickTitle(Integer board_id, HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] cookies = request.getCookies();
		boolean viewed = false;
		Cookie viewCookie = null;
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && cookie.getName().equals("viewed")) {
					viewCookie = cookie;
					
					// "33/3456/44/11/55/.." 쿠키 값은 4096 bytes 한계가 있다. 
					String ids = cookie.getValue();
					
					// split한 배열을 리스트로 만들어주기
					String[] splited = ids.split("/");
					List<String> idList = Arrays.asList(splited);
					
					viewed = idList.contains(board_id.toString());
				}
			}
		}
		
		if (!viewed) {
			mapper.plusView(board_id);
			if (viewCookie == null) {
				// 본 적도 없고 쿠키도 없는 경우
				viewCookie = new Cookie("viewed", board_id.toString());
				
				response.addCookie(viewCookie);
			} else {
				// 쿠키는 있지만 이 글을 처음 보는 경우 (맨 뒤에 새 id를 추가)
				viewCookie.setValue(viewCookie.getValue() + "/" + board_id);
				response.addCookie(viewCookie);
			}
			viewCookie.setPath(request.getContextPath() + "/service/board");
		}
		
		return mapper.get(board_id);
	}
	
}
