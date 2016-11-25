package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spms.vo.Member;

public class MemberDao {
  Connection connection;

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  public List<Member> selectList() throws Exception {
    Statement stmt = null;
    ResultSet rs = null;

    try {
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,MNAME,EMAIL,CRE_DATE,SEX,P_NUM,HOBBY,AGE,POINT" + 
              " FROM MEMBERS" +
          " ORDER BY MNO ASC");
      ArrayList<Member> members = new ArrayList<Member>();
      
      while(rs.next()) {
        members.add(new Member()
        .setNo(rs.getInt("MNO"))
        .setName(rs.getString("MNAME"))
        .setEmail(rs.getString("EMAIL"))
        .setCreatedDate(rs.getDate("CRE_DATE"))
        .setSex(rs.getString("SEX"))
        .setPnum(rs.getString("P_NUM"))
        .setHobby(rs.getString("HOBBY"))
        .setAge(rs.getInt("AGE"))
        .setPoint(rs.getInt("POINT")));
      }
      
      return members;

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }

  public int insert(Member member) throws Exception  {
    PreparedStatement stmt = null;

    try {
      stmt = connection.prepareStatement(
          "INSERT INTO MEMBERS(EMAIL,PWD,MNAME,CRE_DATE,MOD_DATE,SEX,P_NUM,HOBBY,AGE)"
              + " VALUES (?,?,?,NOW(),NOW(),?,?,?,?)");
      stmt.setString(1, member.getEmail());
      stmt.setString(2, member.getPassword());
      stmt.setString(3, member.getName());
      stmt.setString(4, member.getSex());
      stmt.setString(5, member.getPnum());
      stmt.setString(6, member.getHobby());
      stmt.setInt(7, member.getAge());
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;
    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {System.out.println("asd");}
    }
  }

  public int delete(int no) throws Exception {  
    Statement stmt = null;

    try {
      stmt = connection.createStatement();
      return stmt.executeUpdate(
          "DELETE FROM MEMBERS WHERE MNO=" + no);

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }

  public Member selectOne(int no) throws Exception { 
    Statement stmt = null;
    ResultSet rs = null;
    try {
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,EMAIL,MNAME,P_NUM,SEX,HOBBY,AGE,CRE_DATE,POINT FROM MEMBERS" + 
              " WHERE MNO=" + no);    
      if (rs.next()) {
        return new Member()
        .setNo(rs.getInt("MNO"))
        .setEmail(rs.getString("EMAIL"))
        .setName(rs.getString("MNAME"))
        .setPnum(rs.getString("P_NUM"))
        .setSex(rs.getString("SEX"))
        .setHobby(rs.getString("HOBBY"))
        .setAge(rs.getInt("AGE"))
        .setCreatedDate(rs.getDate("CRE_DATE"))
        .setPoint(rs.getInt("POINT"));

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

  public int update(Member member) throws Exception { 
    PreparedStatement stmt = null;
    try {
      stmt = connection.prepareStatement(
          "UPDATE MEMBERS SET EMAIL=?,MNAME=?,MOD_DATE=now()"
              + " WHERE MNO=?");
      stmt.setString(1, member.getEmail());
      stmt.setString(2, member.getName());
      stmt.setInt(3, member.getNo());
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
    }
  }
  public int AddPoint(Member member) throws Exception{
	  PreparedStatement stmt = null;
	  try {
	      stmt = connection.prepareStatement(
	          "UPDATE MEMBERS SET POINT=POINT+50"
	              + " WHERE MNAME=?");
	      stmt.setString(1, member.getName());
	      return stmt.executeUpdate();

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	    }
  }
  
  public Member exist(String email, String password) throws Exception {
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = connection.prepareStatement(
          "SELECT * FROM MEMBERS"
              + " WHERE EMAIL=? AND PWD=?");
      stmt.setString(1, email);
      stmt.setString(2, password);
      rs = stmt.executeQuery();
      if (rs.next()) {
        return new Member()
        		.setNo(rs.getInt("MNO"))
                .setName(rs.getString("MNAME"))
                .setEmail(rs.getString("EMAIL"))
                .setCreatedDate(rs.getDate("CRE_DATE"))
                .setSex(rs.getString("SEX"))
                .setPnum(rs.getString("P_NUM"))
                .setHobby(rs.getString("HOBBY"))
                .setAge(rs.getInt("AGE"))
        		.setPoint(rs.getInt("POINT"));
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
  public Member dbupdate(String name) throws Exception {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	      stmt = connection.prepareStatement(
	          "SELECT * FROM MEMBERS "
	    		+  " WHERE EMAIL = ?");
	      stmt.setString(1,name);
	      rs = stmt.executeQuery();
	      if (rs.next()) {
	        return new Member()
	        		.setNo(rs.getInt("MNO"))
	                .setName(rs.getString("MNAME"))
	                .setEmail(rs.getString("EMAIL"))
	                .setCreatedDate(rs.getDate("CRE_DATE"))
	                .setSex(rs.getString("SEX"))
	                .setPnum(rs.getString("P_NUM"))
	                .setHobby(rs.getString("HOBBY"))
	                .setAge(rs.getInt("AGE"))
	        		.setPoint(rs.getInt("POINT"));
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
  public int point(String name) throws Exception{
	  PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int point = 0;
	    try {
	      stmt = connection.prepareStatement(
	          "SELECT * FROM MEMBERS "
	    		+  " WHERE EMAIL = ?");
	      stmt.setString(1,name);
	      rs = stmt.executeQuery();
	      while(rs.next()){
	    	  point = rs.getInt("POINT");
	      }
	      return point;
	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (rs != null) rs.close();} catch (Exception e) {}
	      try {if (stmt != null) stmt.close();} catch (Exception e) {}
	    }
  }
  public List<Member> PointRank() throws Exception {
	    Statement stmt = null;
	    ResultSet rs = null;

	    try {
	      stmt = connection.createStatement();
	      rs = stmt.executeQuery(
	              "SELECT MNO,MNAME,EMAIL,CRE_DATE,SEX,P_NUM,HOBBY,AGE,POINT" + 
	                  " FROM MEMBERS" +
	              " ORDER BY POINT DESC");
	      ArrayList<Member> members = new ArrayList<Member>();
	      
	      while(rs.next()) {
	        members.add(new Member()
	        .setNo(rs.getInt("MNO"))
	        .setName(rs.getString("MNAME"))
	        .setEmail(rs.getString("EMAIL"))
	        .setCreatedDate(rs.getDate("CRE_DATE"))
	        .setSex(rs.getString("SEX"))
	        .setPnum(rs.getString("P_NUM"))
	        .setHobby(rs.getString("HOBBY"))
	        .setAge(rs.getInt("AGE"))
	        .setPoint(rs.getInt("POINT")));
	      }
	      
	      return members;

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (rs != null) rs.close();} catch(Exception e) {}
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	    }
	  }

}
