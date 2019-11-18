package blog.blog.Services;

import blog.blog.Models.Post;
import blog.blog.Models.UserPost;

import java.util.List;

public interface UserPostService {

    List<UserPost> fetchAll();

    int update(Post post);

    UserPost findById(int id);

    int create(Post post);

    int delete(int id);


}
