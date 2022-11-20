package model;

import exceptions.MyException;

public class IfStmt implements IStmt {
    private Exp exp;
    private IStmt thenS;
    private IStmt elseS;

    public IfStmt(Exp e, IStmt then, IStmt elsee){
        this.exp = e;
        this.thenS = then;
        this.elseS = elsee;
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {
        Value result = this.exp.eval(state.getSymTable());
        if (result instanceof BoolValue boolResult) {
            IStmt statement;
            if (boolResult.getVal()) {
                statement = thenS;
            } else {
                statement = elseS;
            }
            MyIStack<IStmt> stack = state.getExeStack();
            stack.push(statement);
            state.setExeStack(stack);
            return state;
        } else {
            throw new MyException("Please provide a boolean expression in an if statement.");
        }
    }
    @Override
    public String toString(){
        return "IF(" + exp.toString() + ") THEN(" + thenS.toString() + ")ELSE(" + elseS.toString() + ")";
    }
    @Override
    public IStmt deepCopy() {
        return new IfStmt(exp.deepCopy(), thenS.deepCopy(), elseS.deepCopy());
    }

}