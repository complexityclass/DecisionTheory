package algorithms;

/**
 * Created by complexityclass on 18/12/13.
 */
public class CollectiveDecisions {

    public void startResearch(){
        String title = "Programming languages that are demand by 100 employers";
        String[] languages = {"C++", "Java", "Objective-C"};
        String[] variants = {"Java;Objective-C;C++", "C++;Java;Objective-C",
                             "Objective-C;Java;C++", "C++;Java;Objective-C"};
        int[] votes = new int[]{48,22,9,11};
        int[] result = new int[3];

        for(int i = 0; i < votes.length; i++){
            String[] temp = variants[i].split(";");

            for(int j = 0; j < temp.length; j++){

                if(temp[j].equals("C++")){
                    result[0] += votes[i] * (temp.length - j);
                }
                else if(temp[j].equals("Java")){
                    result[1] += votes[i] * (temp.length - j);
                }
                else if(temp[j].equals("Objective-C")){
                    result[2] += votes[i] * (temp.length - j);
                }

            }
        }

        System.out.format("±---------------------------------------------±%n");
        System.out.printf("| Experts   | Priority                        |%n");
        System.out.format("+---------------------------------------------+%n");

        String format = "| %-9d | %-31s | %n";

        for(int i = 0; i < votes.length; i++)
            System.out.format(format,votes[i],variants[i]);
        System.out.format("+---------------------------------------------+%n");

        System.out.println();

        String format2 = "| %-15s | %-4d | %n";
        System.out.format("±------------------------±%n");
        System.out.printf("| Language   | Total     |%n");
        System.out.format("+------------------------+%n");

        for(int i = 0; i < result.length; i++){
            System.out.printf(format2,languages[i],result[i]);
        }

        System.out.format("+------------------------+%n");





    }

}
