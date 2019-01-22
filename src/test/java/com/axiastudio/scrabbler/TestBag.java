package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.bag.LetterTile;
import com.axiastudio.scrabbler.bag.ScarabTile;
import com.axiastudio.scrabbler.bag.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBag {

    @Test
    public void testLetterTile() {
        Tile zTile = new LetterTile("z", 8);
        Tile oTile = new LetterTile("o", 1);
        Tile eTile = new LetterTile("e", 1);
        Assertions.assertTrue(zTile.points()==8);
        Assertions.assertTrue(oTile.points()==1);
        Assertions.assertFalse(eTile.points()==3);
    }

    @Test
    public void testScarabTile() {
        Tile scarab = new ScarabTile();
        Assertions.assertTrue(scarab.isScarab());
        Assertions.assertTrue(scarab.points()==0);
        Assertions.assertTrue(scarab.letter()==null);
        ((ScarabTile) scarab).castLetter("q");
        Assertions.assertTrue(scarab.letter()=="q");
    }

}
