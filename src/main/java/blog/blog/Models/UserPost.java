package blog.blog.Models;

import java.time.LocalDate;

public class UserPost {

    private int userId;
    private String username;
    private String password;
    private String privs;
    private int postId;
    private String postHead;
    private String postBody;
    private LocalDate postDate;
    private int userFkId;

    public UserPost() {
    }

    public UserPost(int userId, String username, String password, String privs, int postId, String postHead, String postBody, LocalDate postDate, int userFkId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.privs = privs;
        this.postId = postId;
        this.postHead = postHead;
        this.postBody = postBody;
        this.postDate = postDate;
        this.userFkId = userFkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivs() {
        return privs;
    }

    public void setPrivs(String privs) {
        this.privs = privs;
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

    public int getUserFkId() {
        return userFkId;
    }

    public void setUserFkId(int userFkId) {
        this.userFkId = userFkId;
    }

    @Override
    public String toString() {
        return "UserPost{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privs='" + privs + '\'' +
                ", postId=" + postId +
                ", postHead='" + postHead + '\'' +
                ", postBody='" + postBody + '\'' +
                ", postDate=" + postDate +
                ", userId=" + userId +
                '}';
    }
}
