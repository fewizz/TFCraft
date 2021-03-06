package com.bioxx.tfc.GUI;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.bioxx.tfc.Reference;
import com.bioxx.tfc.Containers.ContainerQuern;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Core.Player.PlayerInventory;
import com.bioxx.tfc.TileEntities.TileEntityQuern;

public class GuiQuern extends GuiContainer
{
	TileEntityQuern table;

	public GuiQuern(InventoryPlayer inventoryplayer, TileEntityQuern wb, World world, int i, int j, int k)
	{
		super(new ContainerQuern(inventoryplayer, wb, world, i, j, k));
		table = wb;
		xSize = 176;
		ySize = 85 + PlayerInventory.invYSize;
	}

	@Override
	public void onGuiClosed()
	{
		super.onGuiClosed();
	}

	protected void drawGuiContainerForegroundLayer()
	{
		fontRendererObj.drawString(StatCollector.translateToLocal("gui.Inventory"), 8, (ySize - 96) + 2, 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		TFC_Core.bindTexture(new ResourceLocation(Reference.ModID, Reference.AssetPathGui + "gui_quern.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);

		PlayerInventory.drawInventory(this, width, height, ySize - PlayerInventory.invYSize);
	}

	@Override
	public void drawCenteredString(FontRenderer fontrenderer, String s, int i, int j, int k)
	{
		fontrenderer.drawString(s, i - fontrenderer.getStringWidth(s) / 2, j, k);
	}
}
