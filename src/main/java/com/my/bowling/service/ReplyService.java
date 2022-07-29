package com.my.bowling.service;

import java.util.List;

import com.my.bowling.commons.paging.Criteria;
import com.my.bowling.domain.vo.ReplyVO;

public interface ReplyService {

	List<ReplyVO> list(Integer articleNo) throws Exception;
	
	void create(ReplyVO replyVO) throws Exception;
	
	void update(ReplyVO replyVO) throws Exception;
	
	void delete(Integer replyNo) throws Exception;
	
	List<ReplyVO> getRepliesPaging(Integer articleNo, Criteria criteria) throws Exception;
	
	int countReplies(Integer aritcleNo) throws Exception;
}
