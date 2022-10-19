package business;

import java.util.List;

import core.logging.ILogger;
import dataAccess.IDatabase;
import dummyData.DummyData;
import entities.Course;

public class CourseManager {
    private IDatabase database;
    private ILogger[] loggers;

    public CourseManager(IDatabase database, ILogger[] loggers) {
        this.database = database;
        this.loggers = loggers;
    }

    public void add(Course course){
        try {
            addProccess(course);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Course> getAllCourse(){
        return database.getCourseList();
    }

    private void addProccess(Course course) throws Exception{
        if (course.getPrice() < 0) {
            throw new Exception("The course price cannot be less than 0");
        }
        for (Course c : DummyData.dummyCourses) {
            if (c.getName() == course.getName()) {
                throw new Exception("A course with this name already exists");
            }
        }
        
        database.addCourse(course);

        for (ILogger logger : loggers) {
            logger.log(course.getName());
        }
    }
}
