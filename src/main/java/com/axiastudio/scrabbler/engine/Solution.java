package com.axiastudio.scrabbler.engine;

import com.axiastudio.scrabbler.core.Pattern;

public class Solution {

    private Pattern pattern;
    private Integer points;

    public Solution(Pattern pattern, Integer points) {
        this.pattern = pattern;
        this.points = points;
    }

    public Pattern pattern() {
        return pattern;
    }

    public Integer points() {
        return points;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "pattern=" + pattern +
                ", points=" + points +
                '}';
    }
}
