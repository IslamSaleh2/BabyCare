package database;

import com.mysql.jdbc.Connection;
import entity.Baby;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BabyDb {

    public static java.sql.Connection getCon(){
        java.sql.Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/babycare","root","root");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static int save(Baby b){
        int status=0;
        try{
            Connection con= (Connection) getCon();
            PreparedStatement ps=con.prepareStatement("insert into babyname(name,meaning,sex,religion) values(?,?,?,?)");
            ps.setString(1,b.getName());
            ps.setString(2,b.getMeaning());
            ps.setString(3,b.getSex());
            ps.setString(4,b.getReligion());
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    public static List<Baby> getAllRecords(){
        List<Baby> list =new ArrayList<Baby>();
        try{
            Connection con=(Connection) getCon();
            PreparedStatement ps =con.prepareStatement("select * from babyname");
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                Baby baby=new Baby();
                baby.setId(resultSet.getInt(1));
                baby.setName(resultSet.getString(2));
                baby.setMeaning(resultSet.getString(3));
                baby.setSex(resultSet.getString(4));
                baby.setReligion(resultSet.getString(5));
                list.add(baby);
            }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    public static int delete(int id){
        int status=0;
        try{
            Connection con= (Connection) getCon();
            PreparedStatement ps=con.prepareStatement("delete from babyname where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

    public static List<Baby> getRecordsByReligion(String religion){
        List<Baby> list=new ArrayList<Baby>();
        try{
            Connection con= (Connection)getCon();
            PreparedStatement ps=con.prepareStatement("select * from babyname where religion=? ");
            ps.setString(1,religion);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Baby b=new Baby();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setMeaning(rs.getString(3));
                b.setSex(rs.getString(4));
                b.setReligion(rs.getString(5));
                list.add(b);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }

    public static List<Baby> getRecordsByStart(String start){
        List<Baby> list=new ArrayList<Baby>();
        try{
            Connection con= (Connection) getCon();
            PreparedStatement ps=con.prepareStatement("select * from babyname where name like '"+start+"%' ");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Baby b=new Baby();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setMeaning(rs.getString(3));
                b.setSex(rs.getString(4));
                b.setReligion(rs.getString(5));
                list.add(b);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }

}
