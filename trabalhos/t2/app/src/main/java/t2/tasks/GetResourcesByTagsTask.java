package t2.tasks;

import java.util.List;

import javafx.concurrent.Task;
import t2.Resource;
import t2.WebService;

public class GetResourcesByTagsTask extends Task<List<Resource>> {
    private String tags;

    public GetResourcesByTagsTask(String tags) {
        this.tags = tags;
    }

    @Override
    protected List<Resource> call() throws Exception {
        List<Resource> resources = null;

        try {
            resources = WebService.getResourcesByTags(this.tags);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resources;
    }   
}
