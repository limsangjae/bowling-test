package com.my.bowling.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my.bowling.commons.paging.Criteria;
import com.my.bowling.commons.paging.SearchCriteria;
import com.my.bowling.domain.vo.ArticleVO;

@Service
public interface ArticleService {
	void create(ArticleVO articleVO) throws Exception;
	
	ArticleVO read(int articleNo) throws Exception;
	
	void update(ArticleVO articleVO) throws Exception;
	
	void delete(int articleNo) throws Exception;
	
	List<ArticleVO> listAll() throws Exception;
	
	List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
	
	int countArticles(Criteria criteria) throws Exception;
	
	List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;
	
	int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;
	
}
