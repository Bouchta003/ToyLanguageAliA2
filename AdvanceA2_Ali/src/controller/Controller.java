package controller;
import exceptions.MyException;
import model.*;
import repository.MyIRepository;

public class Controller {
    MyIRepository repository;
    boolean displayFlag = false;

    public void setDisplayFlag(boolean value) {

        this.displayFlag = value;
    }

    public Controller(MyIRepository repository) {
        this.repository = repository;
    }

    public PrgState oneStep(PrgState state) throws MyException
    {
        MyIStack<IStmt> stack = state.getExeStack();
        if (stack.isEmpty())
            throw new MyException("Empty Stack");
        IStmt currentStatement = stack.pop();
        state.setExeStack(stack);
        return currentStatement.execute(state);
    }
    public void allSteps() throws MyException {
        PrgState program = this.repository.getCurrentState();
        this.repository.logPrgStateExec();
        display();
        while(!program.getExeStack().isEmpty()) {
            oneStep(program);
            this.repository.logPrgStateExec();
            display();
        }
    }
    private void display() {
        if (displayFlag) {
            System.out.println(this.repository.getCurrentState().toString());
        }
    }
}