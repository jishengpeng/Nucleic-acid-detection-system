package javaee.upload;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet7
 */
@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet7() {
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
		String tube=request.getParameter("tubeid");
		String result=request.getParameter("hesuan");
		//进行字符串匹配，找到每个试剂管
		String[] reportid=new String[10];
		int length1=tube.length();
		int num=0;
		reportid[num]="";
		for(int i=0;i<length1;i++){
			if(tube.charAt(i)==','){
				num=num+1;
				reportid[num]="";
				System.out.println(reportid[num-1]);
			}
			else{
				reportid[num]=reportid[num]+tube.charAt(i);
			}
		}
		//将其写进数据库中
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "18943038195");//localhost是本机地址，3306是端口号，最后是用户名和密码
			String sql="update javaee.report set result=? where reportid=?";
			PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sql);//实例化Statement对象
			for(int i=0;i<=num;i++){
				pstmt.setString(1,result);
				pstmt.setString(2,reportid[i]);
				pstmt.executeUpdate();
			}			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result.equals("1")){
			//是阳性输出警告
			response.setStatus(302);
			response.setHeader("location","uploadwrong.jsp");
		}
		else{
			//是阴性，写入数据库并且登出
			response.setStatus(302);
			response.setHeader("location","login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void Producer(){
		
	}
	
	public void Consumer(){
		
	}

}
