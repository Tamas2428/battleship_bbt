package com.matritellabs.utama.helper;
import java.util.*;

public abstract class Board {
    private ArrayList<ArrayList<String>> myBoard = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> enemyBoard = new ArrayList<ArrayList<String>>();
    private String nameOfThePlayer;

    public Board(String inputNameOfThePlayer) {
        nameOfThePlayer = inputNameOfThePlayer;
    }


    public void createNewBoard(int sizeOfTheBoard) {

        ArrayList<String> singleList = new ArrayList<String>();
        for (int i = 0; i <sizeOfTheBoard ; i++) {
            singleList.add("~");
        }
        for (int i = 0; i <sizeOfTheBoard ; i++) {
            myBoard.add(singleList);
            System.out.println(singleList);
        }

        System.out.println(" ");

        for (int i = 0; i <sizeOfTheBoard ; i++) {
            enemyBoard.add(singleList);
            System.out.println(singleList);
        }
    }
    public void boardPrinter(ArrayList<ArrayList<String>> boardToPrint) {

        for (int i = 0; i <boardToPrint.size() ; i++) {

        }
        System.out.println(boardToPrint);


    }

    public ArrayList<ArrayList<String>> getMyBoard() {
        return myBoard;
    }

    public void setMyBoard(ArrayList<ArrayList<String>> myBoard) {
        this.myBoard = myBoard;
    }

    public ArrayList<ArrayList<String>> getEnemyBoard() {
        return enemyBoard;
    }

    public void setEnemyBoard(ArrayList<ArrayList<String>> enemyBoard) {
        this.enemyBoard = enemyBoard;
    }

    public String getNameOfThePlayer() {
        return nameOfThePlayer;
    }


}
