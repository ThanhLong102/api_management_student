package repository;

import entity.Student;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDao implements StudentDaoImpl {
    Logger logger = Logger.getLogger(StudentDao.class);

    @Override
    public List<Student> findAll(int pageNumber, int pageSize) {
        List<Student> studentList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student " +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);

            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            studentList = query.getResultList();
            return studentList;
        } catch (HibernateException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return studentList;
    }

    @Override
    public Student add(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return student;
        } catch (HibernateException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return student;
    }

    @Override
    public boolean update(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(id);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Student> findStudentByName(String name, int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student WHERE lower(fullName) like lower(to_char(concat(concat('%', :p_student_name), '%')))" +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);
            query.setParameter("p_student_name", name);
            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByBirthday(Date date1, Date date2, int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student " + "where to_char(:p_student_date1, 'ddMMyyyy') <= " +
                    "                    to_char(birthday, 'ddMMyyyy') and to_char(:p_student_date2, 'ddMMyyyy') >= to_char(birthday, 'ddMMyyyy')" +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);
            query.setParameter("p_student_date1", date1);
            query.setParameter("p_student_date2", date2);
            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByGender(String gender, int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student WHERE lower(GENDER) = lower(:p_student_gender)" +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);
            query.setParameter("p_student_gender", gender);
            List<Student> students = query.getResultList();
            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByHometown(String homeTown, int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student WHERE lower(HOMETOWN) = lower(:p_student_hometown)" +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);
            query.setParameter("p_student_hometown", homeTown);
            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByClassName(String className, int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student WHERE lower(CLASS_NAME) = lower(:p_student_className)" +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);
            query.setParameter("p_student_className", className);
            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByMajor(String major, int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student WHERE lower(MAJOR) = lower(:p_student_major)" +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);
            query.setParameter("p_student_major", major);
            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByAverage(double min, double max, int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student where AVERAGE_MARK between :p_student_markMin and :p_student_markMax" +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);
            query.setParameter("p_student_markMin", min);
            query.setParameter("p_student_markMax", max);
            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByBirthday(int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("SELECT * FROM" +
                    "(" +
                    "    SELECT a.*, rownum r__" +
                    "    FROM" +
                    "    (" +
                    "        SELECT * FROM Student where to_char(:p_student_date, 'ddMM') = to_char(birthday, 'ddMM')" +
                    "        ORDER BY id" +
                    "    ) a" +
                    "    WHERE rownum < ((:pageNumber * :pageSize) + 1 )" +
                    ")" +
                    "WHERE r__ >= (((:pageNumber-1) * :pageSize) + 1)", Student.class);
            query.setParameter("p_student_date", new Date());
            query.setParameter("pageNumber", pageNumber);
            query.setParameter("pageSize", pageSize);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }
}
