package dataAccess;

import java.util.List;

import entities.Category;
import entities.Course;
import entities.Instructor;

public interface IDatabase {
    void addCategory(Category category);
    void addInstructor(Instructor instructor);
    void addCourse(Course course);
    List<Course> getCourseList();
}
