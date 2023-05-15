public interface user {
    /*
 查看帖子	ViewPostList
查看帖子信息	ViewPostDetails
删除帖子	DeletePosts
删除评论	DeleteComments
新增用户	AddNewUser
删除用户	DeleteUser
修改用户信息	ChangeUserInformation
查看用户数据	ViewUserList
查看统计数据	ViewStatistics*/
    /*
    发布帖子	PublishPosts
用户查看个人信息	ViewOwnInformation
用户修改个人信息	ChangeOwnInformation
用户修改密码	ChangeOwnPassword
查看帖子	ViewPostList
查看帖子信息	ViewPostDetails
评论帖子	CommentPosts
删除帖子评论	DeleteComments
点赞帖子	LikePosts
删除帖子	DeletePosts
回复评论 ReplyComment
删除评论回复 deleteCommentReply*/
    int publishPosts(int user_id, String title, String content, String... images);
    int viewOwnInformation(int user_id);
    int changeOwnInformation(int user_id,String new_username,  String new_email,String... args);
    int changeOwnPassword(int user_id, String password, String new_password);
    int viewPostList(int num);
    int viewPostDetails(int user_id,int post_id);
    int commentPosts(int user_id, int post_id, String content);
    int deleteComments(int user_id, int comment_id);
    int likePosts(int user_id, int post_id);
    int deletePosts(int user_id, int post_id);
    int replyComment(int user_id, int post_id, int comment_id, String content);
    int deleteCommentReply(int user_id, int post_id, int comment_id, int reply_id);

    int changeUserInformation(int user_id, String username, String password, String new_password, String new_email,String... args);
    int viewUserList(int num);
    int addNewUser(String username, String password, String email);
    int deleteUser(int user_id);
    int viewStatics();
}
