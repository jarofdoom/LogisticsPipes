package net.minecraft.src.buildcraft.krapht;

import net.minecraft.src.ModLoader;
import net.minecraft.src.Packet;

public class ClientProxy {
	public static void sendPacket(Packet packet) {
		ModLoader.getMinecraftInstance().getSendQueue().addToSendQueue(packet);
	}
}
