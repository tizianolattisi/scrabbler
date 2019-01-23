package com.axiastudio.scrabbler.board.classic;

import com.axiastudio.scrabbler.bag.Bag;
import com.axiastudio.scrabbler.bag.BagFactory;

public class ClassicBagFactory implements BagFactory {

    @Override
    public Bag buildAndInitialize() {
        return new ClassicBag();
    }

}
