package model;

public class BoolValue implements Value {
    boolean val;
    public BoolValue(boolean v){

        val = v;
    }
    @Override
    public boolean equals(Object anotherValue) {
        if (!(anotherValue instanceof BoolValue))
            return false;
        BoolValue castValue = (BoolValue) anotherValue;
        return this.val == castValue.val;
    }
    public boolean getVal(){
        return val;}

    public String toString() {

        return String.valueOf(val);
    }

    public Type getType() {

        return new BoolType();
    }

    @Override
    public Value deepCopy() {

        return new BoolValue(val);
    }

}