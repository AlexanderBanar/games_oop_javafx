package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {
    @Test
    public void position() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        assertThat(bishop.position(), is(Cell.C8));
    }

    @Test
    public void copy() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        assertThat(bishop.copy(Cell.C5).position(), is(Cell.C5));
    }

    @Test
    public void way() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.way(Cell.G5), is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void wayWrong() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.H1);
    }
}