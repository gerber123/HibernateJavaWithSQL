package demo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo
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

            Instructor instructor = new Instructor("Susan","Public","susan.public@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.pl/gamerPL","gamer");
//            Course course=new Course("Kurs grania w gry");

//            instructor.add(course);
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

//            session.save(instructor);


            session.getTransaction().commit();


        }
        finally
        {
            factory.close();
        }
    }

}
