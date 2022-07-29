package com.my.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bowling.commons.paging.Criteria;
import com.my.bowling.domain.vo.ReplyVO;
import com.my.bowling.mapper.ReplyMapper;

@Service
public class ReplyServiceimpl implements ReplyService {

	@Autowired
	ReplyMapper replyMapper;
	
	@Override
	public List<ReplyVO> list(Integer articleNo) throws Exception {
		return replyMapper.list(articleNo);
	}

	@Override
	public void create(ReplyVO replyVO) throws Exception {
		replyMapper.create(replyVO);
	}

	@Override
	public void update(ReplyVO replyVO) throws Exception {
		replyMapper.update(replyVO);
	}

	@Override
	public void delete(Integer replyNo) throws Exception {
		replyMapper.delete(replyNo);
	}

	@Override
	public List<ReplyVO> getRepliesPaging(Integer articleNo, Criteria criteria) throws Exception {
		return replyMapper.listPaging(articleNo, criteria);
	}

	@Override
	public int countReplies(Integer aritcleNo) throws Exception {
		return replyMapper.countReplies(aritcleNo);
	}

}
