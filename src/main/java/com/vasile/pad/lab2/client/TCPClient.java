package com.vasile.pad.lab2.client;

import java.io.IOException;

public interface TCPClient {
    void sendToProxy(byte[] obj) throws IOException;
    byte[] readFromProxy() throws IOException, ClassNotFoundException;
    void close() throws IOException;
}
