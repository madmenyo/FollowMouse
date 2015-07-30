package net.madmenyo.gridtest.Follow;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Menno Gouw on 30/7/2015.
 * I created this to show how rotation and positioning is done with Vectors
 */
public class FollowScreen implements Screen {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Arrow arrow;

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        arrow = new Arrow();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        //get mouse position
        Vector3 mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

        System.out.println(Gdx.input.getX());

        //transform it to world/camera
        camera.unproject(mousePosition);

        //set batch projection to camera
        batch.setProjectionMatrix(camera.combined);
        //update arrow
        arrow.update(batch, new Vector2(mousePosition.x, mousePosition.y));

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
