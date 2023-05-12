# Service设计

| Service名            | 描述       |
| --------------- | ---------- |
| ResourceService          | 资源部分   |
| PostService         | 帖子部分 |
| UserService          | 用户信息部分  |
| EXPService | 经验处理部分 |
| AnalyzerService | 数据处理部分 |

## ResourceService

| 函数名            | 描述       |
| --------------- | ---------- |
| listResource | 列出资源列表 |
| commandResource| 推荐资源 |
|uploadResource| 上传资源|
|downloadResource | 下载某一资源 |
| showDetailResource |展示某个资源详情页面 |
| deleteResource| 删除上传的资源 |
| showDownloadHistory | 展示个人的下载记录 |
| updateResource | 管理员更新资源 |


## PostService
| 函数名            | 描述       |
| --------------- | ---------- |
|listPost | 列出帖子列表|
|showDetailPost |展示某个帖子详情 |
|uploadPost |发布帖子 |
|deletePost |删除发布的帖子 |
|likePost |点赞帖子 |
|commentPost |评论帖子 |
|recommentPost |评论回复 |
|deleteComment| 删除评论|

## UserService
| 函数名            | 描述       |
| --------------- | ---------- |
|userLogin | 用户登录|
| userRegister|用户注册 |
|userDeleteConfirm |用户删除账户（确认信息是否正确） |
|userDeleteReconfirm | 用户二次确认要删除自己|
|adminDeleteUser |管理员删除用户 |
|adminLogin |管理员登录 |
|logout |退出登录 |
|viewInformation |查看用户个人信息 |
|modifyInformation |修改用户个人信息 |
|findPassword | 找回密码|

## ExpService

| 函数名             | 描述                 |
| ------------------ | -------------------- |
| increaseExperience | 增加经验             |
| decreaseExperience | 减少经验             |
| getLevel           | 根据经验获得对应权限 |

## AnalyzerService

| 函数名                             | 描述                                       |
| ---------------------------------- | ------------------------------------------ |
| totalNumberOfEnrollees             | 统计总注册人数                             |
| sumNumberOfActivityByTime          | 按时间统计活跃人数                         |
| totalNumberOfResourceByArguments   | 按参数（时间、类别、学科）统计总资源数     |
| totalDownloadOfResourceByArguments | 按参数（时间、类别、学科）统计总资源下载数 |
| totalNumberOfPostByArguments       | 按参数（时间、点赞、浏览量）统计总帖子数   |
| getWordCloud                       | 获取词云                                   |
