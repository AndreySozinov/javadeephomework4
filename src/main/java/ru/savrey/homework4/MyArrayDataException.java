package ru.savrey.homework4;

public class MyArrayDataException extends Exception{
    private final int row;
    private final int column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public MyArrayDataException(String message, int row, int column) {
        super(message);
        this.row = row;
        this.column = column;
    }
}
