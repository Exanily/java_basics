public class TwoDimensionalArray {
    public static char symbol = 'X';
    public static char symbolSpace = ' ';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] array = new char[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || j == array.length - i - 1) {
                    array[i][j] = symbol;
                } else array[i][j] = symbolSpace;
            }
        }
        return array;
    }
}
