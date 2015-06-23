import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TException;

import shared.SharedStruct;
import tutorial.Calculator;
import tutorial.InvalidOperation;
import tutorial.Work;

public class CalculatorHandler implements Calculator.Iface {

    private Map<Integer, SharedStruct> structMap = new HashMap<Integer, SharedStruct>();
    
    public CalculatorHandler() {
        
        structMap.put(1, new SharedStruct(1, "1"));
        structMap.put(2, new SharedStruct(2, "2"));
        structMap.put(3, new SharedStruct(3, "3"));
        structMap.put(4, new SharedStruct(4, "4"));
        structMap.put(5, new SharedStruct(5, "5"));
    }
    
    @Override
    public SharedStruct getStruct(int key) throws TException {

        return this.structMap.get(key);
    }

    @Override
    public void ping() throws TException {
        
        System.out.println("The server is available");
    }

    @Override
    public int add(int num1, int num2) throws TException {

        return num1 + num2;
    }

    @Override
    public int calculate(int logid, Work w) throws InvalidOperation, TException {
        
        return 0;
    }

    @Override
    public void zip() throws TException {
        // TODO Auto-generated method stub
        
    }

}
