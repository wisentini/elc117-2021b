package t2.tasks;

import java.util.List;

import javafx.concurrent.Task;
import t2.Resource;
import t2.WebService;

public class GetResourcesTask extends Task<List<Resource>> {
    @Override
    protected List<Resource> call() throws Exception {
        List<Resource> resources = null;

        try {
            resources = WebService.getResources();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resources;
    }   
}
