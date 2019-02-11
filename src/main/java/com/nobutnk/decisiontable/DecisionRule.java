package com.nobutnk.decisiontable;

import com.nobutnk.decisiontable.matchers.ConditionMatcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DecisionRule<R> {

    private ConditionMatcher[] conditions;
    private R result;
}
