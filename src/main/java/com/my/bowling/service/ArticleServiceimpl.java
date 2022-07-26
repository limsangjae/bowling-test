package com.my.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bowling.commons.paging.Criteria;
import com.my.bowling.commons.paging.PageMaker;
import com.my.bowling.domain.dao.ArticleDAO;
import com.my.bowling.domain.vo.ArticleVO;

@Service
public class ArticleServiceimpl implements ArticleService{

	@Autowired
	ArticleDAO articleDAO;

	@Override
	public void create(ArticleVO articleVO) throws Exception {
		articleDAO.create(articleVO);
	}

	@Override
	public ArticleVO read(int articleNo) throws Exception {
		return articleDAO.read(articleNo);
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		articleDAO.update(articleVO);
	}

	@Override
	public void delete(int articleNo) throws Exception {
		articleDAO.delete(articleNo);
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		return articleDAO.listAll();
	}

	@Override
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
		return articleDAO.listCriteria(criteria);
	}

	@Override
	public int countArticles(Criteria criteria) throws Exception {
		return articleDAO.countArticles(criteria);
	}
	
}
