package com.my.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bowling.commons.paging.Criteria;
import com.my.bowling.commons.paging.SearchCriteria;
import com.my.bowling.domain.vo.ArticleVO;
import com.my.bowling.mapper.ArticleMapper;

@Service
public class ArticleServiceimpl implements ArticleService{

	@Autowired
	ArticleMapper articleMapper;

	@Override
	public void create(ArticleVO articleVO) throws Exception {
		articleMapper.create(articleVO);
	}
 
	@Override
	public ArticleVO read(int articleNo) throws Exception {
		return articleMapper.read(articleNo);
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		articleMapper.update(articleVO);
	}

	@Override
	public void delete(int articleNo) throws Exception {
		articleMapper.delete(articleNo);
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		return articleMapper.listAll();
	}

	@Override
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
		return articleMapper.listCriteria(criteria);
	}

	@Override
	public int countArticles(Criteria criteria) throws Exception {
		return articleMapper.countArticles(criteria);
	}

	@Override
	public List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception {
		return articleMapper.listSearch(searchCriteria);
	}

	@Override
	public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception {
		return articleMapper.countSearchedArticles(searchCriteria);
	}
	
}
