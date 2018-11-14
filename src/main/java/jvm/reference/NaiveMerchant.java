package jvm.reference;

/**
 * Created by kaiscript on 2018/7/29.
 */
public class NaiveMerchant extends Merchant {

    public Number actionPrice(double price,Customer customer) {
        if (customer.isVip()) {
            return 0;
        }
        return 1;
    }

}
