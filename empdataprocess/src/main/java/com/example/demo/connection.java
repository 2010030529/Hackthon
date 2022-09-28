package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class connection {
@RequestMapping("/")
public String lonch()
{
	return "insertdata.jsp";
}
	
@RequestMapping("/insert")
public void inputdata(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{   
	res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    
    String id=req.getParameter("id");
    String name=req.getParameter("name");
    String desig=req.getParameter("desig");
    String sal=req.getParameter("sal");
    String dept=req.getParameter("dept");
    String location=req.getParameter("location");
    
    try{
	      
    	Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/emplyee","root","Vamsi123!");
	      
	      PreparedStatement ps= con.prepareStatement("insert into empdata values(?,?,?,?,?,?)");
      //PreparedStatement ps= con.prepareStatement("select name from register where name=? and email=? and password=?");
	      ps.setString(1, id);
	      ps.setString(2, name);
	      ps.setString(3, desig);
	      ps.setString(4, sal);
	      ps.setString(5, dept);
	      ps.setString(6, location);
	      
	      int rs=ps.executeUpdate();
	     
	      if(rs>0)
	      {
	    	  System.out.print("done");
	      }
    }
    catch(Exception e)
    {
    	System.out.print("error");
    }

}
@RequestMapping("/u")
public String updatedata()
{
	return "update.jsp";
}
@RequestMapping("/update")
public void updatedatavalue(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
	res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    
    String desig=req.getParameter("desig");
    String id=req.getParameter("id");
	
   	try{
   	      
       	Class.forName("com.mysql.cj.jdbc.Driver");
   	      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/emplyee","root","Vamsi123!");
   	      
   	      PreparedStatement ps= con.prepareStatement("update empdata set desig=? where id=?");
         //PreparedStatement ps= con.prepareStatement("select name from register where name=? and email=? and password=?");
   	      
   	      ps.setString(1, desig);
   	      ps.setString(2, id);
   	     
   	      int rs=ps.executeUpdate();
   	     
   	      if(rs<=0)
   	      {
   	    	  System.out.print("done");
   	      }
       }
       catch(Exception e)
       {
       	System.out.print("error");
       }
}
@RequestMapping("/d")
public String deletedatavalue()
{
	return "delete.jsp";
}

@RequestMapping("/delete")
public void deletedata(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
	res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    
    String id=req.getParameter("id");
	
	try{
	      
    	Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/emplyee","root","Vamsi123!");
	      
	      PreparedStatement ps= con.prepareStatement("delete from empdata where id=?");
      //PreparedStatement ps= con.prepareStatement("select name from register where name=? and email=? and password=?");
	      
	      ps.setString(1, id);
	      int rs=ps.executeUpdate();
	     
	      if(rs<=0)
	      {
	    	  System.out.print("done");
	      }
    }
    catch(Exception e)
    {
    	System.out.print("error");
    }

}

private String Intiger(String parameter) {
	// TODO Auto-generated method stub
	return parameter;
}


}




