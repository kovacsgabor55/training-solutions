package collectionsqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs) {
        Queue<Job> ret = new PriorityQueue<>();
        for (Job item : jobs) {
            ret.add(item);
        }
        return ret;
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        Job j = jobs.peek();
        if (j == null) {
            throw new NoJobException("No job available, get a rest!");
        }
        return j;
    }
}
