package model;

public class IntValue implements Value {
    int val;
    public IntValue(int v){

        val = v;
    }
    public int getVal(){

        return val;
    }

    public Type getType() {

        return new IntType();
    }
    @Override
    public Value deepCopy() {

        return new IntValue(val);
    }
    public String toString() {
        return String.valueOf(val);
    }
}