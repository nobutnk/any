package com.nobutnk.decisiontable.matchers;

import java.util.Arrays;

public class Equals implements ConditionMatcher {
    private final Object[] sources;
    
    public Equals(Object... sources) {
        this.sources = sources;
    }

    @Override
    public boolean matches(Object... targets) {
        return Arrays.equals(sources, targets);
    }
}
