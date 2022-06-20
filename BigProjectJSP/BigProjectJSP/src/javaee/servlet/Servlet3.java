package javaee.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String identify =request.getParameter("identify");//获取身份
		String name =request.getParameter("name");//获取用户名
		String password =request.getParameter("password");//获取密码
		int identify1=Integer.parseInt(identify);//强制类型转换
		try {
			insertdata(identify1,name,password);
			System.out.println("管理员增加账号成功");
			//这边我们使用重定向来转换资源
			response.setStatus(302);
			response.setHeader("location","manage.jsp");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void insertdata(int id,String name,String password) throws ClassNotFoundException,SQLException{
		 Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "18943038195");//localhost是本机地址，3306是端口号，最后是用户名和密码
		 Statement stmt=conn.createStatement();//实例化Statement对象
		 String sql="insert into javaee.user(iduser,name,password)"
				 +"values("+id+",'"+name+"','"+password+"')";
		 stmt.executeUpdate(sql);
		 stmt.close();
		 conn.close();

	}

}
