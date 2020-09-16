package mobileBanking;


import java.util.Scanner;

public class MainMenu {
    BankAccount[] bankList = new BankAccount[10];
    Transaction[] transactionsList = new Transaction[10];
    boolean haslogin = false;
    int currentLocation;

    public static void sout(String inp) {
        System.out.println(inp);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        MainMenu instance = new MainMenu();
        instance.DefaultFill();
        sout("would you like to login or create a account ? ");
        String ans = myScanner.nextLine();
        if()


    }

    public void Login() {
        //MainMenu instance = new MainMenu();
        Scanner myScanner = new Scanner(System.in);
        sout("enter the username and passcode of the account you would like to transfer from");
        String username = myScanner.nextLine();
        String password = myScanner.nextLine();
        int counter =0;
        if(counter < 3){
            for (int i = 0;  0<bankList.length ; i++) {
                if (bankList[i].GetUsername().equals(username)){
                    for (int q = 0;  0<bankList.length ; q++) {
                        if(bankList[q].GetPassword().equals(password)){
                            currentLocation = q;
                            haslogin = true;
                            menu();
                        }
                    }
                }
            }
        }
        else{ System.exit(0);};


    }
    public  void menu() {

        MainMenu instance = new MainMenu();
        Scanner myScanner = new Scanner(System.in);
        boolean breaker = false;
        while (!breaker) {

            sout("1  || open acount      ||");
            sout("2  || view account     ||");
            sout("3  || view transation  ||");
            sout("4  || transfer cash    ||");
            sout("5  || logout           ||");
            sout("6  || ceate account    ||");
            sout("7  || remove acount    ||");
            sout("8  || default fill     ||");
            int choice = Integer.parseInt(myScanner.nextLine());
            //try {
            switch (choice) {
                case 1:
                    instance.Createacount();
                    break;
                case 2:
                    instance.ViewAccount();
                    break;
                case 3:
                    instance.ViewTransations();
                    break;
                case 4:
                    instance.TransferCash();
                    break;
                case 5:
                    haslogin = false;
                    breaker = !breaker;

                    break;
                //case 6:
                //   instance.Createacount();
                //     break;
                case 7:
                    instance.RemoveAccount();
                    break;
                case 8:
            }
            // } catch (Exception e) {
            //     sout("dont be silly enter an number ");
            // }
        }
    }

    public void ViewAccount() {
        Scanner myScanner = new Scanner(System.in);
        bankList[currentLocation].ViewAccount();
    }

    public void ViewTransations() {
        Scanner myScanner = new Scanner(System.in);
        sout("enter the username and passcode of the account you would like to view");
       transactionsList[currentLocation].GetTransations();
        }


    public void TransferCash() {
        Scanner myScanner = new Scanner(System.in);
        sout("enter the username and passcode of the account you would like to transfer to");
        String username = myScanner.nextLine();
        String password = myScanner.nextLine();

    }

    public void Createacount() {
        sout("welcome to the account creation tool");
        Scanner myScanner = new Scanner(System.in);
    }

    public void DefaultFill() {
        bankList[0] = new BankAccount("Harry ", "Accenture123", 10, 231233, 3232323);
        bankList[1] = new BankAccount("Dan", "12345", 10, 231233, 3232323);
        bankList[2] = new BankAccount("Imran", "Karim4Ever", 1120, 231235, 4555445);
    }

    public void RemoveAccount() {

        Scanner myScanner = new Scanner(System.in);
        sout("would you like to remove you acount ? ");
        String responce = myScanner.nextLine();

        }

    }


