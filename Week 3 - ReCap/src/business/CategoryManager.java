package business;

import core.logging.ILogger;
import dataAccess.IDatabase;
import dummyData.DummyData;
import entities.Category;

public class CategoryManager {
    private IDatabase database;
    private ILogger[] loggers;

    public CategoryManager(IDatabase database, ILogger[] loggers){
        this.database = database;
        this.loggers = loggers;
    }

    public void add(Category category) throws Exception {
        try {
            addProccess(category);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void addProccess(Category category) throws Exception{
        for (Category c : DummyData.dummyCategories) {
            if (c.getName() == category.getName()) {
                throw new Exception("This category name is already in use : " + category.getName());
            }
        }
        database.addCategory(category);

        for (ILogger logger : loggers) {
            logger.log(category.getName());
        }
    }

}
