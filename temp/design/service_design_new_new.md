来自于2023年5月14日的设计思路

让Controller作为协调器，例如，处理"创建订单"请求的Controller方法可能需要调用OrderService的方法来创建订单，然后调用InventoryService的方法来更新库存，最后调用PaymentService的方法来处理支付。

在这种设计中，Service类成员方法就像是对于Mapper方法的包装，例如UserService.addUser()，而不是类似于UserService.register()。

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

# New New Service Design

## UserService

| 方法签名                                                     | 描述                                        |
| ------------------------------------------------------------ | ------------------------------------------- |
| public String authenticateUser() throws UserException;       | 验证用户输入的用户名和密码，并生成token     |
| public int getUserIdFromToken() throws UserException;        | 验证提供的token是否有效，并返回相应的UserId |
| public boolean addUser(UserRegisterRequest userRegisterReq) throws UserException; | 创建新的用户                                |
|                                                              | 获取用户信息                                |
|                                                              | 修改用户密码                                |
|                                                              | 获取用户列表                                |
|                                                              | 更新用户信息                                |
|                                                              | 删除用户                                    |

## LogService

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

## PostService

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

## LikeService

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

## CommentService

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

## ReplyService

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

## RecourseService

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

## DownloadHistoryService

| 方法签名 | 描述 |
| -------- | ---- |
|          |      |

## StatisticsService