package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spms.servlets.MessageSend;
import spms.vo.Member;
import spms.vo.Message;

public class MessageDao {
  Connection connection;

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  public List<Message> selectList() throws Exception {
    Statement stmt = null;
    ResultSet rs = null;

    try {
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,DELNO,TITLE,CONTENT,MNAME,CRE_DATE" + 
              " FROM MESSAGE" + " ORDER BY MNO ASC");

      ArrayList<Message> messages = new ArrayList<Message>();

      while(rs.next()) {
        messages.add(new Message()
        .setNo(rs.getInt("MNO"))
        .setDelno(rs.getInt("DELNO"))
        .setTitle(rs.getString("TITLE"))
        .setContent(rs.getString("CONTENT"))
        .setName(rs.getString("MNAME"))
        .setCreatedDate(rs.getDate("CRE_DATE")));
      }

      return messages;

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }
  
  public List<Message> ViewMessage(int no) throws Exception {
    Statement stmt = null;
    ResultSet rs = null;

    try {
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,DELNO,TITLE,CONTENT,MNAME,CRE_DATE" + 
              " FROM MESSAGE" + " WHERE MNO=" + no);

      ArrayList<Message> messages = new ArrayList<Message>();

      while(rs.next()) {
        messages.add(new Message()
        .setNo(rs.getInt("MNO"))
        .setDelno(rs.getInt("DELNO"))
        .setTitle(rs.getString("TITLE"))
        .setContent(rs.getString("CONTENT"))
        .setName(rs.getString("MNAME"))
        .setCreatedDate(rs.getDate("CRE_DATE")));
      }

      return messages;

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }

  public int insert(Message message) throws Exception  {
    PreparedStatement stmt = null;

    try {
      stmt = connection.prepareStatement(
          "INSERT INTO message(MNO,TITLE,CONTENT,MNAME,CRE_DATE)"
              + " VALUES (?,?,?,?,NOW())");
      stmt.setInt(1, message.getNo());
      stmt.setString(2, message.getTitle());
      stmt.setString(3, message.getContent());
      stmt.setString(4, message.getName());
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;
    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {System.out.println("asd");}
    }
  }

  public int delete(String name,int delno) throws Exception {  
    Statement stmt = null;

    try {
      stmt = connection.createStatement();
      return stmt.executeUpdate(
          "DELETE FROM message WHERE MNAME='"+ name + "'AND DELNO=" + delno+"");

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }

  public Message selectOne(int no) throws Exception { 
    Statement stmt = null;
    ResultSet rs = null;
    try {
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,DELNO,TITLE,CONTENT,MNAME,CRE_DATE FROM MESSAGE" + 
              " WHERE MNO=" + no);    
      if (rs.next()) {
        return new Message()
        .setNo(rs.getInt("MNO"))
        .setDelno(rs.getInt("DELNO"))
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
