package effective.rule30;

/**
 * Created by kaiscript on 2017/3/1.
 */
public enum BasicOperation implements OperationInterface {
    PLUS("+"){
        public double apply(double x, double y) {
            return x + y;
        }
    };

    private String symbol;
    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

}
