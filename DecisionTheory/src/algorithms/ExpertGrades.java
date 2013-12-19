package algorithms;

public class ExpertGrades {

    public static final int expertCount = 3;
    public static final int paramCount = 5;
    public static double[][] grades = new double[][]{{7,5,8,8,8},{10,6,5,4,3},{7,5,8,8,5}};
    public static double[][] rangs = new double[][]{{1,4,3,2,5},{1,4,2,5,3,},{2,4,3,1,5}};
    public static double[][] we = new double[expertCount][paramCount];
    public static double l = 0;
    public static double[] expertKoeff = new double[]{0.33, 0.33, 0.34};
    public static double[] comp = new double[expertCount];
    public static double[] priz = new double[paramCount];
    public static double[] xt = new double[paramCount];
    public static double[] weight = new double[paramCount];
    public static final double eps = 0.001;

    public  void startResearch(){

        do{
            for(int i = 0; i < expertCount; i++) comp[i] = expertKoeff[i];

            for(int j = 0; j < paramCount; j++){
                xt[j] = 0;
                for(int i = 0; i < expertCount; i++){
                    xt[j] += grades[i][j] * expertKoeff[i];
                }
            }

            double sum = 0;
            double temp = 0;

            for(int j = 0; j < paramCount; j++){
                temp = 0;
                for(int i = 0; i < expertCount; i++){
                    temp += grades[i][j] * xt[j];
                }
                sum += temp;
            }

            l = sum;

            for(int i = 0; i < expertCount; i++){

                sum = 0;

                for(int j = 0; j < paramCount; j++){
                    sum += grades[i][j] * xt[j];
                }

                expertKoeff[i] = sum / l;

            }
        } while ((expertKoeff[0] - comp[0]) > eps && (expertKoeff[1] - comp[1]) > 1 && (expertKoeff[2] - comp[2]) > eps);

        double s = 0;
        double tem = 0;

        for(int j = 0; j < paramCount; j++){
            tem = 0;
            for(int i = 0; i < expertCount; i++){

                tem += rangs[i][j];

            }
            tem = tem - 0.5 * expertCount * (paramCount - 1);
            s += tem;
        }

        double w = 12 * s / (paramCount * paramCount * (expertCount * expertCount * expertCount - expertCount));

        for(int j = 0; j < paramCount; j++){
            for(int i = 0; i < expertCount; i++){
                priz[j] += grades[i][j];
            }
            priz[j] /= expertCount;
        }

        tem = 0;

        for(int j = 0; j < expertCount; j ++){
            for(int i = 0; i < paramCount; i++){
                tem = 0;
                for(int k = 0; k < paramCount; k++){
                    tem += grades[j][k];
                }
                we[j][i] = grades[j][i] / tem;
            }
        }

        for(int i = 0; i < paramCount; i++){
            tem = 0;
            for(int j = 0; j < expertCount; j++){
                tem += we[j][i];
            }
            weight[i] = tem/paramCount;
        }

        String format2 = "| %-15s | %-4f | %n";
        System.out.format("±----------------------------±%n");
        System.out.printf("| Experts        | competence|%n");
        System.out.format("+----------------------------+%n");

        for(int i = 0; i < expertCount; i++){
            String title = "Expert " + i;
            System.out.printf(format2,title,expertKoeff[i]);

        }
        System.out.format("+---------------------------------+%n");

        System.out.println();
        System.out.format("+---------------------------------+%n");
        System.out.format(format2,"Experts consistency", w * 100);
        System.out.format("+---------------------------------+%n");

        String format3 = "|%-15s|";
        String format4 = " %-2f| ";
        System.out.println();

        System.out.format("+--------------------------------------------------------------------------------------+%n");
        System.out.format(format3,"Group evalution of alternatives");

        for(int i = 0; i < paramCount; i++){
            System.out.format(format4,priz[i]);
        }
        System.out.println();
        System.out.format("+--------------------------------------------------------------------------------------+%n");

        System.out.println();

        System.out.format("+--------------------------------------------------------------------------------------+%n");
        System.out.format(format3, "Weight vector");

        for(int i = 0; i < paramCount; i++) System.out.format(format4,weight[i]);
        System.out.println();
        System.out.format("+--------------------------------------------------------------------------------------+%n");


    }



}
