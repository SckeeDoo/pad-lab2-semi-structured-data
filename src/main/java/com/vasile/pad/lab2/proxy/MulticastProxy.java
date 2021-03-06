package com.vasile.pad.lab2.proxy;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MulticastProxy {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private InetAddress mcIPAddress;
    private int mcPort;
    private DatagramSocket udpSocket;

    public MulticastProxy(DatagramSocket udpSocket, String mcAddress, int mcPort) throws UnknownHostException {
         mcIPAddress = InetAddress.getByName(mcAddress);
         this.mcPort = mcPort;
         this.udpSocket =  udpSocket;
         LOGGER.info("Started multicast udp server...");
    }

    public void sendToNodes(byte[] message) throws IOException {
        DatagramPacket packet = new DatagramPacket(message, message.length, mcIPAddress, mcPort);
        udpSocket.send(packet);
    }
}
