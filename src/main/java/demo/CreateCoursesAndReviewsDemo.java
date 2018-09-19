package demo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo
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



            Course course1= new Course("Szachownica dla początkujących");

            Review review1= new Review("O kurcze super kurs");
            Review review2= new Review("O kurcze chuj kurs");
            Review review3= new Review("O kurcze dobry ladny i fajny kurs");
            Review review4= new Review("O proste dobry ladny i fajny kurs");

            course1.addReview(review1);
            course1.addReview(review2);
            course1.addReview(review3);
            course1.addReview(review4);

            System.out.println(course1);

//            System.out.println(course1.getReviews());
            session.save(course1);




            session.getTransaction().commit();


        }
        finally
        {
            factory.close();
        }
    }

}
