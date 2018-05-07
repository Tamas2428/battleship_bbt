package com.matritellabs.utama.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Player1Board myPB1Board = new Player1Board("PlayerOne");
        myPB1Board.boardBuilder(10);


        Player2Board myPB2Board = new Player2Board("PlayerTwo");
        myPB2Board.boardBuilder(10);

        List<String> listOfShips = new ArrayList<>();
        List<String> listOfShips2 = new ArrayList<>();


//        listOfShips.add("carrier");
//        listOfShips.add("cruiser");
        listOfShips.add("destroyer");
//        listOfShips.add("submarine");
//        listOfShips.add("battleship");

//        listOfShips2.add("carrier");
//        listOfShips2.add("cruiser");
        listOfShips2.add("destroyer");
//        listOfShips2.add("submarine");
//        listOfShips2.add("battleship");

        System.out.println(" ");
        LineByLineReader lblReader = new LineByLineReader();

        String rownumber;
        String columnumber;
        String shiptype;
        String toRead;

        System.out.println("Welcome to the Battleship");
        System.out.println("______       _   _   _           _     _       \n" +
                "| ___ \\     | | | | | |         | |   (_)      \n" +
                "| |_/ / __ _| |_| |_| | ___  ___| |__  _ _ __  \n" +
                "| ___ \\/ _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\ \n" +
                "| |_/ / (_| | |_| |_| |  __/\\__ \\ | | | | |_) |\n" +
                "\\____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/ \n" +
                "                                        | |    \n" +
                "                                        |_|  TM");
        System.out.println("Please use only lowercase letters");
        while (!listOfShips.isEmpty()) {
            System.out.println(" ");
            myPB1Board.boardPrinter();
            System.out.println(" ");
            System.out.println("PLAYER1 available ship types : ");
            System.out.println(listOfShips);
            System.out.println("PLAYER1 : type row letter");
            rownumber = lblReader.readLineFromStdIn();
            System.out.println("PLAYER1 : type column number");
            columnumber = lblReader.readLineFromStdIn();

            System.out.println(" ");
            System.out.println("PLAYER1 :  type ship type");
            System.out.println("PLAYER1 available ship types : ");
            System.out.println(listOfShips);
            shiptype = lblReader.readLineFromStdIn();


            System.out.println("PLAYER1 :  type direction");
            toRead = lblReader.readLineFromStdIn();
            System.out.println(" ");

            if (listOfShips.contains(shiptype) && (toRead.equals("right") || toRead.equals("left") || toRead.equals("up") || toRead.equals("down"))) {
                if (!myPB1Board.setShips(rownumber, Integer.parseInt(columnumber), shiptype, toRead)
                        ) {
                    listOfShips.remove(shiptype);
                }
            } else {
                System.out.println("wrong parameters");
            }
            myPB1Board.boardPrinter();
            String ready = lblReader.readLineFromStdIn();
            for (int i = 0; i < 50; i++) {
                System.out.println(" ");
            }
        }
//        clears the screen for the other player
        String ready = lblReader.readLineFromStdIn();
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }
        System.out.println("Press enter if you are the other player");
        ready = lblReader.readLineFromStdIn();


        while (!listOfShips2.isEmpty()) {
            System.out.println(" ");
            myPB2Board.boardPrinter();
            System.out.println(" ");
            System.out.println("PLAYER2 available ship types : ");
            System.out.println(listOfShips2);
            System.out.println("PLAYER2 : type row letter");
            rownumber = lblReader.readLineFromStdIn();
            System.out.println("PLAYER2 : type column number");
            columnumber = lblReader.readLineFromStdIn();

            System.out.println(" ");
            System.out.println("PLAYER2 :  type ship type");
            System.out.println("PLAYER2 available ship types : ");
            System.out.println(listOfShips2);
            shiptype = lblReader.readLineFromStdIn();


            System.out.println("PLAYER2 :  type direction");
            toRead = lblReader.readLineFromStdIn();
            System.out.println(" ");

            if (listOfShips2.contains(shiptype) && (toRead.equals("right") || toRead.equals("left") || toRead.equals("up") || toRead.equals("down"))) {
                if (!myPB2Board.setShips(rownumber, Integer.parseInt(columnumber), shiptype, toRead)
                        ) {
                    listOfShips2.remove(shiptype);
                }
            } else {
                System.out.println("wrong parameters");
            }
        }
        myPB2Board.boardPrinter();
        ready = lblReader.readLineFromStdIn();
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }


        ready = lblReader.readLineFromStdIn();
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }
        System.out.println("Press enter if you are the other player");
        ready = lblReader.readLineFromStdIn();


        while (myPB1Board.checkEndOfGame(myPB1Board.getMyBoard(), myPB2Board.getMyBoard())) {
            boolean succesfulHit = false;
            while (!succesfulHit) {

                System.out.println("Let's destroy the enemy board, put some coordinates here: ");
                System.out.println(" ");
                System.out.println(" ");
                myPB1Board.boardPrinter();

                System.out.println(" ");
                System.out.println(" ");


                System.out.println("PLAYER1 : type row letter");
                rownumber = lblReader.readLineFromStdIn();
                System.out.println("PLAYER1 : type column number");
                columnumber = lblReader.readLineFromStdIn();

                try {

                    if (myPB1Board.hitTheTarget(rownumber, Integer.parseInt(columnumber), myPB2Board.getMyBoard(), myPB1Board.getEnemyBoard(), myPB2Board.getMyBoard())) {
                        succesfulHit = false;
                        ready = lblReader.readLineFromStdIn();
                        System.out.println("Choose an other coordinate.");
                        System.out.println(" ");
                    } else {
                        succesfulHit = true;
                        myPB1Board.boardPrinter();
                        ready = lblReader.readLineFromStdIn();

                        for (int i = 0; i < 50; i++) {
                            System.out.println(" ");
                        }
                        System.out.println("Press enter if you are the other player");
                        ready = lblReader.readLineFromStdIn();
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong coordinates");
                    ready = lblReader.readLineFromStdIn();
                }
            }

            succesfulHit = false;
            while (!succesfulHit) {
                System.out.println("Let's destroy the enemy board, put some coordinates here: ");
                System.out.println(" ");
                System.out.println(" ");
                myPB2Board.boardPrinter();

                System.out.println(" ");
                System.out.println(" ");


                System.out.println("PLAYER2 : type row letter");
                rownumber = lblReader.readLineFromStdIn();
                System.out.println("PLAYER2 : type column number");
                columnumber = lblReader.readLineFromStdIn();

                if (myPB2Board.hitTheTarget(rownumber, Integer.parseInt(columnumber), myPB1Board.getMyBoard(), myPB2Board.getEnemyBoard(), myPB1Board.getMyBoard())) {
                    succesfulHit = false;
                } else {
                    succesfulHit = true;
                    myPB2Board.boardPrinter();
                    ready = lblReader.readLineFromStdIn();

                    for (int i = 0; i < 50; i++) {
                        System.out.println(" ");

                    }
                    System.out.println("Press enter if you are the other player");
                    ready = lblReader.readLineFromStdIn();
                }

            }
        }
    }
}
