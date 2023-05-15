<<<<<<< HEAD
剩下的直接继承 ServiceException 就行了

# Exception Design

### ServiceException

继承Exception类

### UserException

继承ServiceException类

### LogException

继承ServiceException类

### PostException

继承ServiceException类

### LikeException

继承ServiceException类

### CommentException

继承ServiceException类

### ReplyException

继承ServiceException类

### ResourceException

继承ServiceException类

### DownloadHistoryException

继承ServiceException类

### ExperienceException

继承ServiceException类

=======
剩下的直接继承 ServiceException 就行了

# Exception Design

### ServiceException

继承Exception类

| 错误码 | 含义 |
| ------ | ---- |
|        |      |
|        |      |
|        |      |

这里是否需要与HTTP状态响应码保持一致？

### UserException

继承ServiceException类

| 错误码 | 含义             |
| ------ | ---------------- |
| -1     | 注册用户失败     |
| -2     | 删除用户失败     |
| -3     | 修改用户信息失败 |
| -4     | 获取用户信息失败 |
| -5     | 获取用户列表失败 |

### LogException

继承ServiceException类

| 错误码 | 含义         |
| ------ | ------------ |
| -1     | 添加日志失败 |
| -2     | 删除日志失败 |
| -3     | 获取日志失败 |

### PostException

继承ServiceException类

| 错误码 | 含义             |
| ------ | ---------------- |
| -1     | 发布帖子失败     |
| -2     | 删除帖子失败     |
| -3     | 获取帖子详情失败 |
| -4     | 获取帖子列表失败 |

### LikeException

继承ServiceException类

| 错误码 | 含义         |
| ------ | ------------ |
| -1     | 添加点赞失败 |
| -2     | 取消点赞失败 |
| -3     | 查询点赞失败 |

### CommentException

继承ServiceException类

| 错误码 | 含义         |
| ------ | ------------ |
| -1     | 添加评论失败 |
| -2     | 删除评论失败 |
| -3     | 查询评论失败 |

### ReplyException

继承ServiceException类

| 错误码 | 含义         |
| ------ | ------------ |
| -1     | 添加回复失败 |
| -2     | 删除回复失败 |
| -3     | 查询回复失败 |

### ResourceException

继承ServiceException类

| 错误码 | 含义             |
| ------ | ---------------- |
| -1     | 添加资源失败     |
| -2     | 删除资源失败     |
| -3     | 获取资源详情失败 |
| -4     | 获取资源列表失败 |

### DownloadHistoryException

继承ServiceException类

| 错误码 | 含义             |
| ------ | ---------------- |
| -1     | 添加下载历史失败 |
| -2     | 删除下载历史失败 |
| -3     | 获取下载历史失败 |

### ExperienceException

继承ServiceException类

| 错误码 | 含义             |
| ------ | ---------------- |
| -1     | 更改经验失败     |
| -2     | 查询用户经验失败 |
|        |                  |
