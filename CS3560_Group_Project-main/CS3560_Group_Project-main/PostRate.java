public class PostRate{
    int post_ID; 
    int user_ID;
    int rate_ID;

    public PostRate(int post_ID, int user_ID, int rate_ID){
        this.post_ID = post_ID;
        this.user_ID = user_ID; 
        this.rate_ID = rate_ID; 
    }

    public int getPost_ID(){
        return post_ID; 
    }
    public int getUser_ID(){
        return user_ID;
    }
    public int getRate_ID(){
        return rate_ID;
    }
}