package com.my.bowling.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my.bowling.commons.paging.Criteria;
import com.my.bowling.commons.paging.PageMaker;
import com.my.bowling.domain.vo.ArticleVO;

@Service
public interface ArticleService {
	public void create(ArticleVO articleVO) throws Exception;
	public ArticleVO read(int articleNo) throws Exception;
	public void update(ArticleVO articleVO) throws Exception;
	public void delete(int articleNo) throws Exception;
	public List<ArticleVO> listAll() throws Exception;
	
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
	
	public int countArticles(Criteria criteria) throws Exception;
	
}
