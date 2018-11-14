package netty.codec;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import netty.Constant;
import netty.hello.HelloServerHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * Created by kaiscript on 2018/2/27.
 */
public class CodecServer {

    public static final int MAX_FRAME_LENGTH = 1024 * 1024;
    public static final int LENGTH_FIELD_OFFSET = 1;
    public static final int LENGTH_FIELD_LENGTH = 4;
    public static final int LENGTH_ADJUSTMENT = 0;
    public static final int INITIAL_BYTES_TO_STRIP = 0;

    public void start() {
        try {
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup group = new NioEventLoopGroup(1);
            ServerBootstrap bootstrap = new ServerBootstrap().group(bossGroup, group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(Constant.PORT))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new HelloDecoder(MAX_FRAME_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH, LENGTH_ADJUSTMENT, INITIAL_BYTES_TO_STRIP));
                            ch.pipeline().addLast(new CodecServerHandler());
                            ch.pipeline().addLast(new IdleStateHandler(2, 0, 0, TimeUnit.SECONDS));//2s未收到消息超时
                            ch.pipeline().addLast(new HelloIdleHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = bootstrap.bind(Constant.PORT).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new CodecServer().start();
    }

}
