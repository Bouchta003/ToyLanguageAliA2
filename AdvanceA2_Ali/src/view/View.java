package view;
import exceptions.MyException;
import model.*;
import controller.*;
import repository.MyIRepository;
import repository.MyRepository;
import java.util.Objects;
import java.util.Scanner;

public class View {
    public void start() {
        boolean leave = true;//when "leave" becomes false, exits the prg
        while (leave) {
            try {
                System.out.print("\033[H\033[2J");System.out.flush();
                System.out.println("Here are the proposed examples for this first Toy Language :");
                //Command choice for display :
                System.out.println("0. Exit Toy Language.");
                System.out.println("1. First example: Declaration of an int and printing it.");
                System.out.println("2. Second example: int declarations and arithmetic operations.");
                System.out.println("3. Third example: Bool declaration and if condition. ");
                System.out.println("What program do you want to execute: ");
                Scanner readCommand = new Scanner(System.in);
                int command = readCommand.nextInt();
                switch (command) {
                    case 0 :    System.out.println("Exiting program...");leave = false;break;
                    case 1 :    Example1();break;
                    case 2 :    Example2();break;
                    case 3 :    Example3();break;
                    default :   System.out.println("Invalid example, please try again");break;
                }
                //readCommand.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
    // int v ; v = 2 ; print(v);
    private void Example1() throws MyException {
        IStmt example1 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))));
        runStatement(example1);
    }
    // int a ; int b ; a=2+3*5;b=a+1;  print b;
    private void Example2() throws MyException{
        IStmt example2 = new CompStmt(new VarDeclStmt("a",new IntType()),
                new CompStmt(new VarDeclStmt("b",new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp(1,new ValueExp(new IntValue(2)),
                                new ArithExp(3,new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b",new ArithExp(1,new VarExp("a"),
                                        new ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));
        runStatement(example2);
    }
    //bool a; int v ; a=true; if a then v=2 else v=3; print v;
    private void Example3() throws MyException {
        IStmt example3 = new CompStmt(new VarDeclStmt("a", new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"),
                                        new AssignStmt("v", new ValueExp(new IntValue(2))),
                                        new AssignStmt("v", new ValueExp(new IntValue(3)))),
                                        new PrintStmt(new VarExp("v"))))));
        runStatement(example3);
    }
    private void runStatement(IStmt statement) throws MyException{
        MyIStack<IStmt> executionStack = new MyStack<>();
        MyIDictionary<String, Value> symbolTable = new MyDictionary<>();
        MyIList<Value> output = new MyList<>();
        PrgState state = new PrgState(executionStack, symbolTable, output,statement);
        MyIRepository repository = new MyRepository(state);
        Controller controller = new Controller(repository);
        System.out.println("Do you want to display the steps?[Y/n]");
        Scanner readCommand = new Scanner(System.in);
        String command = readCommand.next();
        controller.setDisplayFlag(Objects.equals(command.toUpperCase(), "Y"));
        controller.allSteps();
        System.out.println("Result is" + state.getOut().toString().replace('[', ' ').replace(']', ' '));
    }
}