package collectionsqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {
    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> ret = new ArrayDeque<>();
        for (Job item : jobs) {
            if (item.urgent) {
                ret.addFirst(item);
            } else {
                ret.addLast(item);
            }
        }
        return ret;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getLast();
    }
}
