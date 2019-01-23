package com.axiastudio.scrabbler.board.classic;

import com.axiastudio.scrabbler.core.Bag;
import com.axiastudio.scrabbler.core.BagFactory;

public class ClassicBagFactory implements BagFactory {

    @Override
    public Bag buildAndInitialize() {
        return new ClassicBag();
    }

}
