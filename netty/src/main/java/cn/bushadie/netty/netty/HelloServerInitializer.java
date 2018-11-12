package cn.bushadie.netty.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author jdmy
 * on 2018/11/11.
 * 初始化器, channel注册后  会执行里面的相应初始化方法
 **/
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 通过channel去获得对应的管道
        ChannelPipeline pipeline=ch.pipeline();

        // 通过管道添加handler
        // HttpServerCodec    netty自己提供的助手类,  可以理解为拦截器
        // 当请求来到服务器, 我们需要做编码解码响应到客户端做编码
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        // 添加自定义的注解类助手,  返回 hello netty
        pipeline.addLast("CustomHandler",new CustomHandler());
    }
}
