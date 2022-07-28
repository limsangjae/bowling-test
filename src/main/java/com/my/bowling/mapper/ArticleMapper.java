package com.my.bowling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my.bowling.commons.paging.Criteria;
import com.my.bowling.commons.paging.SearchCriteria;
import com.my.bowling.domain.vo.ArticleVO;

@Mapper
public interface ArticleMapper {
	public void create(ArticleVO articleVO);
	public ArticleVO read(int articleNo);
	public void update(ArticleVO articleVO);
	public void delete(int articleNo);
	public List<ArticleVO> listAll();
	public List<ArticleVO> listPaging(int page);
	public List<ArticleVO> listCriteria(Criteria criteria);
	public int countArticles(Criteria criteria);
	public List<ArticleVO> listSearch(SearchCriteria searchCriteria);
	public int countSearchedArticles(SearchCriteria searchCriteria);
}
