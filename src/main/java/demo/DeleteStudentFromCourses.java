package demo;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentFromCourses
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

            Student student = (Student) session.createQuery("from Student where firstName = 'John'").getSingleResult();



            session.delete(student);


            session.getTransaction().commit();


        }
        finally
        {
            factory.close();
        }
    }

}
