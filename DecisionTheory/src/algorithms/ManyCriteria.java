package algorithms;

/**
 * Created by complexityclass on 18/12/13.
 */
public class ManyCriteria {

    //base matrix
    public double[][] matr = new double[][] {{2,3,4,1},{1,3,2,4},{4,2,3,1},{3,1,4,2},{2,3,4,1}};
    public static final String TITLE  = "Choose key-value storage for cloud based application ";
    public String[] criterions = new String[]{"Outstream perfomance","Inputstream perfomance","API level","Eventually consistent","KV Cache"};
    public String[] alters = new String[]{"MongoDB","Redis","Memcached","HBase"};

    public void startResearch(){


        System.out.println(TITLE);
        System.out.println();

        String leftAlignTitle = "| %-25s | ";
        String leftAlignFormat = " %-2f |";

        System.out.format("±---------------------------±-----------±----------+----------+----------+%n");
        System.out.printf("| criterias                 | MongoDB   | Redis    |Memcached | HBase    |%n");
        System.out.format("+---------------------------+-----------+----------+----------+----------+%n");

        for(int i = 0; i < matr.length; i++){
            System.out.format(leftAlignTitle,criterions[i]);
            for(int j = 0; j < matr[0].length; j++){
                System.out.format(leftAlignFormat, matr[i][j]);
            }
            System.out.println();
        }
        System.out.format("+---------------------------+-----------+----------+----------+----------+%n");

        int factors = 4;
        int options = 5;

        boolean[] s = new boolean[]{true,true,true,true};

        for(int i = 0; i < factors; i++){
            for(int j = 0; j < factors; j++){
                if(i != j){
                    int k = 0;
                    for(int r = 0; r < options; r++){
                        if(matr[r][i] < matr[r][j]) k++;
                    }
                    if(k == options){
                        s[i] = false;
                        break;
                    }
                }
            }
        }
        System.out.println("Alternatives in  accept area");
        String formater = "|%-10d|%-13s|%n";

        System.out.println("--------------------------");

        for(int i = 0; i < factors; i++){
            if(s[i] == true){
                System.out.format(formater,i+1,alters[i]);
            }
        }
        System.out.println("---------------------------");

        double[] vector = new double[]{0.5,0.3,0.4,0.2,0.1};
        int k1 = 0;

        for(int k2 = k1 + 1; k2 < factors; k2++){
            double min = 0;
            double max = 0;
            for(int j = 0; j < options; j++){
                if(matr[j][k1] > matr[j][k2]) min += (matr[j][k1] - matr[j][k2]) * vector[j];
                else
                    max += (matr[j][k2] - matr[j][k1])*vector[j];
            }
            if(max > min){
                k1 = k2;            }
        }

        System.out.println();
        System.out.println("Best alternative is " + (k1 + 1) + " : " + alters[k1]);


    }



}
