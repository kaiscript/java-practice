package netty.heart.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.HashedWheelTimer;
import netty.Constant;

import java.util.concurrent.TimeUnit;

/**
 * Created by kaiscript on 2018/3/4.
 */
public class HeartClient {

    private Bootstrap bootstrap;
    private HashedWheelTimer timer = new HashedWheelTimer();

    public void connect(String host,int port) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO));

        ConnectWatch watch = new ConnectWatch(bootstrap,timer){
            @Override
            public ChannelHandler[] handlers() {
                return new ChannelHandler[]{
                    this,
                        new IdleStateHandler(0,4,0, TimeUnit.SECONDS),
                        new ConnectIdleStateTrigger(),
                        new StringDecoder(),
                        new StringEncoder(),
                        new HeartClientHandler()
                };
            }
        };
        ChannelFuture future;
        synchronized (bootstrap){
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(watch.handlers());
                }
            });
            future = bootstrap.connect(host, port);
        }
        future.sync();

    }

    public static void main(String[] args) {
        try {
            new HeartClient().connect(Constant.HOST, Constant.PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
