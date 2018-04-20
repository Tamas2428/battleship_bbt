package com.matritellabs.utama.helper;
import java.util.*;

public abstract class Board {
    private List<List<String>> myBoard = new ArrayList<List<String>>();
    private List<List<String>> enemyBoard = new ArrayList<List<String>>();
    private String nameOfThePlayer;

    public Board(String inputNameOfThePlayer) {
        nameOfThePlayer = inputNameOfThePlayer;
    }

    public List<List<String>> getMyBoard() {
        return myBoard;
    }

    public void setMyBoard(List<List<String>> myBoard) {
        this.myBoard = myBoard;
    }

    public List<List<String>> getEnemyBoard() {
        return enemyBoard;
    }

    public void setEnemyBoard(List<List<String>> enemyBoard) {
        this.enemyBoard = enemyBoard;
    }

    public String getNameOfThePlayer() {
        return nameOfThePlayer;
    }
}
