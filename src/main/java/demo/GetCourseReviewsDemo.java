package demo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseReviewsDemo
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
            Course tempCourse = session.get(Course.class,theId);
            System.out.println("Instructor: "+tempCourse);

            System.out.println("Courses: "+tempCourse.getReviews());

            session.getTransaction().commit();


        }
        finally
        {
            factory.close();
        }
    }

}
