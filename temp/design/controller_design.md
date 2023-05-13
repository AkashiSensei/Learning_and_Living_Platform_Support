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

在使用了拦截器后，一个Controller方法应该像这样，注意这仅仅是一个示例。

```java
@RequestMapping(value = "/post/upload", method = RequestMethod.POST)
// request 是拦截器处理过的request，拦截器将 token 处理成当前用户的 id 并保存在 curUserId 字段
public RestBean<> updatePost(@RequestBody UploadPostRequest uploadPostRequest, HttpServletRequest request) {
    String curUserId = (String) request.getAttribute("curUserId");
    int ret = postService.uploadPost(uploadPostRequest, curUserId);
    
    // 相应的 service 仅仅返回事务逻辑的返回结果，包装成 RestBean 的任务交给 Controller
    if(ret == 0) {
        return RestBean.success(201);
    }else if(ret == -E_PERM) {
        return RestBean.failure(403, "No permission to upload posts");
    }else {
        return PrestBean.failure(500);
    }
}
```



## UserController

## PostController

| 方法签名                                                     | 描述 |
| ------------------------------------------------------------ | ---- |
| RestBean<> listPost(@RequestBody ListPostRequest listPostRequest, HttpServletRequest request) |      |
| openPost                                                     |      |
| uploadPost                                                   |      |
| deletePost                                                   |      |
| likePost                                                     |      |
| commentPost                                                  |      |
| replyComment                                                 |      |
| deleteComment                                                |      |
| deleteReply                                                  |      |

## ResourceController
