package com.nobutnk.decisiontable.matchers;

import java.util.Arrays;

public class Else implements ConditionMatcher {

    private Object[] sources;
    
    public Else(Object... sources) {
        this.sources = sources;
    }
    
    @Override
    public boolean matches(Object... targets) {
        return !Arrays.asList(this.sources).contains(targets);
    }

}
