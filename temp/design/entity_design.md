| 类型 | 变量名 | 说明 |
| ---- | ------ | ---- |
|      |        |      |
|      |        |      |

# Request

## User

### LoginRequest

## Post

### ListPostRequest

| 类型 | 变量名    | 说明           |
| ---- | --------- | -------------- |
| int  | cntInPage | 每页几个帖子   |
| int  | pageNum   | 请求的是第几页 |

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

