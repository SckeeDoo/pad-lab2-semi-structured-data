package com.vasile.pad.lab2.proxy;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPProxyNodeImpl implements TCPProxyNode {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public TCPProxyNodeImpl(String proxyName, int proxyPort) throws IOException {
        LOGGER.info("address: " + proxyName + ", port: " + proxyPort);
        socket = new Socket(proxyName, proxyPort);
        LOGGER.info("tot zaebisi");
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        LOGGER.info("Client TCP started...");
    }

    @Override
    public void sendToNode(byte[] object) throws IOException {
        objectOutputStream.writeObject(object);
    }

    @Override
    public byte[] readFromNode() throws IOException, ClassNotFoundException {
        return (byte[]) objectInputStream.readObject();
    }

    public void close() throws IOException {
        socket.close();
    }
}
