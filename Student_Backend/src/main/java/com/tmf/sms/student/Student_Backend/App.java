package com.tmf.sms.student.Student_Backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.tmf.sms.student.Student_Backend.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry service = new StandardServiceRegistryBuilder().
				configure("Hibernate.cfg.xml").build();
    	Metadata meta=new MetadataSources(service).buildMetadata();
    	SessionFactory factory=meta.buildSessionFactory();
    	System.out.println("Session has been created....");
    	
    	Session ses=factory.openSession();
    	Student st=new Student();
    	st.setStudentName("Ganesh");
    	st.setGender("Male");
    	st.setPhone(987654321L);
    	st.setFee(4000);
    	st.setEmail("ganesh2939@gmail.com");
    	st.setQualification("B-Tech(EEE)");
    	st.setCourse("JAVA");
    	Transaction tx=ses.beginTransaction();
    	ses.save(st);
    	tx.commit();
    	ses.close();
    }
}
