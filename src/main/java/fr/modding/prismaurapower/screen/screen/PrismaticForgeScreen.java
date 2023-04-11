package fr.modding.prismaurapower.screen.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import fr.modding.prismaurapower.PrismauraPower;
import fr.modding.prismaurapower.screen.menu.PrismaticForgeMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class PrismaticForgeScreen extends AbstractContainerScreen<PrismaticForgeMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(PrismauraPower.MOD_ID, "textures/gui/prismatic_forge.png");

    public PrismaticForgeScreen(PrismaticForgeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);

        this.imageWidth = 192;
        this.imageHeight = 217;

        this.inventoryLabelX = 14;
        this.inventoryLabelY = 125;
    }

    @Override
    protected void renderBg(@NotNull PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if (menu.isCrafting()) {
            this.blit(pPoseStack, x + 162, y + 52, 193, 0, 11, menu.getScaledProgress());
        }
    }

    @Override
    public void render(@NotNull PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
