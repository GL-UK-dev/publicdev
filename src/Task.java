import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task {
    public void sout(String str) {
        System.out.println(str);
    }
    public  void task1() {
        Scanner myScanner = new Scanner(System.in); sout("what is your age");
        int age = Integer.parseInt(myScanner.nextLine());
        if(age <16){ sout("too young"); }
        else if(age >16 && age < 20 ){ sout("end of you teen years"); }
        else if(age >20 && age< 25){ sout("you need to grow up");     }
        else if(age >25 && age< 30){ sout("body is falling apart");   }
        else if(age >30 && age< 40){ sout("you need to grow up");     }
        else if(age >40 && age< 50){ sout("kids will leave now");     }
        else { sout("lotsof time for mid life car");                  }
    }


    public void task2(){
        Scanner myScanner = new Scanner(System.in);
        boolean breaker = false;
        while (!breaker) {
            String[] list ={"welome to the main menu" , "(1) Ikea meatballs" , "(2) bigmac" , "(3) borger " , "(4) exit"};
            sout(list[0] + "\n" + list[1] + "\n" + list[2] + "\n" + list[3] + "\n" + list[4]);
            //sout("welome to the main menu" + "\n" + " (1) Ikea meatballs" + "\n" + " (2) bigmac" + "\n" + "(3) borger" + "\n" + "(4) exit");
            String input = myScanner.nextLine();
            switch (input.toLowerCase()){
                case "1" ->  sout(list[1] );
                case "2" ->  sout(list[2] );
                case "3" ->  sout(list[3] );
                case "4" ->  sout(list[4] );
                default ->  breaker = true;
            }
        }
    }

    public int operator(char op  , int y  , int array[]){
         return switch (op){
            case '+' ->  (array[0] + array[y]);
            case '-' -> (array[0] - array[y]);
            case '/' -> (array[0] / array[y]);
            case '*' -> (array[0] * array[y]);
            default -> 1;
        };

    }

    public void task3(){


        Scanner myScanner = new Scanner(System.in);
        int[] store = {0,0,0};
        sout("welome to the calculator megatrone device" + "\n" + " enter first number");
        store[0] = Integer.parseInt(myScanner.nextLine());
        //store[0] = Integer.parseInt(myScanner.nextLine());
        boolean breaker = false; int i = 0;
        while (!breaker){

            sout("what operand would you like to do");
            String tempOp = myScanner.nextLine();
            char userOp = tempOp.charAt(0);
            sout("second number");
            store[1] = Integer.parseInt(myScanner.nextLine());
            store[2] =  operator(userOp ,(1) , store);
            sout(Integer.toString(store[2]));
            store[0] = store[2];
            sout("would you like to exit y/n");
            switch (myScanner.nextLine().toLowerCase()){
                case "y" :
                    breaker = true;
            }
        }


    }

    public void task4(){
        Scanner myScanner = new Scanner(System.in);
        sout("welocome to employee builder" + "\n" + "how many employees would you like to make?");
        int noOfPeople = Integer.parseInt(myScanner.nextLine());
        Employee[] employeeList = new Employee[noOfPeople];
        for (int i =0 ; i < noOfPeople ; i++){
            sout("enter in the following order the " + "\n" + "name" + "\n" + "position in company" + "\n" +"age" + "\n" +"height" + "\n" +"salery");
            String name = myScanner.nextLine();
            String position = myScanner.nextLine();
            int age = Integer.parseInt(myScanner.nextLine());
            int height = Integer.parseInt(myScanner.nextLine());
            int pay = Integer.parseInt(myScanner.nextLine());
            Employee employee = new Employee(name,position,age,height,pay);
            employeeList[i] = employee;
        }
        for (int x =0 ; x < noOfPeople ; x++){
            employeeList[x].printEmployee();
        }




    }

    public void task5(){
        Random ran = new Random();

        int[][] Cinima = new int[5][5];
        for (int x = 0 ; x < 5 ; x++){
            for (int y = 0 ; y <5 ; y++){
                Cinima[x][y] =  ran.nextInt(1) + 4;
            }
        }

        for (int x = 0 ; x < 5 ; x++){
            for (int y = 0 ; y < 5 ; y++){
                sout(Integer.toString(Cinima[x][y]));
            }
        }

    }


    public static void main(String[] args) {
        Task isntance = new Task();
        //isntance.task1();
        //isntance.task2();
        //isntance.task3();
       isntance.task4();
        //isntance.task5();

    }




}
