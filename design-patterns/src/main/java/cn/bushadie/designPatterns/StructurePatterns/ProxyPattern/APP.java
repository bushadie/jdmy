package cn.bushadie.designPatterns.StructurePatterns.ProxyPattern;

/**
 * @author jdmy
 * on 2018/11/19.
 *
 * 第一个要介绍的代理模式是最常使用的模式之一了，
 * 用一个代理来隐藏具体实现类的实现细节，通常还用于在真实的实现的前后添加一部分逻辑。
 *
 * 既然说是代理，那就要对客户端隐藏真实实现，由代理来负责客户端的所有请求。
 * 当然，代理只是个代理，它不会完成实际的业务逻辑，而是一层皮而已，
 * 但是对于客户端来说，它必须表现得就是客户端需要的真实实现。
 *
 *
 *
 * 我们发现没有，代理模式说白了就是做 “方法包装” 或做 “方法增强”。
 * 在面向切面编程中，算了还是不要吹捧这个名词了，在 AOP 中，其实就是动态代理的过程。
 * 比如 Spring 中，我们自己不定义代理类，但是 Spring 会帮我们动态来定义代理，
 * 然后把我们定义在 @Before、@After、@Around 中的代码逻辑动态添加到代理中。
 *
 *
 *
 * 说到动态代理，又可以展开说 …… Spring 中实现动态代理有两种，
 * 一种是如果我们的类定义了接口，如 UserService 接口和 UserServiceImpl 实现，那么采用 JDK 的动态代理，
 * 感兴趣的读者可以去看看 java.lang.reflect.Proxy 类的源码；
 *
 * 另一种是我们自己没有定义接口的，Spring 会采用 CGLIB 进行动态代理，它是一个 jar 包，性能还不错。
 **/
public class APP {
    public void getFood(){
        // 这里用代理类来实例化
        FoodService foodService = new FoodServiceProxy();
        foodService.makeChicken();
    }
}
