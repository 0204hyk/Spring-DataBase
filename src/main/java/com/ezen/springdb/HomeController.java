package com.ezen.springdb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j2;
import model.Coffee;

/**
 * Handles requests for the application home page.
 */
@Log4j2	     // Log4j2 어노테이션을 사용하면 log 생성자를 자동으로 만들어줌
@Controller
public class HomeController {
	
	@Autowired
	Coffee coffee; // root-context에 등록해놓은 Coffee를 상속받은 CafeMocha의 값이 자동으로 들어온다.
				   // 같은 방식으로 HikariConfig객체와 이를 사용한 HikariDataSource를 등록해놓을 수 있다.
	
	@Autowired
	DataSource ds;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		log.info(coffee);
		log.info(ds);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
