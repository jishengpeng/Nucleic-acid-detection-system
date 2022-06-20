package javaee.ejb.stateful.remote;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class MulBy2Bean
 */
@Stateful
public class MulBy2Bean implements MulBy2BeanRemote {
	int i=0;
	static int sum=0;
	static Student[] student=new Student[5];
    /**
     * Default constructor. 
     */
    public MulBy2Bean() {
        // TODO Auto-generated constructor stub
    }
    
    public int mul(){
    	i=i+1;
    	return i;
    }
    public int getsum(){
    	return sum;
    }
    
    public void get(String value1,String value2,String value3,String value4){
    	if(student[sum]==null)
    		student[sum]=new Student();
    	student[sum].studentid=value1;
    	student[sum].name=value2;
    	student[sum].label=value3;
    	student[sum].shiguan=value4;
    	sum=sum+1;
    }
    
    public String getvalue1(int a){
    	return student[a].studentid;
    }
	public String getvalue2(int a){
		return student[a].name;
	}
	public String getvalue3(int a){
		return student[a].label;
	}
	public String getvalue4(int a){
		return student[a].shiguan;
	}
	
	public void delatesum(){
		sum=sum-1;
	}
   

}

 class Student{
	String studentid;
	String label;
	String name;
	String shiguan;
}
