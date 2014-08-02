package engine.graphics;

import towerDefense.TowerDefense;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * @author Pavel A Rectangle based on my other Project JBreakout. This Rectangle is based on LWJGL. I tworked once, but now it doesn't
 *         seem to work anymore
 */
public class LibGDXUnfilledRectangle extends LibGDXRectangle {

	public LibGDXUnfilledRectangle(float width, float height, Color color) {
		super(width, height, color);
	}

	public LibGDXUnfilledRectangle(float width, float height) {
		super(width, height);
	}

	public LibGDXUnfilledRectangle(float width, float height, float r, float g, float b) {
		super(width, height, r, g, b);
	}

	@Override
	public void draw(float x, float y, float globalScale, SpriteBatch batch) {
		batch.end();

		float scaling = globalScale;
		y = TowerDefense.getHeight() - y; // sets coordinate System from up - right to down - right
		y = y - this.height * scaling; // sets picture anchor to top left corner instead of bottom left
		// this.graphics.draw(new Rectangle(x, y, this.width * globalScale, this.height * globalScale), new GradientFill(0, 0,
		// this.color, this.width * globalScale, this.height * globalScale, this.color));
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, TowerDefense.getWidth(), TowerDefense.getHeight());
		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(this.color.r, this.color.g, this.color.b, 1); // r g b a
		// shapeRenderer.line(x, y, x2, y2);
		shapeRenderer.rect(x, y, this.width * globalScale, this.height * globalScale);
		// shapeRenderer.circle(x, y, radius);
		shapeRenderer.end();
		batch.begin();
	}

}
