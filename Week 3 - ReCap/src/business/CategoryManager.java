package business;

import dataAccess.IDatabase;
import dummyData.DummyData;
import entities.Category;

public class CategoryManager {
    private IDatabase database;

    public CategoryManager(IDatabase database){
        this.database = database;
    }

    public void add(Category category) throws Exception {
        try {
            for (Category c : DummyData.dummyCategories) {
                if (c.getName() == category.getName()) {
                    throw new Exception("This category name is already in use : " + category.getName());
                }
            }
            database.addCategory(category);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
