package netty.boardcast;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import netty.Constant;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * Created by kaiscript on 2018/3/4.
 */
public class Broadcaster {

    private Bootstrap bootstrap;

    private void startBroadcast(int port) {
        try {
            InetSocketAddress address = new InetSocketAddress("255.255.255.255",Constant.PORT);
            EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
            bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .option(ChannelOption.SO_BROADCAST,true)
                    .channel(NioDatagramChannel.class)
                    .handler(new LogEventEncoder(address));
            Channel channel = bootstrap.bind(port).syncUninterruptibly().channel();
            for (;;){
                channel.writeAndFlush(new LogEvent(address, "test", "hello"));
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Broadcaster broadcaster = new Broadcaster();
        broadcaster.startBroadcast(Constant.PORT);
    }

}
