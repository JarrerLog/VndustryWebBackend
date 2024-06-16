package com.vndustrybackend.vndustrybackend.Handlers;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.TimerTask;
import java.util.function.Consumer;

import arc.util.Strings;
import arc.util.Timer;
import mindustry.net.Host;
import mindustry.net.NetworkIO;

public class ServerHandler {
    public static void pingServer(String ip, Consumer<Host> listener) {

        try {
            String resultIP = ip;
            int port = 6567;
            if (ip.contains(":") && Strings.canParsePositiveInt(ip.split(":")[1])) {
                resultIP = ip.split(":")[0];
                port = Strings.parseInt(ip.split(":")[1]);
            }

            DatagramSocket socket = new DatagramSocket();
            socket.send(new DatagramPacket(new byte[] { -2, 1 }, 2, InetAddress.getByName(resultIP), port));

            socket.setSoTimeout(2000);

            DatagramPacket packet = new DatagramPacket(new byte[256], 256);

            long start = System.currentTimeMillis();
            socket.receive(packet);

            ByteBuffer buffer = ByteBuffer.wrap(packet.getData());
            listener.accept(readServerData(buffer, ip, (int) (System.currentTimeMillis() - start)));
            socket.disconnect();
        } catch (Exception e) {
            listener.accept(new Host(0, null, ip, null, 0, 0, 0, null, null, 0, null, null));
        }

    }

    public static Host readServerData(ByteBuffer buffer, String ip, int ping) {
        Host host = NetworkIO.readServerData(ping, ip, buffer);
        host.ping = ping;
        return host;
        // return new PingResult(ip, ping, players + "", host, map, wave + "", version
        // == -1 ? "Custom Build" : (""+version));
    }
}
