package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = (dest.getX() - position.getX() > 0) ? dest.getX() - position.getX() : position.getX() - dest.getX();
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position.getX();
        int deltaY = dest.getY() - position.getY();
        int shiftX = 0;
        int shiftY = 0;
        for (int index = 0; index < size; index++) {
            shiftX = (deltaX > 0) ? shiftX + 1 : shiftX - 1;
            shiftY = (deltaY > 0) ? shiftY + 1 : shiftY - 1;
            int x = position.getX() + shiftX;
            int y = position.getY() + shiftY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (source.getX() - dest.getX()) + (source.getY() - dest.getY()) == 0;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
