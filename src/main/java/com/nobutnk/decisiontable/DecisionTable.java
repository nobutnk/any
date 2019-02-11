package com.nobutnk.decisiontable;

import java.util.ArrayList;
import java.util.List;

import com.nobutnk.decisiontable.matchers.ConditionMatcher;

public class DecisionTable<R> {
    
    private List<DecisionRule<R>> rules = new ArrayList<>();
    private ConditionMatcher[] conditions = null;
    private R result = null;
    
    
    public DecisionTable<R> when(ConditionMatcher...conditions) {
        this.conditions = conditions;
        return this;
    }
    
    public DecisionTable<R> then(R result) {
        this.result = result;
        return this;
    }
    public void entry() {
        DecisionRule<R> rule = new DecisionRule<R>(this.conditions, this.result);
        rules.add(rule);
        
        this.conditions = null;
        this.result = null;
    }
    
    public R resolve(Object...conditions) {
        
        for (DecisionRule<R> rule : rules) {
            if (matchRule(rule, conditions)) {
                return rule.getResult();
            }
        }
        return null;
    }
    
    protected Boolean matchRule(DecisionRule<R> rule, Object...conditions) {
        Boolean result = true;
        for (int i = 0; i < rule.getConditions().length; i++) {
            if (!rule.getConditions()[i].matches(conditions[i])) {
                result = false;
                break;
            }
        }
        
        return result;
    }

}
