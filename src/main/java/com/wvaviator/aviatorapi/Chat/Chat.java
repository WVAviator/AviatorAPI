package com.wvaviator.aviatorapi.Chat;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class Chat {
	
	public static void sendChat(ICommandSender sender, String message) {
		if (sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			sendChat(player, message);
		}
		
		ChatComponentText text = new ChatComponentText(message);
		sender.addChatMessage(text);
	}
	
	public static void sendChat(EntityPlayer player, String message) {
		
		String[] text = message.split("\\s+");
		String formatted;
		char currentColor = 'f';
		for (String string : text) {
			char[] character = string.toCharArray();
			for (int c = 0; c < character.length; c++) {
				if (character[c] == '&') {
					if (getIsColor(character[c+1])) {
						StringBuilder sb = new StringBuilder(string);
						currentColor = character[c+1];
						sb.deleteCharAt(c);
						sb.deleteCharAt(c+1);
						string = sb.toString();
					}
				}
			}
			
			formatted += getColor(currentColor) + string;
		}
		
	}

	private static EnumChatFormatting getColor(char currentColor) {
		switch (c) {
		case '1': return EnumChatFormatting.DARK_BLUE;
		case '2': return EnumChatFormatting.DARK_GREEN;
		case '3': return EnumChatFormatting.DARK_AQUA;
		case '4': return EnumChatFormatting.DARK_RED;
		case '5': return EnumChatFormatting.DARK_PURPLE;
		case '6': return EnumChatFormatting.GOLD;
		case '7': return EnumChatFormatting.GRAY;
		case '8': return EnumChatFormatting.DARK_GRAY;
		case '9': return EnumChatFormatting.BLUE;
		case '0': return EnumChatFormatting.BLACK;
		case 'a': return EnumChatFormatting.GREEN;
		case 'b': return EnumChatFormatting.AQUA;
		case 'c': return EnumChatFormatting.RED;
		case 'd': return EnumChatFormatting.LIGHT_PURPLE;
		case 'e': return EnumChatFormatting.YELLOW;
		case 'f': return EnumChatFormatting.WHITE;
		case 'l': return EnumChatFormatting.BOLD;
		case 'n': return EnumChatFormatting.UNDERLINE;
		case 'o': return EnumChatFormatting.ITALIC;
		case 'k': return EnumChatFormatting.OBFUSCATED;
		case 'm': return EnumChatFormatting.STRIKETHROUGH;
		case 'r': return EnumChatFormatting.RESET;
		}
	}

	private static boolean getIsColor(char c) {
		switch (c) {
		case '1': return true;
		case '2': return true;
		case '3': return true;
		case '4': return true;
		case '5': return true;
		case '6': return true;
		case '7': return true;
		case '8': return true;
		case '9': return true;
		case '0': return true;
		case 'a': return true;
		case 'b': return true;
		case 'c': return true;
		case 'd': return true;
		case 'e': return true;
		case 'f': return true;
		case 'l': return true;
		case 'n': return true;
		case 'o': return true;
		case 'k': return true;
		case 'm': return true;
		case 'r': return true;
		}
		return false;
	}

}
