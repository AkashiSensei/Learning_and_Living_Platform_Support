| 类型 | 属性名 | 说明 |
| ---- | ------ | ---- |
|      |        |      |

# Request

## User

### VerifyUserLoginRequest 

| 类型   | 属性名   | 说明       |
| ------ | -------- | ---------- |
| int    | id       | 用户的id   |
| String | email    | 用户的邮箱 |
| String | password | 用户的密码 |

### VerifyAdminLoginRequest 

| 类型   | 属性名   | 说明           |
| ------ | -------- | -------------- |
| String | account  | 用户的id或邮箱 |
| String | password | 用户的密码     |

### VerifyUserRegisterRequest

| 类型   | 属性名   | 说明       |
| ------ | -------- | ---------- |
| String | email    | 用户的邮箱 |
| String | password | 用户的密码 |

### GetAccountInfoListRequest

| 类型 | 属性名    | 说明             |
| ---- | --------- | ---------------- |
| int  | cntInPage | 页面容纳信息条数 |
| int  | pageNum   | 当前页           |

### UpdateAccountInfoRequest

| 类型          | 属性名       | 说明 |
| ------------- | ------------ | ---- |
| int           | id           | id   |
| String        | name         | 昵称 |
| String        | email        | 邮箱 |
| String        | gender       | 性别 |
| Date          | birthday     | 生日 |
| MultipartFile | profilePhoto | 头像 |

### GetPasswordRequest 

| 类型   | 属性名 | 说明 |
| ------ | ------ | ---- |
| String | email  | 邮箱 |

### UpdatePasswordRequest 

| 类型   | 属性名      | 说明   |
| ------ | ----------- | ------ |
| String | oldPassword | 旧密码 |
| String | newPassword | 新密码 |

### DeleteAccountRequest 

| 类型 | 属性名 | 说明     |
| ---- | ------ | -------- |
| int  | id     | 用户的id |

## Post

### ListPostRequest

| 类型 | 属性名    | 说明           |
| ---- | --------- | -------------- |
| int  | cntInPage | 每页几个帖子   |
| int  | pageNum   | 请求的是第几页 |

### AddPostRequest 

| 类型                 | 属性名    | 说明     |
| -------------------- | --------- | -------- |
| String               | title     | 帖子标题 |
| String               | content   | 帖子正文 |
| Date                 | postTime  | 发帖时间 |
| int                  | authority | 帖子权限 |
| List\<MultipartFile> | images    | 帖子图片 |

### DeletePostRequest

| 类型 | 属性名 | 说明   |
| ---- | ------ | ------ |
| int  | id     | 帖子id |

### ListReplyRequest

| 类型 | 属性名 | 说明   |
| ---- | ------ | ------ |
| int  | id     | 评论id |

### CommentPostRequest 

| 类型                 | 属性名      | 说明     |
| -------------------- | ----------- | -------- |
| int                  | postId      | 帖子id   |
| int                  | userId      | 评论者id |
| Date                 | publishTime | 评论时间 |
| String               | content     | 正文     |
| List\<MultipartFile> | images      | 图片     |

### ReplyCommentRequest

| 类型   | 属性名      | 说明     |
| ------ | ----------- | -------- |
| int    | postId      | 帖子id   |
| int    | commentId   | 评论id   |
| Date   | publishTime | 回复时间 |
| String | content     | 正文     |

### DeletCommentRequest 

| 类型 | 属性名 | 说明   |
| ---- | ------ | ------ |
| int  | id     | 评论id |

### DeleteReplyRequest 

| 类型 | 属性名  | 说明   |
| ---- | ------- | ------ |
| int  | replyId | 回复id |

## Resource

### ListResourceByCategoryRequest 

| 类型   | 属性名    | 说明             |
| ------ | --------- | ---------------- |
| String | category  | 分类             |
| int    | cntInPage | 页面容纳信息条数 |
| int    | pageNum   | 当前页           |

### ListRecommendResoueceRequest 

| 类型 | 属性名    | 说明             |
| ---- | --------- | ---------------- |
| int  | cntInPage | 页面容纳信息条数 |
| int  | pageNum   | 当前页           |

### UploadResourceRequest

| 类型          | 属性名      | 说明     |
| ------------- | ----------- | -------- |
| String        | title       | 资源标题 |
| String        | subject     | 资源学科 |
| String        | category    | 资源类型 |
| Date          | publishTime | 发布时间 |
| String        | content     | 资源简介 |
| MultipartFile | image       | 封面图片 |
| MultipartFile | file        | 资源文件 |

### DownloadResourceRequest

| 类型 | 属性名 | 说明   |
| ---- | ------ | ------ |
| int  | id     | 资源id |

### DeleteResourceRequest 

| 类型 | 属性名 | 说明   |
| ---- | ------ | ------ |
| int  | id     | 资源id |

### GetDownloadHistoryRequest 

| 类型 | 属性名    | 说明             |
| ---- | --------- | ---------------- |
| int  | cntInPage | 页面容纳信息条数 |
| int  | pageNum   | 当前页           |

### DeleteDownloadHistoryRequest 

| 类型 | 属性名 | 说明   |
| ---- | ------ | ------ |
| int  | id     | 资源id |

## Statistics

### TimeRange

| 类型 | 属性名    | 说明     |
| ---- | --------- | -------- |
| Date | beginDate | 起始时间 |
| Date | endDate   | 结束时间 |

# Others

### OverallFigure

| 类型 | 属性名        | 说明     |
| ---- | ------------- | -------- |
| Int  | numOfUser     | 用户总数 |
| Int  | numOfPost     | 帖子总数 |
| Int  | numOfResource | 资源总数 |

### UserSummary

(还需要讨论一下)

| 类型   | 属性名 | 说明 |
| ------ | ------ | ---- |
| int    | id     | id   |
| String | name   | 昵称 |

### UserDisplay

| 类型   | 属性名          | 说明        |
| ------ | --------------- | ----------- |
| int    | id              | id          |
| String | name            | 昵称        |
| String | profilePhotoUrl | 头像        |
| String | token           | 生成的token |

### UserDetail

| 类型   | 属性名          | 说明     |
| ------ | --------------- | -------- |
| int    | id              | id       |
| String | name            | 昵称     |
| String | email           | 邮箱     |
| String | gender          | 性别     |
| Date   | birthday        | 生日     |
| Date   | registerTime    | 注册时间 |
| String | profilePhotoUrl | 头像     |
| Int    | loginCnt        | 登陆天数 |

### PostSummary

| 类型    | 属性名         | 说明                         |
| ------- | -------------- | ---------------------------- |
| int     | id             | id                           |
| String  | title          | 标题                         |
| String  | summaryContent | 帖子部分内容                 |
| boolean | canDelete      | 当前用户是否能够删除这个帖子 |

### PostDetail

| 类型               | 属性名      | 说明                         |
| ------------------ | ----------- | ---------------------------- |
| int                | id          | id                           |
| String             | title       | 标题                         |
| String             | fullContent | 内容                         |
| int                | likeCnt     | 点赞数                       |
| int                | browseCnt   | 浏览量                       |
| String             | userName    | 发帖人昵称                   |
| Date               | publishTime | 发帖时间                     |
| List<CommentEntry> | commentList | 评论                         |
| boolean            | canDelete   | 当前用户是否能够删除这个帖子 |

### CommentEntry

| 类型             | 属性名      | 说明                     |
| ---------------- | ----------- | ------------------------ |
| int              | commentId   | id                       |
| String           | userName    | 评论人昵称               |
| String           | content     | 内容                     |
| Date             | publishTime | 评论时间                 |
| boolean          | canDelete   | 当前用户是否能够删除评论 |
| List<ReplyEntry> | replyList   | 回复                     |

### ReplyEntry

| 类型    | 属性名      | 说明                     |
| ------- | ----------- | ------------------------ |
| int     | replyId     | id                       |
| String  | userName    | 回复人昵称               |
| String  | content     | 内容                     |
| Date    | publishTime | 发布时间                 |
| boolean | canDelete   | 当前用户是否能够删除回复 |

### ResourceSummary

(需要讨论)

| 类型    | 属性名    | 说明                         |
| ------- | --------- | ---------------------------- |
| int     | id        | 资源id                       |
| boolean | canDelete | 当前用户是否能够删除这个资源 |

### ResourceDetail

| 类型          | 属性名      | 说明                         |
| ------------- | ----------- | ---------------------------- |
| int           | id          | 资源id                       |
| String        | title       | 资源标题                     |
| String        | subject     | 资源学科                     |
| String        | category    | 资源类型                     |
| Date          | publishTime | 发布时间                     |
| String        | content     | 资源简介                     |
| MultipartFile | image       | 封面图片                     |
| boolean       | canDelete   | 当前用户是否能够删除这个资源 |

### DownloadHistoryEntry

| 类型   | 属性名       | 说明       |
| ------ | ------------ | ---------- |
| int    | id           | 下载记录id |
| int    | resourceId   | 资源id     |
| String | title        | 资源标题   |
| Date   | downloadTime | 下载时间   |

### LikeEntry

| 类型 | 属性名   | 说明     |
| ---- | -------- | -------- |
| int  | id       | 点赞id   |
| int  | postId   | 帖子id   |
| int  | userId   | 用户id   |
| Date | likeTime | 点赞时间 |

### LogEntry

| 类型 | 属性名    | 说明     |
| ---- | --------- | -------- |
| int  | id        | 日志id   |
| int  | userId    | 用户id   |
| Date | loginTime | 登陆时间 |
