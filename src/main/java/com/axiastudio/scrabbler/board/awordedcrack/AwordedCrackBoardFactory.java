package com.axiastudio.scrabbler.board.awordedcrack;

import com.axiastudio.scrabbler.core.Board;
import com.axiastudio.scrabbler.core.BoardFactory;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.core.LetterOrWord;
import com.axiastudio.scrabbler.core.Square;

public class AwordedCrackBoardFactory implements BoardFactory {


    @Override
    public Board buildAndInitialize() {
        AwordedCrackBoard board = new AwordedCrackBoard(15);

        board.setSquare(new Position(2, 0), new Square(3, LetterOrWord.WORD));
        board.setSquare(new Position(4, 0), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(10, 0), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(12, 0), new Square(3, LetterOrWord.WORD));

        board.setSquare(new Position(1, 1), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(5, 1), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(9, 1), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(13, 1), new Square(3, LetterOrWord.LETTER));

        board.setSquare(new Position(0, 2), new Square(3, LetterOrWord.WORD));
        board.setSquare(new Position(2, 2), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(6, 2), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(8, 2), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(12, 2), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(14, 2), new Square(3, LetterOrWord.WORD));

        board.setSquare(new Position(3, 3), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(7, 3), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(11, 3), new Square(3, LetterOrWord.LETTER));

        board.setSquare(new Position(0, 4), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(6, 4), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(8, 4), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(14, 4), new Square(3, LetterOrWord.LETTER));

        board.setSquare(new Position(1, 5), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(5, 5), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(9, 5), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(13, 5), new Square(2, LetterOrWord.WORD));

        board.setSquare(new Position(2, 6), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(4, 6), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(10, 6), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(12, 6), new Square(3, LetterOrWord.LETTER));

        board.setSquare(new Position(3, 7), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(11, 7), new Square(2, LetterOrWord.WORD));

        board.setSquare(new Position(2, 8), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(4, 8), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(10, 8), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(12, 8), new Square(3, LetterOrWord.LETTER));

        board.setSquare(new Position(1, 9), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(5, 9), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(9, 9), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(13, 9), new Square(2, LetterOrWord.WORD));

        board.setSquare(new Position(0, 10), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(6, 10), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(8, 10), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(14, 10), new Square(3, LetterOrWord.LETTER));

        board.setSquare(new Position(3, 11), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(7, 11), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(11, 11), new Square(3, LetterOrWord.LETTER));

        board.setSquare(new Position(0, 12), new Square(3, LetterOrWord.WORD));
        board.setSquare(new Position(2, 12), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(6, 12), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(8, 12), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(12, 12), new Square(2, LetterOrWord.LETTER));
        board.setSquare(new Position(14, 12), new Square(3, LetterOrWord.WORD));

        board.setSquare(new Position(1, 13), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(5, 13), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(9, 13), new Square(2, LetterOrWord.WORD));
        board.setSquare(new Position(13, 13), new Square(3, LetterOrWord.LETTER));

        board.setSquare(new Position(2, 14), new Square(3, LetterOrWord.WORD));
        board.setSquare(new Position(4, 14), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(10, 14), new Square(3, LetterOrWord.LETTER));
        board.setSquare(new Position(12, 14), new Square(3, LetterOrWord.WORD));

        return board;
    }

}
