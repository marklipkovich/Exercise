import java.util.*;

public class FindCheapestFlight {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K ) {

        int currentCity = 0;
        ArrayList<Integer> outRoutes = new ArrayList<>();
        Stack<Integer> stackCities = new Stack<>();
        Set <Integer>setCities = new HashSet();
        Set <Integer>setCitiesDst = new HashSet();
        ArrayList<Integer> zeroInCity = new ArrayList<>();
        ArrayList<Integer> listCities = new ArrayList<>();
        for (int[] flight : flights) {
            setCities.add(flight[0]);
            //setCities.add(flight[1]);
        }
        int maxCity = Collections.max(setCities) + 1;
        int[] sumFlight = new int[maxCity];
        for (int i = 0; i < maxCity; i++){
            sumFlight[i] = 100000;
        }
        int[][] matrix = new int[maxCity][maxCity];
        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }

        while (!setCities.isEmpty()) {
            for(int city: setCities) {
                int sumDst = 0;

                //int sumSrc = 0;
                //for (int j = 0; j < matrix[city].length; j++) {
                    //sumSrc = sumSrc + matrix[city][j];
                //}
                //if (sumSrc > 0) {
                for (int i = 0; i < maxCity; i++) sumDst = sumDst + matrix[i][city];
                if (sumDst == 0) {
                    zeroInCity.add(city);
                    stackCities.push(city);
                    //listCities.add(city);
                }
                //}
            }
            for (Integer city : zeroInCity) {
                for (int j = 0; j < maxCity; j++) {
                    matrix[city][j] = 0;
                }
                setCities.remove(city);
            }
            zeroInCity.clear();
        }

        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }

        sumFlight[dst] = 0;

        while (currentCity != src) {
            currentCity = stackCities.pop();
            for (int j = 0; j < maxCity; j++) {
                if (matrix[currentCity][j] > 0) outRoutes.add(matrix[currentCity][j] + sumFlight[j]);
            }
            sumFlight[currentCity] = Collections.min(outRoutes);
            outRoutes.clear();
        }
        return sumFlight[currentCity];
    }

    public static void main(String arg[]) {

        FindCheapestFlight findCheapestFlight = new FindCheapestFlight();
        int n = 9;
        int[][] flights = {{5,8,58},{1,5,15},{3,8,38},{3,10,310},{5,11,511},{7,11,711},{7,8,78},{8,9,89},{11,2,112},{11,9,119},{11,10,1110}};
        int src = 1;
        int dst = 9;
        int k = 2;
        System.out.println(findCheapestFlight.findCheapestPrice(n, flights, src, dst, k));
    }
}
