package com.axiastudio.scrabbler.board.awordedcrack;

import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.BoardFactory;
import com.axiastudio.scrabbler.board.classic.ClassicBoard;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.commons.LetterOrWord;
import com.axiastudio.scrabbler.commons.Square;

public class AwordedCrackBoardFactory implements BoardFactory {


    @Override
    public Board buildAndInitialize() {
        ClassicBoard board = new ClassicBoard(15);

        board.setSquare(new Position(1, 0), new Square(3, LetterOrWord.WORD));
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

        // TODO: complete aworded crack board layout
        
        return board;
    }

}
