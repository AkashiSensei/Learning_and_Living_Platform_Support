```java
  /**
     * [PUT]用户登录接口，用来判断登录用户是否在数据库中，如果在的话更新在线时间并签到 
     * @param username 用户登录邮箱/用户id
     * @param password 用户输入的密码
     * @return 0 if 用户名及密码均匹配；
     *         -1 if 用户名不存在；
     *         -2 if 用户名存在但密码错误
     *         -5 if 数据库连接失败
     */
    int userLogin(String username, String password){}

    /**
     * [POST]用户注册接口，如果当前用户名未注册，则注册新用户，并为其分配id 
     * @param username 用户注册邮箱
     * @param password 用户注册密码
     * @return 0 if 用户成功注册
     *         -1 if 用户名已经注册过
     *         -5 if 数据库连接失败/添加失败
     */
    int userRegister(String username, String password){}

    /**
     *[GET]用户删除账户接口。其中用户名为系统获取当前登录用户，而不是用户输入。如果密码正确，则返回确认信息。
     * @param username
     * @param password
     * @return 0 if 用户信息正确
     *         -1 if 密码错误
     *         -5 if 数据库连接错误
     */
    int userDeleteAsk(String username, String password){}

    /**
     * [DELETE]用户返回确认删除的信息，数据库判断是否执行最终的删除操作。
     * @param username
     * @param confirm if 0 then 没有任何操作，表示用户按了“取消“；
     *                if 1 then 选中邮箱/id，删除/修改此用户及其所关联表的信息
     * @return 0 if 成功删除
     *         -5 if 删除失败
     */
    int userDeleteDo(String username, boolean confirm){}

    /**
     * [GET]列出资源列表，需要根据类别和每页/每两页页数提取。
     * @param num 一次加载的数据条数
     * @param category 用户所处类别
     * @return 一个json列表（或者是什么其他的类型）：成功返回
     *          -1 没有数据
     *          -5 获取失败
     */
    int ListResource(int num, int category){}

    /**
     * [GET]根据用户的下载历史推荐资源，没有就默认推荐
     * @param username
     * @return 3-5个json类型的数据（或者其它）：成功返回
     *          -1 资源不足
     *          -5 网络问题
     */
    int commandResource(String username){}

    /**
     * [POST]请求里面传资源的全部信息？就不放在参数里了
     * @param username
     * @return 0 if 上传成功
     *          -1 if 添加数据库失败
     *          -5 if 网络问题
     */

    int uploadResource(String username){}

    /**
     * [POST]下载某一资源，给这一资源下载量+1，同时上传者经验值++
     * @param username
     * @param resourceId
     * @return 文件 if 成功
     *          -1 if 未获取成功
     *          -5 if 网络问题
     */
    int downloadResource(String username, String resourceId){}

    /**
     * [GET]查看某个资源详情页面
     * @param resourceId
     * @return 详细信息 if 成功
     *          -1 if 失败
     */
    int detailResource(String resourceId){}

    /**
     * [DELETE]删除上传的资源，根据change来操作是否减去积分
     * @param username
     * @param resourceId
     * @param change
     * @return 0 if 成功
     *          -1 if 删除失败
     *          -5 if 意外错误
     */
    int deleteResource(String username, String resourceId, boolean change){}

    /**
     * [GET]查看个人的下载记录
     * @param username
     * @return 0 if 成功
     *          -1 if 获取失败
     *          -5 意外错误
     */
    int reviewDownloadHistory(String username){}

/*======================================================================================================*/

    /**
     * [PUT]管理员登录接口，用来判断登录管理员是否在数据库中，如果在的话更新在线时间并签到
     * @param username 管理员登录邮箱/用户id
     * @param password 管理员输入的密码
     * @return 0 if 用户名及密码均匹配；
     *         -1 if 用户名不存在；
     *         -2 if 用户名存在但密码错误
     *         -5 if 数据库连接失败
     */
    int adminLogin(String username, String password){}


    /**
     * [DELETE]管理员删除账户。
     * @param username
     * @return 0 if 删除成功
     *         -1 if 删除失败
     *         -5 if 数据库连接错误
     */
    int userDelete(String username){}

    /**
     * [GET]列出资源列表，需要根据类别和每页/每两页页数提取。
     * @param num 一次加载的数据条数
     * @param category 用户所处类别
     * @return 一个json列表（或者是什么其他的类型）：成功返回
     *          -1 没有数据
     *          -5 获取失败
     */
    int ListResource(int num, int category){}


    /**
     * [POST]下载某一资源，给这一资源下载量+1，同时上传者经验值++
     * @param username
     * @param resourceId
     * @return 文件 if 成功
     *          -1 if 未获取成功
     *          -5 if 网络问题
     */
    int downloadResource(String username, String resourceId){}

    /**
     * [GET]查看某个资源详情页面
     * @param resourceId
     * @return 详细信息 if 成功
     *          -1 if 失败
     */
    int detailResource(String resourceId){}

    /**
     * [DELETE]删除上传的资源，根据change来操作是否减去积分。
     * @param resourceId
     * @param change
     * @return 0 if 成功
     *          -1 if 删除失败
     *          -5 if 意外错误
     */
    int deleteResource(String resourceId, boolean change){}

    /**
     * [PUT]管理员更新资源。这里需要put一个json数据，然后数据库直接全部更新，避免反复对比参数过多
     * @param resourceId
     * @return 0 if 成功
     *          -1 if 失败，前端不予修改
     *          -5 if 意外错误
     */
    int changeResource(String resourceId){}
```