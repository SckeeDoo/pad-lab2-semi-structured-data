package com.vasile.pad.lab2.nodes;

import com.vasile.pad.lab2.proxy.TCPProxyClientImpl;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPNodeImpl implements TCPNode {
    private final static Logger LOGGER = Logger.getLogger(TCPProxyClientImpl.class);
    private ServerSocket server;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public TCPNodeImpl(int port) throws IOException {
        LOGGER.info("TCPNodeIMpl port: " + port);
        server = new ServerSocket(port);
        socket = server.accept(); // locking, waiting for socket to connect

        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        LOGGER.info("Proxy TCP started...");

    }

    @Override
    public byte[] readFromProxy() throws IOException, ClassNotFoundException {
        return (byte[]) objectInputStream.readObject();
    }

    @Override
    public void sendToProxy(byte[] object) throws IOException {
        objectOutputStream.writeObject(object);
    }

    @Override
    public void close() {

    }
}
