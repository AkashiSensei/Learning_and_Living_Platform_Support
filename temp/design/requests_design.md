# Requests

## User

| RequestName        | Method | Header        | Body                                    | ExpectMessage     |
| ------------------ | ------ | ------------- | --------------------------------------- | ----------------- |
| verifyUserLogin    | POST   | None          | email/userId,password                   | None              |
| verifyAdminLogin   | POST   | None          | email/userId,password                   | None              |
| verifyUserRegister | POST   | None          | email,password                          | None              |
| getAccountInfo     | GET    | Authorization | None                                    | UserDetail        |
| getAccountInfoList | GET    | Authorization | cntInPage,pageNum                       | List<UserSummary> |
| updateAccountInfo  | PUT    | Authorization | name,email,gender,birthday,profilePhoto | UserDetail        |
| getPassword        | POST   | Authorization | email                                   | None              |
| updatePassword     | PUT    | Authorization | oldPassword,newPassword                 | None              |
| deleteAccount      | DELETE | Authorization | userId                                  | None              |

## Resource

| RequestName            | Method | Header        | Body                                                    | ExpectMessage         |
| ---------------------- | ------ | ------------- | ------------------------------------------------------- | --------------------- |
| listResourceByCategory | GET    | Authorization | category,cntInPage,pageNum                              | List<ResourceSummary> |
| listRecommendResouece  | GET    | Authorization | cntInPage,pageNum                                       | List<ResourceSummary> |
| uploadResource         | POST   | Authorization | title,subject,category,publishedTime,content,image,file | None                  |
| downloadResource       | GET    | Authorization | resourceId                                              | None                  |
| getResourceDetail      | GET    | Authorization | None                                                    | ResourceDetail        |
| DeleteResource         | DELETE | Authorization | resourceId                                              | None                  |
| getDownloadHistory     | GET    | Authorization | cntInPage,pageNum                                       | List<DownloadRecord>  |
| DeleteDownloadHistory  | DELETE | Authorization | resourceId                                              | None                  |

## Post

| RequestName   | Method | Header        | Body                             | ExpectMessage      |
| ------------- | ------ | ------------- | -------------------------------- | ------------------ |
| listPosts     | GET    | Authorization | cntInPage,pageNum                | List<PostSummary>  |
| addPost       | POST   | Authorization | title,content,postTime,authority | None               |
| deletePost    | DELETE | Authorization | postId                           | None               |
| getPostDetail | GET    | Authorization | None                             | PostDetail         |
| likePost      | POST   | Authorization | None                             | None               |
| undoLikePost  | POST   | Authorization | None                             | None               |
| listComments  | GET    | Authorization | None                             | List<CommentEntry> |
| listReplys    | GET    | Authorization | commentId                        | List<ReplyEntry>   |
| commentPost   | POST   | Authorization | publishTime,content,images       | CommentEntry       |
| replyComment  | POST   | Authorization | commentId,publishTime,content    | ReplyEntry         |
| deletComment  | DELETE | Authorization | commentId                        | None               |
| deleteReply   | DELETE | Authorization | replyId                          | None               |

## Stastics

| RequestName                   | Method | Header        | Body               | ExpectMessage         |
| ----------------------------- | ------ | ------------- | ------------------ | --------------------- |
| getNumOfCurrentOnline         | GET    | Authorization | None               | (Integer)onlineNum    |
| getOverallInfo                | GET    | Authorization | None               | OverallFigure         |
| listPostOrderedByView         | GET    | Authorization | beginDate, endDate | List<PostSummary>     |
| listPostOrderedByPopularity   | GET    | Authorization | beginDate, endDate | List<PostSummary>     |
| listResourceByDownload        | GET    | Authorization | beginDate, endDate | List<ResourceSummary> |
| listUserByCntOfResourceUpload | GET    | Authorization | beginDate, endDate | List<UserSummary>     |

# ReturnValue

All request will be responded with a RestBean:

```java
public class RestBean<T> {
    private int status; 
    private boolean success; 
    private T message;
}
```

## status code

（还没有设计）

# 问题

1. 比如说获取个人信息，是否是在header里面存放当前用户的id，body为空？

| RequestName    | Method | Header | Body | ExpectMessage |
| -------------- | ------ | ------ | ---- | ------------- |
| getAccountInfo | GET    |        | None | User          |

> user的确定是通过放在header里面的token来确定的；
>
> postId、resourceId会放在url里；
>
> 至于像commentId，replyId等隐式的数据，需要放在body体内传输。

2. 分页获取资源/帖子是怎么实现的？

> 通过向后端发送当前页和页面容纳的数量来获得数据
