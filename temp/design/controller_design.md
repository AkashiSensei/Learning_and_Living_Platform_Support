# Controller Design

| Controller类名     | 描述                                                       |
| ------------------ | ---------------------------------------------------------- |
| UserController     | 处理用户和管理员登录、访客注册、用户信息修改等用户相关请求 |
| PostController     | 处理发布新帖子，点赞、评论帖子等帖子相关请求               |
| ResourceController | 处理发布新资源，下载资源等相关请求                         |

如无特殊说明，方法共有，变量私有。

## 返回值模板类

```java
public class RestBean<T> {
    private int status;
    private boolean success;
    private T message;

    private RestBean(int status, boolean success, T message){
        this.status = status;
        this.success = success;
        this.message = message;
    }

    public static <T> RestBean<T> success() {
        return new RestBean<>(200, true, null);
    }

    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(200, true, data);
    }

    public static <T> RestBean<T> failure(int status) {
        return new RestBean<>(status, false, null);
    }

    public static <T> RestBean<T> failure(int status, T data) {
        return new RestBean<>(status, false, data);
    }
}
```



## UserController

### 成员变量

UserService

### 成员方法

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
```



## PostController

### 成员变量

### 成员方法

## ResourceController

### 成员变量

### 成员方法