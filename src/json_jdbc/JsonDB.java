package json_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.JDBCUtil;

public class JsonDB {

	public static void main(String[] args) {
		
		//System.out.println(JsonDept.getJsonDept("20"));
		System.out.println("========================");
		System.out.println(getALLJasonDept());
	}
	
	public static String idCheck(String id) {
		
		String sql = "select * from users where id = ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				map.put("id", rs.getString("id"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return JSONObject.toJSONString(map);
		
	}
	
	public static String getJsonDept(String deptno) {
		
		String sql = "select * from dept where deptno=? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, deptno);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				map.put("deptno", rs.getString("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return JSONObject.toJSONString(map);
		
	}
	
	
	public static String getALLJasonDept() {
		
		String sql = "select * from dept ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		JSONArray array = new JSONArray();
		
		Map<String, String> map = new HashMap<String, String>();
			
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				map.put("deptno", rs.getString("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
				
				//맵 구조 만들면 자바스크립트 객체 만들고 배열에 넣기
				JSONObject obj = new JSONObject(map);
				array.add(obj);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return JSONArray.toJSONString(array);	
	}	
	
	
	public String temp(String deptno) {
		
		String sql = "select * from dept where deptno=? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, deptno);
			
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return "";
		
	}	
}