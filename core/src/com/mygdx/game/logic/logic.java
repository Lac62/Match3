package com.mygdx.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.registry.registry;

import java.util.ArrayList;

/**
 * Created by rcarpenter on 12/21/2017.
 */

public class logic {

    public registry reg;
    public Vector3 mouse_position = new Vector3(0,0,0);
    public int clickDelayCounter = 0;
    public int getClickDelayCounterLength = 15;

    public void update() {

        mouse_position.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        reg.camera.unproject(mouse_position);
        mouse_position.x += reg.windowWidth / 2;
        mouse_position.y += reg.windowHieght / 2;

        System.out.println("Mouse Position: " + mouse_position.x + " " + mouse_position.y);
        clickDelayCounter++;
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            if (clickDelayCounter > getClickDelayCounterLength) {
                for (int i = 0; i < reg.tiles.length; i++) {
                    for (int j = 0; j < reg.tiles.length; j++) {

                        if ((mouse_position.x > reg.tiles[i][j].x) && (mouse_position.x < reg.tiles[i][j].x + 64) && (mouse_position.y > reg.tiles[i][j].y) && (mouse_position.y < reg.tiles[i][j].y + 64)) {
                            reg.tiles[i][j].type = 0;

                            clickDelayCounter = 0;
                        }
                    }
                }
            }
        }

    }
}
