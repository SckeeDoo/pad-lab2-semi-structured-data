package com.vasile.pad.lab2.models;

import java.net.InetAddress;

public class NodeInfo {
    private InetAddress address;
    private int port;
    private MetaInformation metaInformation;

    public NodeInfo(InetAddress address, int port, MetaInformation metaInformation) {
        this.address = address;
        this.port = port;
        this.metaInformation = metaInformation;
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public MetaInformation getMetaInformation() {
        return metaInformation;
    }

    @Override
    public String toString() {
        return "NodeInfo{" +
                "address=" + address +
                ", port=" + port +
                ", metaInformation=" + metaInformation +
                '}';
    }
}
