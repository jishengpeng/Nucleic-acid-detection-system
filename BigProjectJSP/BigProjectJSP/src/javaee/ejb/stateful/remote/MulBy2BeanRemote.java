package javaee.ejb.stateful.remote;

import javax.ejb.Remote;

@Remote
public interface MulBy2BeanRemote {

	
	public int mul();
	public void get(String value1,String value2,String value3,String value4);
	public int getsum();
	public void delatesum();
	public String getvalue1(int a);
	public String getvalue2(int a);
	public String getvalue3(int a);
	public String getvalue4(int a);
}

