import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    static double futureValueMemo(double presentValue, double growthRate, int years, Map<Integer, Double> cache) {
        if (years == 0) {
            return presentValue;
        }
        if (cache.containsKey(years)) {
            return cache.get(years);
        }
        double value = futureValueMemo(presentValue, growthRate, years - 1, cache) * (1 + growthRate);
        cache.put(years, value);
        return value;
    }

    public static void main(String[] args) {
        double presentValue = 100000;
        double growthRate = 0.08;
        int years = 5;

        double result = futureValue(presentValue, growthRate, years);
        System.out.printf("Future value after %d years: Rs.%.2f%n", years, result);

        double memoResult = futureValueMemo(presentValue, growthRate, years, new HashMap<>());
        System.out.printf("Future value (memoized): Rs.%.2f%n", memoResult);
    }
}
