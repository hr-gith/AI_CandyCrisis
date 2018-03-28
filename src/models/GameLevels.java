package models;

import utilities.FileOps;

import java.util.ArrayList;
import java.util.Iterator;

public class GameLevels {
    private ArrayList<GameLevel>  listOfLevels;

    public ArrayList<GameLevel> getListOfLevels() {
        return listOfLevels;
    }

    private void setListOfLevels() {
        listOfLevels = new ArrayList<>();
        ArrayList<String> gameConfigs=FileOps.readFile();
        Iterator<String >gameStringIterator=gameConfigs.iterator();
        while(gameStringIterator.hasNext()){
            //TO-DO: get difficulty from file
            int dificulty = 1;
            String gameConfig=gameStringIterator.next();
            //System.out.println("Game Config : "+gameConfig);
            String[] characters=  gameConfig.split(" ");
            listOfLevels.add(new GameLevel(characters,dificulty ));
        }
        this.listOfLevels = listOfLevels;
    }

    public GameLevels() {
        this.setListOfLevels();
    }
}
