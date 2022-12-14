import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.ILogger;
import dataAccess.IDatabase;
import dataAccess.JdbcDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

public class Main {
    public static void main(String[] args) throws Exception {
        IDatabase currentDb = new JdbcDao();
        ILogger[] loggers = {
            new DatabaseLogger(), 
            new FileLogger(),
        };
        
        Instructor instructor = new Instructor(3, "Engin Demirog");
        Category category = new Category(4, "Dart");
        Course course = new Course(1, "Mobil Programlama", 0, category, instructor);
        Course course2 = new Course(2, "İleri Seviye Mobil Programlama", 1499, category, instructor);

        InstructorManager instructorManager = new InstructorManager(currentDb, loggers);
        CategoryManager categoryManager = new CategoryManager(currentDb, loggers);
        CourseManager courseManager = new CourseManager(currentDb, loggers);

        instructorManager.add(instructor);
        System.out.println("\n");
        categoryManager.add(category);
        System.out.println("\n");
        courseManager.add(course);
        System.out.println("\n");
        courseManager.add(course2);

        System.out.println("\nCourses\n");

        for (Course c : courseManager.getAllCourse()) {
            System.out.println(c.toString());
        }
    }
}
