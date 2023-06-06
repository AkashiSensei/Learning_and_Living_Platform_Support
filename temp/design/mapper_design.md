# MapperDesign

| Mapper接口            | 解释                    |
| --------------------- | ----------------------- |
| UserMapper            | User表映射器            |
| AdminMapper           | Admin表映射器           |
| PostMapper            | Post表映射器            |
| LikeMapper            | Like表映射器            |
| CommentMapper         | Comment表映射器         |
| ReplyMapper           | Reply表映射器           |
| ResourceMapper        | Resource表映射器        |
| LogMapper             | Log表映射器             |
| DownloadHistoryMapper | DownloadHistory表映射器 |
| ExperienceMapper      | Experience表映射器      |

## UserMapper

| 接口函数名                                                   | 解释                     |
| ------------------------------------------------------------ | ------------------------ |
| User getUserByEmail(String email);                           | 通过email获取用户        |
| UserDetail getUserById(String id);                           | 通过id获取用户           |
| User getUserByIdOrEmail(String idOrEmail,String password);   | 通过email或id获取用户    |
| UserSummary getUserSummaryByEmail(String email);             | 获取UserSummary          |
| int addUser(User user);                                      | 添加用户                 |
| boolean setUserInitName(String email);                       | 设置初始用户名           |
| boolean updateUser(UpdateAccountInfoRequest updateAccountInfoRequest) | 更新用户信息             |
| int getUserCount();                                          | 获取用户数量             |
| List\<UserDetail> getAllUserDetail(int filter, int cntInPage); | 获取用户列表             |
| boolean updatePasswordById(String password, String id);      | 修改密码                 |
| boolean deleteUserById(String id);                           | 删除用户                 |
| String getNameById(int userId);                              | 获取用户名               |
| String getProfilePhotoUrl(int userId);                       | 获取用户头像             |
| String getUserSaltByIdOrEmail(String idOrEmail);             | 获取用户盐值             |
| int addUserOnline(User user);                                | 添加在线用户             |
| int setUserOnlineToken(int id,String token);                 | 设置在线用户token        |
| List\<UserOnline> getAllUserOnline();                        | 获取在线用户列表         |
| void removeUserOnlineById(String id);                        | 用户下线                 |
| void setLoginNum(String userId, int logInNum);               | 设置用户登陆天数         |
| int getUserCountByTime(LocalDateTime startTime, LocalDateTime endTime); | 查询某时间段内注册用户数 |
| int getMaxUserId();                                          | 获取最大id               |
| int getAllUserOnlineCount();                                 | 获取在线用户数           |

## AdminMapper

| 接口函数名                                                   | 解释           |
| ------------------------------------------------------------ | -------------- |
| String getAdminSaltByIdOrEmail(String idOrEmail);            | 获取管理员盐值 |
| User verifyAdminByIdOrEmail(String idOrEmail, String password); | 验证管理员密码 |
| Admin getAdminByEmail(String email);                         | 查询管理员     |
| boolean addAdmin(Admin admin);                               | 添加管理员     |
| boolean updateAdmin(Admin admin);                            | 修改管理员密码 |

## PostMapper

| 接口函数名                                                   | 解释                           |
| ------------------------------------------------------------ | ------------------------------ |
| boolean createPost(PostDetail post);                         | 创建帖子                       |
| boolean deletePost(int postId, int userId);                  | 删除帖子                       |
| PostDetail readPost(int postId);                             | 查询帖子（单条）               |
| List\<PostSummary> readPostList(int userId, int filter, int cntInPage); | 查询帖子列表(按id)             |
| List\<PostSummary> readPostListByChange(int userId, int filter, int cntInPage); | 查询所有帖子（按最近修改时间） |
| List\<PostSummary> readPostListByMe(int userId, int filter, int cntInPage); | 查询我发布的所有帖子           |
| List\<PostSummary> readPostListByOther(int userId, int filter, int cntInPage); | 查询其他用户发布的帖子列表     |
| int sumOfUserPosts(int userId);                              | 查询某用户发布的所有帖子数     |
| int getPostCount();                                          | 查询所有帖子数                 |
| boolean updateLike(int postId, int plus);                    | 修改帖子点赞量                 |
| int getFloor(int postId);                                    | 查询帖子楼层数                 |
| boolean updateFloor(int postId, int plus);                   | 增加帖子楼层数                 |
| void addBrowse(int postId);                                  | 增加帖子浏览量                 |
| List\<PostSummary> readPostListByHot(int userId);            | 查询热帖                       |
| boolean updateUpdateTime(int postId, Date time);             | 更新最近更新时间               |
| int getPostCountByTime(LocalDateTime startTime, LocalDateTime endTime); | 查询某事件段内发布的贴子数     |
| List<Post> getPostByTime(LocalDateTime startTime, LocalDateTime endTime); | 查询某事件段内发布的贴子       |

## LikeMapper

| 接口函数名                                                | 解释               |
| --------------------------------------------------------- | ------------------ |
| boolean createLike(int postId, int userId, Date likeTime) | 创建点赞记录       |
| boolean deleteLike(int postId, int userId);               | 删除点赞记录       |
| boolean isLike(int postId, int userId);                   | 查询某用户是否点赞 |

## CommentMapper

| 接口函数名                                                   | 解释             |
| ------------------------------------------------------------ | ---------------- |
| boolean createComment(CommentEntry comment);                 | 创建评论         |
| boolean deleteComment(int commentId, int userId);            | 删除评论         |
| List\<CommentEntry> readPostComment(int postId, int userId, int filter, int cntInPage); | 获取帖子评论     |
| CommentEntry getCommentById(int commentId);                  | 查询帖子评论     |
| int getCommentCount(int postId);                             | 查询某帖子评论数 |

## ReplyMapper

| 接口函数名                                                   | 解释                 |
| ------------------------------------------------------------ | -------------------- |
| boolean createReply(ReplyEntry reply);                       | 创建回复             |
| boolean deleteReply(int replyId, int userId);                | 删除回复             |
| List\<ReplyEntry> readCommendReply(int commentId, int userId, int cntInPage); | 查询某条评论全部回复 |
| List\<ReplyEntry> readAllReply();                            | 查询回复总体统计数据 |

## ResourceMapper

| 接口函数名                                                   | 解释                                         |
| ------------------------------------------------------------ | -------------------------------------------- |
| int getResourceBySubjectsAndCategoriesCount(int[] subjects,int[] categories); | 查询某些学科某些类型的资源数                 |
| int createResource(Resource resource);                       | 创建资源                                     |
| int createResourceCategories(int resourceId, int category);  | 创建资源类型                                 |
| int deleteResource(String resourceId);                       | 删除资源                                     |
| void deleteResourceCategories(int resourceId);               | 删除资源类型                                 |
| ResourceDetail readResource(String resourceId);              | 查询资源详情                                 |
| List\<ResourceCategoryEntry> getResourceCategoriesById(int id); | 查询资源类型                                 |
| int[] readResourceCategories(String resourceId);             | 查询资源类型                                 |
| void updateResource(ResourceDetail resourceDetail);          | 修改资源                                     |
| List\<ResourceSummary> getResourcesBySubjectAndCategoriesByPage (@Param("subjects") int[] subjects,  @Param("categories") int[] categories,@Param("filter") int filter, @Param("cntInPage") int cntInPage); | 查询某些学科某些类型的资源                   |
| int getResourceNumByCategoryAndSubject(int category, int subject); | 按学科按类型查询资源                         |
| int getResourceCountByTime(LocalDateTime startTime, LocalDateTime endTime); | 查询某时间段内发布资源数                     |
| int getResourceCountBySubject(int subject);                  | 查询某学科资源数                             |
| List\<ResourceSummary> searchResourcesBySubjectAndCategoriesByPage( @Param("keywords")String keywords,@Param("subjects") int[] subjects,@Param("categories") int[] categories,  @Param("filter") int filter,@Param("cntInPage") int cntInPage); | 查询符合某关键词的某些学科某些类型的资源     |
| int searchResourceBySubjectsAndCategoriesCount(String keywords, int[] subjects, int[] categories); | 查询符合某关键词的某些学科某些类型的资源数量 |
| ResourceSummary getResourceSummary(int resourceId);          | 查询某用户发布的所有资源                     |
| int getResourceCountByUserId(int userId);                    | 查询某用户发布的所有资源数                   |
| List\<ResourceSummary> getResourceSummaryListRandom(int size, List\<Integer> resourceIDs); | 随机获取除某些id外的资源                     |
| int getAllResourceCount();                                   | 获取全部资源数                               |
| List\<ResourceSummary> getResourceSummaryByUserId(int userId, int filterCount, int pageSize); | 按页查询某用户发布的所有资源                 |

## LogMapper

| 接口函数名                                              | 解释                   |
| ------------------------------------------------------- | ---------------------- |
| boolean addLog(String curUserId);                       | 创建日志               |
| void addLogoutTime(int userId);                         | 添加登出               |
| void deleteLogByUserId(String id);                      | 清空某用户登录日志     |
| Log getLastLogByUserId(@Param("userId") String userId); | 查询某用户最新登录日志 |

## DownloadHistoryMapper

| 接口函数名                                                   | 解释                     |
| ------------------------------------------------------------ | ------------------------ |
| boolean createDownloadHistory(DownloadHistoryEntry downloadHistory); | 创建下载记录             |
| List\<DownloadHistoryEntry> readDownloadHistoryByUserId(int userId); | 获取某用户下载记录       |
| List\<Integer> readAllResourceId();                          | 获取下载过资源的用户id   |
| List\<Integer> readDownloadHistoryByResourceId(Integer resourceId); | 获取下载过某资源的用户id |
| List\<UserResourceMap> getUserResourceMap();                 | 获取用户和资源的下载关系 |
| int getDownloadsByTime(LocalDateTime startTime, LocalDateTime endTime); | 获取某段时间内的下载量   |

## ExperienceMapper

| 接口函数名                                                   | 解释               |
| ------------------------------------------------------------ | ------------------ |
| boolean updateExperience(String curUserId, int changeNumber); | 更改用户经验       |
| boolean getExperience(int curUserId);                        | 获取用户经验项数   |
| int readExperience(int userId);                              | 获取用户经验       |
| void resetDailyExp();                                        | 重置每日经验上限   |
| int getDailyExp(int userId);                                 | 获取当日已获得经验 |