package com.my.bowling.domain.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ReplyVO {
	private Integer replyNo;
	private Integer articleNo;
	private String replyText;
	private String replyWriter;
	private Date regDate;
	private Date updateDate;
}
