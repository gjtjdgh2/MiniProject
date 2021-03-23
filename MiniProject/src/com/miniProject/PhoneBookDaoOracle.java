package com.miniProject;

import java.sql.*;
import java.util.*;

public class PhoneBookDaoOracle implements PhoneBookDao {

	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl="jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,"C##gjtjdgh","1234");
			 
			System.out.println("드라이버 로드 성공");
		}catch(ClassNotFoundException e) {
			System.err.println("드라이버 불러오기 실패");
		}finally {
		
		}
		return conn;
	}
	 
	@Override // 리스트 보는것
	public List<PhoneBookVo> getList() {
		List<PhoneBookVo> list = new ArrayList<>();
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "select id , name , hp , tel from PHONE_BOOK";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id =rs.getInt("id");
				String name =rs.getString("name");
				String hp =rs.getString("hp");
				String tel =rs.getString("tel");
				
				PhoneBookVo vo = new PhoneBookVo(id,name,hp,tel);
				
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			
		}
		}
		return list;
	}

	@Override //검색
	public List<PhoneBookVo> search(String keyword) {
		List<PhoneBookVo> list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = " select  id , name , hp , tel from PHONE_BOOK where name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				PhoneBookVo vo = new PhoneBookVo();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setTel(rs.getString(4));
				list.add(vo);
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
		catch(Exception e) {
			
		}
		}
		return list ;
	}

	@Override
	public PhoneBookVo get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override//삽입
	public boolean insert(PhoneBookVo vo) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		int insertCount = 0;
		try {
			conn =getConnection();
			String sql = "insert into  PHONE_BOOK values(seq_phone_book.nextval,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			
			insertCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}
		catch(Exception e) {
			
		}
		}
		return insertCount == 1;
	}

	@Override// 수정
	public boolean update(PhoneBookVo vo) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		int updateCount = 0;
		try {
			conn =getConnection();
			String sql ="update PHONE_BOOK set name =?,ph=?, tel=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(2, vo.getTel());
			
			updateCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		return updateCount ==1;
	}

	@Override //삭제
	public boolean delete(int id) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		try {
			conn = getConnection();
			String sql =" delete from PHONE_BOOK where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			deletedCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		return deletedCount == 1;
	}

}
