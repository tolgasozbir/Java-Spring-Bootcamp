package dataAccess;

import java.util.List;

import dummyData.DummyData;
import entities.Category;
import entities.Course;
import entities.Instructor;

public class HibernateDao implements IDatabase {
    @Override
    public void addCategory(Category category) {
        DummyData.dummyCategories.add(category);
        System.out.println(category.getName() + " Added with Hibernate");
    }

    @Override
    public void addInstructor(Instructor instructor) {
        DummyData.dummyInstructors.add(instructor);
        System.out.println(instructor.getName() + " Added with Hibernate");
    }

    @Override
    public void addCourse(Course course) {
        DummyData.dummyCourses.add(course);
        System.out.println(course.getName() + " Added with Hibernate");
    }

    @Override
    public List<Course> getCourseList() {
        return DummyData.dummyCourses;
    }
}
