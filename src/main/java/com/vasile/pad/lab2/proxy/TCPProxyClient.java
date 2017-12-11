package com.vasile.pad.lab2.proxy;

import java.io.IOException;

public interface TCPProxyClient {
    byte[] readFromClient() throws IOException, ClassNotFoundException;
    void sendToClient(byte[] object) throws IOException;
    void close();
}
