package cn.bushadie.designPatterns.createPatterns.BuilderPattern;

/**
 * @author jdmy
 * on 2018/11/19.
 *
 * 说实话，建造者模式的链式写法很吸引人，但是，多写了很多“无用”的 builder 的代码，感觉这个模式没什么用。
 * 不过，当属性很多，而且有些必填，有些选填的时候，这个模式会使代码清晰很多。
 * 我们可以在 Builder 的构造方法中强制让调用者提供必填字段
 * 还有，在 build() 方法中校验各个参数比在 User 的构造方法中校验，代码要优雅一些。
 *
 *
 *
 * 当然，如果你只是想要链式写法，不想要建造者模式，有个很简单的办法，
 * User 的 getter 方法不变，所有的 setter 方法都让其 return this 就可以了
 **/
public class APP {
    public static void main(String[] args) {
        User d = User.builder()
                .name("foo")
                .password("pAss12345")
                .age(25)
                .build();
    }
}
