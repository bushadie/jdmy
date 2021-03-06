package cn.bushadie.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author jdmy
 * on 2018/11/10.
 * 实现客户端发送一个请求,服务器会返回hello netty
 **/
public class HelloNetty {
    public static void main(String[] args) {
        //  定义一对线程组
        //  用于接收客户端的链接,但是不做任何处理
        NioEventLoopGroup parentGroup=new NioEventLoopGroup();
        // parentGroup会把工作丢给它
        NioEventLoopGroup childGroup=new NioEventLoopGroup();

        try {
            //  netty 的服务器的创建  serverBootstrap是一个启动类
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(parentGroup,childGroup) // 设置主从线程组
                    .channel(NioServerSocketChannel.class) // 设置nio的双向通道
                    .childHandler(new HelloServerInitializer());

            //启动server,并且设置8088为启动的端口号,  同时启动方式为同步
            ChannelFuture channelFuture=serverBootstrap.bind(8888).sync();// 绑定端口,使用同步的方式

            // 监听关闭的channel,  设置位同步方式为同步
            channelFuture.channel().closeFuture().sync();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}
