package com.axiastudio.scrabbler.board.classic;

import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.BoardFactory;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.commons.LetterOrWord;
import com.axiastudio.scrabbler.commons.Square;

public class ClassicBoardFactory implements BoardFactory {


    @Override
    public Board buildAndInitialize() {
        ClassicBoard board = new ClassicBoard(15);

        board.setSquare(new Position(0, 0), new Square(3, LetterOrWord.WORD));
        board.setSquare(new Position(3, 0), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(7, 0), new Square(3, LetterOrWord.WORD));
        board.setSquare(new Position(11, 0), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(14, 0), new Square(3, LetterOrWord.WORD));

        board.setSquare(new Position(1, 1), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(5, 1), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(9, 1), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(13, 1), new Square(2, LetterOrWord.WORD));

        board.setSquare(new Position(2, 2), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(10, 2), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(12, 2), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(2, 2), new Square(2, LetterOrWord.WORD));

        // TODO: complete classic board layout

        return board;
    }

}
