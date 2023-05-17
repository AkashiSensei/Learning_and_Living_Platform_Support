# 软件设计说明书

## 1、引言

### 1.1 编写目的

​		软件设计包括**软件概要设计**即**软件架构设计**和**软件详细设计**包括**用户界面设计、用例设计、子系统/构件设计、类设计和数据设计**。

- 软件概要设计从全局和宏观视角、站在最高抽象层次来设计软件系统，展示了各个模块及其关系。
- 详细设计面向**程序员**，对体系结构设计成果进行细化和精化，获得高质量的、充分细化的软件设计模型。其目的为方便编程实现，用以指导程序人员编写代码，形成模块或部件的**实现蓝图**。

​		它们分别从不同的层次（从宏观到微观、从全局到局部）、 不同的视角（从结构到行为、从模块到数据）对软件系统进行了设计，针对面向对象需求分析所得到的软件需求模型（如用例图交互图、分析类图），对其进行不断精化（而非转换）获得软件系统的各类软件设计元素，如子系统、构件、设计类等，产生不同视角、不同抽象层次的软件设计模型，如软件体系结构图、用例设计交互图、设计类图、活动图等，形成软件系统完整和详尽的设计方案。

​		本文档以软件设计规格说明书的形式描述了该设计方案，方便评审人员对设计方案的正确性、合理性等方面进行评审。

### 1.2 读者对象

​		用户、软件设计人员、程序员、软件需求分析人员、质量保证人员、软件测试工程师、配置管理工程师。

### 1.3 软件项目概述

​		− 项目名称：学习生活平台（Learning and Living Platform）

​		− 用户单位：进行学习交流的学生和老师及相关管理人员

​		− 开发单位： 北京航空航天大学软件学院 21 级杨溢龙班刘益洲小组

​		− 软件项目的背景和大致功能：

​			该软件主要用于大学校园，帮助解决同学们：学业上的难题求教无门，优秀的资源无人共享，志同道合的朋友难以相遇，校园的资讯无法及时得知等问题；提供一个大学生线上分享课程材料、教科书、视频课程和习题集等资源，交流并分享学习经验的平台。

### 1.4 文档概述

​		1）软件的设计约束部分。它包括软件设计目标和原则、软件设计受到的约束和限制。

​		2）软件的设计部分。它主要分为软件体系结构设计、用户界面设计、用例 设计、类设计、数据设计以及部署设计。

### 1.5 定义

​		（无）

### 1.6 参考资料

​		[1]. 软件工程基础（题库+微课视频版）. 吕云翔. 北京:清华大学出版社，2022

## 2、软件设计约束

### 2.1 软件设计目标和原则

​		软件设计的目的是针对**软件需求**（定义了要做什么样的软件），综合考虑各种**制约因素**（资源、技术、进度等），探究软件实现的**解决方案**。软件设计要满足正确性、充分性、优化性和简单性的质量要求，尽量做到正确可靠、可维护、可重用、可追踪、可移植、可互操作。

​		软件设计遵循的相关策略和原则如下：

1. 抽象与逐步求精：从高层抽象到低层抽象逐步过渡，从高层设计“逐步求精”到底层设计。
2. 模块化：高内聚度、低耦合度，每个模块实现单一的功能。
3. 信息隐藏：模块只提供对外接口，不提供内部实现细节
4. 多视点和关注点分离：将若干性质不同的关注点分离开来，以便在适当的时间处理不同的关注点，随后将这些关注点整合起来，形成局部或者全局性的设计结果。
5. 软件重用：尽可能地重用已有的软件资产来实现软件系统的功能。
6. 迭代设计：将设计过程分解为多个迭代周期，逐步迭代和优化软件系统。
7. 可追踪性：将需求和设计文档、测试用例、代码等相关文档和工件之间的关联关系建立和维护起来，以便在软件开发过程中追踪和验证软件系统是否满足了所有的需求。

### 2.2 软件设计的约束和限制

​		− 运行环境要求：Web 浏览器 Google Chrome、Mozilla Firefox、Microsoft Edge

​		− 开发语言：Java、HTML、CSS、JavaScript

​		− 标准规范：Java 编码风格（规范）、Web 标准、Vue.js 规范

​		− 开发工具：IntelliJ IDEA、Visual Studio Code

## 3、软件设计

### 3.1 软件体系结构设计

#### 3.1.1 总体设计

​	该软件按照架构层次划分可以分为前端实现的“用户界面层”，后端实现的“控制器层”，“服务层”和“模型映射层”。用户界面层负责与用户交互，根据用户的需求向后端发起请求获取数据，并将结果展示给用户。控制器层主要负责接受前端发起的请求，并调用服务层提供的接口实现对应的业务逻辑。服务层主要的作用是调用模型映射层提供的对数据库进行增删改查的封装方法组合成一个完整的业务逻辑，并向控制层提供接口。“模型映射层”实现了对数据库的映射，封装了数据库的增删改查操作，并将获取到的结果封装为特定的实体类进行传递。在此过程中，服务层提供服务的过程中可能出现异常，此时抛出异常包中的特定异常实现异常处理。

![Package Diagram](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/Package%20Diagram.png)

#### 3.1.2 子系统设计

​	按照功能模块划分，我们的系统又可以划分为用户管理子系统，帖子管理子系统，资源管理子系统和统计数据子系统。

​	下面每个子系统分别举一个例子，借助组件顺序图来说明每个子系统的运行顺序和原理。

##### 用户登录

![CSD_Login](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/CSD_Login.jpg)

用户先在前端发起登录请求，此时因为是登录请求，不需要权限验证，拦截器自动放行，请求直接发送至Controller组件，接着Controller组件将请求分发至Service组件，Service组件调用Mapper组件提供的方法对数据库进行查询，并返回结果。如果用户存在，那么返回登陆成功信息；如果用户不存在或者发生异常，那么需要抛出Exception组件对应的异常，最终返回登陆失败信息。

##### 用户发帖

![CSD_addPost](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/CSD_addPost.jpg)

用户先在前端发起发帖请求，此时需要拦截器校验该请求是否来源于合法的用户身份，拦截器会调用Service组件进行校验。若通过，请求发送至Controller组件，接着Controller组件将请求分发至Service组件，Service组件调用Mapper组件提供的方法对数据库进行添加，并返回结果。如果发帖成功，那么返回发帖成功信息；如果发生异常，那么需要抛出Exception组件对应的异常，最终返回发帖失败的信息。

##### 用户上传资源

![CSD_addResourcre](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/CSD_addResourcre.jpg)

用户先在前端发起上传资源请求，此时需要拦截器校验该请求是否来源于合法的用户身份，拦截器会调用Service组件进行校验。若通过，请求发送至Controller组件，接着Controller组件将请求分发至Service组件，Service组件调用Mapper组件提供的方法对数据库进行添加，并返回结果。如果上传资源成功，那么返回上传资源成功信息；如果发生异常，那么需要抛出Exception组件对应的异常，最终返回上传资源失败的信息。

##### 获取系统总体信息

![CSD_getOverallInfo](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/CSD_getOverallInfo.jpg)

用户先在前端发起查看统计数据请求，此时需要拦截器校验该请求是否来源于合法的管理员身份，拦截器会调用Service组件进行校验。若通过，请求发送至Controller组件，接着Controller组件将请求分发至Service组件，Service组件调用Mapper组件提供的方法对数据库进行查询，并返回结果。如果查询成功，那么返回查看统计数据成功信息；如果发生异常，那么需要抛出Exception组件对应的异常，最终返回查看统计数据失败的信息。

### 3.2 用户界面设计

根据平台的用例描述以及每个用例的设计可以发现该软件系统需要有以下页面以支持用户和管理员的操作：

- 资源列表界面“ResourceMain”，该页面作为平台的首页展现给访客/用户/管理，同时也承担了查看教育资源的任务。
- 登陆界面“Login”，该页面的职责为帮助用户完成登录操作。
- 注册界面“Register”，该页面的职责为帮助用户完成注册操作。

通过这三个页面，用户可以完成平台的登录和注册。

![描述平台登录和注册功能的页面组件顺序图](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/Login.png)

本平台为了实现对于教育资源的查看、修改和管理，还需要以下页面：

- 教育资源详情页“ResourceDetail”，该页面的职责是展示教育资源的详细信息，并允许用户对教育资源进行修改，删除和下载。
- 发布新教育资源页面“AddResource”，用户将欲上传到平台教育资源的详细信息填写在此页面，并进行发布。
- 教育资源下载历史页面“DownloadHistory”，该页面展示当前用户的教育资源下载历史。

通过教育资源主页和以上三个页面，用户可以对平台的教育资源进行访问，发布，下载，修改和管理。

![描述教育资源系统的页面组件顺序图](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/Resource.png)

本平台为了实现帖子的查看、发布、修改和管理，还需要以下页面：

- 讨论区主页“PostMain”，该页面用于显示目前讨论区的所有帖子，用户也可以在该页面进行帖子的发布和删除。
- 发布帖子页面“AddPost”，用户将欲发布帖子的详细信息填写在此页面，并进行发布。
- 帖子详情界面“PostDetail”，用户可以在此界面查看帖子的具体内容，并对帖子进行点赞、评论、删除或删除评论。

![描述帖子系统的页面组件顺序图](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/Post.png)

本平台为了实现用户对自身账号的管理，还需要以下页面：

- 查看个人信息页面“PersonalInfo”，用户可以在该页面查看和编辑自己的账号信息，或者注销自己的账号。

![描述账号信息管理的页面组件顺序图](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/Account.png)

最后，本平台为了实现管理员对平台的管理，还需要以下页面：

- 用户账号管理页面“UserManage”，管理员可以在本页查看、修改和删除所有用户的账号。
- 展示平台统计数据页面“Statistics”，管理员可以在此页面查看平台的所有统计数据。

![描述管理员管理的页面组件顺序图](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/Admin.png)

### 3.3 用例设计

#### （1）“访客注册”用例实现的设计方案

​		“访客注册”功能的实现主要是通过后端服务器进行注册，将用户数据注入数据库，并完成用户信息的返回，从而完成用户注册的整个过程。具体实现过程见下图 所描述的用例实现顺序图。

![USD_Register](.\img\USD_Register.jpg)

​		首先，用户通过浏览器HTTP请求向后端发送POST请求，越过拦截器调用“UserController”对象的“verifyUserRegister(verifyUserRegisterRequest, request)”方法向“UserController”传输含有注册用户信息的“verifyUserRegisterRequest”类实例，“UserController”继续调用“UserService”对象的“addUser(verifyUserRegisterRequest)”方法传递包装的“verifyUserRegisterRequest”类实例，最后“UserService”调用“UserMapper”对象解析相关“request”得到基本属性，它的“readUserByEmail(email)”方法先查询该邮箱是否被注册过，若已经注册则返回“UserDetail”类实例并告知前端该邮箱已经被注册过；若未注册则调用其“createUser(user)”方法在数据库的“User”表中新建条目，最后将注册信息通过“Restbean”返回前端。一旦注册成功，系统自动登录并将界面重定向到主界面。

#### （2）“用户登录”用例实现的设计方案

​		“用户登录”功能的实现主要是通过“spring boot”后端框架提供的服务，查询数据库中是否有用户输入的账号和密码信息，从而来判定该用户的身份是否合法。具体实现过程见下图 所描述的用例实现顺序图。

![USD_Login](.\img\USD_Login.jpg)

​		首先，用户通过浏览器HTTP请求向后端发送，并越过拦截器调用“UserController”对象的“VerifyUserLogin(verifyUserLoginRequest, request)”方法向“UserController”传输含有输入登录的账户和密码的包装实体类实例“verifyUserLoginRequest”，随后该“UserController”向“UserService”类对象发消息“authenticateUser(verifyUserLoginRequest)”，将请求下发到具体的“Service”类中。接收到消息后，“UserService”对象处理具体请求，将请求内容获取得到两个属性“userId/email”和“password”，并向“Mapper”类“UserMapper”对象发消息“identifyUser(userId/email, password)”以验证用户提交的账号和密码是否合法。“UserMapper”对象通过对相关数据库“User”表的映射操纵数据库，来判断用户身份的合法性，并将验证的返回值返回给“UserService”对象，若抛出异常或发现账号不存在或密码错误，则直接返回登录页面并显示相关错误提示；若密码匹配，则“UserService”继续调用“ExperienceService”实例的方法“updateExperience(curUserId, changeNumber)”给用户增加经验，该功能最后靠“ExperienceMapper”实例的“updateExperience(curUserId, changeNumber)”方法更新数据库。若该过程成功完成，则返回成功的“Restbean”；若不成功，返回失败的“Restbean”。一旦登录成功，系统将界面重定向到主界面。

#### （3）“修改个人信息”用例实现的设计方案

​		“修改个人信息”功能的实现主要是通过后端服务器进行数据库的更新，将更新的用户数据覆盖原有数据条目，并完成用户信息的返回，从而完成用户修改个人信息的整个过程。具体实现过程见下图 所描述的用例实现顺序图。

![USD_ChangeOwnInformation](.\img\USD_ChangeOwnInformation.png)

​		首先，用户通过前端输入框和按钮通过浏览器将HTTP请求向后端发送，后端服务器的“AuthenticationInterceptor”拦截器将请求阻拦并验证token信息，若验证不通过，则直接返回，并将错误告知前端浏览器；若验证通过，则将请求放过，调用“UserController”对象的“updateAccountInfo(updateAccountInfoRequest, request)”方法向“UserController”传输含有用户信息的包装实体类实例“updateAccountInfoRequest”，随后“UserController”通过调用“UserService”的“updateUser(updateAccountInfoRequest)”方法向下分发请求给“UserService”对象，将请求解析为具体的实体类“User”实例，最后“UserService”调用“UserMapper”的“updateUser(user)”方法将“User”实例“user”更新至数据库内。最后返回更新是否成功的“Restbean”给前端并显示更新是否成功的数据。

#### （4）“删除个人账户”用例实现的设计方案

​		“删除个人账户”功能的实现主要是通过用户将确认删除个人账户的请求传递给后端，后端完成用户信息的删除并完成是否成功信息的返回，从而完成用户删除个人账户的整个过程。具体实现过程见下图 所描述的用例实现顺序图。

![USD_DeleteOwnAccount](.\img\USD_DeleteOwnAccount.png)

​		首先，拦截器“AuthenticationInterceptor”对象拦截前端发送的相关请求，验证token，若token验证不通过，则直接返回失败信息；若验证通过，则调用“UserController”对象的“deleteAccount(deleteAccountRequest, request)”方法将包含用户账户id和相关信息的实体类对象“deleteAccountRequest”传递给“UserController”，“UserController”进一步调用“UserService”的方法“deleteUser(deleteAccountRequest)”将请求下发到“UserService”，“UserService”解析“deleteAccountRequest”得到“userId”等相关数据，并调用“UserMapper”的方法“deleteUser(userId)”将“userId”对应的用户条目删除。删除成功后，“UserService”继续调用“LogMapper”的“deleteLog(userId)”方法将“userId”对应的日志清空。最后将注销账户的信息通过“Restbean”返回。

#### （5）“找回密码”用例实现的设计方案

​		“找回密码”功能的实现主要是通过用户将找回密码的请求传递给后端，后端检索数据库相关用户的密码数据并将密码返回，从而完成用户找回密码的整个过程。具体实现过程见下图 所描述的用例实现顺序图。

![USD_FindPassword](.\img\USD_FindPassword.png)

​		首先，用户通过浏览器HTTP请求发送到后端，拦截器“AuthenticationInterceptor”对象拦截请求，验证token，若token验证不通过，则直接返回失败信息；若验证通过，则调用“UserController”对象的“getPassword(getPasswordRequest, request)”方法将“getPasswordRequest”类的实例传递给“UserController”处理，“UserController”继续调用“UserService”的方法“getPassword(getPasswordRequest)”将请求分发给“UserService”处理，“UserService”解析“getPasswordRequest”实体类的内容，获取用户的“userId”，并调用“UserMapper”的“readPassword(userId)”方法查询对应“userId”条目的“password”字段，最后将密码打包成“RestBean”返回。

#### （6）“查看帖子详情”用例实现的设计方案

​		“查看帖子详情”功能的实现主要是通过用户点击相关按钮，事件绑定浏览器详情将HTTP请求传输给后端，后端查询帖子详细数据并将帖子内容返回，从而完成用户查看帖子详情的整个过程。具体实现过程见下图 所描述的用例实现顺序图。

![USD_ViewPostDetails](.\img\USD_ViewPostDetails.png)

​		首先，用户提交的请求被拦截器“AuthenticationInterceptor”对象拦截，调用“PostController”对象的“openPost(request)”方法将请求交给“PostController”处理，“PostController”先验证权限，通过调用“ExperienceService”对象的“getExperienceForPost(curUserId, postId)”方法来比对帖子权限和用户等级，“ExperienceService”通过调用“ExperienceMapper”对象的“getExperience(curUserId)”方法获取用户经验等级。若权限不通过，则直接返回，禁止用户访问；如权限通过，“PostController”对象继续调用“PostService”对象的“getPost(postId)”方法将获取帖子详细信息的请求交给“PostService”处理，“PostService”调用“PostMapper”对象的“readPost(postId)”方法查询数据库的相关信息，并把帖子详细信息返回。成功返回后，系统将界面重定向到帖子详细页面。

#### （7）“发布帖子”用例实现的设计方案

​		“发布帖子”功能的实现主要是用户通过浏览器HTTP请求将发布帖子请求传输给后端，后端将帖子详细数据增加到数据库内并将帖子内容返回，从而完成用户发布帖子的整个过程。具体实现过程见下图 所描述的用例实现顺序图。

![USD_AddPost](.\img\USD_AddPost.jpg)

​		首先，用户提交的请求被拦截器“AuthenticationInterceptor”对象拦截，并验证token，若若token验证不通过，则直接返回失败信息；若验证通过，则调用“PostController”对象的“uploadPost(addPostRequest, requeset)”方法将包装后的的帖子信息请求实体类addPostRequest交给“PostController”对象处理，“PostController”调用“PostService”对象的“addPost(addPostRequest)”方法将请求下发给“PostService”对象处理，“PostService”解析请求为“Post”实体类的实例“post”，并调用“PostMapper”对象的“createPost(post)”将“post”实例数据注入数据库。完成添加帖子后，“PostController”继续调用“ExperienceService”对象的“updateExperience(curUserId, changeNumber)”方法给相应用户增加经验，具体由“ExperienceService”调用“ExperienceMapper”对象的“updateExperience(curUserId, changeNumber)”方法将数值更新至数据库中。最后，“PostController”返回包含成功数据的“RestBean”。

#### （8）“查看教育资源详情”用例实现的设计方案

​		“查看教育资源详情”功能的实现主要是用户点击资源列表，通过绑定的浏览器HTTP请求传输给后端，后端将资源详细数据获取并返回显示，从而完成用户查看教育资源详情的整个过程。具体实现过程见下图 所描述的用例实现顺序图。

![USD_ViewResourceDetail](.\img\USD_ViewResourceDetail.jpg)

​		首先，用户提交的请求被拦截器“AuthenticationInterceptor”对象拦截，并验证token，若若token验证不通过，则直接返回失败信息；若验证通过，则调用“ResourceController”对象的“getResourceDetail(request)”方法将任务交给“ResourceController”处理，“ResourceController”通过调用“ResourceService”的“getResourceDetailed(resourceId)”方法将请求下发给“ResourceService”解析处理。“ResourceService”调用“ResourceMapper”的“readResource(resourceId)”方法，令“ResourceMapper”查询数据库获得帖子相关信息，将信息包装为“ResourceEntry”类实例。最后，返回包含相关信息的“RestBean”，系统将界面重定向到资源详细页面。

### 3.4 类设计

#### 功能类

![DCD_Logic](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/DCD_Logic.png)



#### 实体类

![DCD_Entities](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/DCD_Entities.png)

#### 异常类

![DCD_Exception](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/DCD_Exception.png)

### 3.5 数据设计

数据设计如下表：

| 表名            | 描述       | 主键 | 索引       |
| --------------- | ---------- | ---- | ---------- |
| User            | 用户信息   | id   |            |
| Admin           | 管理员信息 | id   |            |
| Post            | 帖子       | id   | userId     |
| Like            | 点赞       | id   | postId     |
| Comment         | 评论       | id   | postId     |
| Reply           | 评论的回复 | id   | commentId  |
| Resource        | 教育资源   | id   | userId     |
| Log             | 登录日志   | id   | userId     |
| DownloadHistory | 下载记录   | id   | resourceId |

#### User表

| 字段名          | 类型         | 约束       | 描述         |
| --------------- | ------------ | ---------- | ------------ |
| id              | int          | 主键，自增 |              |
| name            | varchar(20)  |            | 最长20字符   |
| password        | varchar(255) |            | 加盐加密密码 |
| email           | varchar(40)  |            | 邮箱         |
| gender          | enum         |            | 性别         |
| birthday        | Date         |            | 生日         |
| 其他信息        |              |            |              |
| salt            | varchar(20)  |            | 加密盐值     |
| registerTime    | Date         |            | 注册时间     |
| profilePhotoUrl | varchar(255) |            | 头像         |
| LogInNum        | int          |            | 登陆天数     |

#### Admin表

| 字段名   | 类型         | 约束       | 描述         |
| -------- | ------------ | ---------- | ------------ |
| id       | int          | 主键，自增 |              |
| password | varchar(255) |            | 加盐加密密码 |
| email    | varchar(40)  |            | 邮箱         |
| salt     | varchar(20)  |            | 加密盐值     |

#### Post表

| 字段名                    | 类型          | 约束                           | 描述               |
| ------------------------- | ------------- | ------------------------------ | ------------------ |
| id                        | int           | 主键，自增                     |                    |
| title                     | varchar(30)   |                                | 帖子标题，最多30字 |
| userId                    | int           | 外键User.id ON DELETE SET NULL | 发布者id           |
| content                   | text          |                                | 帖子内容           |
| floorCount                | int           |                                | 楼层数             |
| postTime                  | Datetime      |                                | 发布时间           |
| thumbnail1,thumbnail2,... | varchar(2048) |                                | 拥有的缩略图们     |
| imageUrl,imageUrl,...     | varchar(2048) |                                | 拥有的图片们       |
| likeCount                 | int           |                                | 点赞数             |
| authority                 | int           |                                | 帖子权限           |
| browseCount               | int           |                                | 浏览数             |

#### Like

| 字段名   | 类型     | 约束                  | 描述     |
| -------- | -------- | --------------------- | -------- |
| id       | int      | 主键，自增            |          |
| postId   | int      | 外键Post.id，级联删除 | 所属帖子 |
| userId   | int      | 外键User.id           | 所属用户 |
| likeTime | Datetime |                       | 点赞时间 |

#### Comment

| 字段名      | 类型         | 约束                            | 描述                   |
| ----------- | ------------ | ------------------------------- | ---------------------- |
| id          | int          | 主键，自增                      |                        |
| postId      | int          | 外键，Post.id，级联删除         | 所属帖子id             |
| userId      | int          | 外键User.id，ON DELETE SET NULL | 发布者id               |
| publishTime | Datetime     |                                 | 评论时间               |
| content     | varchar(255) |                                 | 评论内容,最多255字     |
| imageUrl    | varchar(255) |                                 | 评论图片，限定至多一张 |
| floor       | int          |                                 | 第几楼                 |

#### Reply

| 字段名      | 类型         | 约束                           | 描述                |
| ----------- | ------------ | ------------------------------ | ------------------- |
| id          | int          | 主键，自增                     |                     |
| postId      | int          | 外键，Post.id，级联删除        | 所属帖子id          |
| commentId   | int          | 外键，Comment.id，级联删除     | 所属评论id          |
| userId      | int          | 外键User.id ON DELETE SET NULL | 回复者id            |
| publishTime | datetime     |                                | 回复时间，精确到秒  |
| content     | varchar(255) |                                | 回复内容，最多255字 |

#### Resource

| 字段名        | 类型         | 约束                           | 描述               |
| ------------- | ------------ | ------------------------------ | ------------------ |
| id            | int          | 主键，自增                     |                    |
| userId        | int          | 外键User.id ON DELETE SET NULL | 发布者id           |
| title         | varchar(30)  |                                | 资源标题           |
| subject       | enum         |                                | 资源学科           |
| category      | enum         |                                | 资源类型           |
| publishedTime | Datetime     |                                | 发布时间，精确到秒 |
| size          | int          |                                | 大小               |
| content       | text         |                                | 资源简介           |
| path          | char         |                                | 资源路径           |
| imageUrl      | varchar(255) |                                | 资源封面           |
| downloadCount | int          |                                | 下载量             |
| authority     | int          |                                | 权限               |
| downloadUrl   | varchar(255) |                                | 下载链接           |

#### Log

| 字段名    | 类型     | 约束                           | 描述               |
| --------- | -------- | ------------------------------ | ------------------ |
| id        | int      | 主键，自增                     |                    |
| userId    | int      | 外键User.id ON DELETE SET NULL | 登陆者id           |
| loginTime | Datetime |                                | 登陆时间，精确到秒 |

#### DownloadHistory

| 字段名       | 类型     | 约束                           | 描述               |
| ------------ | -------- | ------------------------------ | ------------------ |
| id           | int      | 主键，自增                     |                    |
| userId       | int      | 外键User.id ON DELETE SET NULL | 下载者id           |
| resourceId   | int      | 外键Resource.id                | 资源id             |
| downloadTime | Datetime |                                | 下载时间，精确到秒 |

#### Experience

| 字段名 | 类型 | 约束                            | 描述   |
| ------ | ---- | ------------------------------- | ------ |
| id     | int  | 外键User.id，ON DELETE SET NULL | 用户id |
| exp    | int  |                                 | 经验   |



### 3.6 部署设计

​		学习生活平台（Learning and Living Platform）采用云服务器部署的方式，使用Linux（Ubuntu 22.04 LTS 64 位）+Apache+Mysql建立 web 服务器的软件，以及相关的 Web 服务器配置文件。同时我们使用 HTTPS 协议，以确保网站的访问是安全的。之后通过使用 DNS 服务器将域名映射到服务器的 IP 地址，并配置虚拟主机以便让网站能够被访问。