# Service Design

Service接口设计模板如下，具体设计思路应更新在《设计文档》中，有些参数设计仍需商榷：

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

## UserService

26个方法

| 方法签名                                                     | 描述                               |
| ------------------------------------------------------------ | ---------------------------------- |
| public String getUserSalt(String idOrEmail)                  | 获取用户盐值                       |
| public String getAdminSalt(String idOrEmail)                 | 获取管理员盐值                     |
| public Admin getAdminByEmail(String email)                   | 获取管理员信息                     |
| public void updateAdmin(Admin admin)                         | 更新管理员信息                     |
| public String getUserIdByToken(String token)                 | 从 token 中提取用户ID              |
| public User authenticateUser(VerifyUserLoginRequest verifyUserLoginRequest) | 验证用户输入的用户名和密码         |
| public User authenticateAdmin(VerifyAdminLoginRequest verifyAdminLoginRequest) | 验证管理员输入的用户名和密码       |
| public void addUserOnline(User user,String token)            | 将已登录用户添加到已登陆用户的表中 |
| public void setUserOnlineToken(int id, String token)         | 设置/更新已登录用户的token         |
| public List\<UserOnline> getAllUserOnline()                  | 获得所有已登录的用户               |
| public void deleteUserOnline(String id)                      | 将用户从已登录用户中移除           |
| public int getMaxUserId()                                    | 获得已注册用户中最大的id           |
| public String addUser(VerifyRegisterRequest verifyRegisterRequest) | 创建新的用户                       |
| public String addAdmin(VerifyRegisterRequest verifyRegisterRequest) | 创建新的管理员                     |
| public User findUserByEmail(String email)                    | 根据邮箱 查找用户                  |
| public UserDetail getUserInfo(String userId) throws UserException | 获取用户信息                       |
| public boolean updateAccountInfo(UpdateAccountInfoRequest updateAccountInfoRequest) | 更新用户信息                       |
| public void setLoginNum(String userId, int logInNum)         | 更新用户登陆天数                   |
| public void resetPassword(String email, String code)         | 重置用户密码                       |
| public void updatePassword(String id, String password)       | 修改用户密码                       |
| public Page\<UserDetail> getUserDetailList(GetAccountInfoListRequest getAccountInfoListRequest) | 按页获取用户列表                   |
| public boolean deleteAccount(String id)                      | 删除用户                           |
| public String getProfilePhotoUrl(int userId)                 | 获取用户头像                       |
| public int getUserCountByTime(LocalDateTime startTime, LocalDateTime endTime) | 获取一定时间范围内注册的用户       |
| public int getAllUserOnlineCount()                           | 获取当前在线用户数                 |
| public  int getAllUserCount()                                | 获取所有注册用户数                 |

## LogService

| 方法签名                                 | 描述                       |
| ---------------------------------------- | -------------------------- |
| public boolean addLog(String curUserId)  | 添加一条新的登陆记录       |
| public Log getLastLog(String userId)     | 获得某用户最后一次登录记录 |
| public void deleteLogByUserId(String id) | 删除某个账号所有记录       |
| public void userLogout(int userId)       | 添加用户登出记录           |

## PostService

| 方法签名                                                     | 描述                       |
| ------------------------------------------------------------ | -------------------------- |
| public int addPost(AddPostRequest addPostRequest, String filepath, int userId) throws PostException | 发布帖子                   |
| public Page\<PostSummary> getPostList(int userId, ListPostRequest listPostRequest) throws PostException | 按页获取帖子列表           |
| public PostDetail getPost(int postId) throws PostException   | 获取帖子详情               |
| public boolean deletePost(DeletePostRequest deletePostRequest) throws PostException | 删除帖子                   |
| public void addBrowse(int postId)                            | 增加帖子浏览量             |
| public List<PostSummary> getPostByHot(int userId) throws PostException | 获得热门帖子列表           |
| public boolean updateUpdateTime(int postId) throws PostException | 更新帖子更新时间           |
| public int getPostCountByTime(LocalDateTime startTime, LocalDateTime endTime) | 获取某时间段发布的帖子量   |
| public List\<Post> getPostByTime(LocalDateTime startTime, LocalDateTime endTime) | 获取某时间段发布的所有帖子 |
| public int getAllPostCount()                                 | 获得所有帖子量             |
| public Page\<PostSummary> postsOfUser(ListUserPostRequest listUserPostRequest) throws PostException | 按页获取某用户发的所有帖子 |

## LikeService

| 方法签名                                                     | 描述                       |
| ------------------------------------------------------------ | -------------------------- |
| public boolean getLiked(int curUserId, int postId)           | 查询某用户是否已点赞此帖子 |
| public boolean addLike(int userId, int postId) throws LikeException | 增加点赞                   |
| public boolean deleteLike(int userId, int postId) throws LikeException | 撤销点赞                   |

## CommentService

删除帖子时使用级联删除的方式删除评论。

| 方法签名                                                     | 描述                   |
| ------------------------------------------------------------ | ---------------------- |
| public boolean addComment(CommentPostRequest commentPostRequest, String path) throws CommentException | 发布评论               |
| public Page\<CommentEntry> getCommentList(ListCommentRequest listCommentRequest) throws CommentException | 按页获取帖子的所有评论 |
| public boolean deleteComment(DeleteCommentRequest deleteCommentRequest, int curUserId) throws CommentException | 删除评论               |
| public CommentEntry getComment(int commentId) throws CommentException | 获取评论               |

## ReplyService

删除帖子或评论时使用级联删除删除相应回复。

| 方法签名                                                     | 描述           |
| ------------------------------------------------------------ | -------------- |
| public List\<ReplyEntry> getReplyList(ListReplyRequest listReplyRequest) throws ReplyException | 获取回复列表   |
| public ReplyEntry addReply(ReplyCommentRequest replyCommentRequest) throws ReplyException | 发布评论的回复 |
| public boolean deleteReply(DeleteReplyRequest deleteReplyRequest, int userId) throws ReplyException | 删除评论       |

## ResourceService

| 方法签名                                                     | 描述                         |
| ------------------------------------------------------------ | ---------------------------- |
| public boolean addResource(String userId,UploadResourceRequest uploadResourceRequest) throws ResourceException | 发布资源                     |
| public ResourceDetail getResourceDetail(GetResourceDetailRequest getResourceDetailRequest)throws ResourceException | 获取资源详情                 |
| public void updateResourceDetail(ResourceDetail resourceDetail) | 修改资源                     |
| public void updateResourceCategories(int resourceId,int[] categories) | 修改资源学科和类型           |
| public Page\<ResourceSummary> getResourceSummaryByClassWithPage( ListResourceByCategoryRequest listResourceByCategoryRequest) | 按页按学科按类别获取资源     |
| public void deleteResource(String resourceId)                | 删除资源                     |
| public int getResourceNumByCategoryAndSubject(int category, int subject) | 获取某学科某类型资源数       |
| public int getResourceCountByTime(LocalDateTime startTime, LocalDateTime endTime) | 获取某时间段发布的资源数     |
| public int getResourceCountBySubject(int subject)            | 获取某学科的资源数           |
| public Page\<ResourceSummary> searchResource(SearchResourceRequest searchResourceRequest) | 分页获取搜索的资源           |
| public ResourceSummary getResourceSummary(int resourceId)    | 获取资源概览                 |
| public List\<ResourceSummary> getResourceSummaryListRandom(int size, List\<Integer> resourceIDs) | 随机获取资源列表             |
| public Page\<ResourceSummary> getResourceSummaryByUserIdWithPage (ListResourceByUserIdRequest listResourceByUserIdRequest) | 分页获取某用户发布的所有资源 |
| public int getAllResourceCount()                             | 获取资源总数                 |

## DownloadHistoryService

| 方法签名                                                     | 描述                               |
| ------------------------------------------------------------ | ---------------------------------- |
| public int getDownloadsByTime(LocalDateTime startTime, LocalDateTime endTime) | 获取某时间段内的下载资源总量       |
| public boolean addDownloadHistory(String userId, String resourceId,String resourceTitle, String fileName) | 增加下载记录                       |
| public List\<DownloadHistoryEntry> listDownloadHistoryByUserId(String userId) | 获取某用户的所有下载记录           |
| public List\<Integer> listAllResourceId()                    | 获取所有已被下载过的资源id         |
| public List\<Integer> listDownloadHistoryUserIdByResourceId(Integer resourceId) | 获取所有下载过某资源的用户id       |
| public Map<Integer, Integer> getUserResourceMap()            | 将用户id与其下载过的资源id建立映射 |



## ExperienceService

| 方法签名                                                     | 描述                    |
| ------------------------------------------------------------ | ----------------------- |
| public boolean changeExp(String curUserId, int changeExp)    | 为相应用户增加/扣除积分 |
| public int getLevel(int userId)                              | 获取相应用户的等级      |
| public String getLevelName(int level)                        | 获取等级名称            |
| public int readExp(int userId)                               | 获取用户经验            |
| @Scheduled(cron = "0 0 0 * * *") public void resetDailyExp() | 每天凌晨重置当日经验    |

## Base64Util

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |
|          |      |
|          |      |



## ExamineService

| 方法签名                                        | 描述                 |
| ----------------------------------------------- | -------------------- |
| public static String TextCensor(String content) | 检查文本信息是否违规 |

## FileUtil

| 方法签名                                                     | 描述                           |
| ------------------------------------------------------------ | ------------------------------ |
| public static String readFileAsString(String filePath) throws IOException | 读取文件内容，作为字符串返回   |
| public static byte[] readFileByBytes(String filePath) throws IOException | 根据文件路径读取\**byte[] 数组 |

## GsonUtils

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |
|          |      |
|          |      |

## HttpUtil

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |
|          |      |
|          |      |

## JwtUtil

| 方法签名                                           | 描述                |
| -------------------------------------------------- | ------------------- |
| public static String createToken(User user)        | 为用户生成token     |
| public static DecodedJWT verifyToken(String token) | 解析token           |
| public static String getUserId(String token)       | 从token中获取userId |

## MailUtil

| 方法签名                                                     | 描述     |
| ------------------------------------------------------------ | -------- |
| public void sendSimpleMail(String from, String to, String cc, String subject, String content) | 发送邮件 |
|                                                              |          |
|                                                              |          |

