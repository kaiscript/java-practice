package netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by kaiscript on 2018/2/26.
 */
public class HelloDecoder extends LengthFieldBasedFrameDecoder {

    private static final int HEADER_LENGTH = 5;
    private byte type;
    private int length;
    private String body;

    public HelloDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if (in == null) {
            return null;
        }
        if (in.readableBytes() < HEADER_LENGTH) {
            throw new Exception("not enough length.");
        }
        type = in.readByte();
        length = in.readInt();
        if (in.readableBytes() < length) {
            throw new Exception("not enough body length.");
        }
        ByteBuf byteBuf = in.readBytes(length);
        byte[] bytes = new byte[in.readableBytes()];
        byteBuf.readBytes(bytes);
        body = new String(bytes, "UTF-8");
        HelloMsg msg = new HelloMsg(type, length, body);
        return msg;
    }
}
