package com.matritellabs.utama.helper;

public class Main {
    public static void main(String[] args) {

        Player1Board myPB1Board = new Player1Board("PlayerOne");
        myPB1Board.boardBuilder(10);
        myPB1Board.hitTheTarget(3,4);
        System.out.println(myPB1Board.getEnemyBoard());

        myPB1Board.setShips(2,5,hajoka,"down");

        myPB1Board.boardPrinter();
    }
}
