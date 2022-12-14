package model;
import exceptions.MyException;


public interface IStmt {
    PrgState execute(PrgState state) throws MyException;
    IStmt deepCopy();
    String toString();
}