package com.matritellabs.utama.helper;

public class Main {
    public static void main(String[] args) {

        Player1Board myPB1Board = new Player1Board("PlayerOne");
        myPB1Board.boardBuilder(10);
        myPB1Board.hitTheTarget(3,4);
        System.out.println(myPB1Board.getEnemyBoard());

        Battleship hajoka = new Battleship();
        Battleship hajoka2 = new Battleship();


        myPB1Board.setShips(5,7,hajoka,"up");
        myPB1Board.setShips(8,7,hajoka2,"up");


        myPB1Board.boardPrinter();
    }
}
