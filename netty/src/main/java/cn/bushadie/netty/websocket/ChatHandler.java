package cn.bushadie.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

/**
 * @author jdmy
 * on 2018/11/12.
 * 处理消息的handler,  在netty中,是用于为websocket专门处理文本的对象,  frame是消息载体
 **/
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    // 用户记录和管理所有客户端的channel
    private static ChannelGroup clients=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,TextWebSocketFrame msg) throws Exception {
        // 获取客户端传输过来的消息
        String content=msg.text();
        System.out.println("接收到的消息: "+content);
        String shortText=ctx.channel().id().asShortText();
        System.out.println("shortText = "+shortText);
        //  下面的for是所有的链接都接收到消息
        for(Channel client: clients) {
            String clientText=client.id().asShortText();
            System.out.println("clientText = "+clientText);
            if(ctx.channel().id()==client.id()) {
                String str="[单条联系 服务器在 "+LocalDateTime.now()+"  接收到到消息],内容为  "+content;
                client.writeAndFlush(new TextWebSocketFrame(str));
            }
        }
        // 这个方法和上面的for一样
        //        clients.writeAndFlush( new TextWebSocketFrame( "[服务器在 " + LocalDateTime.now() + "  接收到到消息],内容为  " + content ) );

    }

    /**
     * 当客户端链接服务器后(打开连接)
     * 获取客户端的channel,并且放到 channelGroup中进行管理
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当触发 handlerRemoved  ,  ChannelGroup会自动移除对应客户端的channel
        //        clients.remove( ctx.channel() );
        System.out.println("客户端断开: "+ctx.channel().id().asLongText());
        System.out.println("客户端断开: "+ctx.channel().id().asShortText());
    }
}
