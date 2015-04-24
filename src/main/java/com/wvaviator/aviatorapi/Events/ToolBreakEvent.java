package com.wvaviator.aviatorapi.Events;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class ToolBreakEvent extends BreakEvent{
	
	private World world;
	private BlockPos pos;
	private IBlockState state;
	private EntityPlayer player;
	private ItemStack itemStack;
	
	public ToolBreakEvent(World world, BlockPos pos, IBlockState state, EntityPlayer player, ItemStack itemStack) {
		super(world, pos, state, player);
		
		this.player = player;
		this.pos = pos;
		this.state = state;
		this.player = player;
		this.itemStack = itemStack;
	}
	
	public ItemStack getTool() {
		return itemStack;
	}
	
	public Item getItem() {
		return itemStack.getItem();
	}
	
	public Block getBlock() {
		return state.getBlock();
	}

}
