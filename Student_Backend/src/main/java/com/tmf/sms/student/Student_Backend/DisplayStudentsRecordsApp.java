package com.tmf.sms.student.Student_Backend;

import java.util.List;

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
public class DisplayStudentsRecordsApp 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry service = new StandardServiceRegistryBuilder().
				configure("Hibernate.cfg.xml").build();
    	Metadata meta=new MetadataSources(service).buildMetadata();
    	SessionFactory factory=meta.buildSessionFactory();
    	System.out.println("Session has been created....");
    	
    	Session ses=factory.openSession();
    	List<Student> student=ses.createQuery("from Student").list();
    	for(Student std:student) {
    		System.out.println(std);
    	}
    	ses.close();
    }
}
