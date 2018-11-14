package netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by kaiscript on 2018/2/27.
 */
public class CodecServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client (" + ctx.channel().remoteAddress() + ")-->Server...msg:" + msg.toString());
    }
}
