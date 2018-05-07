package com.matritellabs.utama.helper;

import sun.security.krb5.internal.crypto.Des;

import java.io.IOException;
import java.util.*;

public abstract class Board {
    private List<List<String>> myBoard = new ArrayList<List<String>>();
    private List<List<String>> enemyBoard = new ArrayList<List<String>>();
    private String nameOfThePlayer;


    public Board(String inputNameOfThePlayer) {
        nameOfThePlayer = inputNameOfThePlayer;
    }

    //hit target method
    public boolean hitTheTarget(String srowNumber, int columnNumber, List<List<String>> enemyBoard, List<List<String>> myenemyBoard, List<List<String>> otherPlayerBoard) {

        boolean thrown = false;
        int rowNumber = rowTranslater(srowNumber);
        rowNumber = rowNumber - 1;
        columnNumber = columnNumber - 1;
        try {
            if (enemyBoard.get(rowNumber).get(columnNumber).equals("O")) {
                thrown = false;
            }
        } catch (IndexOutOfBoundsException | NumberFormatException ioobe) {
            thrown = true;
        }
        if (!thrown) {
            if (enemyBoard.get(rowNumber).get(columnNumber).equals("O")) {
                myenemyBoard.get(rowNumber).set(columnNumber, "X");
                otherPlayerBoard.get(rowNumber).set(columnNumber, "X");
            } else {
                myenemyBoard.get(rowNumber).set(columnNumber, "*");
            }
        } else if (thrown) {
            System.out.println("Choose an other coordinate.");
            System.out.println(" ");
        }
        return thrown;
    }

    public boolean checkEndOfGame(List<List<String>> myBoard, List<List<String>> enemyBoard) {
        boolean continueGame = false;
//        boolean continueGameForEnemy = false;
        int containsShipForP1 = 0;
        int containsShipForP2 = 4;

        for (List key : myBoard) {
            if (key.contains("O")) {
                continueGame = true;
                containsShipForP1 = 1;
            }
        }
        if (containsShipForP1 == 0) {
            System.out.println("Player 2 won. Congratulations!");
            continueGame = false;
        }

        if (continueGame) {
            for (List key : enemyBoard) {
                if (key.contains("O")) {
                    continueGame = true;
                    containsShipForP2 = 2;
                }
            }
        }

        if (containsShipForP2 == 4 && continueGame) {
            System.out.println("Player 1 won. Congratulations!");
            continueGame = false;
        }
        return continueGame;
    }


    public void boardBuilder(int inputlistSize) {

        for (int i = 0; i < inputlistSize; i++) {
            this.myBoard.add(new ArrayList<String>());
            for (int j = 0; j < inputlistSize; j++) {
                this.myBoard.get(i).add("~");
            }
        }
        for (int i = 0; i < inputlistSize; i++) {
            enemyBoard.add(new ArrayList<String>());
            for (int j = 0; j < inputlistSize; j++) {
                enemyBoard.get(i).add("~");
            }
        }
    }

    public static int rowTranslater(String x) {

        switch (x) {

            case "a":
                return 1;
            case "b":
                return 2;
            case "c":
                return 3;
            case "d":
                return 4;
            case "e":
                return 5;
            case "f":
                return 6;
            case "g":
                return 7;
            case "h":
                return 8;
            case "i":
                return 9;
            case "j":
                return 10;
            default:
                return 0;
        }
    }

    public void boardPrinter() {
        System.out.println("This is your board");
        System.out.print(" ");
        for (int i = 0; i < this.myBoard.size(); i++) {
            System.out.print(" " + (i + 1));
        }
        for (int i = 0; i < this.myBoard.size(); i++) {
            System.out.println();
            System.out.print((char) ('A' + i));
            for (int j = 0; j < this.myBoard.get(0).size(); j++) {
                System.out.print(" " + this.myBoard.get(i).get(j));
            }
        }

        System.out.println();
        System.out.println("\n This is the enemy's board");
        System.out.print(" ");
        for (int i = 0; i < this.myBoard.size(); i++) {
            System.out.print(" " + (i + 1));
        }
        for (int i = 0; i < enemyBoard.size(); i++) {
            System.out.println();
            System.out.print((char) ('A' + i));
            for (int j = 0; j < enemyBoard.get(0).size(); j++) {
                System.out.print(" " + enemyBoard.get(i).get(j));
            }
        }
    }

    public boolean setShips(String srowNumber, int columnNumber, String typeS, String direction) {

        List<Ship> listOfShips = new ArrayList<>();
        Carrier carrier = new Carrier();
        Cruiser cruiser = new Cruiser();
        Destroyer destroyer = new Destroyer();
        Submarine submarine = new Submarine();
        Battleship battleship = new Battleship();

        listOfShips.add(carrier);
        listOfShips.add(cruiser);
        listOfShips.add(destroyer);
        listOfShips.add(submarine);
        listOfShips.add(battleship);


        int shipNumber = 999;

        if (typeS.equals("carrier")) {
            shipNumber = 0;
        }

        if (typeS.equals("cruiser")) {
            shipNumber = 1;
        }

        if (typeS.equals("destroyer")) {
            shipNumber = 2;

        }
        if (typeS.equals("submarine")) {
            shipNumber = 3;
        }
        if (typeS.equals("battleship")) {
            shipNumber = 4;
        }

        int rowNumber = rowTranslater(srowNumber);
        rowNumber = rowNumber - 1;
        columnNumber = columnNumber - 1;
        boolean thrown = false;


        if (direction.equals("right")) {
            try {
                for (int i = 0; i < listOfShips.get(shipNumber).getSize(); i++) {

                    this.myBoard.get(rowNumber).get(columnNumber + i);
                    if (this.myBoard.get(rowNumber).get(columnNumber + i) == "O") {
                        thrown = true;
                    }

                }
            } catch (IndexOutOfBoundsException ioobe) {
                thrown = true;
            }


            if (!thrown) {
                for (int i = 0; i < listOfShips.get(shipNumber).getSize(); i++) {
                    this.myBoard.get(rowNumber).set(columnNumber + i, "O");
                }
            } else if (thrown) {
                System.out.println("Choose an other coordinate.");
                System.out.println(" ");
            }
        }


        if (direction.equals("left")) {
            try {
                for (int i = 0; i < listOfShips.get(shipNumber).getSize(); i++) {

                    this.myBoard.get(rowNumber).get(columnNumber - i);
                    if (this.myBoard.get(rowNumber).get(columnNumber - i) == "O") {
                        thrown = true;
                    }

                }
            } catch (IndexOutOfBoundsException ioobe) {
                thrown = true;
            }


            if (!thrown) {
                for (int i = 0; i < listOfShips.get(shipNumber).getSize(); i++) {
                    this.myBoard.get(rowNumber).set(columnNumber - i, "O");
                }
            } else if (thrown) {
                System.out.println(" ");
                System.out.println("Choose an other coordinate.");
            }
        }

        if (direction.equals("down")) {
            try {
                for (int i = 0; i < listOfShips.get(shipNumber).getSize(); i++) {

                    this.myBoard.get(rowNumber + i).get(columnNumber);
                    if (this.myBoard.get(rowNumber + i).get(columnNumber) == "O") {
                        thrown = true;
                    }

                }
            } catch (IndexOutOfBoundsException ioobe) {
                thrown = true;
            }


            if (!thrown) {
                for (int i = 0; i < listOfShips.get(shipNumber).getSize(); i++) {
                    this.myBoard.get(rowNumber + i).set(columnNumber, "O");
                }
            } else if (thrown) {
                System.out.println("Choose an other coordinate.");
            }
        }

        if (direction.equals("up")) {
            try {
                for (int i = 0; i < listOfShips.get(shipNumber).getSize(); i++) {

                    this.myBoard.get(rowNumber - i).get(columnNumber);
                    if (this.myBoard.get(rowNumber - i).get(columnNumber) == "O") {
                        thrown = true;
                    }

                }
            } catch (IndexOutOfBoundsException ioobe) {
                thrown = true;
            }


            if (!thrown) {
                for (int i = 0; i < listOfShips.get(shipNumber).getSize(); i++) {
                    this.myBoard.get(rowNumber - i).set(columnNumber, "O");
                }
            } else if (thrown) {
                System.out.println("Choose an other coordinate.");
            }
        }
        return thrown;
    }


    public List<List<String>> getMyBoard() {
        return this.myBoard;
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
