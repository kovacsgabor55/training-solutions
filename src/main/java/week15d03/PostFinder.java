package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {
    private final List<Post> posztmen;

    public PostFinder(List<Post> posztmen) {
        this.posztmen = new ArrayList<>(posztmen);
    }

    public List<Post> findPosts(String user) {
        List<Post> result = new ArrayList<>();
        for (Post item : posztmen) {
            if (item.getOwner().equals(user) && item.getPublishedAt().isBefore(LocalDate.now())) {
                result.add(item);
            }

        }
        return result;
    }

    public List<Post> getPosztmen() {
        return new ArrayList<>(posztmen);
    }
}
