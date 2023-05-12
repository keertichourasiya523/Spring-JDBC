package com.springDemo.SpringJdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
import com.springDemo.SpringJdbc.Dao.studentDaoImpl;

public class App 
{
    public static void main( String[] args ) {
    	
ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
studentDaoImpl stu = context.getBean("studentDao",studentDaoImpl.class);

Scanner sc=new Scanner(System.in);
while(true) {
	System.out.println("press 1 to insert data");
	System.out.println("press 2 to update data");
	System.out.println("press 3 to delete data");
	System.out.println("press 4 to display single student data");
	System.out.println("press 5 to display all students data");
	System.out.println("press 6 to exit");
	
	System.out.println("Enter your choice-------");
	int choice=sc.nextInt();
	
	switch(choice) {
	case 1:System.out.println("Enter student id");
	int id=sc.nextInt();

	System.out.println("Enter Student name");
	String name= sc.next();

	System.out.println("Enter student city");
	String city=sc.next();


	    Student student=new Student();
	   
	    student.setId(id);
	    student.setName(name);
	    student.setCity(city);
	     
	    int r = stu.insert(student);
	    System.out.println("Student's data got inserted"+r);
		break;
		
		
	case 2:
		System.out.println("Enter student id to be update");
	    int id1=sc.nextInt();

	    System.out.println("Enter Student's new name");
	
	    String name1= sc.next();

	    System.out.println("Enter student's new city");
	    String city1=sc.next();


	    Student student1=new Student();
	   
	    student1.setId(id1);
	    student1.setName(name1);
	    student1.setCity(city1);
	     
	    int r1 = stu.change(student1);
	    System.out.println("Student's data got updated\n\n");
	    System.out.println(r1);
		break;
	case 3:
		System.out.println("Enter Id to be deleted...");
		
		int id2=sc.nextInt();
		
		Student stu2=new Student();
		stu2.setId(id2);
		
		int r2=stu.delete(id2);
		
		System.out.println("student data got deleted successfully...");
		
		System.out.println(r2);
		
		break;
	case 4:
		System.out.println("Enter the id of student whose data you wanna display!!");
		int id3=sc.nextInt();
		
		Student r3 = stu.getStudent(id3);
		System.out.println(r3);
		
		
		break;
	case 5: 
		List<Student> students = stu.getAllStudents();
		for(Student s: students) {
		System.out.println(s);
		}
		break;
	case 6:
		
		System.out.println("thank you...");
		System.exit(0);
		
		break;
		
		default : System.out.println("you entered wrong credential.....");
	}


    
    
    }
}
    }