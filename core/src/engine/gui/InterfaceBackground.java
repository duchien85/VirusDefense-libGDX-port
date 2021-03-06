package engine.gui;

import towerDefense.Gameplay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import engine.Drawable;
import engine.graphics.OwnSprite;

public class InterfaceBackground extends GUI implements Drawable {
	private OwnSprite picture;

	public InterfaceBackground(String backgroundPath) {
		super(Gameplay.INTERFACE_START_X, 0);
		this.picture = new OwnSprite(backgroundPath, 1f);
	}

	@Override
	public void draw(SpriteBatch batch) {
		this.picture.draw(this.x, this.y, Gameplay.GLOBAL_GUI_SCALE, batch);

	}

}
