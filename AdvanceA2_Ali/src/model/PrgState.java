package model;
public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Value> symTable;
    private MyIList<Value> out;
    public void setExeStack(MyIStack<IStmt> newStack) {

        this.exeStack = newStack;
    }
    public void setOut(MyIList<Value> newOut) {

        this.out = newOut;
    }
    public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<String, Value> symTable, MyIList<Value> out, IStmt prg){
        this.exeStack = exeStack;
        this.exeStack.push(prg);
        this.symTable = symTable;
        this.out = out;
    }
    public MyIDictionary<String, Value> getSymTable() {

        return symTable;
    }
    public void setSymTable(MyIDictionary<String, Value> newSymTable) {
        this.symTable = newSymTable;
    }
    public MyIList<Value> getOut() {

        return out;
    }
    public MyIStack<IStmt> getExeStack() {

        return exeStack;
    }
    @Override
    public String toString(){
        String ans = "";
        ans += exeStack.toString();
        ans += symTable.toString();
        ans += out.toString();
        return ans;
    }
}