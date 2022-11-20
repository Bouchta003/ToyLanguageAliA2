package model;

import exceptions.MyException;

public class ArithExp implements Exp{
    Exp e1;
    Exp e2;
    int op; //1-plus, 2-minus, 3-star, 4-divide

    public ArithExp(int op,Exp e1, Exp e2) {

        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }
    public Value eval(MyIDictionary<String, Value>tbl) throws MyException {
        Value v1;
        Value v2;
        v1 = this.e1.eval(tbl);
        if (v1.getType().equals(new IntType())) {
            v2 = this.e2.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1;
                int n2;
                n1= i1.getVal();
                n2 =i2.getVal();
                if(op==1) return new IntValue(n1+n2);
                else if(op==2) return new IntValue(n1-n2);
                else if(op==3) return new IntValue(n1*n2);
                else if(op==4)
                    if(n2==0) throw new MyException("Division by 0");
                    else return new IntValue(n1/n2);
            }
            else
                throw new MyException("Second Value should be an Integer !!");
        }
        else
            throw new MyException("First Value should be an Integer !!");
        return null;
    }
    @Override
    public Exp deepCopy() {
        return new ArithExp(op, e1.deepCopy(), e2.deepCopy());
    }

    @Override
    public String toString() {
        return e1.toString() + " " + op + " " + e2.toString();
    }
}
