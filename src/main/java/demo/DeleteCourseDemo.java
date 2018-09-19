package demo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo
{
    public static void main(String args[])
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();



        try{
            System.out.println("Getting new student Object: ");

            int theId =1;





            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class,1);
            Course course = instructor.getCourses().get(0);

            System.out.println(course);

            session.delete(course);

            session.getTransaction().commit();

            System.out.println("DONE!");
        }
        finally
        {
            factory.close();
        }
    }

}
