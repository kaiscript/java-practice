package netty.heartBeat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;

/**
 * Created by kaiscript on 2018/2/28.
 */
public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {

    private static final int TRY_TIMES = 5;

    private int lossTime = 0;

    private static final ByteBuf HEART_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Heartbeat", CharsetUtil.UTF_8));

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("client触发时间:" + new Date());
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                lossTime++;
                System.out.println("lossTime" + lossTime);
                if (lossTime <= TRY_TIMES) { //超过这个数就不发了
                    ctx.channel().writeAndFlush(HEART_SEQUENCE.duplicate());
                }
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        System.out.println(message);
        if (message.equals("Heartbeat")) {
            System.out.println("HeartBeatClientHandler channelRead");
            ctx.write("has read message from server");
            ctx.flush();
        }
        ReferenceCountUtil.release(msg);
    }
}
