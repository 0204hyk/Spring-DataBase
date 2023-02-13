package com.ezen.springdb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springdb.dto.BoardDTO;
import com.ezen.springdb.dto.Reply;
import com.ezen.springdb.mapper.BoardMapper;
import com.ezen.springdb.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	BoardMapper board_mapper;
	
	@Autowired
	ReplyMapper reply_mapper;
	
	@GetMapping(value = {"/list", "/"})
	public void list(Model model, HttpServletRequest req) {
		String pageStr = req.getParameter("page");
		
		List<BoardDTO> boards = board_mapper.getAll();
		
		int page; 
		
		if (pageStr == null) {
			page = 1;
		} else {
			page = Integer.parseInt(pageStr);
		}
		
		int page_size = 10;
		int board_size = boards.size();
		int start_index = (page - 1) * page_size;
		int end_index = page * page_size;
		end_index = end_index > board_size ? board_size : end_index;
		
		int max_page = board_size % page_size == 0 ?
				board_size / page_size : board_size / page_size + 1;
		
		int pagination_start = (page / page_size) * page_size + 1;
		int pagination_end;
		
		if (page % 10 == 0) {
			pagination_end = (page / page_size) * page_size; 
		} else {
			pagination_end = (page / page_size + 1) * page_size;
		}
		
		pagination_end = pagination_end > max_page ? max_page : pagination_end;
		
		model.addAttribute("boards", boards.subList(start_index, end_index));
		model.addAttribute("pagination_start", pagination_start);
		model.addAttribute("pagination_end", pagination_end);
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write_form";
	}
	
	@PostMapping("/write")
	public String writeSumbit(BoardDTO board) {
		board_mapper.add(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/contents")
	public void contents(Model model, Integer board_id) {
		model.addAttribute("board", board_mapper.get(board_id));
		int row = board_mapper.increaseView(board_id);		
		model.addAttribute("replys", reply_mapper.getAll(board_id));
	}
	
	@GetMapping("/modify")
	public String modifyPwCheck(Model model, Integer board_id) {
		model.addAttribute("type", "modify");
		model.addAttribute("board_id", board_id);
		return "board/password";
	}
	
	@PostMapping("/modify")
	public String modify(Model model, HttpServletRequest req, Integer board_id) {
		String user_pw = req.getParameter("user_pw");
		
		if (board_id == null) {
			System.out.println("board_id 없음");
			return "redirect:/board/list";
		}
		BoardDTO b = board_mapper.get(board_id);
		
		req.setAttribute("board", b);
		
		if (b != null && b.getWriter_pw().equals(user_pw)) {
			return "board/modi_form";
		} else {
			System.out.println("비밀번호 틀림");
			return "redirect:/board/contents?board_id=" + board_id;
		}		
	}
	
	@PostMapping("/modify/do")
	public String modifySubmit(Model model, HttpServletRequest req, Integer board_id) {
		String write_title = req.getParameter("write_title");
		String write_content = req.getParameter("write_content");

		BoardDTO b = board_mapper.get(board_id);
		
		b.setBoard_id(board_id);
		b.setWrite_title(write_title);
		b.setWrite_content(write_content);
		
		board_mapper.update(b);
		model.addAttribute("board_id", board_id);
		
		return "board/modify_complete";
	}
	
	@GetMapping("/delete")
	public String deletePwCheck(Model model, Integer board_id) {
		model.addAttribute("type", "delete");
		model.addAttribute("board_id", board_id);
		return "board/password";
	}
	
	@PostMapping("/delete")
	public String delete(Model model, HttpServletRequest req, Integer board_id) {
		String user_pw = req.getParameter("user_pw");
		
		if (board_id == null) {
			System.out.println("board_id 없음");
			return "redirect:" + req.getContextPath() + "/list";
		}
		
		BoardDTO b = board_mapper.get(board_id);
		
		if (b != null && b.getWriter_pw().equals(user_pw)) {
			board_mapper.delete(b);
			return "board/delete_complete";
			
		} else {
			System.out.println("비밀번호 틀림");
			return "redirect:/board/contents?board_id=" + board_id;
		}
	}
	
	@PostMapping("/write_reply")
	public String writeReply(Reply reply) {
		reply_mapper.write(reply);
		
		return "redirect:/board/contents?board_id=" + reply.getBoard_id();
	}
	
	@GetMapping("/recommend")
	public String recommend(Integer board_id) {
		board_mapper.increaseRecommend(board_id);
		board_mapper.decreaseView(board_id);
		return "redirect:/board/contents?board_id=" + board_id;
	}
	
	@GetMapping("/not_recommend")
	public String notRecommend(Integer board_id) {
		board_mapper.increaseNotRecommend(board_id);
		board_mapper.decreaseView(board_id);
		return "redirect:/board/contents?board_id=" + board_id;
	}
}	
