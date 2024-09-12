public class PostComment{
    int post_ID;
    int post_userID;
    int comment_userID;
    int comment_ID;

    // Constructor. 
    public PostComment(int post_ID, int post_userID, int comment_userID, int comment_ID){
        this.post_ID = post_ID;
        this.post_userID = post_userID;
        this.comment_userID = comment_userID;
        this.comment_ID = comment_ID;
    }
    
    // Getter methods.
    public int getPost_ID(){
        return post_ID;
    }
    public int getPost_UserID(){
        return post_userID;
    }
    public int getComment_userID(){
        return comment_userID;
    }
    public int getComment_ID(){
        return comment_ID;
    }
}