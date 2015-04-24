package com.wvaviator.aviatorapi.Events.BaseEvents;

import com.wvaviator.aviatorapi.AviatorAPI;
import com.wvaviator.aviatorapi.Events.ToolBreakEvent;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakHandler {
	
	@SubscribeEvent
	public void onBlockBreak(BreakEvent e) {
		
		EntityPlayer player = e.getPlayer();
		IBlockState state = e.state;
		World world = e.world;
		BlockPos pos = e.pos;
		ItemStack itemStack = player.getItemInUse();
		
		if (itemStack.getItem().isItemTool(itemStack)) {
			if (AviatorAPI.EVENT_BUS.post(new ToolBreakEvent(world, pos, state, player, itemStack))) {
				
			}
		}
		
	}

}
