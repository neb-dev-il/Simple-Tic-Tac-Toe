package tictactoe;
import java.util.Scanner;

class Main {

    public static void printArray(char[][] twoDimensionalArray) {
        System.out.println("---------");
        for (char[] chars : twoDimensionalArray) {
            System.out.print("| ");
            for (char aChar : chars) {

                System.out.print(aChar + " ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.println("---------");
    }

    public static boolean is3X(char[][] twoDimensionalArray) {
        boolean isWon = false;
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        for (int i = 0; i < twoDimensionalArray.length && !isWon; i++) {
            int sumRows = 0;
            int sumColumns = 0;
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                if (twoDimensionalArray[i][j] != ' ') {
                    sumRows += twoDimensionalArray[i][j];
                    if (i == j) {
                        sumDiagonal1 += twoDimensionalArray[i][j];
                    }
                    if (i + j == 2) {
                        sumDiagonal2 += twoDimensionalArray[i][j];
                    }
                }
                if (twoDimensionalArray[j][i] != ' ') {
                    sumColumns += twoDimensionalArray[j][i];
                }
                if (sumRows == 264 || sumColumns == 264 || sumDiagonal1 == 264 || sumDiagonal2 == 264) {
                    isWon = true;
                    break;
                }
            }
        }
        return isWon;
    }

    public static boolean is3O(char[][] twoDimensionalArray) {
        boolean isWon = false;
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        for (int i = 0; i < twoDimensionalArray.length && !isWon; i++) {
            int sumRows = 0;
            int sumColumns = 0;
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                if (twoDimensionalArray[i][j] != ' ') {
                    sumRows += twoDimensionalArray[i][j];
                    if (i == j) {
                        sumDiagonal1 += twoDimensionalArray[i][j];
                    }
                    if (i + j == 2) {
                        sumDiagonal2 += twoDimensionalArray[i][j];
                    }
                }
                if (twoDimensionalArray[j][i] != ' ') {
                    sumColumns += twoDimensionalArray[j][i];
                }
                if (sumRows == 237 || sumColumns == 237 || sumDiagonal1 == 237 || sumDiagonal2 == 237) {
                    isWon = true;
                    break;
                }
            }
        }
        return isWon;
    }

    public static boolean isCoordinatesInRange(int i, int j) {
        boolean isCoordinatesInRange = false;
        if (i < 0 || i >= 3 || j < 0 || j >= 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            isCoordinatesInRange = true;
        }
        return isCoordinatesInRange;
    }

    public static boolean isCellOccupied (int i, int j, char[][] twoDimensionalArray) {
        boolean isCellOccupied = false;
        if (twoDimensionalArray[i][j] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            isCellOccupied = true;
        }
        return isCellOccupied;
    }

    public static void enterMove (char[][] twoDimensionalArray) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (!is3X(twoDimensionalArray) && !is3O(twoDimensionalArray) && counter < 9) {
            System.out.print("Enter the coordinates: ");
            String coordinates = scanner.nextLine();
            try {
                coordinates = coordinates.replaceAll(" ", "");
                int value = Integer.parseInt(coordinates);
                int firstCoordinate = (value / 10) - 1;
                int secondCoordinate = (value % 10) - 1;
                if (!isCoordinatesInRange(firstCoordinate, secondCoordinate) && !isCellOccupied(firstCoordinate, secondCoordinate, twoDimensionalArray)) {
                    ++counter;
                    if (counter % 2 == 0) {
                        twoDimensionalArray[firstCoordinate][secondCoordinate] = 'O';
                    } else {
                        twoDimensionalArray[firstCoordinate][secondCoordinate] = 'X';
                    }
                    printArray(twoDimensionalArray);
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
        if (is3X(twoDimensionalArray)) {
            System.out.println("X wins");
        } else if (is3O(twoDimensionalArray)) {
            System.out.println("O wins");
        } else {
            System.out.println("Draw");
        }
    }

    public static void main(String[] args) {
        char[][] array = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
        printArray(array);
        enterMove(array);
    }
}