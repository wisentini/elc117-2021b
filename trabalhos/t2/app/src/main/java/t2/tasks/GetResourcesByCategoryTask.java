package t2.tasks;

import java.util.List;

import javafx.concurrent.Task;
import t2.Resource;
import t2.WebService;

public class GetResourcesByCategoryTask extends Task<List<Resource>> {
    private String category;

    public GetResourcesByCategoryTask(String category) {
        this.category = category;
    }

    @Override
    protected List<Resource> call() throws Exception {
        List<Resource> resources = null;

        try {
            resources = WebService.getResourcesByCategory(this.category);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resources;
    }
}
