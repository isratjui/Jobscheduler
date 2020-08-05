package os.lab;

import java.util.Scanner;

/**
 *
 * @author JUI
 */
public class OSLAB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task name, time and priority");
        int na=sc.nextInt();
        task v[] = new task[na];
        for(int i=0;i<na;i++)
        {System.out.println("p"+i+" burst time"+" priority");
            int t=sc.nextInt();
            int p=sc.nextInt();


            v[i] = new task(i, t, p);


        }
        // Priority Scheduling
        System.out.println("Priority scheduling");
        task v1[] = new task[na];
        for (int i = 0; i < na; i++) {
            v1[i] = v[i];
        }
        int r = 0;
        boolean flag = true;
        task temp;
        for (int i = 0; i < (v1.length - 1); i++) {
            for (int j = 0; j < v1.length - i - 1; j++) {
                if (v1[j].priority < v1[j + 1].priority) {
                    temp = v1[j];
                    v1[j] = v1[j + 1];
                    v1[j + 1] = temp;
                }
            }
        }
        int time = 0;
        for (int i = 0; i < na; i++) {
            time = time + v1[i].time;
            System.out.println("p"+v1[i].name + ":" + time);
        }
        //first come, first serve
        System.out.println("First come, first serve");
        time = 0;
        for (int i = 0; i < na; i++) {
            time = time + v[i].time;
            System.out.println(v[i].name + ":" + time);
        }
        //Shortest Job First
        System.out.println("Shortest Job First");
        for (int i = 0; i < (v1.length - 1); i++) {
            for (int j = 0; j < v1.length - i - 1; j++) {
                if (v1[j].time > v1[j + 1].time) {
                    temp = v1[j];
                    v1[j] = v1[j + 1];
                    v1[j + 1] = temp;
                }
            }
        }
        time = 0;
        for (int i = 0; i < na; i++) {
            time = time + v1[i].time;
            System.out.println(v1[i].name + ":" + time);
        }

    }

}

