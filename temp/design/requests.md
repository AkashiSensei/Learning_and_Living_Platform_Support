All request will be responded with a RestBean:

```java
public class RestBean<T> {
    private int status; 
    private boolean success; 
    private T message;
}
```

Possible requests from the frontend:

## User:

| RequestName        | Method | Header | Body                       | ExpectMessage |
| ------------------ | ------ | ------ | -------------------------- | ------------- |
| verifyUserLogin    | POST   |        | email/id,password          | None          |
| verifyAdminLogin   | POST   |        | email/id,password          | None          |
| verifyUserRegister | POST   |        | email,password             | None          |
| getAccountInfo     | GET    |        | None                       | User          |
| getAccountInfoList | GET    |        | None                       | List<User>    |
| updateAccountInfo  | PUT    |        | name,email,gender,birthday | User          |
| updatePassword     | PUT    |        | password                   | None          |
| deleteAccount      | DELETE |        | None                       | None          |

## Resource:



## Post:

