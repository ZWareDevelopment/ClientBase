package dev.zihasz.client.feature.traits;

import java.awt.*;

public interface IDraggable {

	boolean isDrag();
	void setDrag(boolean drag);
	Point getDragPos();
	void setDragPos(Point dragPos);

}
