package t2.tasks;

import java.util.List;

import javafx.concurrent.Task;
import t2.Resource;
import t2.WebService;

public class GetResourcesByUserIdTask extends Task<List<Resource>> {
    private String userId;

    public GetResourcesByUserIdTask(String userId) {
        this.userId = userId;
    }

    @Override
    protected List<Resource> call() throws Exception {
        List<Resource> resources = null;

        try {
            resources = WebService.getResourcesByUserId(this.userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resources;
    }   
}
