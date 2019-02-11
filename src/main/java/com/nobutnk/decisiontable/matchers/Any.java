package com.nobutnk.decisiontable.matchers;

public class Any implements ConditionMatcher {
    
    public Any() {
        
    }

    public boolean matches(Object... targets) {
        return true;
    }

    public String toString() {
        return "<any>";
    }
}
