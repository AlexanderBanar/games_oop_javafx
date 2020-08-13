package ru.job4j.puzzle.firuges;

public class Checker implements Figure {
    private final Cell position;

    public Checker(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[0];
    }

    @Override
    public Figure copy(Cell dest) {
        return new Checker(dest);
    }
}
