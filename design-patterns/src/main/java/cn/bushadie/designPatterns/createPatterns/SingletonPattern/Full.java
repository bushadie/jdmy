package cn.bushadie.designPatterns.createPatterns.SingletonPattern;

/**
 * @author jdmy
 * on 2018/11/19.
 * 饱汉模式
 *
 *
 * 双重检查，指的是两次检查 instance 是否为 null。
 *
 * volatile 在这里是需要的，希望能引起读者的关注。
 *
 * 很多人不知道怎么写，直接就在 getInstance() 方法签名上加上 synchronized，这就不多说了，性能太差。
 **/
public class Full {
    // 首先，也是先堵死 new Full() 这条路
    private Full() {}
    // 和饿汉模式相比，这边不需要先实例化出来，注意这里的 volatile，它是必须的
    private static volatile Full instance = null;

    public static Full getInstance() {
        if (instance == null) {
            // 加锁
            synchronized (Full.class) {
                // 这一次判断也是必须的，不然会有并发问题
                if (instance == null) {
                    instance = new Full();
                }
            }
        }
        return instance;
    }
}
