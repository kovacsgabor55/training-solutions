package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        Post ps = new Post("tit", LocalDate.of(2015,02,12), "do", "ow");
        PostFinder postFinder = new PostFinder(Arrays.asList(ps));
        System.out.println(postFinder.getPosztmen().size());
        System.out.println(postFinder.findPosts("ow"));
    }
}
