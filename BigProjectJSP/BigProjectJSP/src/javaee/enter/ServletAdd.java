package javaee.enter;

import java.io.IOException;
//import java.io.*;
//������ҳ��д��
//import java.io.PrintWriter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Hashtable;
import java.sql.SQLException;

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
 * Servlet implementation class ServletAdd
 */
@WebServlet("/ServletAdd")
public class ServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MulBy2BeanRemote mulBy2R1;
	
//	@PersistenceUnit(unitName = "BigProject")
//	private EntityManagerFactory emf1;
//	
//	
//	@Resource
//	UserTransaction utx;
//       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//��servlet�е���bean
		Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        try {
            Context context = new InitialContext(jndiProperties);
           
            final String appName = "";
            final String moduleName = "BigProjectJSP";
            final String distinctName = "";
           System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!javaee.ejb.stateful.remote.MulBy2BeanRemote?stateful");
           //���ɵ�һ���ͻ���
           
            Object obj = context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!javaee.ejb.stateful.remote.MulBy2BeanRemote?stateful");
            mulBy2R1 =(MulBy2BeanRemote)obj;
        }
        catch (NamingException e) {
            e.printStackTrace();
        }
		
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
		//��ȡҳ���ֵ
		String value1=(String)request.getSession().getAttribute("value1");
		String value2=(String)request.getSession().getAttribute("value2");
		String value3=(String)request.getSession().getAttribute("value3");
		String value4=(String)request.getSession().getAttribute("value4");
		
//		//д��ҳ��
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter writer=response.getWriter();
//		
//		writer.write("nihao");
		if(value1.equals("qiunannan")){
			//��ʾ��ɾ��ҳ��
			
			mulBy2R1.delatesum();
			int sum2=mulBy2R1.getsum();
			System.out.println("��ɾ�������ѧ������:"+sum2);
			for(int w=0;w<sum2;w++){
				String tmp1=mulBy2R1.getvalue1(w);
				String tmp2=mulBy2R1.getvalue2(w);
				String tmp3=mulBy2R1.getvalue3(w);
				String tmp4=mulBy2R1.getvalue4(w);
				System.out.println(tmp1+tmp2+tmp3+tmp4);
			}
			response.setStatus(302);
			response.setHeader("Location","enter.jsp");
		}
		else{
			if(value1.equals("qiunannan1")){
				//��ʾ���ύ�߼��������ӵ����ݿ���
				try {
					insertdata();
					System.out.println("���¼����Ϣ�ɹ�");
					//�������ʹ���ض�����ת����Դ
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
			else{
				//��ʾ�������߼�
				System.out.println(value1);
				System.out.println(value2);
				System.out.println(value3);
				System.out.println(value4);
				
				//������״̬�Ựbean
				mulBy2R1.get(value1, value2, value3, value4);
				
				int sum1=mulBy2R1.getsum();
				System.out.println("�����ӽ����ѧ������:"+sum1);
				
				for(int w=0;w<sum1;w++){
					String tmp1=mulBy2R1.getvalue1(w);
					String tmp2=mulBy2R1.getvalue2(w);
					String tmp3=mulBy2R1.getvalue3(w);
					String tmp4=mulBy2R1.getvalue4(w);
					System.out.println(tmp1+tmp2+tmp3+tmp4);
				}
				
				response.setStatus(302);
				response.setHeader("Location","enter.jsp");
			}			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void insertdata() throws ClassNotFoundException,SQLException{
		 Class.forName("com.mysql.jdbc.Driver");//����mysql����
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "18943038195");//localhost�Ǳ�����ַ��3306�Ƕ˿ںţ�������û���������
		 Statement stmt=conn.createStatement();//ʵ����Statement����
		 int sum2=mulBy2R1.getsum();	
		 for(int w=0;w<sum2;w++){
				String tmp1=mulBy2R1.getvalue1(w);//ѧ��
				String tmp2=mulBy2R1.getvalue2(w);//����
//				String tmp3=mulBy2R1.getvalue3(w);//���
				String tmp4=mulBy2R1.getvalue4(w);//�Լ�
				String tmp5="0";
				System.out.println("���ڴ����д�����ݿ�");
				String sql="insert into javaee.report(reportid,studentid,studentname,result)"
						 +"values('"+tmp4+"','"+tmp1+"','"+tmp2+"','"+tmp5+"')";
				stmt.executeUpdate(sql);
			}
		 stmt.close();
		 conn.close();

	}

}
