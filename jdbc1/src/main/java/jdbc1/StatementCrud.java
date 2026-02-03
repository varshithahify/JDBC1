package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCrud {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
//		Statement s=c.createStatement();
//		s.execute("create database smart");
//		System.out.println("database created");
		
//		CREATE TABLE
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/smart","root","root");
		Statement s=c.createStatement();
		s.execute("create table if not exists employee(name varchar(20) not null,id int primary key, phone bigint(15) not null unique)");
		System.out.println("Table is created");
		
//		INSERT TABLE
		s.execute("insert into employee values('varsha',101,1234567897)");
		s.execute("insert into employee values('arsha',102, 1234569897)");
		s.execute("insert into employee values('karsha',103, 1234545897)");
		System.out.println("values inserted");
		
//		FETCH row by row
		ResultSet r=s.executeQuery("select* from employee where id=103");
		r.next();
		System.out.println("name:"+r.getString(1)+" "+"Id:"+r.getInt(2)+" "+"phone:"+r.getLong(3));
		
//		FETCH ALL
		ResultSet r1=s.executeQuery("select*from employee");
		while(r1.next()) {
			System.out.println("name:"+r.getString(1)+" "+"Id:"+r.getInt(2)+" "+"phone:"+r.getLong(3));
		}
		
//		UPDATE TABLE
		s.execute("update employee set name='harsha' where id=101");
		s.executeUpdate("update employee set name='keshav' where id=102");
		System.out.println("values updated");
		
//		DELETE TABLE
		s.execute("delete from employee where name='harsha'");
		System.out.println("table deleted");
		
//		DELETE ALL
		s.execute("drop table employee");
		System.out.println("table deleted");
	}

}
