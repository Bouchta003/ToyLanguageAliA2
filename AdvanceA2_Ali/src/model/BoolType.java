package model;

public class BoolType implements Type {
    public BoolType() {
    }
    @Override
    public boolean equals(Type anotherType) {

        return anotherType instanceof BoolType;
    }
    public Value defaultValue()
    {

        return new BoolValue(false);
    }

    @Override
    public Type deepCopy() {

        return new BoolType();
    }
    public String toString() {
        return "bool";}
}
