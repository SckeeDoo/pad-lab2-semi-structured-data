package com.vasile.pad.lab2.nodes;

import java.io.IOException;

public interface TCPNode {
    byte[] readFromProxy() throws IOException, ClassNotFoundException;
    void sendToProxy(byte[] object) throws IOException;
    void close();
}
