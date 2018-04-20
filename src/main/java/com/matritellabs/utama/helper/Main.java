package com.matritellabs.utama.helper;

public class Main {
    public static void main(String[] args) {
        Player1Board myPB1Board = new Player1Board("PlayerOne");
        //myPB1Board.boardBuilder(10);
        //myPB1Board.boardPrinter();
        myPB1Board.boardBuilder(10);
        System.out.println(myPB1Board.getEnemyBoard());
        System.out.println(myPB1Board.getMyBoard());
        myPB1Board.boardPrinter();
    }
}
