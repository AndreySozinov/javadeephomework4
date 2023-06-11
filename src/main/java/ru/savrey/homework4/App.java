package ru.savrey.homework4;

public class App {
    public static void main(String[] args) {

        String[][] arr = {{"5", "5", "5", "5"},
                            {"5", "5", "5", "5"},
                            {"5", "5", "5", "5"},
                            {"5", "5", "5", "5"}};

        try {
            System.out.printf("Сумма элементов массива: %d\n", sumArray4x4(arr));
        } catch (MyArraySizeException e) {
            System.out.printf("Ошибка в размерности массива.\n%s\n", e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.printf("""
                    Ошибка преобразования в целое число элемента массива в ячейке строки %d столбца %d.
                    %s
                    """, e.getRow() + 1, e.getColumn() + 1, e.getMessage());
        }
    }

    public static int sumArray4x4(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        final int arrLength = 4;
        int result = 0;
        if (arr.length != arrLength || arr[0].length != arrLength || arr[1].length != arrLength ||
            arr[2].length != arrLength || arr[3].length != arrLength){
            throw new MyArraySizeException("Размер массива должен быть " + arrLength + " х " + arrLength + ".");
        } else {
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[0].length; j++){
                    try {
                        int d = Integer.parseInt(arr[i][j]);
                        result += d;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Неверный формат элемента массива.", i, j);
                    }
                }
            }
        }
        return result;
    }
}
