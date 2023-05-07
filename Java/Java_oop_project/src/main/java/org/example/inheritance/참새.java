package org.example.inheritance;

public class 참새 extends 조류 implements 날수있는{
    참새() {
        myClass = "참새";
    }

    @Override
    public void fly() {
        System.out.println(myClass+" 나는 중, 팔랑팔랑팔랑~");
    }
}
