package dev.zihasz.client.clickgui;

import dev.zihasz.client.feature.module.Category;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author krnl
 * @since idk 7:50AM lol
 */

public class ClickGui extends GuiScreen {

    public ArrayList<ClickGuiFrame> frames; // definition of frames.

    public  ClickGui() {
        frames = new ArrayList<>();
        int offset = 0;
        for (Category c : Category.values()) {
            ClickGuiFrame frame = new ClickGuiFrame(c.name(),100 + offset,20,100,12);
            frames.add(frame);
            offset =+ 150;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
       super.drawScreen(mouseX,mouseY,partialTicks);
       for (ClickGuiFrame f : frames) {
           f.onUpdate(mouseX,mouseY);
       }
    }
    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar,keyCode);
        for (ClickGuiFrame f : frames) {
            f.keyTyped(typedChar,keyCode);
        }
    }
    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX,mouseY,mouseButton);
        for (ClickGuiFrame f : frames) {
            f.mouseClicked(mouseX,mouseY,mouseButton);
        }
    }
    @Override
    public void mouseReleased(int mouseX, int mouseY, int state)  {
        super.mouseReleased(mouseX,mouseY,state);
        for (ClickGuiFrame f : frames) {
            f.mouseReleased(mouseX,mouseY,state);
        }
    }
    @Override
    public boolean doesGuiPauseGame() {
        return super.doesGuiPauseGame();
    }
}
