package com.my.bowling.domain.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ArticleVO {
	private int articleNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
}
