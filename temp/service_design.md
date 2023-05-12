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
| listResource | 列出资源列表 | Resource |
| commandResource| 推荐资源 | Download_record, Resource, Image(这里存疑？看看推荐模块要不要显示图片) |
|uploadResource| 上传资源| User, Image, Resource |
|downloadResource | 下载某一资源 | User, Resource, Download_record |
| showDetailResource |展示某个资源详情页面 | Resource, Image |
| deleteResource| 删除上传的资源 | User, Image, Resource |
| showDownloadHistory | 展示个人的下载记录 | Download_record, Resource |
| updateResource | 管理员更新资源 | Resource, Image(maybe) |


## PostService
| 函数名            | 描述       | 用到的表 |
| --------------- | ---------- | ------------ |
|listPost | 列出帖子列表| Post, Like, Image |
|showDetailPost |展示某个帖子详情 | Post, Like, Image, Comment, Reply, User |
|uploadPost |发布帖子 | Post, User, Image |
|deletePost |删除发布的帖子 | Post, User, Image, Like, Comment, Reply |
|likePost |点赞帖子 | Post, User, Like |
|commentPost |评论帖子 | Post, Comment, User, Image |
|recommentPost |评论回复 | Reply, User |
|deleteComment| 删除评论| Post, User, Image(maybe), Comment, Reply |

## UserService
| 函数名            | 描述       | 用到的表 |
| --------------- | ---------- | ------------ |
|userLogin | 用户登录| User, Log | 
| userRegister|用户注册 | User, Log |
|userDeleteConfirm |用户删除账户（确认信息是否正确） | User |
|userDeleteReconfirm | 用户二次确认要删除自己| User, Image, Download_record(这里没有其它几个表是因为涉及到用户名的都变成“该用户已注销”即可) |
|adminDeleteUser |管理员删除用户 |  User, Image, Download_record |
|adminLogin |管理员登录 |Admin, Log|
|logout |退出登录 | |
|viewInformation |查看用户个人信息 | User |
|modifyInformation |修改用户个人信息 | User, Image(maybe) |
|findPassword | 找回密码| User |

## ExpService

| 函数名             | 描述                 | 用到的表 |
| ------------------ | -------------------- | ------------ |
| increaseExperience | 增加经验             | User |
| decreaseExperience | 减少经验             | User |
| getLevel           | 根据经验获得对应权限 | User |

## AnalyzerService

| 函数名                             | 描述                                       | 用到的表 |
| ---------------------------------- | ------------------------------------------ | ------------ |
| totalNumberOfEnrollees             | 统计总注册人数                             | User |
| sumNumberOfActivityByTime          | 按时间统计活跃人数                         | Log |
| totalNumberOfResourceByArguments   | 按参数（时间、类别、学科）统计总资源数     | Resource |
| totalDownloadOfResourceByArguments | 按参数（时间、类别、学科）统计总资源下载数 | Download_record |
| totalNumberOfPostByArguments       | 按参数（时间、点赞、浏览量）统计总帖子数   | Post |
| getWordCloud                       | 获取词云                                   | Download_record |
