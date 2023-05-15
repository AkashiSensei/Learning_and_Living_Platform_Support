| 类型 | 变量名 | 说明 |
| ---- | ------ | ---- |
|      |        |      |

# Request

## User

### VerifyUserLoginRequest 

| 类型   | 变量名   | 说明           |
| ------ | -------- | -------------- |
| string | account  | 用户的id或邮箱 |
| string | password | 用户的密码     |

### VerifyAdminLoginRequest 

| 类型   | 变量名   | 说明           |
| ------ | -------- | -------------- |
| string | account  | 用户的id或邮箱 |
| string | password | 用户的密码     |

### VerifyUserRegisterRequest

| 类型   | 变量名   | 说明       |
| ------ | -------- | ---------- |
| string | account  | 用户的邮箱 |
| string | password | 用户的密码 |

### GetAccountInfoListRequest

| 类型 | 变量名    | 说明             |
| ---- | --------- | ---------------- |
| int  | cntInPage | 页面容纳信息条数 |
| int  | pageNum   | 当前页           |

### UpdateAccountInfoRequest

| 类型   | 变量名          | 说明 |
| ------ | --------------- | ---- |
| string | id              | id   |
| string | name            | 昵称 |
| string | email           | 邮箱 |
| string | gender          | 性别 |
| Date   | birthday        | 生日 |
| string | profilePhotoUrl | 头像 |

### GetPasswordRequest 

| 类型   | 变量名 | 说明 |
| ------ | ------ | ---- |
| string | email  | 邮箱 |

### UpdatePasswordRequest 

| 类型   | 变量名      | 说明   |
| ------ | ----------- | ------ |
| string | oldPassword | 旧密码 |
| string | newPassword | 新密码 |

### DeleteAccountRequest 

| 类型   | 变量名 | 说明     |
| ------ | ------ | -------- |
| string | id     | 用户的id |

## Post

### ListPostRequest

| 类型 | 变量名    | 说明           |
| ---- | --------- | -------------- |
| int  | cntInPage | 每页几个帖子   |
| int  | pageNum   | 请求的是第几页 |

### AddPostRequest 

| 类型                | 变量名    | 说明     |
| ------------------- | --------- | -------- |
| string              | title     | 帖子标题 |
| string              | content   | 帖子正文 |
| Date                | postTime  | 发帖时间 |
| int                 | authority | 帖子权限 |
| List<MultipartFile> | images    | 帖子图片 |

### DeletePostRequest

| 类型   | 变量名 | 说明   |
| ------ | ------ | ------ |
| string | id     | 帖子id |

### LikePostRequest

| 类型   | 变量名 | 说明   |
| ------ | ------ | ------ |
| string | id     | 帖子id |

### CommentPostRequest 

| 类型                | 变量名      | 说明     |
| ------------------- | ----------- | -------- |
| String              | postId      | 帖子id   |
| Date                | publishTime | 评论时间 |
| String              | content     | 正文     |
| List<MultipartFile> | images      | 图片     |

### ReplyCommentRequest

| 类型   | 变量名      | 说明     |
| ------ | ----------- | -------- |
| String | postId      | 帖子id   |
| String | commentId   | 评论id   |
| Date   | publishTime | 回复时间 |
| String | content     | 正文     |

### DeletCommentRequest 

| 类型   | 变量名    | 说明   |
| ------ | --------- | ------ |
| String | commentId | 评论id |

### DeleteReplyRequest 

| 类型   | 变量名  | 说明   |
| ------ | ------- | ------ |
| String | replyId | 回复id |

## Resource

### ListResourceByCategoryRequest 

| 类型   | 变量名    | 说明             |
| ------ | --------- | ---------------- |
| String | Category  | 分类             |
| int    | cntInPage | 页面容纳信息条数 |
| int    | pageNum   | 当前页           |

### ListRecommendResoueceRequest 

| 类型 | 变量名    | 说明             |
| ---- | --------- | ---------------- |
| int  | cntInPage | 页面容纳信息条数 |
| int  | pageNum   | 当前页           |

### UploadResourceRequest

| 类型          | 变量名        | 说明     |
| ------------- | ------------- | -------- |
| String        | subject       | 资源学科 |
| String        | category      | 资源类型 |
| Date          | publishedTime | 发布时间 |
| String        | content       | 资源简介 |
| MultipartFile | image         | 封面图片 |
| MultipartFile | File          | 资源文件 |

### DownloadResourceRequest

| 类型   | 变量名 | 说明   |
| ------ | ------ | ------ |
| String | id     | 资源id |

### DeleteResourceRequest 

| 类型   | 变量名 | 说明   |
| ------ | ------ | ------ |
| String | id     | 资源id |

### GetDownloadHistoryRequest 

| 类型 | 变量名    | 说明             |
| ---- | --------- | ---------------- |
| int  | cntInPage | 页面容纳信息条数 |
| int  | pageNum   | 当前页           |

### DeleteDownloadHistoryRequest 

| 类型   | 变量名 | 说明   |
| ------ | ------ | ------ |
| String | id     | 资源id |

# Others

### UserSummary

### UserDetail

### PostSummary

| 类型    | 变量名         | 说明                         |
| ------- | -------------- | ---------------------------- |
| int     | postId         |                              |
| String  | title          |                              |
| String  | summaryContent |                              |
| boolean | canDelete      | 当前用户是否能够删除这个帖子 |

### PostDetail

| 类型               | 变量名      | 说明 |
| ------------------ | ----------- | ---- |
| int                | postId      |      |
| String             | title       |      |
| String             | fullContent |      |
| int                | likeCnt     |      |
| int                | browseCnt   |      |
| String             | userName    |      |
| String             | uploadTime  |      |
| List<CommentEntry> | comments    |      |
| boolean            | canDelete   |      |

### CommentEntry

| 类型             | 变量名     | 说明 |
| ---------------- | ---------- | ---- |
| int              | commentId  |      |
| String           | userName   |      |
| String           | content    |      |
| String           | uploadTime |      |
| boolean          | canDelete  |      |
| List<ReplyEntry> | replies    |      |

### ReplyEntry

| 类型    | 变量名    | 说明 |
| ------- | --------- | ---- |
| int     | commentId |      |
| String  | userName  |      |
| String  | content   |      |
| boolean | canDelete |      |

### ResourceSummary

| 类型 | 变量名 | 说明 |
| ---- | ------ | ---- |
|      |        |      |

### ResourceDetail

| 类型 | 变量名 | 说明 |
| ---- | ------ | ---- |
|      |        |      |

### DownloadRecord

| 类型 | 变量名 | 说明 |
| ---- | ------ | ---- |
|      |        |      |

