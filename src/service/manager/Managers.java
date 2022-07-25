package service.manager;

import service.history.*;

import java.net.MalformedURLException;
import java.net.URL;


public class Managers {
    private static final HistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
    private static TaskManager taskManager = new HTTPTaskManager();

    static public HistoryManager getDefaultHistory() {
        return inMemoryHistoryManager;
    }

    static public TaskManager getDefault() {
        try {
            taskManager = new HTTPTaskManager(new URL("http://localhost"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return taskManager;
    }

}
