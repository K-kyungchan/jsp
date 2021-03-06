package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceI {
	List<UserVo> selectAllUser();

	UserVo selectUser(String userid);

	Map<String, Object> selectPagingUser(PageVo page);
	
	int modifyUser(UserVo userVo);
	
	int registUser(UserVo userVo);
	
	int deleteUser(String userid);
}
