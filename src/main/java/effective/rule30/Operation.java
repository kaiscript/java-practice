package effective.rule30;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiscript on 2017/3/1.
 */
public enum Operation {

    PLUS("+") { double apply(double x,double y) { return x + y;} },
    MINUS("-") {
        double apply(double x, double y){
            return x - y;
        }
    },
    TIME("*"){
        double apply(double x,double y){
            return x * y;
        }
    },
    DIVIDE("/"){
        double apply(double x,double y){
            return x / y;
        }
    };

    private String symbol;
    Operation(String symbol) {
        this.symbol = symbol;
    }

    private static final Map<String, Operation> map = new HashMap<>();
    static {
        for (Operation operation : values()) {
            map.put(operation.symbol, operation);
        }
    }

    public static Operation formString(String symbol) {
        return map.get(symbol);
    }

    abstract double apply(double x, double y);
}
