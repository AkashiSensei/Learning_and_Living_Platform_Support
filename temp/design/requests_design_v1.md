## ReturnValue

All request will be responded with a RestBean:

```java
public class RestBean<T> {
    private int status; 
    private boolean success; 
    private T message;
}
```

## status code

# Requests



Possible requests from the frontend:

**两个问题：**

1.比如说获取个人信息，是否是在header里面存放当前用户的id，body为空？

| RequestName    | Method | Header | Body | ExpectMessage |
| -------------- | ------ | ------ | ---- | ------------- |
| getAccountInfo | GET    |        | None | User          |

2.分页获取资源/帖子是怎么实现的？

## User:

| RequestName        | Method | Header | Body                       | ExpectMessage |
| ------------------ | ------ | ------ | -------------------------- | ------------- |
| verifyUserLogin    | POST   |        | email/id,password          | None          |
| verifyAdminLogin   | POST   |        | email/id,password          | None          |
| verifyUserRegister | POST   |        | email,password             | None          |
| getAccountInfo     | GET    |        | None                       | User          |
| getAccountInfoList | GET    |        | None                       | List<User>    |
| updateAccountInfo  | PUT    |        | name,email,gender,birthday | User          |
| updatePassword     | PUT    |        | password                   | None          |
| deleteAccount      | DELETE |        | None                       | None          |

## Resource:

| RequestName            | Method | Header | Body     | ExpectMessage  |
| ---------------------- | ------ | ------ | -------- | -------------- |
| listResourceByCategory | GET    |        | category | List<Resource> |
| listRecommendResouece  | GET    |        | None     | List<Resource> |
| uploadResource         | POST   |        | fileData | None           |
| downloadResource       | GET    |        | None     | (not sure)     |
| getResourceDetail      | GET    |        | None     | Resource       |
| DeleteResource         | DELETE |        | None     | None           |
| getDownloadHistory     | GET    |        | None     | List<Resource> |

## Post:

| RequestName   | Method | Header | Body                                     | ExpectMessage |
| ------------- | ------ | ------ | ---------------------------------------- | ------------- |
| listPosts     | GET    |        | None                                     | List<Post>    |
| addPost       | POST   |        | title,content,postTime,authority,imageId | None          |
| deletePost    | DELETE |        | None                                     | None          |
| getPostDetail | GET    |        | None                                     | Post          |
| likePost      | POST   |        | (not sure)                               | None          |
| commentPost   | POST   |        | commentTime,content,imageId,(floor?)     | Comment       |
| replyComment  | POST   |        | (commentId?),replyTime,content           | Reply         |
| deletComment  | DELETE |        | None                                     | None          |
| deleteReply   | DELETE |        | None                                     | None          |
