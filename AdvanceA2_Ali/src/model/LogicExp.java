package model;

import exceptions.MyException;

public class LogicExp implements Exp {

    Exp e1;
    Exp e2;
    int op; //1-OR, 2-AND

    public LogicExp(int op,Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {

        Value v1, v2;
        v1 = e1.eval(tbl);
        if (v1.getType().equals(new BoolType())) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new BoolType())) {
                BoolValue i1 = (BoolValue) v1;
                BoolValue i2 = (BoolValue) v2;

                boolean b1, b2;
                b1 = i1.getVal();
                b2 = i2.getVal();

                if(op==1) return new BoolValue(b1||b2);
                if(op==2) return new BoolValue(b1 && b2);
            }
            else
                throw new MyException("second operand is not a boolean");
        }
        else
            throw new MyException("first operand is not a boolean");

        return new BoolValue(true);
    }
    @Override
    public Exp deepCopy() {
        return new LogicExp(op, e1.deepCopy(), e2.deepCopy());
    }
    @Override
    public String toString() {
        return e1.toString() + " " + op + " " + e2.toString();
    }
}
