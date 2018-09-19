package demo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class DeleteCourseReviewsDemo
{
    public static void main(String args[])
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();



        try{

            session.beginTransaction();

            int theId = 12;
//            Course tempCourse = session.get(Course.class,theId);
            Review review = session.get(Review.class,5);
            session.delete(review);

            session.getTransaction().commit();


        }
        finally
        {
            session.close();
            factory.close();
        }
    }

}
