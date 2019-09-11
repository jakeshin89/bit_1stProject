package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.UsersVO;

public class UsersDAO_Oracle extends UsersDAO{

	
	public List<UsersVO> getUsersRec(){
		
		String sql = "select * from users order by id";
		
		List<UsersVO> list = new ArrayList<UsersVO>();
			
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			while (rs.next()) {		
				UsersVO users = new UsersVO();			
				users.setId(rs.getString("id"));
				users.setPassword(rs.getString("password"));
				users.setName(rs.getString("name"));
				users.setRole(rs.getString("role"));
				list.add(users);
			}					
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}	
		return list;
	}
	
	
	public List<UsersVO> getUsersRec(int page, int n){

		String sql = "select * from users order by id";
		
		List<UsersVO> list = new ArrayList<UsersVO>();
			
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			while (rs.next()) {		
				UsersVO users = new UsersVO();			
				users.setId(rs.getString("id"));
				users.setPassword(rs.getString("password"));
				users.setName(rs.getString("name"));
				users.setRole(rs.getString("role"));
				list.add(users);
			}					
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}	
		return list;
	}
	
	
	public UsersVO login(UsersVO vo) {
		
		String sql = "select * from users where id = ? and password = ?";
		
		UsersVO data = null;
			
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				data = new UsersVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}					
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}	
		System.out.println(data);
		return data;
	}
	
	
	public int addUsers(UsersVO users) {
		
		String sql ="insert into users(id, password, name, role) "+
		"values(?, ?, ?, ?) ";

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, users.getId());
			ps.setString(2, users.getPassword());
			ps.setString(3, users.getName());
			ps.setString(4, users.getRole());
			
			result = ps.executeUpdate();
				
			} catch (Exception e) {
				e.getStackTrace();
			} finally {
				JDBCUtil.close(null, ps, con);
			}
			System.out.println(result);
			return result;
	}
		
	public int updateUsers(UsersVO users) {
		
		String sql = 
				
		"update users set password = ? "+
		"where id = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, users.getPassword());
			ps.setString(2, users.getId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		return result;
	}
	
	
	public void searchUsers(String id) {
		
		String sql = 

		"select * from users where upper(id) like ? "+
		"order by id";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+id.toUpperCase()+"%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString("id")+"   ");
				System.out.print(rs.getString("name")+"   ");
				System.out.print(rs.getString("role")+"   ");
				System.out.println();
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
	}


	public int deleteUsers(String id) {
		
		String sql = "delete from users where id = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		return result;
	}
}