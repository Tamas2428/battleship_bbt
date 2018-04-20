package com.matritellabs.utama.helper;

public class Main {

    public static void main(String[] args) {


Player1Board table = new Player1Board("player1");

table.createNewBoard(10);

        System.out.println(table.getEnemyBoard());

    }
}
