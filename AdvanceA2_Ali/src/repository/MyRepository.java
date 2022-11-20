package repository;

import model.PrgState;

import java.util.ArrayList;
import java.util.List;
import exceptions.MyException;

public class MyRepository implements  MyIRepository{
    List<PrgState> listOfPrograms;
    @Override
    public void logPrgStateExec() throws MyException {
    }
    public MyRepository(PrgState prgState){
        this.listOfPrograms = new ArrayList<>();
        this.listOfPrograms.add(prgState);
    }
    @Override
    public PrgState getCurrentState() {

        return this.listOfPrograms.get(0);
    }
}