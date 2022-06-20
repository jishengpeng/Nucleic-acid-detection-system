package javaee.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
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
//		System.out.println("jsp1");
		try {
			int flag=getdata(name,password);
			if(flag==1){
				//进行判断来决定跳转到哪个页面，不同身份不同页面
				if(identify.equals("1")){
					request.getRequestDispatcher("manage.jsp").forward(request, response);
				}
				else{
					if(identify.equals("2")){
						request.getRequestDispatcher("enter.jsp").forward(request, response);
					}
					else{
						if(identify.equals("3")){
							request.getRequestDispatcher("upload.jsp").forward(request, response);
						}
						else{
							request.getRequestDispatcher("query.jsp").forward(request, response);
						}
					}
				}
			}
			else{
				request.getRequestDispatcher("wrong.jsp").forward(request, response);
			}
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
	
	//定义数据库的一些操作
	public int getdata(String name,String password) throws ClassNotFoundException,SQLException{
		 Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "18943038195");//localhost是本机地址，3306是端口号，最后是用户名和密码
		 Statement stmt=conn.createStatement();//实例化Statement对象
		 String queryNumberSQL="SELECT * from javaee.user";
		 ResultSet rs=stmt.executeQuery(queryNumberSQL);//执行数据库查询操作并获取结果集
		 int flag=0;
		 while(rs.next()){
//			 int id=rs.getInt("iduser");
			 String name1=rs.getString("name");
			 String password1=rs.getString("password");
//			 System.out.println(id);
//			 System.out.println(name1);
//			 System.out.println(password1);
			 if(name.equals(name1)){
				 if(password.equals(password1)){
					 flag=1;
				 }
			 }
		 }
		 rs.close();
		 stmt.close();
		 conn.close();
		 System.out.println(flag);
		 return flag;
	}

}
