package com.axiastudio.scrabbler.board.classic;

import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.BoardFactory;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.commons.LetterOrWord;
import com.axiastudio.scrabbler.commons.Tile;

public class ClassicBoardFactory implements BoardFactory {


    @Override
    public Board buildAndInitialize() {
        ClassicBoard board = new ClassicBoard(15);

        board.setTile(new Position(0, 0), new Tile(3, LetterOrWord.WORD));
        board.setTile(new Position(3, 0), new Tile(2, LetterOrWord.LETTER));
        board.setTile(new Position(7, 0), new Tile(3, LetterOrWord.WORD));
        board.setTile(new Position(11, 0), new Tile(2, LetterOrWord.LETTER));
        board.setTile(new Position(14, 0), new Tile(3, LetterOrWord.WORD));

        board.setTile(new Position(1, 1), new Tile(2, LetterOrWord.WORD));
        board.setTile(new Position(5, 1), new Tile(3, LetterOrWord.LETTER));
        board.setTile(new Position(9, 1), new Tile(3, LetterOrWord.LETTER));
        board.setTile(new Position(13, 1), new Tile(2, LetterOrWord.WORD));

        board.setTile(new Position(2, 2), new Tile(2, LetterOrWord.WORD));
        board.setTile(new Position(10, 2), new Tile(2, LetterOrWord.LETTER));
        board.setTile(new Position(12, 2), new Tile(2, LetterOrWord.LETTER));
        board.setTile(new Position(2, 2), new Tile(2, LetterOrWord.WORD));

        // TODO: complete classic board layout

        return board;
    }

}
