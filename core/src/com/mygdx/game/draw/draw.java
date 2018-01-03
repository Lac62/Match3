package com.mygdx.game.draw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.registry.registry;

/**
 * Created by rcarpenter on 12/19/2017.
 */

public class draw {
    public registry reg;

    SpriteBatch batch;
    public TextureRegion[] textureRegions;

    public draw() {
        batch = new SpriteBatch();

        textureRegions = new TextureRegion[2000];
        textureRegions[0] = new TextureRegion(new Texture("sprite.png"), 0, 0, 64, 64);
    }

    public void update(){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //Draw Tiles
        for (int i = 0; i < reg.tiles.length; i++) {
            for (int j = 0; j < reg.tiles.length; j++) {
                if (reg.tiles[i][j].type == 0) {
                    batch.setColor(1, 0, 0, 1);
                }
                else if (reg.tiles[i][j].type == 1) {
                    batch.setColor(0, 1, 0, 1);
                }
                else if (reg.tiles[i][j].type == 2) {
                    batch.setColor(0, 0, 1, 1);
                }
                else if (reg.tiles[i][j].type == 3) {
                    batch.setColor(1, 1, 0, 1);
                }
                else if (reg.tiles[i][j].type == 4) {
                    batch.setColor(0, 1, 1, 1);
                }
                else if (reg.tiles[i][j].type == 5) {
                    batch.setColor(1, 0, 1, 1);
                }
                else if (reg.tiles[i][j].type == 6) {
                    batch.setColor(0.5f, 0.5f, 0.5f, 1);
                }
                batch.draw(textureRegions[0], reg.tiles[i][j].x, reg.tiles[i][j].y);

                batch.setColor(1,1,1,1);
            }
        }

        batch.end();
    }

}