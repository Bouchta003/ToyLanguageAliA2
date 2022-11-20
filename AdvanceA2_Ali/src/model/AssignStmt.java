package model;
import exceptions.MyException;


public class AssignStmt implements IStmt {
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp ex){
        this.exp = ex;
        this.id = id;
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> symbolTable = state.getSymTable();
        if (symbolTable.isDefined(id)) {
            Value value = exp.eval(symbolTable);
            Type typeId = (symbolTable.lookup(id)).getType();
            if (value.getType().equals(typeId)) {
                symbolTable.put(id, value);
            } else {
                throw new MyException("Declared type of variable " + id + " and type of the assigned expression do not match.");
            }
        } else {
            throw new MyException("The used variable " + id + " was not declared before.");
        }
        state.setSymTable(symbolTable);
        return state;
    }
    @Override
    public IStmt deepCopy() {
        return new AssignStmt(id, exp.deepCopy());
    }
    @Override
    public String toString(){
        return id + " = " + exp.toString();
    }

}