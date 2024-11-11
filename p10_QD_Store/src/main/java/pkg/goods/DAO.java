package pkg.goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class DAO {
	

	// DAO
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	// DB 접속용 메서드
	public Connection mtdDBConn() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/store_Manager?";
			url += "useSSL=false&";
			url += "useUnicode=true&";
			url += "characterEncoding=UTF8&";
			url += "serverTimezone=Asia/Seoul&";
			url += "allowPublicKeyRetrieval=true";

			String uid = "root";
			String upw = "1234";

			conn = DriverManager.getConnection(url, uid, upw);
			// Select 실행 및 출력영역 시작

		} catch (ClassNotFoundException e) {
			System.out.print(e.getMessage());
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return conn;

	}
	
	
	// 입력용 메서드 시작
	public boolean mtdInsert(DTO dto) {
		
		mtdDBConn();
		boolean chk =false;
		
		try {
			String sql = "insert into goodsList ";
			sql += "(oriFName, upFName, goodsName, ";
			sql += "price, content, remoteIP) ";
			sql += "values (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getOriFName());
			pstmt.setString(2, dto.getUpFName());
			pstmt.setString(3, dto.getGoodsName());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getRemoteIP());
			int rtnCnt = pstmt.executeUpdate();
			if(rtnCnt == 1) {
				chk = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chk;
	}
	
	// 입력용 메서드  끝
	
	
	// 목록 출력용 메서드 시작
	public List<DTO> mtdSelect() {
		
		mtdDBConn();		
		List<DTO> list = new ArrayList<DTO>();
		DTO dto = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from goodsList ";
			sql += "order by number desc";
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				dto = new DTO();
				dto.setNumber(rs.getInt("number"));
				dto.setOriFName(rs.getString("oriFName"));
				dto.setUpFName(rs.getString("upFName"));
				dto.setGoodsName(rs.getString("goodsName"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setRegTM(rs.getTimestamp("regTM"));
				dto.setRemoteIP(rs.getString("remoteIP"));
				
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
		return list;
		
	}
	// 목록 출력용 메서드 끝
	
	// 삭제용 메서드 시작
	public void mtdDelete(HttpServletRequest req) {
		int number = Integer.parseInt(req.getParameter("number"));
		int rtnCnt = 0;
		
		mtdDBConn();
		try {
			String sql = "delete from goodsList where number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rtnCnt = pstmt.executeUpdate();
			if(rtnCnt == 1) {
				System.out.println("삭제 OK!!");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 삭제용 메서드 끝

}
