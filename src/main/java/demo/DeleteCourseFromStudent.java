package demo;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseFromStudent
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

            Course courseChests = (Course) session.createQuery("from Course where id = '10'").getSingleResult();



            session.delete(courseChests);


            session.getTransaction().commit();


        }
        finally
        {
            factory.close();
        }
    }

}
