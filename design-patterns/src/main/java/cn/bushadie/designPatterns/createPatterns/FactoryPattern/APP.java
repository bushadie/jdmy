package cn.bushadie.designPatterns.createPatterns.FactoryPattern;

import cn.bushadie.designPatterns.rubbish.Food;

/**
 * @author jdmy
 * on 2018/11/19.
 * 虽然都是调用 makeFood("A") 制作 A 类食物，但是，不同的工厂生产出来的完全不一样。
 *
 * 第一步，我们需要选取合适的工厂，然后第二步基本上和简单工厂一样。
 *
 * 核心在于，我们需要在第一步选好我们需要的工厂。比如，我们有 LogFactory 接口，
 * 实现类有 FileLogFactory 和 KafkaLogFactory，分别对应将日志写入文件和写入 Kafka 中，
 * 显然，我们客户端第一步就需要决定到底要实例化 FileLogFactory 还是 KafkaLogFactory，这将决定之后的所有的操作。
 **/
public class APP {
    public static void main(String[] args) {
        // 先选择一个具体的工厂
        FoodFactory factory = new ChineseFoodFactory();
        // 由第一步的工厂产生具体的对象，不同的工厂造出不一样的对象
        Food food = factory.makeFood("A");
    }
}
