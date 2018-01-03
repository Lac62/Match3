package com.mygdx.game.registry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.draw.draw;
import com.mygdx.game.enitities.Tile;
import com.mygdx.game.logic.logic;

/**
 * Created by rcarpenter on 12/19/2017.
 */

public class registry {
    //Window Information
    public String windowName = "Match 3 Game";
    public int windowWidth = 1000;
    public int windowHieght = 1000;
    public OrthographicCamera camera;
    public StretchViewport viewport;
    //Tiles
    public Tile[][] tiles;


    //Classes
    public draw draw;
    public logic logic;

    public registry(){

        //Window Information
        Gdx.graphics.setTitle(windowName);
        Gdx.graphics.setWindowedMode(windowWidth, windowHieght);
        camera = new OrthographicCamera(windowWidth, windowHieght);
        viewport = new StretchViewport(windowWidth, windowHieght, camera);
        viewport.apply();
        //initialize classes
        draw = new draw();
        draw.reg = this;
        logic = new logic();
        logic.reg = this;

        //Setup Tiles
        tiles = new Tile[7][7];
        for (int i = 0; i < tiles.length; i++){
            for (int j = 0; j < tiles.length; j++){
                Tile newTile = new Tile(MathUtils.random(0,6), (i * 64) , (j * 64) );
                tiles[i][j] = newTile;

            }
        }
    }


}
