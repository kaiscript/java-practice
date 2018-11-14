package netty.heartBeat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * Created by kaiscript on 2018/3/1.
 */
public class HeartbeatClient {

    public static void main(String[] args) {
        new HeartbeatClient().connect();
    }

    public void connect() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast("ping", new IdleStateHandler(0, 2, 0, TimeUnit.SECONDS));
                            p.addLast("decoder", new StringDecoder());
                            p.addLast("encoder", new StringEncoder());
                            p.addLast(new HeartBeatClientHandler());
                        }
                    });
            ChannelFuture future = b.connect("127.0.0.1", 8888).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
//            group.shutdownGracefully();//关闭连接
            System.out.println("try to connect");
            connect();
            System.out.println("connect");
        }
    }


}
