package net.madmenyo.gridtest.Follow;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by Menno Gouw on 30/7/2015.
 * I created this to show how rotation and positioning is done with Vectors
 */
public class Arrow {

    private Texture texture;
    private Vector2 position;

    private float speed = 2;

    /**
     * Creates a arrow to follow the mouse
     */
    public Arrow()
    {
        texture = new Texture("badlogic.jpg");
        //set initial position of this arrow.
        position = new Vector2(0,0);
    }

    /**
     * Gives a Vector 2 representing the centre of the image in world/camera coordinates
     * @return
     */
    private Vector2 getOrigin()
    {
        return new Vector2(position.x + texture.getWidth() / 2, position.y + texture.getHeight() / 2);
    }

    /**
     * Updates and draws the arrow to follow the mouse pointer.
     * @param batch SpriteBatch to draw on
     * @param target The world/camera position of the mouse pointer
     */
    public void update(SpriteBatch batch, Vector2 target)
    {
        //Get direction, here we need to copy the target vector because we want to use it again. Remember..? Chaining.
        Vector2 direction = target.cpy().sub(getOrigin());

        //Normalize the direction so it is exactly 1 long
        direction.nor();

        //Increase the direction by x speed, this is actually called velocity so let's name it correctly
        Vector2 velocity = direction.scl(speed);

        //Calculate angle
        float angle = velocity.angle();

        //Increase the position of the arrow
        position.add(velocity);

        //drawing it using the position and offseting the origin relative to the texture position. In our case the middle.
        batch.begin();
        batch.draw(texture,
                position.x,
                position.y,
                texture.getWidth() / 2,
                texture.getHeight() / 2,
                texture.getWidth(),
                texture.getHeight(),
                1, 1,
                angle,
                0, 0,
                texture.getWidth(),
                texture.getHeight(),
                false, false);
        batch.end();
    }
}
