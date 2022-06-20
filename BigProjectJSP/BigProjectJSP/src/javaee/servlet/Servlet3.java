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
		String identify =request.getParameter("identify");//��ȡ���
		String name =request.getParameter("name");//��ȡ�û���
		String password =request.getParameter("password");//��ȡ����
		int identify1=Integer.parseInt(identify);//ǿ������ת��
		try {
			insertdata(identify1,name,password);
			System.out.println("����Ա�����˺ųɹ�");
			//�������ʹ���ض�����ת����Դ
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
		 Class.forName("com.mysql.jdbc.Driver");//����mysql����
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "18943038195");//localhost�Ǳ�����ַ��3306�Ƕ˿ںţ�������û���������
		 Statement stmt=conn.createStatement();//ʵ����Statement����
		 String sql="insert into javaee.user(iduser,name,password)"
				 +"values("+id+",'"+name+"','"+password+"')";
		 stmt.executeUpdate(sql);
		 stmt.close();
		 conn.close();

	}

}
