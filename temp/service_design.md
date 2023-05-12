# Service设计

| Service名            | 描述       |
| --------------- | ---------- | 
| ResourceService          | 资源部分   | 
| PostService         | 帖子部分 |
| UserService          | 用户信息部分  |
| EXPService | 经验处理部分 |
| AnalyzerService | 数据处理部分 |

## ResourceService

| 函数名            | 描述       | 用到的表 |
| --------------- | ---------- | ------------ |
| listResource | 列出资源列表 | resource |
| commandResource| 推荐资源 | download_record, resource, image(这里存疑？看看推荐模块要不要显示图片) |
|uploadResource| 上传资源| user, image, resource |
|downloadResource | 下载某一资源 | user, resource, download_record |
| showDetailResource |展示某个资源详情页面 | resource, image |
| deleteResource| 删除上传的资源 | user, image, resource |
| showDownloadHistory | 展示个人的下载记录 | download_record, resource |
| updateResource | 管理员更新资源 | resource, image(maybe) |


## PostService
| 函数名            | 描述       | 用到的表 |
| --------------- | ---------- | ------------ |
|listPost | 列出帖子列表| post, like, image |
|showDetailPost |展示某个帖子详情 | post, like, image, comment, reply, user |
|uploadPost |发布帖子 | post, user, image |
|deletePost |删除发布的帖子 | post, user, image, like, comment, reply |
|likePost |点赞帖子 | post, user, like |
|commentPost |评论帖子 | post, comment, user, image |
|recommentPost |评论回复 | reply, user |
|deleteComment| 删除评论| post, user, image, like, comment, reply |

## UserService
| 函数名            | 描述       | 用到的表 |
| --------------- | ---------- | ------------ |
|userLogin | 用户登录| user, log | 
| userRegister|用户注册 | user, log |
|userDeleteConfirm |用户删除账户（确认信息是否正确） | user |
|userDeleteReconfirm | 用户二次确认要删除自己| user, image, download_record(这里没有其它几个表是因为涉及到用户名的都变成“该用户已注销”即可) |
|adminDeleteUser |管理员删除用户 |  user, image, download_record |
|adminLogin |管理员登录 |admin, log|
|logout |退出登录 | |
|viewInformation |查看用户个人信息 | user |
|modifyInformation |修改用户个人信息 | user, image(maybe) |
|findPassword | 找回密码| user |

## ExpService

| 函数名             | 描述                 | 用到的表 |
| ------------------ | -------------------- | ------------ |
| increaseExperience | 增加经验             | user |
| decreaseExperience | 减少经验             | user |
| getLevel           | 根据经验获得对应权限 | user |

## AnalyzerService

| 函数名                             | 描述                                       | 用到的表 |
| ---------------------------------- | ------------------------------------------ | ------------ |
| totalNumberOfEnrollees             | 统计总注册人数                             | user |
| sumNumberOfActivityByTime          | 按时间统计活跃人数                         | log |
| totalNumberOfResourceByArguments   | 按参数（时间、类别、学科）统计总资源数     | resource |
| totalDownloadOfResourceByArguments | 按参数（时间、类别、学科）统计总资源下载数 | download_record |
| totalNumberOfPostByArguments       | 按参数（时间、点赞、浏览量）统计总帖子数   | post |
| getWordCloud                       | 获取词云                                   | download_record |
