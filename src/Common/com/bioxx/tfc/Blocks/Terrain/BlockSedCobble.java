package com.bioxx.tfc.Blocks.Terrain;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.bioxx.tfc.TFCBlocks;
import com.bioxx.tfc.api.Constant.Global;

public class BlockSedCobble extends BlockCobble
{
	public BlockSedCobble(Material material) {
		super(material);
		names = Global.STONE_SED;
		icons = new IIcon[names.length];
	}

	@Override
	public boolean canFallBelow(World world, int i, int j, int k)
	{
		Block l = world.getBlock(i, j, k);
		if (world.isAirBlock(i, j, k))
			return true;
		if (l == Blocks.fire)
			return true;
		if (l == TFCBlocks.TallGrass)
			return true;
		Material material = l.getMaterial();
		if (material == Material.water)
			return true;
		return material == Material.lava;
	}

	@Override
	public int tickRate(World world)
	{
		return 3;
	}
}
