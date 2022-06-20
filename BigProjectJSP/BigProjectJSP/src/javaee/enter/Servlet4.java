package javaee.enter;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.ejb.stateful.remote.MulBy2BeanRemote;


//import jluee.control.String;



import org.apache.hc.client5.http.fluent.Request;

/**
 * Servlet implementation class Servlet4
 */
@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MulBy2BeanRemote mulBy2R1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//在servlet中调用bean
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
		System.out.println("12345678");
		String param = request.getParameter("studentid");//学号
		String tubeid=request.getParameter("tubeid");
		System.out.println(param);
		String URI = "http://localhost:8080/RESTWS_Hello/helloworld/sayHi?name=" + param;
		String result = Request.get(URI).execute().returnContent().toString();//姓名
        System.out.println(result);
        
        int label=0;   
        label=mulBy2R1.mul();
        System.out.println("the  value in Clinet 1:  "+label);
        
        //向增加页面写入
        request.setAttribute("value1", param);
        request.setAttribute("value2", result);
        String label1=String.valueOf(label);
        request.setAttribute("value3", label1);
        request.setAttribute("value4", tubeid);
		request.getRequestDispatcher("enteradd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
