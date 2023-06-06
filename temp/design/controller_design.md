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
| ResponseEntity\<RestBean> getOtherUserInfo(@RequestBody GetOtherUserInfoRequest getOtherUserInfoRequest, HttpServletRequest request) | 获取其他用户的账号信息 |
| ResponseEntity\<RestBean> getAccountInfoList(@RequestBody GetAccountInfoListRequest getAccountInfoListRequest, HttpServletRequest request) | 按页获取账号列表 |
| ResponseEntity\<RestBean>  updateAccountInfo(@RequestBody UpdateAccountInfoRequest updateAccountInfoRequest, HttpServletRequest request){ | 更新账号信息 |
| ResponseEntity\<RestBean> getPassword(@RequestBody GetPasswordRequest getPasswordRequest, HttpServletRequest request) | 忘记密码 |
| ResponseEntity\<RestBean> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest, HttpServletRequest request) | 更新密码 |
| ResponseEntity\<RestBean> deleteAccount(@RequestBody DeleteAccountRequest deleteAccountRequest, HttpServletRequest request){ | 删除账号 |


## PostController

| 方法签名                                                     | 描述 |
| ------------------------------------------------------------ | ---- |
| ResponseEntity\<RestBean> uploadImage(@RequestPart("file") MultipartFile image,HttpServletRequest request) | 上传帖子图片 |
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
| ResponseEntity\<RestBean> getUserPost(@RequestBody ListUserPostRequest listUserPostRequest, HttpServletRequest request) | 分页获取某用户发布的所有帖子 |

## ResourceController

| 方法签名                                                     | 描述 |
| ------------------------------------------------------------ | ---- |
| ResponseEntity\<RestBean> uploadFile(@RequestPart("file") MultipartFile file, HttpServletRequest request) | 上传资源文件 |
| ResponseEntity\<RestBean> uploadImage(@RequestPart("file") MultipartFile image,HttpServletRequest request) | 上传图片 |
| ResponseEntity\<RestBean> listResourceByClassWithPage(@RequestBody ListResourceByCategoryRequest listResourceByCategoryRequest,                                                                   HttpServletRequest request) | 分页分类获取资源列表 |
| ResponseEntity\<RestBean> searchResource(@RequestBody SearchResourceRequest searchResourceRequest,HttpServletRequest request) |分页（按关键词）分类获取资源列表 |
| ResponseEntity\<RestBean> listResourceRecommend(HttpServletRequest request) |获取某用户的推荐资源列表 |
| ResponseEntity\<RestBean> uploadResource(@RequestBody UploadResourceRequest uploadResourceRequest, HttpServletRequest request) |上传资源 |
| ResponseEntity\<RestBean> downloadResource(@RequestBody DownloadResourceRequest downloadResourceRequest, HttpServletRequest request) |下载资源 |
| ResponseEntity\<RestBean> getResourceDetail(@RequestBody GetResourceDetailRequest getResourceDetailRequest,HttpServletRequest request) |获取资源详情页 |
| ResponseEntity\<RestBean> updateResource(@RequestBody UpdateResourceRequest updateResourceRequest, HttpServletRequest request) |修改资源 |
| ResponseEntity\<RestBean> deleteResource(@RequestBody DeleteResourceRequest deleteResourceRequest,HttpServletRequest request) |删除资源 |
| ResponseEntity\<RestBean> listResourceByUserId(@RequestBody ListResourceByUserIdRequest listResourceByUserIdRequest,                                                     HttpServletRequest request) |分页查看某用户发布的资源 |
| ResponseEntity\<RestBean> listDownloadHistoryByUserId(HttpServletRequest request) |获取某用户的下载历史 |

## StatisticController

| 方法签名                                                     | 描述                         |
| ------------------------------------------------------------ | ---------------------------- |
| ResponseEntity\<RestBean> getOverallFigure(HttpServletRequest request) | 获取总体信息                 |
| ResponseEntity\<RestBean> resourceClassificationStatistics(HttpServletRequest request) | 获取每学科，每类别的资源数量 |
| ResponseEntity\<RestBean> resourceCountBySubject(HttpServletRequest request) | 获取每个学科的资源量         |
| ResponseEntity\<RestBean> resourceDownloadsByDays(HttpServletRequest request) | 过去30天每天资源的下载量     |
| ResponseEntity\<RestBean> userRegisterCountByDays(HttpServletRequest request) | 过去30天的每天新增注册用户量 |
| ResponseEntity\<RestBean> hotPostByDays(HttpServletRequest request) | 过去七天的所有帖子的热度信息 |
