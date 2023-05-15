# New Service Design

前言：service主要负责**具体的、面向请求的**事务处理操作，**暂时**先分为**基础service**和**业务（复合）service**，以下为根据requests并结合之前service设计，请先看以下**问题部分**

---

V1：

然而如果只以BaseService和CompoundService作为两个interface又显得其方法过于冗杂，条理不慎明晰...此中矛盾实难处理。姑且认为User、Post、Resource三个**核心的、不涉及其他Mapper的**Service属于BaseService（例如，评论功能就不属于PostService），其余均为CompoundService。

***(然而Post里面还有curUserId...我要放弃治疗了)***

---

V2：

讨论的结果是直接将Service中的方法独立为单独的Interface（Service），虽然会很多但也算一种处理方式了...(其中，三级标题只是进行分类，便于查找)

**抛出异常依然根据其主体设定处理方式？**

![](img\20230514131536.png)

***还有之前说的是Post和Resource是都要检查curuserId的？***

---

如无特殊说明，以下设计的成员变量均私有，由框架完成绑定；以下成员方法均公有。

## 基础service

### Log（我怀疑其存在的必要性）

#### addLog

| 方法签名                                                  | 描述             | 异常处理     |
| --------------------------------------------------------- | ---------------- | ------------ |
| public boolean addLog(int curUserId) throws LogException; | 添加用户登录记录 | LogException |

#### deleteLog

| 方法签名                                                     | 描述             | 异常处理     |
| ------------------------------------------------------------ | ---------------- | ------------ |
| public boolean deleteLog(int curUserId) throws LogException; | 删除用户登录记录 | LogException |



### User

#### verifyUserLoginService

| 方法签名                                                     | 描述     | 异常处理      |
| ------------------------------------------------------------ | -------- | ------------- |
| public boolean userLogin(VerifyUserLoginRequest userLoginReq) throws UserException; | 用户登录 | UserException |

#### verifyAdminLoginService

| 方法签名                                                     | 描述       | 异常处理       |
| ------------------------------------------------------------ | ---------- | -------------- |
| public boolean adminLogin(VerifyAdminLoginRequest adminLoginReq) throws AdminException; | 管理员登录 | AdminException |

#### verifyUserRegisterService

| 方法签名                                                     | 描述     | 异常处理      |
| ------------------------------------------------------------ | -------- | ------------- |
| public boolean userRegister(VerifyUserRegisterRequest userRegisterReq) throws UserException; | 用户注册 | UserException |

#### getAccountInfoService

| 方法签名                                                     | 描述         | 异常处理      |
| ------------------------------------------------------------ | ------------ | ------------- |
| public User getAccountInfo(GetAccountInfoRequest getAccountInfoReq) throws UserException; | 获取账号信息 | UserException |

#### getAccountInfoList  

| 方法签名                                                     | 描述         | 异常处理      |
| ------------------------------------------------------------ | ------------ | ------------- |
| public List<User> getAccountInfoList(GetAccountInfoListRequest getAccountInfoListReq) throws UserException; | 获取账号列表 | UserException |

#### updateAccountInfo

| 方法签名                                                     | 描述         | 异常处理      |
| ------------------------------------------------------------ | ------------ | ------------- |
| public User updateAccountInfo(UpdateAccountInfoRequest updateAccountInfoReq) throws UserException; | 更新账号信息 | UserException |

#### updatePassword

| 方法签名                                                     | 描述     | 异常处理      |
| ------------------------------------------------------------ | -------- | ------------- |
| public boolean updatePassword(UpdatePasswordRequest updatePasswordReq) throws UserException; | 更新密码 | UserException |

#### deleteAccount

| 方法签名                                                     | 描述     | 异常处理      |
| ------------------------------------------------------------ | -------- | ------------- |
| public boolean deleteAccount(DeleteAccountRequest deleteAccountReq) throws UserException; | 删除账号 | UserException |

#### getExp

| 方法签名                                               | 描述         | 异常处理      |
| ------------------------------------------------------ | ------------ | ------------- |
| public int getExp(int curUserId) throws UserException; | 获取用户经验 | UserException |



### Resource

#### listResourceByCategory

| 方法签名                                                     | 描述             | 异常处理          |
| ------------------------------------------------------------ | ---------------- | ----------------- |
| public List<Resource> listResourceByCategory(ListResourceByCategoryRequest listResourceByCategoryReq) throws ResourceException; | 分类获取资源列表 | ResourceException |

#### listRecommendResouece

| 方法签名                                                     | 描述             | 异常处理          |
| ------------------------------------------------------------ | ---------------- | ----------------- |
| public List<Resource> listRecommendResouece(ListRecommendResoueceRequest listRecommendResoueceReq) throws ResourceException; | 获取推荐资源列表 | ResourceException |

#### uploadResource

| 方法签名                                                     | 描述     | 异常处理          |
| ------------------------------------------------------------ | -------- | ----------------- |
| public boolean uploadResource(UploadResourceRequest uploadResourceReq) throws ResourceException; | 上传资源 | ResourceException |

#### downloadResource

| 方法签名                                                     | 描述     | 异常处理          |
| ------------------------------------------------------------ | -------- | ----------------- |
| public boolean downloadResource(DownloadResourceRequest downloadResourceReq) throws ResourceException; | 下载资源 | ResourceException |

#### getResourceDetail

| 方法签名                                                     | 描述           | 异常处理          |
| ------------------------------------------------------------ | -------------- | ----------------- |
| public Resource getResourceDetail(GetResourceDetailRequest getResourceDetailReq) throws ResourceException; | 获取资源详情页 | ResourceException |

#### deleteResource  

| 方法签名                                                     | 描述     | 异常处理          |
| ------------------------------------------------------------ | -------- | ----------------- |
| public boolean deleteResource(DeleteResourceRequest deleteResourceReq) throws ResourceException; | 删除资源 | ResourceException |



### DownloadRecord（同理存疑）

#### getDownloadHistory  

| 方法签名                                                     | 描述         | 异常处理          |
| ------------------------------------------------------------ | ------------ | ----------------- |
| public List<Resource> getDownloadHistory(GetDownloadHistoryRequest GetDownloadHistoryReq) throws ResourceException; | 获取下载历史 | ResourceException |



### Post

#### listPosts

|                           方法签名                           | 描述         | 异常处理      |
| :----------------------------------------------------------: | ------------ | ------------- |
| public List<Post> listPosts(ListPostsRequest listPostsReq) throws PostException; | 获取帖子列表 | PostException |

#### addPost

| 方法签名                                                     | 描述     | 异常处理      |
| ------------------------------------------------------------ | -------- | ------------- |
| public boolean addPost(AddPostRequest addPostReq) throws PostException; | 发布帖子 | PostException |

#### deletePost

| 方法签名                                                     | 描述     | 异常处理      |
| ------------------------------------------------------------ | -------- | ------------- |
| public boolean deletePost(DeletePostRequest deletePostReq) throws PostException; | 删除帖子 | PostException |

#### getPostDetail

| 方法签名                                                     | 描述             | 异常处理      |
| ------------------------------------------------------------ | ---------------- | ------------- |
| public Post getPostDetail(GetPostDetailRequest getPostDetailReq) throws PostException; | 获取帖子详细信息 | PostException |



### Like（存疑）

#### likePost

| 方法签名                                                     | 描述     | 异常处理      |
| ------------------------------------------------------------ | -------- | ------------- |
| public boolean likePost(likePostRequest likePostReq) throws PostException; | 点赞帖子 | PostException |



### Comment

#### commentPost

| 方法签名                                                     | 描述     | 异常处理         |
| ------------------------------------------------------------ | -------- | ---------------- |
| public Comment commentPost(CommentPostRequest commentPostReq) throws CommentException; | 评论帖子 | CommentException |

#### deletComment

| 方法签名                                                     | 描述     | 异常处理         |
| ------------------------------------------------------------ | -------- | ---------------- |
| public boolean deletComment(DeletCommentRequest deletCommentReq) throws CommentException; | 删除评论 | CommentException |



### Reply

#### replyComment

| 方法签名                                                     | 描述     | 异常处理       |
| ------------------------------------------------------------ | -------- | -------------- |
| public Reply replyComment(ReplyCommentRequest replyCommentReq) throws ReplyException; | 回复评论 | ReplyException |

#### deleteReply

| 方法签名                                                     | 描述     | 异常处理       |
| ------------------------------------------------------------ | -------- | -------------- |
| public boolean deleteReply(DeleteReplyRequest deleteReplyReq) throws ReplyException; | 删除评论 | ReplyException |

#### 

## 复合service

注：例如我们再操作前检查权限啥的，或者删贴同时扣经验，总之就是综合完成某事务。（但是也不一定，其实按照这个逻辑likePost和其他一大堆都应该放在这...但是我又觉得可以直接调用有关mapper，多个service有点大可不必，基础service只实现增删改查有点功能和mapper重复了（不过从面向对象——事务、数据库的层面上说也不重复），下层service对接mapper，上层service对接request，或许上面大部分service该放这里？我放弃了）

#### checkService



