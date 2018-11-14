package netty.hello2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by kaiscript on 2018/2/25.
 */
public class HelloClientHandler2 extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("HelloClientHandler read:"+msg);
    }
}
