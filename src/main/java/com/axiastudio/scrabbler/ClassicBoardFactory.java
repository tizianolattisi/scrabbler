package com.axiastudio.scrabbler;

public class ClassicBoardFactory implements BoardFactory {


    @Override
    public Board buildAndInitialize() {
        ClassicBoard board = new ClassicBoard(15);
        board.setTile(new Position(0, 0), new Tile(3, LetterOrWord.WORD));
        board.setTile(new Position(3, 0), new Tile(2, LetterOrWord.LETTER));
        board.setTile(new Position(7, 0), new Tile(3, LetterOrWord.WORD));
        board.setTile(new Position(11, 0), new Tile(2, LetterOrWord.LETTER));
        board.setTile(new Position(14, 0), new Tile(3, LetterOrWord.WORD));
        // TODO: complete classic board layout
        return board;
    }

}
