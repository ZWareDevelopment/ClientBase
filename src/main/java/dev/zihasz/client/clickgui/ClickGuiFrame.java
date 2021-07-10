package dev.zihasz.client.clickgui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author krnl
 */

public class ClickGuiFrame {

    // Scale X Y.
    public int y;
    public int x;

    // Main scaling.
    public int width;
    public int height;

    // Mouse Drag.
    public int mouseDragY;
    public int mouseDragX;
    public boolean mouseIsdragging;

    // Mouse Hover.
    public int hovered;

    // Open
    public int open;

    // For the constructor.
    public String name;

    // ModHeight.
    public int modheight;

    public ArrayList<Button> buttons; // not done yet since zihasz hasnt written the module manager.

    public ClickGuiFrame(String name, int x, int y, int width, int modheight) { // main constructor dont add anything else in here u goblin.
       this.name = name;
       this.x = x;
       this.y = y;
       this.modheight = modheight;
       this.width = width;

    }
    public void onUpdate(int mouseX,int mouseY) {
       if(mouseIsdragging) {
           x = mouseX - mouseDragX;
           y = mouseY - mouseDragY;
       }
    }
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Gui.drawRect(x, y,x + width,y + modheight,0x70010101);
        Minecraft mc = Minecraft.getMinecraft();
        mc.fontRenderer.drawStringWithShadow(name,x +2,y +2,-1); // draws the category text.
    }
    public void keyTyped(char typedChar, int keyCode) throws IOException {
    }
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if(mouseButton == 0) {
            if(bounding(mouseX,mouseY)) {
                mouseIsdragging = true;
                this.mouseDragX = mouseX - x;
                this.mouseDragY = mouseY - y;
            }
        }
    }
    public void mouseReleased(int mouseX, int mouseY, int state)  {
        mouseIsdragging = false;
    }
    public boolean bounding(int mouseX, int mouseY) {
        if(mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + modheight) {
            return true;
        }else
            return false;
    }
}
