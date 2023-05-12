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

| 接口函数名                             | 解释                       |
| -------------------------------------- | -------------------------- |
| int createUser(User user);             | 创建用户                   |
| int deleteUser(int userId)             | 删除用户（用户使用）       |
| int deleteUser(List\<int> userIdList); | 批量删除用户（管理员使用） |
| int updateUser(User user);             | 修改用户信息               |
| User readUser(int userId);             | 查询用户（单条）           |
| List\<User> readAllUser();             | 查询所有用户（管理员使用） |

## AdminMapper

| 接口函数名                    | 解释             |
| ----------------------------- | ---------------- |
| int createAdmin(Admin admin); | 创建管理员       |
| int updateAdmin(Admin admin); | 修改管理员信息   |
| Admin readAdmin(int adminId); | 查询用户（单条） |

## PostMapper

| 接口函数名                  | 解释                                     |
| --------------------------- | ---------------------------------------- |
| int createPost(Post post);  | 创建帖子                                 |
| int deletePost(int postId)  | 删除帖子                                 |
| Post readPost(int postId);  | 查询帖子（单条）                         |
| List\<Post> readPostList(); | 查询帖子列表（返回信息可以较少——需讨论） |

## LikeMapper

| 接口函数名                  | 解释                                                  |
| --------------------------- | ----------------------------------------------------- |
| int createLike(Like like);  | 创建（即增加，在此为符合数据库CURD命名）点赞记录      |
| int deleteLike(int likeId); | 删除（即取消，同上，like仅有uid-pid两个属性）点赞记录 |
| int readLike(int postId);   | 查询点赞数量                                          |

## CommentMapper

| 接口函数名                                  | 解释                                       |
| ------------------------------------------- | ------------------------------------------ |
| int createComment(Comment comment);         | 创建评论                                   |
| int deleteComment(int commentId);           | 删除评论（注意数据库设计中的级联删除问题） |
| List\<Comment> readPostComment(int postId); | 查询帖子评论                               |

## ReplyMapper

| 接口函数名                                     | 解释                                       |
| ---------------------------------------------- | ------------------------------------------ |
| int createReply(Reply reply);                  | 创建回复                                   |
| int deleteReply(int replyId);                  | 删除回复（注意数据库设计中的级联删除问题） |
| List\<Reply> readPostCommendReply(int postId); | 查询评论回复                               |

## ImageMapper

| 接口函数名                                      | 解释                                       |
| ----------------------------------------------- | ------------------------------------------ |
| int createImage(Image image);                   | 创建图片                                   |
| int deleteImage(int imageId);                   | 删除图片（注意数据库设计中的级联删除问题） |
| List\<Image> readImage(List\<int> imageIdList); | 查询多张图片                               |

## ResourceMapper

| 接口函数名                             | 解释                                       |
| -------------------------------------- | ------------------------------------------ |
| int createResource(Resource resource); | 创建资源                                   |
| int deleteResource(int resourceId);    | 删除资源（注意数据库设计中的级联删除问题） |
| Resource readResource(int resourceId); | 查询资源（单条）                           |
| List\<Resource> readResourceList();    | 查询资源列表（返回信息可以较少——需讨论）   |

## LogMapper

| 接口函数名              | 解释                         |
| ----------------------- | ---------------------------- |
| int createLog(Log log); | 创建日志                     |
| List\<Log> readLog();   | 查询日志（具体查询参数待定） |

## DownloadRecordMapper

| 接口函数名                                               | 解释                             |
| -------------------------------------------------------- | -------------------------------- |
| int createDownloadRecord(DownloadRecord downloadRecord); | 创建下载记录                     |
| List\<DownloadRecord> readDownloadRecord();              | 查询下载记录（具体查询参数待定） |