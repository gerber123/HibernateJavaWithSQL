package demo;

import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo
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

            int theId =7;

            session.beginTransaction();
            InstructorDetail instructorDetail= session.get(InstructorDetail.class,theId);

            //remove the associate object reference
            //break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(instructorDetail);
            session.getTransaction().commit();

            System.out.println("DONE!");
        }
        finally
        {
            factory.close();
        }
    }

}
