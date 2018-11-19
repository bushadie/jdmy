package cn.bushadie.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @author jdmy
 * on 2018/11/12.
 **/
@Component
public class WSServer {
    private static class SingletonWSServer {
        static final WSServer instance=new WSServer();
    }

    public static WSServer getInstance() {
        return SingletonWSServer.instance;
    }

    private NioEventLoopGroup mainGroup;
    private NioEventLoopGroup subGroup;
    private ServerBootstrap server;
    private ChannelFuture channelFuture;

    public WSServer() {
        mainGroup=new NioEventLoopGroup();
        subGroup=new NioEventLoopGroup();

        server=new ServerBootstrap();
        server.group(mainGroup,subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WSServerInitializer());
        ChannelFuture channelFuture=server.bind(8888);
    }

    public void start() {
        channelFuture=server.bind(8888);
        System.err.println("netty websocket server 启动完毕");
    }
}