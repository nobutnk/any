package com.nobutnk.decisiontable;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.nobutnk.decisiontable.matchers.Any;
import com.nobutnk.decisiontable.matchers.Else;
import com.nobutnk.decisiontable.matchers.Equals;

public class DecisionTableTest {

    @Test
    public void test01() {
        DecisionTable<String> dt = new DecisionTable<>();
        dt.when(new Equals("AAA"), new Equals("BBB")).then("answer1").entry();
        dt.when(new Equals("AAA"), new Equals("CCC")).then("answer2").entry();
        dt.when(new Equals("XXX"), new Equals("YYY")).then("answer10").entry();
        
        assertThat(dt.resolve("AAA", "BBB"), is("answer1"));
        assertThat(dt.resolve("AAA", "CCC"), is("answer2"));
        assertThat(dt.resolve("XXX", "YYY"), is("answer10"));
    }
    
    @Test
    public void test02() {
        DecisionTable<String> dt = new DecisionTable<>();
        dt.when(new Equals("AAA"), new Equals("BBB")).then("answer1").entry();
        dt.when(new Equals("AAA"), new Else("BBB")).then("answer2").entry();
        
        assertThat(dt.resolve("AAA", "BBB"), is("answer1"));
        assertThat(dt.resolve("AAA", "CCC"), is("answer2"));
        assertThat(dt.resolve("AAA", "DDD"), is("answer2"));
    }
    
    @Test
    public void test03() {
        DecisionTable<String> dt = new DecisionTable<>();
        dt.when(new Equals("AAA"), new Equals("BBB"), new Any()).then("answer1").entry();
        dt.when(new Equals("AAA"), new Else("BBB"), new Equals("XXX")).then("answer2").entry();
        
        assertThat(dt.resolve("AAA", "BBB", "aaa"), is("answer1"));
        assertThat(dt.resolve("AAA", "CCC", "XXX"), is("answer2"));
        assertThat(dt.resolve("AAA", "CCC", "YYY"), is(nullValue()));
    }
    
}
