package blog.blog.Models;

import java.time.LocalDate;

public class Post {

    private int postId;
    private String postHead;
    private String postBody;
    private LocalDate postDate;
    private int userId;

    public Post() {
    }

    public Post(int postId, String postHead, String postBody, LocalDate postDate, int userId) {
        this.postId = postId;
        this.postHead = postHead;
        this.postBody = postBody;
        this.postDate = postDate;
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostHead() {
        return postHead;
    }

    public void setPostHead(String postHead) {
        this.postHead = postHead;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postHead='" + postHead + '\'' +
                ", postBody='" + postBody + '\'' +
                ", postDate=" + postDate +
                ", userId=" + userId +
                '}';
    }
}
