package netty.boardcast;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import netty.Constant;

/**
 * Created by kaiscript on 2018/3/4.
 */
public class Monitor {

    private Bootstrap bootstrap;

    public void startMonitor() {
        bootstrap = new Bootstrap();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new LogEventDecoder());
                            pipeline.addLast(new LogEventHandler());
                        }
                    })
                    .localAddress(Constant.PORT);
            Channel channel = bootstrap.bind().syncUninterruptibly().channel();
            System.out.println("Monitor running...");
            channel.closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.startMonitor();
    }

}
