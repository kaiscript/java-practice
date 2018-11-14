package netty.heart.client;

import io.netty.channel.ChannelHandler;

/**
 * Created by kaiscript on 2018/3/1.
 */
public interface ChannelHandlerHolder {

    abstract ChannelHandler[] handlers();

}
