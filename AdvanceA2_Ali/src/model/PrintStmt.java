package model;
import exceptions.MyException;

public class PrintStmt implements IStmt {
    private Exp exp;
    public PrintStmt(Exp e){

        this.exp = e;
    }
    @Override
    public String toString(){

        return "Print(" + exp.toString() + ")";
    }
    @Override
    public PrgState execute(PrgState state) throws MyException{
        MyIList<Value> out = state.getOut();
        out.add(exp.eval(state.getSymTable()));
        state.setOut(out);
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new PrintStmt(exp.deepCopy());
    }
}