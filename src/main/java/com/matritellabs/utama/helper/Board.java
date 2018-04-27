package com.matritellabs.utama.helper;

import java.util.*;

public abstract class Board {
    private List<List<String>> myBoard = new ArrayList<List<String>>();
    private List<List<String>> enemyBoard = new ArrayList<List<String>>();
    private String nameOfThePlayer;

    public Board(String inputNameOfThePlayer) {
        nameOfThePlayer = inputNameOfThePlayer;
    }

    //hit target method
    public void hitTheTarget(int rowNumber, int coloumnNumber) {
        if (enemyBoard.get(rowNumber - 1).get(coloumnNumber - 1) == "0")
            enemyBoard.get(rowNumber - 1).set(coloumnNumber - 1, "X");
    }


    //bence - create new board
    public void boardBuilder(int inputlistSize) {

        for (int i = 0; i < inputlistSize; i++) {
            myBoard.add(new ArrayList<String>());
            for (int j = 0; j < inputlistSize; j++) {
                myBoard.get(i).add("~");
            }
        }
        for (int i = 0; i < inputlistSize; i++) {
            enemyBoard.add(new ArrayList<String>());
            for (int j = 0; j < inputlistSize; j++) {
                enemyBoard.get(i).add("~");
            }
        }
    }


    //benyo - create new board
//    public void createNewBoard(int sizeOfTheBoard) {
//        ArrayList<String> singleList = new ArrayList<String>();
//        for (int i = 0; i < sizeOfTheBoard ; i++) {
//            singleList.add("~");
//        }
//        for (int i = 0; i < sizeOfTheBoard ; i++) {
//            myBoard.add(singleList);
//        }
//        for (int i = 0; i < sizeOfTheBoard ; i++) {
//            enemyBoard.add(singleList);
//        }
//
//    }


    //saját - clear board method
    public void clearBoard() {
        for (int i = 0; i < myBoard.size(); i++) {
            for (int j = 0; j < myBoard.get(0).size(); j++) {
                myBoard.get(i).set(j, "0");
            }
        }
        for (int i = 0; i < enemyBoard.size(); i++) {
            for (int j = 0; j < enemyBoard.get(0).size(); j++) {
                enemyBoard.get(i).set(j, "0");
            }
        }
    }

    //Bence - board printer method
    public void boardPrinter() {
        System.out.println("This is your board");
        for (int i = 0; i < myBoard.size(); i++) {
            System.out.println();
            for (int j = 0; j < myBoard.get(0).size(); j++) {
                System.out.print(" " + myBoard.get(i).get(j));
            }
        }
        System.out.println();
        System.out.println("\n This is the enemys board");
        for (int i = 0; i < enemyBoard.size(); i++) {
            System.out.println();
            for (int j = 0; j < enemyBoard.get(0).size(); j++) {
                System.out.print(" " + enemyBoard.get(i).get(j));
            }
        }
    }

    public void setShips(int rowNumber, int columnNumber, Ship type, String direction) {

        rowNumber = rowNumber - 1;
        columnNumber = columnNumber - 1;
        List<Integer> rowCoordinates = new ArrayList<>();
        List<Integer> columnCoordinates = new ArrayList<>();
        boolean thrown = false;


        if (direction.equals("right")) {
            try {
                for (int i = 0; i < type.getSize(); i++) {

                    myBoard.get(rowNumber).get(columnNumber + i);
                    if (myBoard.get(rowNumber).get(columnNumber + i) == "O") {
                        thrown = true;
                    }

                }
            } catch (IndexOutOfBoundsException ioobe) {
                thrown = true;
            }


            if (!thrown) {
                for (int i = 0; i < type.getSize(); i++) {
                    myBoard.get(rowNumber).set(columnNumber + i, "O");
                }
            } else if (thrown) {
                System.out.println("Choose an other coordinate.");
            }
        }


        if (direction.equals("left")) {
            try {
                for (int i = 0; i < type.getSize(); i++) {

                    myBoard.get(rowNumber).get(columnNumber - i);
                    if (myBoard.get(rowNumber).get(columnNumber - i) == "O") {
                        thrown = true;
                    }

                }
            } catch (IndexOutOfBoundsException ioobe) {
                thrown = true;
            }


            if (!thrown) {
                for (int i = 0; i < type.getSize(); i++) {
                    myBoard.get(rowNumber).set(columnNumber - i, "O");
                }
            } else if (thrown) {
                System.out.println("Choose an other coordinate.");
            }
        }

        if (direction.equals("down")) {
            try {
                for (int i = 0; i < type.getSize(); i++) {

                    myBoard.get(rowNumber + i).get(columnNumber);
                    if (myBoard.get(rowNumber + i).get(columnNumber) == "O") {
                        thrown = true;
                    }

                }
            } catch (IndexOutOfBoundsException ioobe) {
                thrown = true;
            }


            if (!thrown) {
                for (int i = 0; i < type.getSize(); i++) {
                    myBoard.get(rowNumber + i).set(columnNumber, "O");
                }
            } else if (thrown) {
                System.out.println("Choose an other coordinate.");
            }
        }

        if (direction.equals("up")) {
            try {
                for (int i = 0; i < type.getSize(); i++) {

                    myBoard.get(rowNumber - i).get(columnNumber);
                    if (myBoard.get(rowNumber - i).get(columnNumber) == "O") {
                        thrown = true;
                    }

                }
            } catch (IndexOutOfBoundsException ioobe) {
                thrown = true;
            }


            if (!thrown) {
                for (int i = 0; i < type.getSize(); i++) {
                    myBoard.get(rowNumber - i).set(columnNumber, "O");
                }
            } else if (thrown) {
                System.out.println("Choose an other coordinate.");
            }
        }


//}
//catch (IndexOutOfBoundsException ioobe) {
//    System.out.println( "Please choose an other coordinate.");
//    thrown = true;
//}
//
//if (thrown) {
//
//
//}

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
