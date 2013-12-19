package algorithms;

/**
 * Created by complexityclass on 18/12/13.
 */
public class StatisticsModels {

    private static final int DIM = 3;

    private double[] waldCriteria(double[][] matrix, double[] result){
        double[] temp = new double[DIM];
        for(int i = 0; i < DIM; i++){
            for(int j = 0; j < 3; j++){
                temp[j] = matrix[i][j];
            }
            result[i] = min(temp);
        }

        return result;
    }

    private double[] bayessCriteria(double[][] matrix, double[] result){
        double temp[] = new double[DIM];
        for(int i = 0; i < DIM; i++){
            for(int j = 0; j < DIM ; j++){
                result[i] = matrix[i][j] * 0.33;
            }
        }

        return result;
    }

    private double min(double[] arr){
        double min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    private double max(double[] arr){
        double max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    public void startResearch(){


        double[][] matrix = new double[][] {{25,17,32},{12,24,34},{11,10,50}};
        double[] bayes = new double[DIM];
        double[] wald = new double[DIM];
        bayes = bayessCriteria(matrix,bayes);
        wald = waldCriteria(matrix,wald);
        int bayesIter = 0;
        int waldIter = 0;
        double bayesMax = max(bayes);
        double waldMax = max(wald);

        while(bayesMax != bayes[bayesIter]){
            ++bayesIter;
        }
        while(waldMax != wald[waldIter]){
            ++waldIter;
        }

        System.out.println("---------------------------------------------------------------------+");
        System.out.println("                                Data representation");
        System.out.format("±----------------------------±-----------±-----------+---------------+%n");
        System.out.printf("| Parser type                | XML       |  JSON     |Protocolbuffers|%n");
        System.out.format("+----------------------------+-----------+-----------+---------------+%n");
        String leftAlignTitle = "| %-25s | ";
        String leftAlignFormat = " %-2f |";

        String[] parserType = new String[]{"LL-parser","LR-parser","GLR-parser"};

        for(int i = 0; i < DIM; i++){
            System.out.format(leftAlignTitle,parserType[i]);
            for(int j = 0; j < DIM; j++ ){
                System.out.format(leftAlignFormat,matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println("+-----------------------------------------------------------------+");

        System.out.println("Bayess");
        System.out.println("+-----------+");
        String formatter = "| %-2f |%n";
        for(int i = 0; i < bayes.length; i++){
            System.out.printf(formatter, bayes[i]);
        }
        System.out.println("+-----------+");

        System.out.println("Best Strategy : " + (bayesIter + 1));

        System.out.println();

        System.out.println("Wald");
        System.out.println("+-----------+");
        for(int i = 0; i < wald.length; i++){
            System.out.printf(formatter, wald[i]);
        }
        System.out.println("+-----------+");

        System.out.println("Best Strategy : " + (waldIter + 1));

    }



}
