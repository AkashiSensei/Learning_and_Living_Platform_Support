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

​		功能类主要分为“拦截器层”、“控制器层”，“服务层”和“模型映射层”。

- 拦截器层主要检查前端传来数据的token是否合法，若合法，则将请求放过；若不合法，则直接返回相应信息。对于大部分用户请求，都要经过拦截器层的处理才能进一步分发给控制器，这样保证了系统的安全性。仅有注册、登录功能可以不验证token而绕过拦截器直接处理。
- 控制器层主要负责根据具体的请求类型，调用不同的service组合，Controller作为协调器，完成多样的需求，并把相应二点结果打包返回给用户界面。
- 服务层主要负责具体解析控制器层分发的请求，选择具体所需的参数并将其传输到具体的Mapper方法中。服务层与模型映射层基本一一对应，根据具体的请求主体划分成不同的接口，并建立对应接口的具体实现类。服务层将处理结果返回给控制器层，若出现异常，则抛出对应异常并完成处理。
- 模型映射层主要负责对数据库存在表的对应映射，每一个Mapper映射一张表，并建立对应的实体类模型实现对于数据库的操作。完成操作后，模型映射层将对应数据和返回码交给服务层，由服务层判断是否出现错误。

##### 拦截器层设计示例

```java
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    // 方案A：放行某些地址
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/login", "/publicPath1", "/publicPath2").permitAll() // Ignore "/login", "/publicPath1", and "/publicPath2"
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    // 方案B，token无效并不立即拒绝请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    }
}
```

依赖 UserService

```java
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor);
    }
}
```

注册拦截器

##### 控制器层设计示例

```java
@RequestMapping(value = "/post/upload", method = RequestMethod.POST)
// request 是拦截器处理过的request，拦截器将 token 处理成当前用户的 id 并保存在 curUserId 字段
public RestBean<> uploadPost(@RequestBody UploadPostRequest uploadPostRequest, HttpServletRequest request) {
    String curUserId = (String) request.getAttribute("curUserId");
    int ret = postService.uploadPost(uploadPostRequest, curUserId);
    
    // 相应的 service 仅仅返回事务逻辑的返回结果，包装成 RestBean 的任务交给 Controller
    if(ret == 0) {
        return RestBean.success(201);
    }else if(ret == -E_PERM) {
        return RestBean.failure(403, "No permission to upload posts");
    }else {
        return RestBean.failure(500);
    }
}
```

###### 具体设计

- UserController 负责处理和用户有关的请求，包括用户和管理员增删改查的需求。
- PostController 负责处理和帖子有关的请求，包括帖子、评论和回复增删改查的需求。
- ResourceController 负责处理和资源有关的请求，包括资源的增删改查、下载等功能的需求。
- StatisticController 负责处理和统计数据有关的请求，包括处理有关日志、资源下载量等数据的需求。

###### UserController

| 方法签名                                                     | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| RestBean\<UserDisplay> verifyUserLogin(@RequestBody VerifyUserLoginRequest verifyUserLoginRequest, HttpServletRequest request) | 检查用户登入信息，调用verifyUserLoginService, addLog, changeExp(成功登入加积分) |
| RestBean\<UserDisplay> verifyAdminLogin(@RequestBody VerifyAdminLoginRequest verifyAdminLoginRequest, HttpServletRequest request) | 检查管理员登入信息，调用verifyAdminLoginService              |
| RestBean\<UserSummary> verifyUserRegister(@RequestBody VerifyUserRegisterRequest verifyUserRegisterRequest, HttpServletRequest request) | 检查用户注册信息，调用verifyUserRegisterService              |
| RestBean\<UserDetail> getAccountInfo(HttpServletRequest request) | 获取账号信息，调用getAccountInfoService, getExp              |
| RestBean\<List\<UserSummary>> getAccountInfoList(@RequestBody GetAccountInfoListRequest getAccountInfoListRequest, HttpServletRequest request) | 获取账号列表，调用getAccountInfoList                         |
| RestBean\<String>  updateAccountInfo(@RequestBody UpdateAccountInfoRequest updateAccountInfoRequest, HttpServletRequest request) | 更新账号信息，调用updateAccountInfo                          |
| RestBean\<String> getPassword(@RequestBody GetPasswordRequest getPasswordRequest, HttpServletRequest request) | 忘记密码，调用getPassword                                    |
| RestBean\<String> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest, HttpServletRequest request) | 更新密码，调用updatePassword                                 |
| RestBean\<String> deleteAccount(@RequestBody DeleteAccountRequest deleteAccountRequest, HttpServletRequest request) | 删除账号，调用deleteAccount, deleteLog                       |

###### PostController

| 方法签名                                                     | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| RestBean\<List\<PostSummary>> listPost(@RequestBody ListPostRequest listPostRequest, HttpServletRequest request) | 获取帖子列表，调用listPosts                                  |
| RestBean\<PostDetail> openPost(HttpServletRequest request)   | 获取帖子详细信息，调用getPostDetail                          |
| RestBean\<List\<PostSummary>> uploadPost(@RequestBody AddPostRequest addPostRequest, HttpServletRequest request) | 发布帖子，调用addPost, changeExp, listPosts(这里表示发布完要重新刷新) |
| RestBean\<List\<PostSummary>> deletePost(@RequestBody DeletePostRequest deletePostRequest, HttpServletRequest request) | 删除帖子，调用deletePost,listPosts, changeExp                |
| RestBean\<PostDetail> likePost(HttpServletRequest request)   | 点赞帖子，调用likePost, changeExp, getPostDetail             |
| RestBean\<PostDetail> undoLikePost(HttpServletRequest request) | 取消点赞帖子                                                 |
| RestBean\<PostDetail> commentPost(@RequestBody CommentPostRequest commentPostRequest, HttpServletRequest request) | 评论帖子，调用commentPost, changeExp, getPostDetail          |
| RestBean\<List\<CommentEntry>> listComment(HttpServletRequest request) | 获取评论列表                                                 |
| RestBean\<List\<ReplyEntry>> listReply(@RequestBody ListReplyRequest listReplyRequest, HttpServletRequest request) | 获取评论的回复列表                                           |
| RestBean\<PostDetail> replyComment(@RequestBody ReplyCommentRequest replyCommentRequest, HttpServletRequest request) | 回复评论，调用replyComment, getPostDetail                    |
| RestBean\<PostDetail> deleteComment(@RequestBody DeletCommentRequest deleteCommentRequest, HttpServletRequest request) | 删除评论，调用deletComment, getPostDetail, changeExp         |
| RestBean\<PostDetail> deleteReply(@RequestBody DeleteReplyRequest deleteReplyRequest, HttpServletRequest request) | 删除评论回复，调用deleteReply, getPostDetail                 |

###### ResourceController

| 方法签名                                                     | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| RestBean\<List\<ResourceSummary>> listResourceByCategory(@RequestBody ListResourceByCategoryRequest listResourceByCategoryRequest, HttpServletRequest request) | 分类获取资源列表，调用listResourceByCategory                 |
| RestBean\<List\<ResourceSummary>> listRecommendResource(@RequestBody ListRecommendResoueceRequest listRecommendResoueceRequest, HttpServletRequest request) | 获取推荐资源列表，调用listRecommendResouece                  |
| RestBean\<String> uploadResource(@RequestBody UploadResourceRequest uploadResourceRequest, HttpServletRequest request) | 上传资源，调用uploadResource, changeExp                      |
| RestBean\<String> downloadResource(@RequestBody DownloadResourceRequest downloadResourceRequest, HttpServletRequest request) | 下载资源，调用downloadResource, changeExp                    |
| RestBean\<ResourceDetail> getResourceDetail(HttpServletRequest request) | 获取资源详情页，调用getResourceDetail                        |
| RestBean\<List\<ResourceSummary>> deleteResource(@RequestBody DeleteResourceRequest deleteResourceRequest, HttpServletRequest request) | 删除资源，调用deleteResource,changeExp,listResourceByCategory |
| RestBean\<List\<DownloadHistoryEntry>> getDownloadHistory(@RequestBody GetDownloadHistoryRequest getDownloadHistoryRequest, HttpServletRequest request) | 获取下载历史,调用getDownloadHistory                          |
| RestBean\<String> deleteDownloadHistory(@RequestBody DeleteDownloadHistoryRequest deleteDownloadHistoryRequest,HttpServletRequest request) | 清空某资源的下载历史,调用deleteDownloadHistory               |

###### StatisticController

| 方法签名                                                     | 描述                             |
| ------------------------------------------------------------ | -------------------------------- |
| RestBean\<int>getNumOfCurrentOnline(HttpServletRequest request) | 获取当前在线人数                 |
| RestBean\<OverallFigure> getOverallInfo(HttpServletRequest request) | 获取总体信息                     |
| RestBean\<List\<PostSummary>> listPostOrderedByView(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据浏览量对帖子排序并获取       |
| RestBean\<List\<PostSummary>> listPostOrderedByPopularity(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据热度对帖子排序并获取         |
| RestBean\<List\<ResourceSummary>> listResourceByDownload(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据下载量对资源排序并获取       |
| RestBean\<List\<UserSummary>> listUserByCntOfResourceUpload(@RequestBody TimeRange timeRange, HttpServletRequest request) | 根据上传资源数量对用户排序并获取 |

##### 服务层设计示例

###### 具体设计

- UserService 负责具体解析和处理与用户有关的请求，包括用户和管理员增删改查的需求。
- LogService 负责处理添加、删除和查询日志的需求。
- PostService 负责具体解析和处理与帖子有关的请求，包括帖子的发布、删除、查询的需求。
- LikeService 负责处理用户点赞功能的需求。
- CommentService 负责具体解析和处理与评论有关的请求，包括评论的发布、删除、查询的需求。
- ReplyService 负责具体解析和处理与回复有关的请求，包括回复的发布、删除、查询的需求。
- RecourseService 负责具体解析和处理与资源有关的请求，包括资源的发布、删除、查询的需求。
- DownloadHistoryService 负责处理用户下载资源功能的需求。
- StatisticService 负责具体解析和处理和统计数据有关的请求，包括查询有关日志、资源下载量等数据的需求。
- ExperienceService 负责处理用户经验等级的增加、减少、查询功能的需求。

​		服务层完成具体的请求，并负责有关信息的级联删除功能。

###### UserService

| 方法签名                                                     | 描述                                      |
| ------------------------------------------------------------ | ----------------------------------------- |
| public UserDisplay authenticateUser(VerifyUserLoginRequest verifyUserLoginRequest) throws UserException; | 验证用户输入的用户名和密码，并生成token   |
| public UserDisplay authenticateAdmin(VerifyAdminLoginRequest verifyAdminLoginRequest) throws UserException; | 验证管理员输入的用户名和密码，并生成token |
| public int getUserIdFromToken(String token) throws UserException; | 从 token 中提取用户ID                     |
| public String generateToken(int userId) throws UserException; | 生成token                                 |
| public boolean validateToken(String token) throws UserException; | 验证token                                 |
| public String addUser(VerifyUserRegisterRequest verifyUserRegisterRequest) throws UserException; | 创建新的用户                              |
| public UserDetail getUser(int userId) throws UserException;  | 获取用户信息                              |
| public string getPassword(GetPasswordRequest getPasswordRequest) throws UserException; | 获取用户的密码                            |
| public boolean updatePassword(UpdatePasswordRequest updatePasswordRequest) throws UserException; | 修改用户密码                              |
| public List<UserSummary> getUserList(GetAccountInfoListRequest getAccountInfoListRequest) throws UserException; | 获取用户列表                              |
| public boolean updateUser(UpdateAccountInfoRequest updateAccountInfoRequest) throws UserException; | 更新用户信息                              |
| public boolean deleteUser(DeleteAccountRequest deleteAccountRequest) throws UserException; | 删除用户                                  |
| public List<UserSummary> getUserSummary() throws UserException; | 获取用户总体统计数据                      |

###### LogService

| 方法签名                                                   | 描述                     |
| ---------------------------------------------------------- | ------------------------ |
| public boolean addLog(int curUserId) throws LogException;  | 添加一条新的登陆记录     |
| public boolean deleteLog(Date date) throws LogException;   | 删除某个日期之前所有记录 |
| public boolean deleteLog(int uesrId) throws LogException;  | 删除某个账号所有记录     |
| public List<LogEntry> getLogSummary() throws LogException; | 获取登录总体统计数据     |

###### PostService

| 方法签名                                                     | 描述                 |
| ------------------------------------------------------------ | -------------------- |
| public List<PostSummary> getPostList(ListPostRequest listPostRequest) throws PostException; | 按页获取帖子列表     |
| public boolean addPost(AddPostRequest addPostRequest) throws PostException; | 添加新帖子           |
| public boolean deletePost(DeletePostRequest deletePostRequest) throws PostException; | 删除帖子             |
| public PostDetail getPost(int postId) throws PostException;  | 获取帖子详细信息     |
| public List<PostSummary> getPostSummary() throws PostException; | 获取帖子总体统计数据 |

###### LikeService

| 方法签名                                                     | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| public boolean  addLike(int userId, int postId) throws LikeException; | 用户点赞时，添加新的点赞关系                                 |
| public boolean  deleteLike(int userId, int postId) throws LikeException; | 用户取消点赞时，删除点赞关系                                 |
| public int getLikeNum(int postId) throws LikeException;      | 获取对应帖子点赞数目                                         |
| public boolean getLiked(int curUserId, int postId) throws LikeException; | 获取相应用户对相应帖子的是否点赞，用于帖子显示，扣除积分，点赞/取消时的检查 |
| public List<LikeEntry> getLikeSummary() throws LikeException; | 获取点赞总体统计数据                                         |

###### CommentService

| 方法签名                                                     | 描述                                   |
| ------------------------------------------------------------ | -------------------------------------- |
| public boolean addComment(CommentPostRequest commentPostRequest) throws CommentException; | 添加新的评论                           |
| public boolean deleteComment(DeleteCommentRequest deleteCommentRequest, int curUserId) throws CommentException; | 删除某条评论，注意检查评论是否属于用户 |
| public List<CommentEntry> getCommentList(int postId) throws CommentException; | 获取对应帖子在相对位置的几条评论       |
| public boolean deleteCommentAll(int postId) throws CommentException; | 删除对应帖子的全部评论，用于评论删除   |
| public List<CommentEntry> getCommentSummary() throws CommentException; | 获取评论总体统计数据                   |

###### ReplyService

| 方法签名                                                     | 描述                                               |
| ------------------------------------------------------------ | -------------------------------------------------- |
| public boolean addReply(ReplyCommentRequest replyCommentRequest) throws ReplyException; | 添加新的回复                                       |
| public boolean deleteReply(DeleteCommentRequest deleteCommentRequest) throws ReplyException; | 删除相应的回复                                     |
| public List<ReplyEntry> getReplyList(int postId, int commentId) throws ReplyException; | 获取对应帖子对应评论的前几条回复                   |
| public List<ReplyEntry> getReplyAll(int postId, int commentId) throws ReplyException; | 获取对应帖子对应评论的全部回复                     |
| public boolean deleteReplyAll(int postId) throws ReplyException; | 删除对应帖子对应评论的全部回复，用于帖子删除       |
| public boolean deleteReplyAll(int postId, int commentId) throws ReplyException; | @重载 删除对应帖子对应评论的全部回复，用于评论删除 |
| public List<ReplyEntry> getReplySummary() throws ReplyException; | 获取回复总体统计数据                               |

###### RecourseService

| 方法签名                                                     | 描述                 |
| ------------------------------------------------------------ | -------------------- |
| public List<ResourceSummary> getResourceRecommended(ListRecommendResourceRequest listRecommendResourceRequest) throws ResourceException; | 获取推荐资源列表     |
| public List<ResourceSummary> getResourceByCategory(ListResourceByCategoryRequest listResourceByCategoryRequest) throws ResourceException; | 按类搜索资源         |
| public boolean addResource(UploadResourceRequest uploadResourceRequest) throws ResourceException; | 添加新资源           |
| public boolean deleteResource(DeleteResourceRequest deleteResourceRequest) throws ResourceException; | 删除资源             |
| public String getResourceUrl(DownloadResourceRequest downloadResourceRequest) throws ResourceException; | 下载资源             |
| public ResourceDetail getResourceDetailed(int resourceId) throws ResourceException; | 获取资源详情         |
| public List<ResourceSummary> getResourceSummary() throws ResourceException; | 获取资源总体统计数据 |
| public List<ResourceSummary> getResourceSummaryByCategory(ListResourceByCategoryRequest listResourceByCategoryRequest ) throws ResourceException; | 获取资源按类统计数据 |

###### DownloadHistoryService

| 方法签名                                                     | 描述                     |
| ------------------------------------------------------------ | ------------------------ |
| public List<DownloadHistoryEntry> getDownloadHistoryEntryByPage(GetDownloadRecordRequest getDownloadHistoryRequest) throws DownloadHistoryException; | 按页获取下载历史         |
| public boolean deleteDownloadHistory(int resourceId) throws DownloadHistoryException; | 清空某资源下载历史       |
| public List<DownloadHistoryEntry> getDownloadHistoryEntry() throws DownloadHistoryException; | 获取下载历史相关统计数据 |

###### StatisticService

| 方法签名                                                     | 描述                             |
| ------------------------------------------------------------ | -------------------------------- |
| public OverallFigure getOverallInfo(HttpServletRequest request) throws StatisticsException; | 获取总体信息                     |
| public int getNumOfCurrentOnline(HttpServletRequest request) throws StatisticsException; | 获取当前在线                     |
| public List<PostSummary> getPostListOrderedByPopularity(TimeRange timeRange, HttpServletRequest request) throws StatisticsException; | 根据热度对帖子排序并获取         |
| public List<ResourceSummary> getResourceListByDownload(TimeRange timeRange, HttpServletRequest request) throws StatisticsException; | 根据下载量对资源排序并获取       |
| public List<UserSummary> getUserListByCntOfResourceUpload(TimeRange timeRange, HttpServletRequest request) throws StatisticsException; | 根据上传资源数量对用户排序并获取 |

###### ExperienceService

| 方法签名                                                     | 描述                               |
| ------------------------------------------------------------ | ---------------------------------- |
| public boolean updateExperience(int curUserId, int changeNumber) throws ExperienceException; | 为相应用户增加/扣除积分            |
| public int getExperience2Level(int curUserId) throws ExperienceException; | 获取相应用户的等级                 |
| public int setPostPermission(int postId) throws ExperienceException; | 为帖子设置权限                     |
| public boolean getExperienceForPost(int curUserId, int postId) throws ExperienceException; | 检查相应用户是否有权查看某帖子内容 |

##### 模型映射层设计示例

###### 具体设计

- UserMapper 负责映射User表，实现User表的增删改查功能。
- AdminMapper 负责映射Admin表，实现Admin表的增删查功能。
- PostMapper 负责映射Post表，实现Post表的增删查功能。
- LikeMapper 负责映射Like表，实现Like表的增删查功能。
- CommentMapper 负责映射Comment表，实现Comment表的增删查功能。
- ReplyMapper 负责映射Reply表，实现Reply表的增删查功能。
- ResourceMapper 负责映射Resource表，实现Resource表的增删查功能。
- LogMapper 负责映射Log表，实现Log表的增删查功能。
- DownloadHistoryMapper 负责映射DownloadHistory表，实现DownloadHistory表的增删查功能。
- ExperienceMapper 负责映射Experience表，实现Experience表的增删查功能。

###### UserMapper

| 接口函数名                                                   | 解释                       |
| ------------------------------------------------------------ | -------------------------- |
| String createUser(UserDetail user);                          | 创建用户                   |
| int deleteUser(int userId)                                   | 删除用户（用户使用）       |
| int deleteUser(List\<int> userIdList);                       | 批量删除用户（管理员使用） |
| int updateUser(UserDetail user);                             | 修改用户信息               |
| int updatePassword(int userId, String password)              | 修改用户密码               |
| UserDetail readUserById(int userId);                         | 查询用户（单条）           |
| UserDetail readUserByEmail(String email)                     | 查询用户（单条）           |
| String readPassword(int userId);                             | 查询用户密码               |
| UserDisplay identifyUserById(int userId, String password);   | 使用id验证用户及密码       |
| UserDisplay identifyUserByEmail(String email, String password); | 使用email验证用户及密码    |
| List\<UserSummary> readAllUser();                            | 查询所有用户（管理员使用） |

###### AdminMapper

| 接口函数名                                       | 解释               |
| ------------------------------------------------ | ------------------ |
| int createAdmin(Admin admin);                    | 创建管理员         |
| int updateAdmin(Admin admin);                    | 修改管理员信息     |
| Admin readAdmin(int adminId);                    | 查询管理员（单条） |
| int identifyAdmin(int adminId, String password); | 验证管理员及密码   |

###### PostMapper

| 接口函数名                                    | 解释                 |
| --------------------------------------------- | -------------------- |
| int createPost(Post post);                    | 创建帖子             |
| int deletePost(int postId)                    | 删除帖子             |
| PostDetail readPost(int postId);              | 查询帖子（单条）     |
| List\<PostSummary> readPostList(int pageNum); | 查询帖子列表（按页） |
| List\<PostSummary> readAllPost();             | 查询所有帖子         |

###### LikeMapper

| 接口函数名                      | 解释                                                  |
| ------------------------------- | ----------------------------------------------------- |
| int createLike(Like like);      | 创建（即增加，在此为符合数据库CURD命名）点赞记录      |
| int deleteLike(int likeId);     | 删除（即取消，同上，like仅有uid-pid两个属性）点赞记录 |
| int readLike(int postId);       | 查询点赞数量                                          |
| List\<LikeEntry> getAllLike()； | 查询点赞总体统计数据                                  |

###### CommentMapper

| 接口函数名                                       | 解释                                       |
| ------------------------------------------------ | ------------------------------------------ |
| int createComment(CommentEntry comment);         | 创建评论                                   |
| int deleteComment(int commentId);                | 删除评论（注意数据库设计中的级联删除问题） |
| int deletePostComment(int postId);               | 删除帖子所有评论                           |
| List\<CommentEntry> readPostComment(int postId); | 查询帖子评论                               |
| List\<CommentEntry> readAllComment();            | 查询评论总体统计数据                       |

###### ReplyMapper

| 接口函数名                                         | 解释                                       |
| -------------------------------------------------- | ------------------------------------------ |
| int createReply(ReplyEntry reply);                 | 创建回复                                   |
| int deleteReply(int replyId);                      | 删除回复（注意数据库设计中的级联删除问题） |
| int deletePostReply(int postId);                   | 删除帖子所有回复                           |
| int deleteCommentReply(int commentId);             | 删除某条评论回复                           |
| List\<ReplyEntry> readPostReply(int postId);       | 查询帖子评论前几条回复                     |
| List\<ReplyEntry> readCommendReply(int commentId); | 查询某条评论全部回复                       |
| List\<ReplyEntry> readAllReply();                  | 查询回复总体统计数据                       |

###### ResourceMapper

| 接口函数名                                                   | 解释                                       |
| ------------------------------------------------------------ | ------------------------------------------ |
| int createResource(ResourceDetail resource);                 | 创建资源                                   |
| int deleteResource(int resourceId);                          | 删除资源（注意数据库设计中的级联删除问题） |
| ResourceDetail readResource(int resourceId);                 | 查询资源详情                               |
| List\<ResourceSummary> readResourceListRecommended(Date date, int pageNum, ...); | 查询推荐资源列表                           |
| List\<ResourceSummary> readResourceListByCategory(int category, int pageNum); | 查询分类资源列表                           |
| List\<ResourceSummary> readResourceListBySubject(int subject, int pageNum); | 查询分学科资源列表                         |
| String readResourceDownload(int resourceId);                 | 查询资源下载URL                            |
| List\<ResourceSummary> readAllResource();                    | 查询资源总体统计数据                       |
| List\<ResourceSummary> readAllResourceByCategory(int category); | 查询资源分类统计数据                       |
| List\<ResourceSummary> readAllResourceBySubject(int subject); | 查询资源分类统计数据                       |

###### LogMapper

| 接口函数名                          | 解释             |
| ----------------------------------- | ---------------- |
| int createLog(Log log);             | 创建日志         |
| List\<LogEntry> readLog(Date date); | 查询日志         |
| int deleteLog(int userId)           | 清空用户日志     |
| int deleteLog(Datetime datetime)    | 清空日期所有日志 |

###### DownloadHistoryMapper

| 接口函数名                                                   | 解释                     |
| ------------------------------------------------------------ | ------------------------ |
| int createDownloadHistory(DownloadHistoryEntry downloadHistory); | 创建下载记录             |
| List\<DownloadHistoryEntry> readDownloadHistoryByPage(int pageNum); | 查询下载记录             |
| int deleteDownloadHistory(int resourceId);                   | 清空下载记录             |
| List\<DownloadHistoryEntry> readAllDownloadHistory();        | 查询下载历史总体统计数据 |

###### ExperienceMapper

| 接口函数名                                                | 解释         |
| --------------------------------------------------------- | ------------ |
| Boolean updateExperience(int curUserId, int changeNumber) | 更改用户经验 |
| Boolean getExperience(int curUserId)                      | 获取用户经验 |

#### 实体类

![DCD_Entities](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/DCD_Entities.png)

实体类主要根据具体的需求，分为以下三种：

- 返回值类。即返回给用户界面的RestBean类。
- 请求实体类。即包含用户具体请求的Request类，包括各种Request、TimeRange类。
- 模型实体类。即根据具体的用户需求对从数据库获取的数据进行打包的Entry类，包括各种OverallFigure、Summary、Detail、Display、Entry类。

###### RestBean类

​		该类为泛型工具类。

- 该类由msg和code两个属性构成，分别代表响应信息和状态码。
- 该类私有了构造，无法通过new创建对象。
- 该类提供了多个获取实例的方法，可以通过这些方法用于快速创建对象。
- 可以通过@RestController或者@RequestBody以json的形式传递给前端页面。

###### 请求实体类

| 类名                          | 含义                   |
| ----------------------------- | ---------------------- |
| VerifyUserLoginRequest        | 验证用户登录请求       |
| VerifyAdminLoginRequest       | 验证管理员登录请求     |
| VerifyUserRegisterRequest     | 验证用户注册请求       |
| GetAccountInfoListRequest     | 获取用户列表请求       |
| UpdateAccountInfoRequest      | 更新用户数据请求       |
| GetPasswordRequest            | 找回密码请求           |
| UpdatePasswordRequest         | 更改密码请求           |
| DeleteAccountRequest          | 删除用户账户请求       |
| ListPostRequest               | 获取帖子列表请求       |
| AddPostRequest                | 发布帖子请求           |
| DeletePostRequest             | 删除帖子请求           |
| ListReplyRequest              | 显示回复请求           |
| CommentPostRequest            | 评论帖子请求           |
| ReplyCommentRequest           | 回复评论请求           |
| DeletCommentRequest           | 删除评论请求           |
| DeleteReplyRequest            | 删除回复请求           |
| ListResourceByCategoryRequest | 按学科获取资源列表请求 |
| ListRecommendResoueceRequest  | 按推荐获取资源列表请求 |
| UploadResourceRequest         | 上传资源请求           |
| DownloadResourceRequest       | 下载资源请求           |
| DeleteResourceRequest         | 删除资源请求           |
| GetDownloadHistoryRequest     | 获取下载历史请求       |
| DeleteDownloadHistoryRequest  | 清空下载历史请求       |
| TimeRange                     | 设置时间范围           |

###### 模型实体类

| 类名                 | 含义               |
| -------------------- | ------------------ |
| OverallFigure        | 总体数据包装类     |
| UserSummary          | 用户列表包装类     |
| UserDisplay          | 显示用户信息包装类 |
| UserDetail           | 用户详细信息包装类 |
| PostSummary          | 帖子列表包装类     |
| PostDetail           | 帖子详细信息包装类 |
| CommentEntry         | 评论实体类         |
| ReplyEntry           | 回复实体类         |
| ResourceSummary      | 资源列表包装类     |
| ResourceDetail       | 资源详细信息包装类 |
| DownloadHistoryEntry | 下载历史实体类     |
| LikeEntry            | 点赞实体类         |
| LogEntry             | 日志实体类         |

#### 异常类

![DCD_Exception](https://zzq-typora-picgo.oss-cn-beijing.aliyuncs.com/DCD_Exception.png)

​		根据发生异常的请求和处理方法的主体不同，划分为不同的异常类，并抛出相应的异常返回值。在服务层实现抛出异常和相应处理。根据错误码选择将报错返回用户界面和实施回滚等机制。

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