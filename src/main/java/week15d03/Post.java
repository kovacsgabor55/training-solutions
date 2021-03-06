package week15d03;

import java.time.LocalDate;
import java.util.Objects;

public class Post {
    private final String title;
    private final LocalDate publishedAt;
    private final String content;
    private final String owner;

    public Post(String title, LocalDate publishedAt, String content, String owner) {
        Objects.requireNonNull(publishedAt, "");
        if (content.isBlank() || title.isBlank()) {
            throw new IllegalArgumentException("something happend!");
        }
        this.title = title;
        this.publishedAt = publishedAt;
        this.content = content;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Post{" + "title='" + title + '\'' + ", publishedAt=" + publishedAt + ", content='" + content + '\'' + ", owner='" + owner + '\'' + '}';
    }

}