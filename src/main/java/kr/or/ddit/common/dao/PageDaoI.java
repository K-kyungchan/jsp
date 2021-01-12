package kr.or.ddit.common.dao;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface PageDaoI {
	List<PageVo> selectPagingUser(PageVo page);
	
}
		