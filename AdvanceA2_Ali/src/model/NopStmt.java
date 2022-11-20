package model;

import exceptions.MyException;


public class NopStmt implements IStmt {
    public NopStmt() {
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {

        return null;
    }
    @Override
    public IStmt deepCopy() {
        return new NopStmt();
    }

    @Override
    public String toString() {
        return "NopStatement";
    }
}
