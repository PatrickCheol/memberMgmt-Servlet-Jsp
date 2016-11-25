package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import spms.vo.Board;
import spms.vo.Member;

public class BoardDao {
  Connection connection;

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  public List<Board> BoardList() throws Exception {
	    Statement stmt = null;
	    ResultSet rs = null;

	    try {
	      stmt = connection.createStatement();
	      rs = stmt.executeQuery(
	              "SELECT MNO,MNAME,TEXT,CRE_DATE" + 
	                  " FROM BOARD" +
	              " ORDER BY MNO DESC");
	      ArrayList<Board> boards = new ArrayList<Board>();
	      
	      while(rs.next()) {
	        boards.add(new Board()
	        .setNo(rs.getInt("MNO"))
	        .setName(rs.getString("MNAME"))
	        .setText(rs.getString("TEXT"))
	        .setCreatedDate(rs.getDate("CRE_DATE")));
	      }
	      
	      return boards;

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (rs != null) rs.close();} catch(Exception e) {}
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	    }
	  }
  public int insert(Board board) throws Exception  {
    PreparedStatement stmt = null;

    try {
      stmt = connection.prepareStatement(
          "INSERT INTO board(MNAME,TEXT,CRE_DATE)"
              + " VALUES (?,?,NOW())");
      stmt.setString(1, board.getName());
      stmt.setString(2, board.getText());
      System.out.println(board.getName());
      System.out.println(board.getText());
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;
    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }

  public int delete(int no) throws Exception {  
    Statement stmt = null;

    try {
      stmt = connection.createStatement();
      return stmt.executeUpdate(
          "DELETE FROM board WHERE MNO=" + no);

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }
/*
  public Message selectOne(int no) throws Exception { 
    Statement stmt = null;
    ResultSet rs = null;
    try {
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,TITLE,CONTENT,MNAME,CRE_DATE FROM MESSAGE" + 
              " WHERE MNO=" + no);    
      if (rs.next()) {
        return new Message()
        .setNo(rs.getInt("MNO"))
        .setTitle(rs.getString("TITLE"))
        .setContent(rs.getString("CONTENT"))
        .setName(rs.getString("MNAME"))
        .setCreatedDate(rs.getDate("CRE_DATE"));

      } else {
        throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
      }

    } catch (Exception e) {
      throw e;
    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }
  */
/*
  public Message exist(String email, String password) throws Exception {
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = connection.prepareStatement(
          "SELECT MNAME,MNO FROM MESSAGE"
              + " WHERE EMAIL=? AND PWD=?");
      stmt.setString(1, email);
      stmt.setString(2, password);
      rs = stmt.executeQuery();
      if (rs.next()) {
        return new Message()
          .setName(rs.getString("MNAME"))
          .setEmail(rs.getString("EMAIL"));
      } else {
        return null;
      }
    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch (Exception e) {}
      try {if (stmt != null) stmt.close();} catch (Exception e) {}
    }
  }
 */

}
