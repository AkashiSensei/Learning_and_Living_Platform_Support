# Controller Design

| Controller类名     | 描述                                                       |
| ------------------ | ---------------------------------------------------------- |
| UserController     | 处理用户和管理员登录、访客注册、用户信息修改等用户相关请求 |
| PostController     | 处理发布新帖子，点赞、评论帖子等帖子相关请求               |
| ResourceController | 处理发布新资源，下载资源等相关请求                         |

如无特殊说明，方法共有，变量私有。

## 返回值body模板类

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

最终的返回值实际上是ResponseEntity\<RestBean>



## UserController

| 方法签名                                               | 描述 |
| ---- | ------------------------------------------------------------ |
| ResponseEntity\<RestBean> verifyToken(HttpServletRequest request) | 检查token，并判断是用户还是管理员 |
| ResponseEntity\<RestBean&gt; getSalt(@RequestBody GetSaltRequest getSaltRequest, HttpServletRequest request){ | 根据id获取其盐值 |
| ResponseEntity\<RestBean> getLevel( HttpServletRequest request) | 根据token获取用户等级 |
| ResponseEntity\<RestBean> verifyUserLogin(@RequestBody VerifyUserLoginRequest verifyUserLoginRequest,                                                HttpServletRequest request) | 检查用户登入信息 |
| ResponseEntity\<RestBean> verifyAdminLogin(@RequestBody VerifyAdminLoginRequest verifyAdminLoginRequest, HttpServletRequest request) | 检查管理员登入信息 |
| RestBean\<UserSummary> verifyUserRegister(@RequestBody VerifyUserRegisterRequest verifyUserRegisterRequest, HttpServletRequest request) | 检查用户注册信息，调用verifyUserRegisterService |
| ResponseEntity\<RestBean> logout(HttpServletRequest request) | 用户/管理员登出 |
| RestBean\<UserDetail> getAccountInfo(HttpServletRequest request) | 获取账号信息，调用getAccountInfoService, getExp |
| RestBean\<List\<UserSummary>> getAccountInfoList(@RequestBody GetAccountInfoListRequest getAccountInfoListRequest, HttpServletRequest request) | 获取账号列表，调用getAccountInfoList |
| RestBean\<String>  updateAccountInfo(@RequestBody UpdateAccountInfoRequest updateAccountInfoRequest, HttpServletRequest request) | 更新账号信息，调用updateAccountInfo |
| RestBean\<String> getPassword(@RequestBody GetPasswordRequest getPasswordRequest, HttpServletRequest request) | 忘记密码，调用getPassword |
| RestBean\<String> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest, HttpServletRequest request) | 更新密码，调用updatePassword |
| RestBean\<String> deleteAccount(@RequestBody DeleteAccountRequest deleteAccountRequest, HttpServletRequest request) | 删除账号，调用deleteAccount, deleteLog |


## PostController

| 方法签名                                                     | 描述 |
| ------------------------------------------------------------ | ---- |
| RestBean\<List\<PostSummary>> listPost(@RequestBody ListPostRequest listPostRequest, HttpServletRequest request) | 获取帖子列表，调用listPosts   |
| RestBean\<PostDetail> openPost(HttpServletRequest request)                          | 获取帖子详细信息，调用getPostDetail     |
| RestBean\<List\<PostSummary>> uploadPost(@RequestBody AddPostRequest addPostRequest, HttpServletRequest request)         |  发布帖子，调用addPost, changeExp, listPosts(这里表示发布完要重新刷新)   |
| RestBean\<List\<PostSummary>> deletePost(@RequestBody DeletePostRequest deletePostRequest, HttpServletRequest request)               | 删除帖子，调用deletePost,listPosts, changeExp    |
| RestBean\<PostDetail> likePost(HttpServletRequest request)                         | 点赞帖子，调用likePost, changeExp, getPostDetail     |
| RestBean\<PostDetail> undoLikePost(HttpServletRequest request) | 取消点赞帖子 |
| RestBean\<PostDetail> commentPost(@RequestBody CommentPostRequest commentPostRequest, HttpServletRequest request)                      | 评论帖子，调用commentPost, changeExp, getPostDetail     |
| RestBean\<List\<CommentEntry>> listComment(HttpServletRequest request) | 获取评论列表 |
| RestBean\<List\<ReplyEntry>> listReply(@RequestBody ListReplyRequest listReplyRequest, HttpServletRequest request) | 获取评论的回复列表 |
| RestBean\<PostDetail> replyComment(@RequestBody ReplyCommentRequest replyCommentRequest, HttpServletRequest request)                    | 回复评论，调用replyComment, getPostDetail     |
| RestBean\<PostDetail> deleteComment(@RequestBody DeletCommentRequest deleteCommentRequest, HttpServletRequest request)                   | 删除评论，调用deletComment, getPostDetail, changeExp     |
| RestBean\<PostDetail> deleteReply(@RequestBody DeleteReplyRequest deleteReplyRequest, HttpServletRequest request)                      | 删除评论回复，调用deleteReply, getPostDetail     |

## ResourceController

| 方法签名                                                     | 描述 |
| ------------------------------------------------------------ | ---- |
| RestBean\<List\<ResourceSummary>> listResourceByCategory(@RequestBody ListResourceByCategoryRequest listResourceByCategoryRequest, HttpServletRequest request) |分类获取资源列表，调用listResourceByCategory |
| RestBean\<List\<ResourceSummary>> listRecommendResource(@RequestBody ListRecommendResoueceRequest listRecommendResoueceRequest, HttpServletRequest request) |获取推荐资源列表，调用listRecommendResouece |
| RestBean\<String> uploadResource(@RequestBody UploadResourceRequest uploadResourceRequest, HttpServletRequest request) |上传资源，调用uploadResource, changeExp |
| RestBean\<String> downloadResource(@RequestBody DownloadResourceRequest downloadResourceRequest, HttpServletRequest request) |下载资源，调用downloadResource, changeExp |
| RestBean\<ResourceDetail> getResourceDetail(HttpServletRequest request) |获取资源详情页，调用getResourceDetail |
| RestBean\<List\<ResourceSummary>> deleteResource(@RequestBody DeleteResourceRequest deleteResourceRequest, HttpServletRequest request) |删除资源，调用deleteResource,changeExp,listResourceByCategory |
| RestBean\<List\<DownloadHistoryEntry>> getDownloadHistory(@RequestBody GetDownloadHistoryRequest getDownloadHistoryRequest, HttpServletRequest request) |获取下载历史,调用getDownloadHistory |
| RestBean\<String> deleteDownloadHistory(@RequestBody DeleteDownloadHistoryRequest deleteDownloadHistoryRequest,HttpServletRequest request) |清空某资源的下载历史,调用deleteDownloadHistory |

## StatisticController

| 方法签名                                                     | 描述                             |
| ------------------------------------------------------------ | -------------------------------- |
| RestBean\<int>getNumOfCurrentOnline(HttpServletRequest request) | 获取当前在线人数                 |
| RestBean\<OverallFigure> getOverallInfo(HttpServletRequest request) | 获取总体信息                     |
| RestBean\<List\<PostSummary>> listPostOrderedByView(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据浏览量对帖子排序并获取       |
| RestBean\<List\<PostSummary>> listPostOrderedByPopularity(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据热度对帖子排序并获取         |
| RestBean\<List\<ResourceSummary>> listResourceByDownload(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据下载量对资源排序并获取       |
| RestBean\<List\<UserSummary>> listUserByCntOfResourceUpload(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据上传资源数量对用户排序并获取 |
