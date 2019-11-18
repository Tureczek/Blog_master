package blog.blog.Services;

import blog.blog.Models.Post;
import blog.blog.Models.UserPost;
import blog.blog.Repositories.ProjectVariable;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserPostServiceImpl implements UserPostService {

    /**
     * Getting a combined list of users and posts, found by a lET JOIN in the database
     * @return All posts and users.
     */
    @Override
    public List<UserPost> fetchAll() {
        List<UserPost> userPost = new ArrayList<>();

        try{
        Connection con = DriverManager.getConnection(ProjectVariable.getUrl(), ProjectVariable.getUsername(), ProjectVariable.getPassword());
        Statement stmt = con.createStatement();
        ResultSet rs =stmt.executeQuery("SELECT * FROM blog.user_table LEFT JOIN blog.post_table ON user_table.user_id = post_table.user_id");

        while (rs.next()) {
            UserPost up = new UserPost();

            up.setUserId(rs.getInt(1));
            up.setUsername(rs.getString(2));
            up.setPassword(rs.getString(3));
            up.setPrivs(rs.getNString(4));
            up.setPostId(rs.getInt(5));
            up.setPostHead(rs.getString(6));
            up.setPostBody(rs.getString(7));
            //up.setPostDate(rs.getDate(8));
            up.setUserFkId(rs.getInt(9));
            userPost.add(up);

        }
        con.close();

        } catch (SQLException e){

        } return userPost;
    }

    /**
     *
     * @param post the post found by id in findById method
     * @return return the post, and making it possible to edit it
     */
    @Override
    public int update(Post post) {
        try {
            Connection con = DriverManager.getConnection(ProjectVariable.getUrl(), ProjectVariable.getUsername(), ProjectVariable.getPassword());
            PreparedStatement pstmt = con.prepareStatement("UPDATE blog.post_table SET post_head = ?, post_body = ? WHERE post_id = ?;");



            pstmt.setString(1, post.getPostHead());
            pstmt.setString(2, post.getPostBody());
            pstmt.setInt(3, post.getPostId());
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    /**
     * Finding posts by Id
     * @param id returning id on given post
     * @return  id is used to edit a post in program
     */
    @Override
    public UserPost findById(int id) {

        UserPost userPost= new UserPost();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = DriverManager.getConnection(ProjectVariable.getUrl(), ProjectVariable.getUsername(), ProjectVariable.getPassword());
            pstmt = con.prepareStatement("SELECT * FROM blog.post_table Where post_id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()){
                userPost.setPostId(rs.getInt(1));
                userPost.setPostHead(rs.getString(2));
                userPost.setPostBody(rs.getString(3));
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }

        }

        return userPost;
    }

    /**
     *
     * @param post Creating a new post
     */
    @Override
    public int create(Post post) {

        try {
            Connection con = DriverManager.getConnection(ProjectVariable.getUrl(), ProjectVariable.getUsername(), ProjectVariable.getPassword());
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO blog.post_table (post_head, post_body, user_id) VALUES (?,?,?) ");

            pstmt.setString(1, post.getPostHead());
            pstmt.setString(2, post.getPostBody());
            pstmt.setInt(3, post.getUserId());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     *
     * @param id Finding post by id
     * @return Deleting the post found by id
     */
    @Override
    public int delete(int id) {

        try {
        Connection con = DriverManager.getConnection(ProjectVariable.getUrl(), ProjectVariable.getUsername(), ProjectVariable.getPassword());
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM blog.post_table Where post_id = ?");
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
