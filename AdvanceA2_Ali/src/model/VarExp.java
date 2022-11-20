package model;

import exceptions.MyException;

public class VarExp implements Exp{
    String id;

    public VarExp(String id) {

        this.id = id;
    }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {

        return tbl.lookup(id);
    }
    @Override
    public Exp deepCopy() {
        return new VarExp(id);
    }
    @Override
    public String toString() {
        return id;
    }
}