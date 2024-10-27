package com.siddharth;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Student Management System using Hibernate By @author JeansPanT!
 * @version 1.0
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Configuration cfg = new Configuration();
            cfg.configure();
            SessionFactory sf = cfg.buildSessionFactory();
            Session sess = sf.openSession();
            Scanner sc = new Scanner(System.in);
            boolean running = true;  

            
            while (running) {
                System.out.println("STUDENT MANAGEMENT SYSTEM USING HIBERNATE");
                System.out.println("1. Add a new Student");
                System.out.println("2. Update an Old Student");
                System.out.println("3. Delete an Old Student");
                System.out.println("4. View an Old Student");
                System.out.println("5. View all Old Student");
                System.out.println("6. Exit");
                System.out.println("Enter your choice: ");
                
                Integer choice = sc.nextInt();
                sc.nextLine();  
                
                switch (choice) {
                    case 1: {
                        Student s = new Student();
                        Transaction tx = sess.beginTransaction();
                        
                        System.out.println("Enter Student's Roll No.:");
                        s.setId(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Enter Student's Name:");
                        s.setName(sc.nextLine());
                        System.out.println("Enter Student's Age:");
                        s.setAge(sc.nextInt());
                        System.out.println("Enter Student's Percentage:");
                        s.setPer(sc.nextFloat());
                        sc.nextLine();
                        System.out.println("Enter Student's Address:");
                        s.setAdd(sc.nextLine());
                        
                        sess.save(s);
                        tx.commit();
                        System.out.println("Data inserted Successfully...");
                    }
                    break;

                    case 2: {
                        System.out.println("Enter Student's Roll No.:");
                        Student stu = (Student) sess.get(Student.class, sc.nextInt());
                        sc.nextLine();
                        
                        if (stu != null) { 
                            System.out.println("1. To update Student's Name");
                            System.out.println("2. To update Student's Age");
                            System.out.println("3. To update Student's Percentage");
                            System.out.println("4. To update Student's Address");
                            Integer c = sc.nextInt();
                            sc.nextLine();
                            
                            Transaction tx = sess.beginTransaction(); 
                            
                            switch (c) {
                                case 1: {
                                    System.out.println("Enter New Student's Name:");
                                    stu.setName(sc.nextLine());
                                    sess.update(stu);
                                    tx.commit();
                                    System.out.println("Name Updated Successfully...");
                                }
                                break;
                                case 2: {
                                    System.out.println("Enter New Student's Age:");
                                    stu.setAge(sc.nextInt());
                                    sess.update(stu);
                                    tx.commit();
                                    System.out.println("Age Updated Successfully...");
                                }
                                break;
                                case 3: {
                                    System.out.println("Enter New Student's Percentage:");
                                    stu.setPer(sc.nextFloat());
                                    sess.update(stu);
                                    tx.commit();
                                    System.out.println("Percentage Updated Successfully...");
                                }
                                break;
                                case 4: {
                                    System.out.println("Enter New Student's Address:");
                                    stu.setAdd(sc.nextLine());
                                    sess.update(stu);
                                    tx.commit();
                                    System.out.println("Address Updated Successfully...");
                                }
                                break;
                                default: {
                                    System.out.println("You've entered a Wrong Number !!!");
                                }
                                break;
                            }
                        } else {
                            System.out.println("Student not found!");
                        }
                    }
                    break;

                    case 3: {
                        System.out.println("Enter Student's Roll No.:");
                        Student stu = (Student) sess.get(Student.class, sc.nextInt());
                        if (stu != null) {
                            Transaction tx = sess.beginTransaction(); 
                            sess.delete(stu);
                            tx.commit();
                            System.out.println("Data deleted Successfully...");
                        } else {
                            System.out.println("Student not found!");
                        }
                    }
                    break;

                    case 4: {
                        System.out.println("Enter Student's Roll No.:");
                        Student stu = (Student) sess.get(Student.class, sc.nextInt());
                        if (stu != null) {
                            System.out.println("Student's ID: " + stu.getId());
                            System.out.println("Student's Name: " + stu.getName());
                            System.out.println("Student's Age: " + stu.getAge());
                            System.out.println("Student's Percentage: " + stu.getPer());
                            System.out.println("Student's Address: " + stu.getAdd());
                        } else {
                            System.out.println("Student not found!");
                        }
                    }
                    break;
                    
                    case 5: {           	
                        Query q = sess.createQuery("from Student");
                        List<Student> students = q.list();
                        for(Student s: students) {
                        	System.out.println(s.getId()+"  |  "+s.getName()+"  |  "+s.getAge()+"  |  "+s.getPer()+"  |  "+s.getAdd());
                        }
                    }
                    break;

                    case 6: {
                        running = false; 
                        System.out.println("Exiting the application...");
                    }
                    break;

                    default: {
                        System.out.println("You've entered a Wrong Number !!!");
                    }
                    break;
                }
            }
            
            sc.close();
            sess.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
