/**
 * Created by kaiscript on 2018/3/3.
 */
public class Foundation {

    public static void main(String[] args) {
        double DOLLAR = 6.3484002;
        double HK = 0.810690706;
        int Tencent= 730234;
        int BaiduInc = 157640;
        int AlibabaGroup = 213484;
        int NetEaseInc =  60796;
        int JDcomInc = 447982;
        int Ctrip =  199329;
        int c58comInc = 52365;
        int SINACorp = 32313;
        int Vipshop = 216922;
        int WeiboCorp = 19671;

        int TencentPrice = 436;
        double BaiduIncPrice = 250.6;
        double AlibabaGroupPrice = 179.760;
        double NetEaseIncPrice = 288.710;
        double JDcomIncPrice = 43.800;
        double CtripPrice = 45.630;
        double c58comIncPrice = 76.790;
        double SINACorpPrice = 117.500;
        double VipshopPrice = 18.210;
        double WeiboCorpPrice = 130.550;
        double sum = Tencent * TencentPrice* HK + (BaiduInc * BaiduIncPrice + AlibabaGroup * AlibabaGroupPrice + NetEaseInc * NetEaseIncPrice
                + JDcomInc * JDcomIncPrice + Ctrip * CtripPrice + c58comInc * c58comIncPrice + SINACorp * SINACorpPrice
                + Vipshop * VipshopPrice + WeiboCorp * WeiboCorpPrice) *DOLLAR;
        double count = Tencent + BaiduInc + AlibabaGroup + NetEaseInc + JDcomInc + Ctrip + c58comInc + SINACorp + Vipshop + WeiboCorp;
        System.out.println(sum);
        double realSum = 1230756240.73;
        double fen = 823432720;
        double sum1 = 17239001.75;
        double sum2 =5197271.57;
        System.out.println((sum + sum1 + sum2) / fen);
        System.out.println(realSum / fen);

    }

}
