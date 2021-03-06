package com.vasile.pad.lab2.proxy;

import java.io.IOException;

public interface TCPProxyNode {
    void sendToNode(byte[] obj) throws IOException;
    byte[] readFromNode() throws IOException, ClassNotFoundException;
    void close() throws IOException;
}
