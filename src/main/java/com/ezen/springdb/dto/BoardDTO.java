package com.ezen.springdb.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
		
	private Integer board_id;
	private String writer_id;
	private String writer_pw;
	private String write_title;
	private String write_content;
	private Date write_date;
	private Integer write_view;
	private Integer write_recommend;
	private Integer write_not_recommend;
	
	private static SimpleDateFormat dayFormat = new SimpleDateFormat("yy.MM.dd");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	
	public String getCreationDateTime() {		
		LocalDate creationDate = LocalDate.ofInstant(write_date.toInstant(), ZoneId.systemDefault());
		LocalDate today = LocalDate.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
		
		return creationDate.isEqual(today) ? 
				timeFormat.format(write_date) : dayFormat.format(write_date);		
	}
}
