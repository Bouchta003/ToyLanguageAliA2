package model;

import exceptions.MyException;

public interface Exp {
    Value eval(MyIDictionary<String, Value> tbl) throws MyException;
    Exp deepCopy();
}