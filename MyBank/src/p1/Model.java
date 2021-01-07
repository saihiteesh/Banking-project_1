package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
	private String custid;
	private String accno;
	private String pwd;
	private String balance;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getCustid() {
		return custid;
	}
	public String getAccno() {
		return accno;
	}
	public String getPwd() {
		return pwd;
	}
	public String getBalance() {
		return balance;
	}

public Model()//Constructor are created so that it executes first because loader and connection should establish
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("DRIVER LOADED");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/root");
		System.out.println("connection established");
	}
	catch(Exception e)
	{
		System.out.println("problem in connection");
	}
}
	public boolean Login()
	{
	try
	{
		pstmt=con.prepareStatement("SELECT * FROM CUSTOMERDATA WHERE CUSTID=? AND PWD=?");
		pstmt.setString(1, custid);
		pstmt.setString(2, pwd);
		if(res.next()==true)
		{
			accno=res.getString("ACCNO");
			return true;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
	}
}

public boolean checkBalance()
{
	try {
		pstmt=con.prepareStatement("SELECT * FROM MyBank WHERE AccNo=?");
		pstmt.setString(1,accno);
		res=pstmt.executeQuery();
		if(res.next()==true)
		{
			balance=res.getString("BALANCE");
			return true;
		}
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return false;
}
public boolean ChangePwd()
{
	try{
		pstmt=con.prepareStatement("UPDATE Mybank SET PWD=? WHERE ACCNO=?");
		pstmt.setString(1,pwd);
		pstmt.setString(2,accno);
		int row=pstmt.executeUpdate();
		if(row==0)
		{
			return false;
		}
	}
	catch(Exception e)
	{
	}
	return true;
}
}


