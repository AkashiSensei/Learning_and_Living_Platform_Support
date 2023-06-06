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
| ResponseEntity\<RestBean> verifyUserRegister(@RequestBody VerifyRegisterRequest verifyRegisterRequest, HttpServletRequest request) | 检查用户注册信息 |
| ResponseEntity\<RestBean> handleHeartbeat(HttpServletRequest request) | 心跳机制，更新在线用户状态 |
| ResponseEntity\<RestBean> logout(HttpServletRequest request) | 用户/管理员登出 |
| checkTokenExpiration() | 监测在线用户状态，每一分钟执行一次 |
| ResponseEntity\<RestBean> getUserInfo(HttpServletRequest request) | 获取账号信息 |
| ResponseEntity\<RestBean> getAccountInfoList(@RequestBody GetAccountInfoListRequest getAccountInfoListRequest, HttpServletRequest request) | 按页获取账号列表 |
| ResponseEntity\<RestBean>  updateAccountInfo(@RequestBody UpdateAccountInfoRequest updateAccountInfoRequest, HttpServletRequest request){ | 更新账号信息 |
| ResponseEntity\<RestBean> getPassword(@RequestBody GetPasswordRequest getPasswordRequest, HttpServletRequest request) | 忘记密码 |
| ResponseEntity\<RestBean> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest, HttpServletRequest request) | 更新密码 |
| ResponseEntity\<RestBean> deleteAccount(@RequestBody DeleteAccountRequest deleteAccountRequest, HttpServletRequest request){ | 删除账号 |


## PostController

| 方法签名                                                     | 描述 |
| ------------------------------------------------------------ | ---- |
| ResponseEntity\<RestBean> uploadImage(@RequestPart("file") MultipartFile image,                                           HttpServletRequest request) | 上传帖子图片 |
| ResponseEntity\<RestBean> listPost(@RequestBody ListPostRequest listPostRequest, HttpServletRequest request) | 获取帖子列表   |
| ResponseEntity\<RestBean> openPost(@RequestBody GetPostDetailRequest getPostDetailRequest, HttpServletRequest request) | 获取帖子详细信息     |
| ResponseEntity\<RestBean> uploadPost(@RequestBody AddPostRequest addPostRequest, HttpServletRequest request) |  发布帖子   |
| ResponseEntity\<RestBean> deletePost(@RequestBody DeletePostRequest deletePostRequest, HttpServletRequest request) | 删除帖子    |
| ResponseEntity\<RestBean> likePost(@RequestBody LikePostRequest likePostRequest ,HttpServletRequest request) throws PostException | 点赞（取消点赞）帖子 |
| ResponseEntity\<RestBean> commentPost(@RequestBody CommentPostRequest commentPostRequest, HttpServletRequest request) throws PostException | 评论帖子，调用     |
| ResponseEntity\<RestBean> listComment(@RequestBody ListCommentRequest listCommentRequest, HttpServletRequest request) | 获取评论列表 |
| ResponseEntity\<RestBean> listReply(@RequestBody ListReplyRequest listReplyRequest, HttpServletRequest request) | 获取评论的回复列表 |
| ResponseEntity\<RestBean> replyComment(@RequestBody ReplyCommentRequest replyCommentRequest, HttpServletRequest request) throws PostException | 回复评论     |
| ResponseEntity\<RestBean> deleteComment(@RequestBody DeleteCommentRequest deleteCommentRequest, HttpServletRequest request) | 删除评论     |
| ResponseEntity\<RestBean> deleteReply(@RequestBody DeleteReplyRequest deleteReplyRequest, HttpServletRequest request) | 删除评论回复，调用deleteReply, getPostDetail     |
| ResponseEntity\<RestBean> getPostByHot(HttpServletRequest request) | 获取热门帖子 |

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
