package com.lucky.game.net;

import com.lucky.game.GameConfiguration;
import io.micrometer.core.instrument.util.NamedThreadFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GameNettyServer {

    GameConfiguration gameConfig;

    String name;
    int port;
    Channel channel;
    ServerBootstrap b;
    EventLoopGroup boss;
    EventLoopGroup work;

    private ChannelInboundHandler handler;

    public GameNettyServer() {
    }

    public GameNettyServer(String name, int port) {
        this.name = name;

        this.port = port;
    }

    public void start() {
        try {
            b = new ServerBootstrap();
            boss = new NioEventLoopGroup(1, new NamedThreadFactory(this.name + "-boss"));
            work = new NioEventLoopGroup(gameConfig.getPoolSize(), new NamedThreadFactory(this.name + "-worker"));
            ChannelFuture future = b.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(handler)
                    .bind(port)
                    .sync();
            channel = future.channel();
        } catch (Exception e) {
            log.error("netty启动 error", e);
        }

        if (log.isInfoEnabled()) {
            log.info("Start SocketServer. name={}, port={}", name, port);
        }
    }

    public void stop() {
        try {
            ChannelFuture close = channel.close();
            close.awaitUninterruptibly();
            if (log.isInfoEnabled()) {
                log.info("Stop SocketServer. name={}, port={}", name, port);
            }
        } finally {
            this.boss.shutdownGracefully();
            this.work.shutdownGracefully();
        }
    }
}
