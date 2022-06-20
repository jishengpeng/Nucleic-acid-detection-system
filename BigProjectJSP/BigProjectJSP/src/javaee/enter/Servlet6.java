package javaee.enter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javaee.ejb.stateful.remote.MulBy2BeanRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet6
 */
@WebServlet("/Servlet6")
public class Servlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MulBy2BeanRemote mulBy2R1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet6() {
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
		try {
			Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			try {
	    	Context context = new InitialContext(jndiProperties);  
		    final String appName = "";
		    final String moduleName = "BigProjectJSP";
		    final String distinctName = "";
		   System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!javaee.ejb.stateful.remote.MulBy2BeanRemote?stateful");
		   //生成第一个客户端
		   
		    Object obj = context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!javaee.ejb.stateful.remote.MulBy2BeanRemote?stateful");
		    mulBy2R1 =(MulBy2BeanRemote)obj;
			}
	        catch (NamingException e) {
	            e.printStackTrace();
	        }
			insertdata();
			System.out.println("大白录入信息成功");
			//这边我们使用重定向来转换资源
			response.setStatus(302);
			response.setHeader("location","login.jsp");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (SQLException e) {
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
	
	public void insertdata() throws ClassNotFoundException,SQLException{
		 Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "18943038195");//localhost是本机地址，3306是端口号，最后是用户名和密码
		 Statement stmt=conn.createStatement();//实例化Statement对象
		 int sum2=mulBy2R1.getsum();
		 System.out.println("最终录入的样本的数量为："+sum2);
		 for(int w=0;w<sum2;w++){
				String tmp1=mulBy2R1.getvalue1(w);//学号
				String tmp2=mulBy2R1.getvalue2(w);//姓名
//				String tmp3=mulBy2R1.getvalue3(w);//序号
				String tmp4=mulBy2R1.getvalue4(w);//试剂
				String tmp5="0";
				System.out.println("现在大白在写入数据库");
				String sql="insert into javaee.report(reportid,studentid,studentname,result)"
						 +"values('"+tmp4+"','"+tmp1+"','"+tmp2+"','"+tmp5+"')";
				stmt.executeUpdate(sql);
			}
		 stmt.close();
		 conn.close();

	}

}
