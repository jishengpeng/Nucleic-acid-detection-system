package javaee.query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Servlet8
 */
@WebServlet("/Servlet8")
public class Servlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet8() {
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
		String studentnumber=request.getParameter("id");
		String tmp1="";
		String tmp2="";
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "18943038195");//localhost是本机地址，3306是端口号，最后是用户名和密码
			String sql="select studentname,result from javaee.report where studentid=?";
			PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sql);//实例化Statement对象
			pstmt.setString(1, studentnumber);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				tmp1=rs.getString("studentname");
				tmp2=rs.getString("result");
			}
			rs.close();
			pstmt.close();
			conn.close();
			System.out.println(studentnumber+tmp1+tmp2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //向增加页面写入
        request.setAttribute("value1", studentnumber);
        request.setAttribute("value2", tmp1);
        request.setAttribute("value3", tmp2);
		request.getRequestDispatcher("queryresult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
