package com.vasile.pad.lab2.client;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClientImpl implements TCPClient {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public TCPClientImpl(String proxyName, int proxyPort) throws IOException {
        socket = new Socket(proxyName, proxyPort);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        LOGGER.info("Client TCP started...");
    }

    @Override
    public void sendToProxy(byte[] object) throws IOException {
        objectOutputStream.writeObject(object);
    }

    @Override
    public byte[] readFromProxy() throws IOException, ClassNotFoundException {
        return (byte[]) objectInputStream.readObject();
    }

    public void close() throws IOException {
        socket.close();
    }
}
