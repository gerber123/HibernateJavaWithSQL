package demo;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentDemo
{
    public static void main(String args[])
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();



        try{



            session.beginTransaction();



            Course course1= new Course("Szachownica dla początkujących");

            System.out.println("Saving the course....");
            session.save(course1);

            System.out.println("Saved the course....");

            Student tempStudent1 = new Student("John","Doe","JOHNYbRA@GMAIL.COM");
            Student tempStudent2 = new Student("Fira","public","JOHNYbRA@GMAIL.waa");

            course1.addStudent(tempStudent1);
            course1.addStudent(tempStudent2);

            System.out.println("Saving students....");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved students: "+course1.getStudents());


            session.getTransaction().commit();


        }
        finally
        {
            factory.close();
        }
    }

}
