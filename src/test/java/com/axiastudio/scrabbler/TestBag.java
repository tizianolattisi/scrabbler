package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.bag.LetterTile;
import com.axiastudio.scrabbler.bag.ScarabTile;
import com.axiastudio.scrabbler.core.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBag {

    @Test
    public void testLetterTile() {
        Tile zTile = new LetterTile("z", 8);
        Tile oTile = new LetterTile("o", 1);
        Tile eTile = new LetterTile("e", 1);
        Assertions.assertEquals(8, (int) zTile.points());
        Assertions.assertEquals(1, (int) oTile.points());
        Assertions.assertNotEquals(3, (int) eTile.points());
    }

    @Test
    public void testScarabTile() {
        Tile scarab = new ScarabTile();
        Assertions.assertTrue(scarab.isScarab());
        Assertions.assertEquals(0, (int) scarab.points());
        Assertions.assertNull(scarab.letter());
        ((ScarabTile) scarab).castLetter("q");
        Assertions.assertSame("q", scarab.letter());
    }

}
