package service;

import java.util.List;

import vo.UsersVO;

public interface UsersService {

	List<UsersVO> usersList();
	int addUsers(UsersVO vo);
	int deleteUsers(String id);
	int updateUsers(UsersVO vo);
	UsersVO login (UsersVO vo);
	
}