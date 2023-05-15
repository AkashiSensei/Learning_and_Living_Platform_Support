# Controller Design

| Controller类名     | 描述                                                       |
| ------------------ | ---------------------------------------------------------- |
| UserController     | 处理用户和管理员登录、访客注册、用户信息修改等用户相关请求 |
| PostController     | 处理发布新帖子，点赞、评论帖子等帖子相关请求               |
| ResourceController | 处理发布新资源，下载资源等相关请求                         |

如无特殊说明，方法共有，变量私有。

## 返回值模板类

```java
public class RestBean<T> {
    private int status;
    private boolean success;
    private T message;

    private RestBean(int status, boolean success, T message){
        this.status = status;
        this.success = success;
        this.message = message;
    }

```

在使用了拦截器后，一个Controller方法应该像这样，注意这仅仅是一个示例。

```java
@RequestMapping(value = "/post/upload", method = RequestMethod.POST)
// request 是拦截器处理过的request，拦截器将 token 处理成当前用户的 id 并保存在 curUserId 字段
public RestBean<> updatePost(@RequestBody UploadPostRequest uploadPostRequest, HttpServletRequest request) {
    String curUserId = (String) request.getAttribute("curUserId");
    int ret = postService.uploadPost(uploadPostRequest, curUserId);
    
    // 相应的 service 仅仅返回事务逻辑的返回结果，包装成 RestBean 的任务交给 Controller
    if(ret == 0) {
        return RestBean.success(201);
    }else if(ret == -E_PERM) {
        return RestBean.failure(403, "No permission to upload posts");
    }else {
        return PrestBean.failure(500);
    }
}
```



## UserController

| 方法签名                                                     | 描述 |
| ---- | ------------------------------------------------------------ |
| verifyUserLogin(@RequestBody VerifyUserLoginRequest verifyUserLoginRequest, HttpServletRequest request) | 检查用户登入信息，调用verifyUserLoginService, addLog, changeExp(成功登入加积分) |
| verifyAdminLogin(@RequestBody VerifyAdminLoginRequest verifyAdminLoginRequest, HttpServletRequest request) | 检查管理员登入信息，调用verifyAdminLoginService |
| verifyUserRegister(@RequestBody VerifyUserRegisterRequest verifyUserRegisterRequest, HttpServletRequest request) | 检查用户注册信息，调用verifyUserRegisterService |
| getAccountInfo(HttpServletRequest request) | 获取账号信息，调用getAccountInfoService, getExp |
| getAccountInfoList(@RequestBody GetAccountInfoListRequest getAccountInfoListRequest, HttpServletRequest request) | 获取账号列表，调用getAccountInfoList |
| updateAccountInfo(@RequestBody UpdateAccountInfoRequest updateAccountInfoRequest, HttpServletRequest request) | 更新账号信息，调用updateAccountInfo |
| getPassword(@RequestBody GetPasswordRequest getPasswordRequest, HttpServletRequest request) | 忘记密码，调用getPassword |
| updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest, HttpServletRequest request)  | 更新密码，调用updatePassword |
| deleteAccount(@RequestBody DeleteAccountRequest deleteAccountRequest, HttpServletRequest request) | 删除账号，调用deleteAccount, deleteLog |


## PostController

| 方法签名                                                     | 描述 |
| ------------------------------------------------------------ | ---- |
| listPost(@RequestBody ListPostRequest listPostRequest, HttpServletRequest request) | 获取帖子列表，调用listPosts   |
| openPost(HttpServletRequest request)                                                     | 获取帖子详细信息，调用getPostDetail     |
| uploadPost(@RequestBody AddPostRequest addPostRequest, HttpServletRequest request)                                                   |  发布帖子，调用addPost, changeExp, listPosts(这里表示发布完要重新刷新)   |
| deletePost(@RequestBody DeletePostRequest deletePostRequest, HttpServletRequest request)                                                   | 删除帖子，调用deletePost,listPosts, changeExp    |
| likePost(HttpServletRequest request)                                                     | 点赞帖子，调用likePost, changeExp, getPostDetail     |
| undoLikePost(HttpServletRequest request) | 取消点赞帖子 |
| commentPost(@RequestBody CommentPostRequest commentPostRequest, HttpServletRequest request)                                                  | 评论帖子，调用commentPost, changeExp, getPostDetail     |
| listComment(HttpServletRequest request) | 获取评论列表 |
| listReply(@RequestBody ListReplyRequest listReplyRequest, HttpServletRequest request) | 获取评论的回复列表 |
| replyComment(@RequestBody ReplyCommentRequest replyCommentRequest, HttpServletRequest request)                                                 | 回复评论，调用replyComment, getPostDetail     |
| deleteComment(@RequestBody DeletCommentRequest deletCommentRequest, HttpServletRequest request)                                                | 删除评论，调用deletComment, getPostDetail, changeExp     |
| deleteReply(@RequestBody DeleteReplyRequest deleteReplyRequest, HttpServletRequest request)                                                  | 删除评论回复，调用deleteReply, getPostDetail     |

## ResourceController

| 方法签名                                                     | 描述 |
| ------------------------------------------------------------ | ---- |
| listResourceByCategory(@RequestBody ListResourceByCategoryRequest listResourceByCategoryRequest, HttpServletRequest request) |分类获取资源列表，调用listResourceByCategory |
| listRecommendResource(@RequestBody ListRecommendResoueceRequest listRecommendResoueceRequest, HttpServletRequest request) |获取推荐资源列表，调用listRecommendResouece |
| uploadResource(@RequestBody UploadResourceRequest uploadResourceRequest, HttpServletRequest request) |上传资源，调用uploadResource, changeExp |
| downloadResource(@RequestBody DownloadResourceRequest downloadResourceRequest, HttpServletRequest request) |下载资源，调用downloadResource, changeExp |
| getResourceDetail(HttpServletRequest request) |获取资源详情页，调用getResourceDetail |
| DeleteResource(@RequestBody DeleteResourceRequest deleteResourceRequest, HttpServletRequest request) |删除资源，调用deleteResource,changeExp,listResourceByCategory |
| getDownloadHistory(@RequestBody GetDownloadHistoryRequest getDownloadHistoryRequest, HttpServletRequest request) |获取下载历史,调用getDownloadHistory |
| deleteDownloadHistory(@RequestBody DeleteDownloadHistoryRequest deleteDownloadHistoryRequest,HttpServletRequest request) |清空某资源的下载历史,调用deleteDownloadHistory |

## StatisticController

| 方法签名                                                     | 描述                             |
| ------------------------------------------------------------ | -------------------------------- |
| getNumOfCurrentOnline(HttpServletRequest request)            | 获取当前在线人数                 |
| getOverallInfo(HttpServletRequest request)                   | 获取总体信息                     |
| listPostOrderedByView(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据浏览量对帖子排序并获取       |
| listPostOrderedByPopularity(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据热度对帖子排序并获取         |
| listResourceByDownload(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据下载量对资源排序并获取       |
| listUserByCntOfResourceUpload(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据上传资源数量对用户排序并获取 |
