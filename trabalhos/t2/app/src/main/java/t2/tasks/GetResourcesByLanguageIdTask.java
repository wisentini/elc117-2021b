package t2.tasks;

import java.util.List;

import javafx.concurrent.Task;
import t2.Resource;
import t2.WebService;

public class GetResourcesByLanguageIdTask extends Task<List<Resource>> {
    private String languageId;

    public GetResourcesByLanguageIdTask(String languageId) {
        this.languageId = languageId;
    }

    @Override
    protected List<Resource> call() throws Exception {
        List<Resource> resources = null;

        try {
            resources = WebService.getResourcesByLanguageId(this.languageId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resources;
    }   
}
