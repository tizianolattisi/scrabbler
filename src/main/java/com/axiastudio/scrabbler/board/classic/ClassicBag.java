package com.axiastudio.scrabbler.board.classic;

import com.axiastudio.scrabbler.bag.AbstractBag;
import com.axiastudio.scrabbler.core.Bag;

import java.util.HashMap;
import java.util.Map;

public class ClassicBag extends AbstractBag implements Bag {

    private Map<String, Integer> points = new HashMap<>();

    public ClassicBag() {

        points.put("a", 1);
        points.put("b", 5);
        points.put("c", 2);
        points.put("d", 5);
        points.put("e", 1);
        points.put("f", 5);
        points.put("g", 8);
        points.put("h", 8);
        points.put("i", 1);
        points.put("l", 3);
        points.put("m", 3);
        points.put("n", 3);
        points.put("o", 1);
        points.put("p", 5);
        points.put("q", 10);
        points.put("r", 2);
        points.put("s", 2);
        points.put("t", 2);
        points.put("u", 3);
        points.put("v", 5);
        points.put("z", 8);

    }

    @Override
    public Integer getValueOfALetter(String letter) {
        return points.get(letter);
    }

}
