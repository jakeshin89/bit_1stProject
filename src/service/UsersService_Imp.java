package service;

import java.util.List;

import dao.UsersDAO;
import vo.UsersVO;

public class UsersService_Imp implements UsersService {

	UsersDAO dao;	
	
	public UsersService_Imp() {}

	public UsersService_Imp(UsersDAO dao) {
		this.dao = dao;
	}

	public UsersDAO getDao() {
		return dao;
	}

	public void setDao(UsersDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<UsersVO> usersList() {
		return dao.getUsersRec();
	}

	@Override
	public int addUsers(UsersVO vo) {
		return dao.addUsers(vo);
	}

	@Override
	public int deleteUsers(String id) {
		return dao.deleteUsers(id);
	}

	@Override
	public int updateUsers(UsersVO vo) {
		return dao.updateUsers(vo);
	}

	@Override
	public UsersVO login(UsersVO vo) {
		return dao.login(vo);
	}

}
