import Enums.UnitType;

import java.util.Random;

import static Enums.UnitType.*;

/**
 * @Author: Jun Zhu
 * @Date: 10/29/2022 5:01 PM
 * @Description: map class, contains the size of map which is able to scalable and a 2D unit array
 */
public class Map {

    private Cell boardArray[][];

    private int boardSize;

    public Map(Cell[][] boardArray, int boardSize) {
        this.boardArray = boardArray;
        this.boardSize = boardSize;
        initiateMap();
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    private void initiateMap(){
        Cell[][] boardArray = this.boardArray;
        for(int i=0;i<boardSize*boardSize;i++){
            boardArray[i/boardSize][i%boardSize] = new Cell(Common_Type,null,null);
        }
        Random random = new Random();
        //initiateMap for inaccessible
        for(int i=2;i<boardSize;i+=3){
            for(int j=0;j<boardSize;j++){
                boardArray[j][i].setUnitType(Inaccessible_Type);
            }
        }
        //initiateMap for hero nexus
        for(int i=0;i<boardSize;i++){
            if (!boardArray[boardSize-1][i].getUnitType().equals(Inaccessible_Type)){
                boardArray[boardSize-1][i].setUnitType(Hero_Nexus);
            }
        }
        //initiateMap for monster nexus
        for(int i=0;i<boardSize;i++){
            if (!boardArray[0][i].getUnitType().equals(Inaccessible_Type)){
                boardArray[0][i].setUnitType(Monster_Nexus);
            }
        }
        //initiateMap for Bush
        InitiateRandomArea(boardArray, random, Bush_Type);
        //initiate map for Cave
        InitiateRandomArea(boardArray, random, Cave_Type);
        //initiate map for Koulou
        InitiateRandomArea(boardArray, random, Koulou_Type);
    }

    private void InitiateRandomArea(Cell[][] boardArray, Random random, UnitType unitType) {
        for(int i=0;i<4;i++){
            boolean validRandom = false;
            while(!validRandom){
                int randomNum = random.nextInt(boardSize * boardSize);
                if (boardArray[randomNum/boardSize][randomNum%boardSize].getUnitType().equals(Common_Type)){
                    boardArray[randomNum/boardSize][randomNum%boardSize].setUnitType(unitType);
                    validRandom = true;
                }
            }
        }
    }

    public void printMap(){
        for(int row = 0;row<boardSize;row++){
            for(int col = 0;col<boardSize;col++){
                if(boardArray[row][col].getMonster()!=null && boardArray[row][col].getHero()!=null){
                    System.out.format("\033[%dm%s\033[0m", boardArray[row][col].getUnitType().getTypeNum(), "HM");
                }else if(boardArray[row][col].getMonster()!=null){
                    System.out.format("\033[%dm%s\033[0m", boardArray[row][col].getUnitType().getTypeNum(), "M ");
                }else if(boardArray[row][col].getHero()!=null){
                    System.out.format("\033[%dm%s\033[0m", boardArray[row][col].getUnitType().getTypeNum(), "H ");
                }else{
                    System.out.format("\033[%dm%s\033[0m", boardArray[row][col].getUnitType().getTypeNum(), "  ");
                }
            }
            System.out.println();
        }
    }

    public Cell[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(Cell[][] boardArray) {
        this.boardArray = boardArray;
    }

}
