package netty.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by kaiscript on 2018/2/25.
 */
public class BaseClientHandler extends ChannelInboundHandlerAdapter {

    private byte[] req; //client bytes较多，一次发送不完，发多次。server需要进行黏包处理
    private byte[] req1;//client bytes较少，进行黏包后再发送给server。server需要进行拆包处理
    private int counter;

    public BaseClientHandler() {
        req = ("at sun.nio.ch.SocketDispatcher.read0(Native Method)\n" +
                "\tat sun.nio.ch.SocketDispatcher.read(SocketDispatcher.java:43)\n" +
                "\tat sun.nio.ch.IOUtil.readIntoNativeBuffer(IOUtil.java:223)\n" +
                "\tat sun.nio.ch.IOUtil.read(IOUtil.java:192)\n" +
                "\tat sun.nio.ch.SocketChannelImpl.read(SocketChannelImpl.java:380)\n" +
                "\tat io.netty.buffer.UnpooledUnsafeDirectByteBuf.setBytes(UnpooledUnsafeDirectByteBuf.java:446)\n" +
                "\tat io.netty.buffer.AbstractByteBuf.writeBytes(AbstractByteBuf.java:879)\n" +
                "\tat io.netty.channel.socket.nio.NioSocketChannel.doReadBytes(NioSocketChannel.java:225)\n" +
                "\tat io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:114)\n" +
                "\tat io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:511)\n" +
                "\tat io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:468)\n" +
                "\tat io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:382)\n" +
                "\tat io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:354)\n" +
                "\tat io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:116)\n" +
                "\tat io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:137)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)").getBytes();

        req1 = "test".getBytes();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ByteBuf message = null;
//        message = Unpooled.buffer(req.length);
//        message.writeBytes(req);
//        ctx.writeAndFlush(message);

        for (int i = 0; i < 100; i++) {
            ByteBuf msg = Unpooled.buffer(req1.length);
            msg.writeBytes(req1);
            ctx.write(msg);
        }
        ctx.flush();
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String buf = (String) msg;
        System.out.println("now buffer:" + buf);
        System.out.println("counter:" + ++counter);
    }
}
