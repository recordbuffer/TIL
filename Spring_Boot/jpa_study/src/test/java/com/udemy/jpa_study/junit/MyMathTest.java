package com.udemy.jpa_study.junit;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class MyMathTest {


    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }


    @Test
    public void sum_3num(){
        MyMath myMath = new MyMath();
        int res = myMath.sum(new int[] {1,2,3});

        assertEquals(6, res);
    }

    @Test
    public void sum_3num_boolCheck(){
        MyMath myMath = new MyMath();
        int res = myMath.sum(new int[] {1,2,3});
        boolean cond = false;

        if (res<10) {
            cond = true;
        }

        assertEquals(true, cond);
    }

}
