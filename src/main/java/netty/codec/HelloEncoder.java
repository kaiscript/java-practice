package netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by kaiscript on 2018/2/27.
 */
public class HelloEncoder extends MessageToByteEncoder<HelloMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, HelloMsg msg, ByteBuf out) throws Exception {
        byte type = msg.getType();
        int length = msg.getLength();
        String body = msg.getBody();
        System.out.println(body);
        out.writeByte(type);
        out.writeInt(length);
        out.writeBytes(body.getBytes());//?
    }

}
