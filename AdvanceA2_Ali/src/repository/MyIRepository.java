package repository;

import exceptions.MyException;
import model.PrgState;


public interface MyIRepository {
    void logPrgStateExec() throws MyException;
    PrgState getCurrentState();

}