package demo;

import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOnylDetail
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
            session.beginTransaction();
            Instructor tempInstructor = session.get(Instructor.class,3);
            System.out.println("Deleting the instructor... ");

            if(tempInstructor!=null)
            {
                System.out.println("Deleting...");
                session.delete(tempInstructor);
            }
            session.getTransaction().commit();

            System.out.println("DONE!");
        }
        finally
        {
            factory.close();
        }
    }

}
