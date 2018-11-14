package netty.heart.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import netty.Constant;

import java.util.concurrent.TimeUnit;


/**
 * Created by kaiscript on 2018/3/1.
 */
@ChannelHandler.Sharable
public class ConnectWatch extends ChannelInboundHandlerAdapter implements ChannelHandlerHolder,TimerTask {

    private int attempts;
    private volatile boolean reconnect = true;
    private final Bootstrap bootstrap;
    private final Timer timer;

    public ConnectWatch(Bootstrap bootstrap, Timer timer) {
        this.bootstrap = bootstrap;
        this.timer = timer;
    }

    @Override
    public ChannelHandler[] handlers() {
        return new ChannelHandler[0];
    }

    @Override
    public void run(Timeout timeout) throws Exception {
        ChannelFuture future;
        synchronized (bootstrap){
            bootstrap.handler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(handlers());
                }
            });
            future = bootstrap.connect(Constant.HOST, Constant.PORT);
        }
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                boolean success = future.isSuccess();
                if (success) {
                    System.out.println("重连成功");
                }
                else {
                    System.out.println("重连失败");
                    future.channel().pipeline().fireChannelInactive();
                }
            }
        });
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("链路被激活,，重新尝试次数重置为0");
        attempts = 0;
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("链路关闭");
        if (reconnect) {
            System.out.println("链路关闭，将进行重连");
            if(attempts< 12){
                attempts++;
                int timeout = 2 << attempts;
                timer.newTimeout(this, timeout, TimeUnit.MILLISECONDS);
            }

        }
        ctx.fireChannelInactive();
    }
}
