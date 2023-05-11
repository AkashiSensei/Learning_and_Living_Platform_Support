

# 数据库设计：

| 表名            | 描述       | 主键 | 索引        |
| --------------- | ---------- | ---- | ----------- |
| user            | 用户信息   | id   |             |
| admin           | 管理员信息 | id   |             |
| post            | 帖子       | id   | user_id     |
| like            | 点赞       | id   | post_id     |
| comment         | 评论       | id   | post_id     |
| reply           | 评论的回复 | id   | comment_id  |
| image           | 图片       | id   | post_id     |
| resource        | 教育资源   | id   | user.id     |
| log             | 登录日志   | id   | user_id     |
| download_record | 下载记录   | id   | resource_id |

## user表

| 字段名   | 类型        | 约束       | 备注         |
| -------- | ----------- | ---------- | ------------ |
| id       | int         | 主键，自增 |              |
| name     | varchar(20) |            | 最长20字符   |
| password | varchar(20) |            | 密码最长20位 |
| Email    | varchar(40) |            | 邮箱         |
| gender   | enum        |            | 性别         |
| birthday | date        |            | 生日         |
| 其他信息 |             |            |              |
| salt     | varchar(20) |            | 加密盐值     |
| score    | int         |            | 积分         |
|          |             |            |              |

## admin表

| 字段名   | 类型        | 约束       | 备注         |
| -------- | ----------- | ---------- | ------------ |
| id       | int         | 主键，自增 |              |
| name     | varchar(20) |            | 最长20字符   |
| password | varchar(20) |            | 密码最长20位 |
| Email    | varchar(40) |            | 邮箱         |
| gender   | enum        |            | 性别         |
| birthday | date        |            | 生日         |
| 其他信息 |             |            |              |
| salt     | varchar(20) |            | 加密盐值     |

## post表

| 字段名            | 类型        | 约束        | 备注               |
| ----------------- | ----------- | ----------- | ------------------ |
| id                | int         | 主键，自增  |                    |
| title             | varchar(30) |             | 帖子标题，最多30字 |
| user_id           | int         | 外键user.id | 发布者id           |
| content           | text        |             | 帖子内容           |
| floor_count       | int         |             | 楼层数             |
| post_time         | datetime    |             | 发布时间           |
| image_id,image_id,... | int     | 外键image.id | 拥有的图片们         |
| like_count  | int         |             | 点赞数             |
| authority | int | | 帖子权限 |

## like

| 字段名  | 类型 | 约束        | 备注     |
| ------- | ---- | ----------- | -------- |
| id      | int  | 主键，自增  |          |
| post_id | int  | 外键post.id | 所属帖子 |
| user_id | int  | 外键user.id | 所属用户 |

## comment

| 字段名       | 类型         | 约束           | 备注                   |
| ------------ | ------------ | -------------- | ---------------------- |
| id           | int          | 主键，自增     |                        |
| post_id      | int          | 外键，post.id  | 所属帖子id             |
| user_id      | int          | 外键user.id    | 发布者id               |
| comment_time | datetime     |                | 评论时间               |
| content      | varchar(255) |                | 评论内容,最多255字     |
| image_id     | int          | 外键，image.id | 评论图片，限定至多一张 |
| floor        | int          |                | 第几楼                 |

## reply

| 字段名     | 类型         | 约束             | 备注                |
| ---------- | ------------ | ---------------- | ------------------- |
| id         | int          | 主键，自增       |                     |
| post_id    | int          | 外键，post.id    | 所属帖子id          |
| comment_id | int          | 外键，comment.id | 所属评论id          |
| user_id    | int          | 外键user.id      | 回复者id            |
| reply_time | datetime     |                  | 回复时间，精确到秒  |
| content    | varchar(255) |                  | 回复内容，最多255字 |

## image

| 字段名         | 类型 | 约束        | 备注               |
| -------------- | ---- | ----------- | ------------------ |
| id             | int  | 主键，自增  |                    |
| thumbnail_path | char |             | 略缩图路径         |
| origin_path    | char |             | 原图路径           |

## resource

| 字段名         | 类型     | 约束         | 备注               |
| -------------- | -------- | ------------ | ------------------ |
| id             | int      | 主键，自增   |                    |
| user_id        | int      | 外键user.id  | 发布者id           |
| category       | enum     |              | 资源类型           |
| published_time | datetime |              | 发布时间，精确到秒 |
| size           | int      |              | 大小               |
| content        | text     |              | 资源简介           |
| path           | char     |              | 资源路径           |
| image_id       | int      | 外键image.id | 资源封面           |
| download_count | int      |              | 下载量             |
| authority      | int      |              | 权限               |

## login_log

| 字段名      | 类型     | 约束        | 备注               |
| ----------- | -------- | ----------- | ------------------ |
| id          | int      | 主键，自增  |                    |
| user_id     | int      | 外键user.id | 登陆者id           |
| type        | enum     |             | 登陆或登出         |
| login_time  | datetime |             | 登陆时间，精确到秒 |
| logout_time | datetime |             | 登出时间，精确到秒 |

## download_record

| 字段名        | 类型     | 约束            | 备注               |
| ------------- | -------- | --------------- | ------------------ |
| id            | int      | 主键，自增      |                    |
| user_id       | int      | 外键user.id     | 下载者id           |
| resource_id   | int      | 外键resource.id | 资源id             |
| download_time | datetime |                 | 下载时间，精确到秒 |

