package netty.heartBeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Created by kaiscript on 2018/2/28.
 */
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

    private int lossConnectTime = 0 ;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                lossConnectTime++;
                System.out.println("没收到客户端消息.");
                if (lossConnectTime > 2) {
                    ctx.channel().close();
                    System.out.println("关闭连接");
                }
            }
        }
        else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channel read");
        System.out.println(ctx.channel().remoteAddress() + "==>server:" + msg.toString());
        ctx.writeAndFlush("back from server:"+msg);
    }


}
