# Interceptor Design

此文档仅用于说明在晚上顺序图时针对拦截器的问题，并不代表真正的拦截器设计。

应该需要 WebConfig 类注册拦截器。

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



## 附上和小chai的交流

### You

我现在正在画用例实现的顺序图，但我并不太清楚涉及到拦截器的部分应该怎么画，我的拦截器在处理token的时候会调用UserService的public int getUserIdFromToken(String token) throws UserException;方法，并且通过拦截器后请求会到达Controller，请你向我描述这部分的顺序图应该怎么画。

### ChatGPT

顺序图（Sequence Diagram）是一种常用的UML图，它用于描述对象之间的交互顺序。在你的场景中，顺序图可以帮助你理解和展示请求是如何通过拦截器、Controller、Service等组件来处理的。

下面是一种可能的顺序图描述，不过请注意这是一种简化版的描述，并没有包含所有的细节。

1. 客户端发起请求，请求会首先到达拦截器（Interceptor）。
2. 拦截器从请求中提取出token，并调用UserService的getUserIdFromToken方法来验证和解析token。此时，UserService可能需要调用JWT工具类或者其他依赖来进行具体的验证和解析工作。如果token无效或者解析失败，UserService将抛出异常。
3. 拦截器捕获到UserService抛出的异常，然后拦截器会向客户端返回一个错误响应，并终止后续的请求处理流程。如果token有效并且能够成功解析，拦截器将把userId保存到请求的属性中，并让请求继续向下传递。
4. 请求到达Controller。Controller从请求的属性中获取到userId，然后调用相应的Service方法来处理请求。此时，Service方法可能需要调用Mapper或者其他依赖来进行具体的操作。
5. Controller从Service方法得到结果，然后构建一个响应并返回给客户端。

在顺序图中，你需要画出每一个组件（Interceptor、UserService、Controller等）作为一个独立的垂直线，然后用箭头表示消息或者方法调用的传递。每一个箭头应该包含方法的名称以及传递的参数，并且箭头的方向应该表示调用的方向。你还需要按照时间顺序排列这些箭头，即在图的上方的箭头表示先发生的调用，而在下方的箭头表示后发生的调用。

希望这个回答能够帮到你。如果你需要更具体的帮助，例如如何在特定的UML工具中画出这个顺序图，或者如何添加更多的细节，欢迎你再次提问。

### You

非常感谢你的解答，但我仍有一些相关问题。第一个是，我该如何在顺序图中表示请求到达Controller呢？我可以直接从拦截器引出一个消息到Controller吗？还是说我该怎么表示？第二个是我该怎么在顺序图中表示正常返回和异常？

### ChatGPT

1. 在顺序图中，从拦截器到Controller的请求表示，通常是直接用箭头从拦截器的激活框（表示拦截器正在处理请求的一个矩形条）引向Controller的生命线。这个箭头表示拦截器处理完请求之后，请求会传递到Controller。这个箭头上的文字可以描述这个行为，例如“pass request”。
2. 在顺序图中，有多种方式来表示正常返回和异常：正常返回：可以用带箭头的虚线表示。例如，当Controller调用Service的方法后，Service的方法执行完毕并返回结果，这时可以从Service的激活框引出一条带箭头的虚线指向Controller的生命线。这个虚线上的文字可以描述返回的结果，例如“return result”。异常：可以用带箭头的实线表示，这条线通常是红色或者其他醒目的颜色。例如，当UserService在解析token时出现异常，它会抛出一个异常，这时可以从UserService的激活框引出一条带箭头的实线指向拦截器的生命线。这个实线上的文字可以描述抛出的异常，例如“throw UserException”。
3. 正常返回：可以用带箭头的虚线表示。例如，当Controller调用Service的方法后，Service的方法执行完毕并返回结果，这时可以从Service的激活框引出一条带箭头的虚线指向Controller的生命线。这个虚线上的文字可以描述返回的结果，例如“return result”。
4. 异常：可以用带箭头的实线表示，这条线通常是红色或者其他醒目的颜色。例如，当UserService在解析token时出现异常，它会抛出一个异常，这时可以从UserService的激活框引出一条带箭头的实线指向拦截器的生命线。这个实线上的文字可以描述抛出的异常，例如“throw UserException”。

这只是一种常见的方式来表示正常返回和异常，具体的表示方式可能会因为不同的UML工具或者个人习惯而有所不同。关键是要确保你的顺序图能够清楚地表达出请求的处理流程，包括正常的处理流程和出现异常时的处理流程。

### You

另外一个问题，我是否需要额外添加边界类呢，还是将我的拦截器上标注<<boundary>>就行呢？

### ChatGPT

在绘制UML图时，"边界类"一词通常用于描述用例图中的元素，用来代表系统与外部实体（比如用户或另一个系统）交互的接口。在你的场景中，如果你认为拦截器扮演着类似的角色（即作为系统和用户之间的交互接口），那么你完全可以在拦截器上标注<<boundary>>。

然而，在顺序图中，我们通常不使用"边界类"这样的概念。顺序图主要关注的是系统内部的交互和流程，而不是系统与外部实体的交互。所以，你只需要确保顺序图清楚地描述了系统内部的流程，包括拦截器如何处理请求，以及请求如何从拦截器传递到Controller，无需额外添加边界类。

总的来说，是否需要额外添加边界类，取决于你想要用UML图表达什么信息，以及你认为什么样的表示方式最能清晰地传达这些信息。

### You

好的，那么拦截器的生命线应该到什么时候呢，到pass request就可以了吗？

### ChatGPT

在顺序图中，每个对象（在这个场景中，拦截器就是一个对象）的生命周期是由它的"生命线"表示的。生命线从对象第一次参与交互开始，直到它不再参与为止。

在你的场景中，一旦拦截器完成了它的任务（即验证令牌并将请求传递给Controller），它就不再参与该交互。因此，拦截器的生命线应该在"pass request"之后结束。然后，Controller的生命线将从接收请求开始，继续进行处理。

所以，是的，你的理解是正确的，拦截器的生命线应该在"pass request"之后结束。

### You

好的，接下来请你为我解释一下涉及JwtUtil的部分。你为我提供的JwtUtil是一个自定义的类，其中使用了来自Jwts类的方法，通过自定义Jwts类方法的使用方式，实现了自定义Token生成的方式。我的理解是否正确？如果正确的话，JwtUtil类使用Jwts的静态方法，这两个类是什么关系呢？

### ChatGPT

你的理解是正确的。JwtUtil是一个自定义的工具类，用于生成和验证JWT（JSON Web Token）。这个类使用了Jwts类的静态方法，这是因为Jwts是Java中一个常用的JWT处理库，它提供了一系列的方法，用于构建和解析JWT。

JwtUtil和Jwts的关系是使用者和被使用者的关系。JwtUtil使用（或者说依赖于）Jwts库来处理JWT相关的工作。Jwts库为JwtUtil提供了生成、解析和验证JWT所需要的工具。在这种情况下，JwtUtil是调用者（也就是使用Jwts的代码），而Jwts是被调用者（也就是被JwtUtil使用的代码）。

### You

好的，在这种情况下，我应该可以不使用JwtUtil类，而将相应的生成逻辑放在我的UserService方法中。在这种情况下， 在顺序图中，我是否需要画从UserService到Jwts的消息吗，Jwts类需要自己的生命线吗？

### ChatGPT

对的，你完全可以选择不使用JwtUtil类，而是直接在UserService中使用Jwts类的静态方法。这种情况下，你可以选择在顺序图中画出UserService到Jwts的消息，以表明你在UserService中使用了Jwts的方法。

至于Jwts类是否需要生命线，这取决于你想要在顺序图中展示的细节程度。通常来说，我们在顺序图中添加生命线是为了表示某个对象在整个交互过程中的存在。然而，由于Jwts类的方法是静态的，它们不依赖于Jwts类的任何实例，你可以选择不为Jwts类添加生命线。相反，你可以将UserService到Jwts的消息表示为一种方法调用，这样可以清晰地展示UserService是如何使用Jwts的方法的。

总的来说，是否需要为Jwts类添加生命线，以及是否需要画出UserService到Jwts的消息，都取决于你想要在顺序图中展示的细节程度，以及你认为哪种方式能更清晰地表达你的设计。

### You

我如何在顺序图中表达方法调用，这个消息有什么不同？

### ChatGPT

在顺序图中，方法调用通常用一个带箭头的实线来表示，箭头的方向表示方法调用的方向，从调用者指向被调用者。这条线的顶端，也就是箭头的起点，通常在调用者的生命线上，而箭头的终点则位于被调用者的生命线上。

在箭头的线上，你可以写上调用的方法名称，以及传递的参数。这样，读图的人就可以清楚地看到哪个对象调用了哪个方法，以及传递了哪些参数。

例如，如果UserService调用了Jwts的一个名为generateToken的方法，你可以画一条从UserService生命线指向Jwts生命线的带箭头的实线，并在这条线上写上"generateToken()"。

需要注意的是，如果调用的是静态方法，你可以在方法名称前加上类名和一个点，比如"Jwts.generateToken()"，以表示这是一个静态方法调用。

另外，如果方法调用有返回值，你还可以用一条带箭头的虚线来表示返回，箭头的方向从被调用者指向调用者。在这条线上，你可以写上返回的值或类型。

例如，如果generateToken方法返回了一个token，你可以画一条从Jwts生命线指向UserService生命线的带箭头的虚线，并在这条线上写上"token"。

### You

我在我的AuthenticationInterceptor上标注<<Interceptor>>是否是合适的，分别在UserController和UserService上标注<<Controller>><<Service>>是否是合适的？这个标注的内容是什么含义呢？

### ChatGPT

在UML图中，使用 << >> 符号包裹的注解称为"stereotype"，这是一种元模型的扩展机制，用于给模型元素添加额外的属性。在这种情况下，"Interceptor"、"Controller"和"Service"都是一种stereotype，它们提供了一种标识类的角色或者职责的方式。

- <<Interceptor>> 通常表示这个类是一个拦截器，用于拦截并处理传递给服务器的请求或响应。
- <<Controller>> 通常表示这个类是一个控制器，用于接收和处理来自客户端的请求，并将请求传递给后续的处理环节。
- <<Service>> 通常表示这个类是一个服务类，用于处理业务逻辑。

标注这些 stereotype 是合适的，因为它们可以帮助读图的人快速理解每个类的职责和角色。然而，这些标注并不是必需的，也不会改变类的行为，它们只是用来提高模型的可读性和可理解性。

需要注意的是，虽然你可以自由地创建和使用你自己的stereotype，但是一些stereotype，如 "<<Entity>>", "<<Boundary>>", "<<Control>>" 等，在UML中有特定的含义，使用它们时需要遵循相应的规则。

### You

由于异常并不是一定会被抛出，因此我觉得直接将异常返回画在顺序图中不太恰当，我是否应该做一些额外的处理？

### ChatGPT

在顺序图中表示可能抛出的异常是一个常见的问题。通常，我们不会在顺序图中直接表示异常，因为顺序图主要是用来表示对象之间的交互，而异常是一种跨越多个交互的情况，所以在顺序图中表示起来可能会比较复杂。

但是，如果你认为在顺序图中表示异常对于理解系统的行为是重要的，你可以使用以下的方法来表示：

1. 使用注释：你可以在顺序图中添加注释，说明在某个步骤可能会抛出异常。这是一种简单但有效的方法。
2. 使用条件片段：UML提供了一种叫做"combined fragment"的机制，可以用来表示条件交互。你可以使用一个"alt"片段来表示如果发生异常，系统会执行哪些操作。
3. 使用单独的顺序图：如果处理异常的逻辑比较复杂，你也可以创建一个单独的顺序图来表示异常处理的流程。然后在主顺序图中通过链接或者注释引用这个异常处理的顺序图。

总的来说，如何在顺序图中表示异常取决于你想要表达的信息以及你的观众。你需要权衡在顺序图中添加更多的细节和保持顺序图的清晰性之间的平衡。

