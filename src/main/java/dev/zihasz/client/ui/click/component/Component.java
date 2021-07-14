package dev.zihasz.client.ui.click.component;

import java.awt.*;

public interface Component {

	void render(Point mouse);

	void onMouseDown(Point mouse, int mb);

	void onMouseUp(Point mouse, int mb);

	void onKeyTyped(int key, char character);

	void onClosed();

	int height();

}
