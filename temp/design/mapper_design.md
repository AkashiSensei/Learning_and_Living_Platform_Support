# MapperDesign

| Mapper接口           | 解释                   |
| -------------------- | ---------------------- |
| UserMapper           | User表映射器           |
| AdminMapper          | Admin表映射器          |
| PostMapper           | Post表映射器           |
| LikeMapper           | Like表映射器           |
| CommentMapper        | Comment表映射器        |
| ReplyMapper          | Reply表映射器          |
| ImageMapper          | Image表映射器          |
| ResourceMapper       | Resource表映射器       |
| LogMapper            | Log表映射器            |
| DownloadRecordMapper | DownloadRecord表映射器 |

## UserMapper

| 接口函数名                                                   | 解释                       |
| ------------------------------------------------------------ | -------------------------- |
| String createUser(User user);                                | 创建用户                   |
| int deleteUser(int userId)                                   | 删除用户（用户使用）       |
| int deleteUser(List\<int> userIdList);                       | 批量删除用户（管理员使用） |
| int updateUser(UserDetail user);                             | 修改用户信息               |
| int updatePassword(int userId, String password)              | 修改用户密码               |
| UserDetail readUserById(int userId);                         | 查询用户（单条）           |
| UserDetail readUserByEmail(String email)                     | 查询用户（单条）           |
| String readPassword(int userId);                             | 查询用户密码               |
| UserDisplay identifyUserById(int userId, String password);   | 使用id验证用户及密码       |
| UserDisplay identifyUserByEmail(String email, String password); | 使用email验证用户及密码    |
| List\<UserSummary> readAllUser();                            | 查询所有用户（管理员使用） |

## AdminMapper

| 接口函数名                                       | 解释               |
| ------------------------------------------------ | ------------------ |
| int createAdmin(Admin admin);                    | 创建管理员         |
| int updateAdmin(Admin admin);                    | 修改管理员信息     |
| Admin readAdmin(int adminId);                    | 查询管理员（单条） |
| int identifyAdmin(int adminId, String password); | 验证管理员及密码   |

## PostMapper

| 接口函数名                                    | 解释                 |
| --------------------------------------------- | -------------------- |
| int createPost(Post post);                    | 创建帖子             |
| int deletePost(int postId)                    | 删除帖子             |
| PostDetail readPost(int postId);              | 查询帖子（单条）     |
| List\<PostSummary> readPostList(int PageNum); | 查询帖子列表（按页） |
| List\<PostSummary> readAllPost();             | 查询所有帖子         |

## LikeMapper

| 接口函数名                      | 解释                                                  |
| ------------------------------- | ----------------------------------------------------- |
| int createLike(Like like);      | 创建（即增加，在此为符合数据库CURD命名）点赞记录      |
| int deleteLike(int likeId);     | 删除（即取消，同上，like仅有uid-pid两个属性）点赞记录 |
| int readLike(int postId);       | 查询点赞数量                                          |
| List\<LikeEntry> getAllLike()； | 查询点赞总体统计数据                                  |

## CommentMapper

| 接口函数名                                       | 解释                                       |
| ------------------------------------------------ | ------------------------------------------ |
| int createComment(CommentEntry comment);         | 创建评论                                   |
| int deleteComment(int commentId);                | 删除评论（注意数据库设计中的级联删除问题） |
| int deletePostComment(int postId);               | 删除帖子所有评论                           |
| List\<CommentEntry> readPostComment(int postId); | 查询帖子评论                               |
| List\<CommentEntry> readAllComment();            | 查询评论总体统计数据                       |

## ReplyMapper

| 接口函数名                                         | 解释                                       |
| -------------------------------------------------- | ------------------------------------------ |
| int createReply(ReplyEntry reply);                 | 创建回复                                   |
| int deleteReply(int replyId);                      | 删除回复（注意数据库设计中的级联删除问题） |
| int deletePostReply(int postId);                   | 删除帖子所有回复                           |
| int deleteCommentReply(int commentId);             | 删除某条评论回复                           |
| List\<ReplyEntry> readPostReply(int postId);       | 查询帖子评论前几条回复                     |
| List\<ReplyEntry> readCommendReply(int commentId); | 查询某条评论全部回复                       |
| List\<ReplyEntry> readAllReply();                  | 查询回复总体统计数据                       |

## ResourceMapper

| 接口函数名                                                   | 解释                                       |
| ------------------------------------------------------------ | ------------------------------------------ |
| int createResource(ResourceDetail resource);                 | 创建资源                                   |
| int deleteResource(int resourceId);                          | 删除资源（注意数据库设计中的级联删除问题） |
| ResourceDetail readResource(int resourceId);                 | 查询资源详情                               |
| List\<ResourceSummary> readResourceListRecommended(Date date, int pageNum, ...); | 查询推荐资源列表                           |
| List\<ResourceSummary> readResourceListByCategory(int category, int pageNum); | 查询分类资源列表                           |
| String readResourceDownload(int resourceId);                 | 查询资源下载URL                            |
| List\<ResourceSummary> readAllResource();                    | 查询资源总体统计数据                       |
| List\<ResourceSummary> readAllResourceByCategory(int category); | 查询资源总体统计数据                       |

## LogMapper

| 接口函数名                          | 解释             |
| ----------------------------------- | ---------------- |
| int createLog(Log log);             | 创建日志         |
| List\<LogEntry> readLog(Date date); | 查询日志         |
| int deleteLog(int userId)           | 清空用户日志     |
| int deleteLog(Datetime datetime)    | 清空日期所有日志 |

## DownloadHistoryMapper

| 接口函数名                                                   | 解释                     |
| ------------------------------------------------------------ | ------------------------ |
| int createDownloadHistory(DownloadHistoryEntry downloadHistory); | 创建下载记录             |
| List\<DownloadHistoryEntry> readDownloadHistoryByPage(int pageNum); | 查询下载记录             |
| int deleteDownloadHistory(int resourceId);                   | 清空下载记录             |
| List\<DownloadHistoryEntry> readAllDownloadHistory();        | 查询下载历史总体统计数据 |

## ExperienceMapper

| 接口函数名                                                | 解释         |
| --------------------------------------------------------- | ------------ |
| Boolean updateExperience(int curUserId, int changeNumber) | 更改用户经验 |
| Boolean getExperience(int curUserId)                      | 获取用户经验 |