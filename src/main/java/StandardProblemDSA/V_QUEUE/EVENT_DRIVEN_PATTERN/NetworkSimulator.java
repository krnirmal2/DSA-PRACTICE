package StandardProblemDSA.V_QUEUE.EVENT_DRIVEN_PATTERN;

import java.util.LinkedList;
import java.util.Queue;

class Packet {
  int packetId;
  String data;

  public Packet(int packetId, String data) {
    this.packetId = packetId;
    this.data = data;
  }
}

class NetworkSimulator {
  private Queue<Packet> packetQueue;

  // ✅ Constructor
  public NetworkSimulator() {
    packetQueue = new LinkedList<>();
  }

  // ✅ Receive Packet
  public void receivePacket(int packetId, String data) {
    packetQueue.add(new Packet(packetId, data));
    System.out.println("Packet " + packetId + " received.");
  }

  // ✅ Transmit Packet
  public void transmitPackets() {
    while (!packetQueue.isEmpty()) {
      Packet packet = packetQueue.poll();
      System.out.println("Transmitting Packet ID: " + packet.packetId + " - Data: " + packet.data);
      try {
        Thread.sleep(300); // Simulate network delay
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("All packets transmitted.");
  }

  public static void main(String[] args) {
    NetworkSimulator network = new NetworkSimulator();
    network.receivePacket(101, "Hello");
    network.receivePacket(102, "How are you?");
    network.receivePacket(103, "Goodbye");

    network.transmitPackets();
  }
} /*
  ✅ Time Complexity:

  O(1) for receiving packets

  O(N) for transmitting packets

  🔹 Dry Run
  Operation	Queue State
  receivePacket(101, "Hello")	[101]
  receivePacket(102, "How are you?")	[101, 102]
  receivePacket(103, "Goodbye")	[101, 102, 103]
  transmitPackets()	Processes: 101 → 102 → 103
  */
