package com.logicorp.games.Minesweeper.utils;

import com.logicorp.games.Minesweeper.Main;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Configuration {

    public static final Properties setting = new Properties();

    static {
        try {
            setting.load(Main.class.getResourceAsStream("resources/config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getTileWidth(){
        return Integer.parseInt(setting.get("TILE_WIDTH").toString());
    }
    
    public static int getTileHeight(){
        return Integer.parseInt(setting.get("TILE_WIDTH").toString());
    }
    
    public static String getBackgroundStyle(){
        return setting.getProperty("SQUARE_BACKGROUD_COLOR");
    }

    public static String getMinedStyle() {
        return setting.getProperty("MINED_BACKGROUD_COLOR");
    }
}
