package com.gua.npcnjobs.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.CompletionHandler;

public class MyAIOSocketServer {
    public void aio() {
        try {
            AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(8002));
            new CompletionHandler<AsynchronousServerSocketChannel, Object>() {
                @Override
                public void completed(AsynchronousServerSocketChannel result, Object attachment) {
                    asynchronousServerSocketChannel.accept();
                    while (true){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    }
                }

                @Override
                public void failed(Throwable exc, Object attachment) {

                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
