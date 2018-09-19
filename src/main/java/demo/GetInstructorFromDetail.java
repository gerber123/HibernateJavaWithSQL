package demo;

import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorFromDetail
{
    public static void main(String args[])
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();



        try{
            System.out.println("Getting new student Object: ");

            int theId =4;





            session.beginTransaction();
            InstructorDetail instructorDetail= session.get(InstructorDetail.class,theId);
            System.out.println(instructorDetail.getInstructor());
            session.getTransaction().commit();

            System.out.println("DONE!");
        }
        finally
        {
            factory.close();
        }
    }

}
