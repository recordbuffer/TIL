package com.udemy.jpa_study.junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AssertTest {

    @Test
    public void test() {
        boolean con = true;
        assertEquals(true, con);
    }
}
