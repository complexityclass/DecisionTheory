import algorithms.CollectiveDecisions;
import algorithms.ExpertGrades;
import algorithms.ManyCriteria;
import algorithms.StatisticsModels;

/**
 * Created by complexityclass on 18/12/13.
 */
public class TestClient {

    public static void main(String[] args) {

        System.out.println("**********************************RESEARCH************************************************");

        System.out.println("Lab 1");
        ExpertGrades lab1 = new ExpertGrades();
        lab1.startResearch();

        System.out.println("==========================================================================================");
        System.out.println();

        System.out.println("Lab 2");
        ManyCriteria lab2 = new ManyCriteria();
        lab2.startResearch();

        System.out.println("==========================================================================================");
        System.out.println();

        System.out.println("Lab 3");
        StatisticsModels lab3 = new StatisticsModels();
        lab3.startResearch();

        System.out.println("==========================================================================================");
        System.out.println();

        System.out.println("Lab 4");
        CollectiveDecisions lab4 = new CollectiveDecisions();
        lab4.startResearch();
        System.out.println("==========================================================================================");

    }

}
