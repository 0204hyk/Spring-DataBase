package com.ezen.springdb.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import lombok.Data;

@Data
public class Reply {

	private Integer reply_id;
	private String commenter_id;
	private String commenter_pw;
	private String reply_content;
	private Date reply_date;
	private Integer board_id;
	
	private static SimpleDateFormat dayFormat = new SimpleDateFormat("yy.MM.dd");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	
	public String getCreationDateTime() {		
		LocalDate creationDate = LocalDate.ofInstant(reply_date.toInstant(), ZoneId.systemDefault());
		LocalDate today = LocalDate.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
		
		return creationDate.isEqual(today) ? 
				timeFormat.format(reply_date) : dayFormat.format(reply_date);		
	}

}
