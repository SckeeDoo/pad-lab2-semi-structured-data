package com.vasile.pad.lab2.nodes;

import com.vasile.pad.lab2.models.ProxyCommand;

import java.io.IOException;
import java.net.InetAddress;

public interface MulticastNode {
    void close() throws IOException;
    ProxyCommand readFromProxy() throws IOException;
    InetAddress getProxyAddress();
    int getProxyPort();
}
