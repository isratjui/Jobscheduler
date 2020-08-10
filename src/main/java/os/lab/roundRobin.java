package os.lab;

import java.util.*;
public class roundRobin{
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        ArrayList<Node> arrli = new ArrayList<Node>();
        int pro = 5;
        String process;
        int dur;
        int priority;
        for(int i=0;i<5;i++)
        {System.out.println("burst time for"+"p"+i);
            int bt=sc.nextInt();
            System.out.println("Priority time for"+"p"+i);
            int pt=sc.nextInt();
            arrli.add(new Node (i,bt,pt));
        }


        round(arrli);

    }

    //round robin scheduling
    public static void round(ArrayList<Node>arr){
        ArrayList<Node>temp = new ArrayList<Node>();
        ArrayList<Node>array = new ArrayList<Node>();
        for (int i=0; i<arr.size(); i++){
            temp.add(arr.get(i));
        }
        int index = 0;
        int timer = 1;
        int clock = 0;
        int in = temp.size();
        boolean flag = false;
        int count = 1;
        System.out.println("\nRound Robin Scheduling (Process-Duration-Priority)");
        
        // Clock

        while (flag !=true){
            in--;
            temp.get(in).time = temp.get(in).time - timer;

            if ((count)%temp.size() == 0){
                clock = clock+count*timer;
                for (int j = temp.size()-1; j>=0; j--){
                    if(temp.get(j).time <= 0){
                        System.out.println("Clock "+clock);
                        temp.get(j).time=clock;
                        array.add(temp.get(j));
                        temp.remove(j);
                    }
                    in = temp.size();
                }
                for (int i=0; i<temp.size(); i++){
                    System.out.println("P"+temp.get(i).name+" - "+temp.get(i).time);
                }
                count=0;
                System.out.println("Size "+temp.size());
            }
            count++;
            if (temp.size()==0){flag = true;}
        }
        System.out.println();
        for (int i=0; i<array.size(); i++){
            System.out.println("P"+array.get(i).name+" - "+array.get(i).time+" - "+array.get(i).prio);
        }
    }
}
