package dataAccess;

import java.util.List;

import dummyData.DummyData;
import entities.Category;
import entities.Course;
import entities.Instructor;

public class JdbcDao implements IDatabase {
    @Override
    public void addCategory(Category category) {
        DummyData.dummyCategories.add(category);
        System.out.println(category.getName() + " Added Category with Jdbc");
    }

    @Override
    public void addInstructor(Instructor instructor) {
        DummyData.dummyInstructors.add(instructor);
        System.out.println(instructor.getName() + " Added Instructor with Jdbc");
    }

    @Override
    public void addCourse(Course course) {
        DummyData.dummyCourses.add(course);
        System.out.println(course.getName() + "Added Course with Jdbc");  
    }

    @Override
    public List<Course> getCourseList() {
        return DummyData.dummyCourses;
    }
}
