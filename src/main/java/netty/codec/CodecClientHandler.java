package netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by kaiscript on 2018/2/27.
 */
public class CodecClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        HelloMsg msg = new HelloMsg((byte) 0xAB, "Hello,Netty".length(), "Hello,Netty");
        ctx.writeAndFlush(msg);
    }

}
