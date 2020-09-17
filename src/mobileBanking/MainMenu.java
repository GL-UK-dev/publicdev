package mobileBanking;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    List<BankAccount> bankList = new ArrayList<BankAccount>();
    List<Transaction> transactionsList = new ArrayList<Transaction>();
    boolean haslogin = false;
    int currentLocation =0;

    public static void sout(String inp) {
        System.out.println(inp);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        MainMenu instance = new MainMenu();
        instance.DefaultFill();


        while (true) {
            sout("would you like to login or create a account ?  or exit ");
            String ans = myScanner.nextLine();
            if (ans.equalsIgnoreCase("create")) {
                instance.Createacount();
            } else if (ans.equalsIgnoreCase("login"))
            {
                instance.Login();
            } else if ( ans.equalsIgnoreCase("exit"))
            {
                System.exit(0);
            }
        }
    }


    public void Login() {
        //MainMenu instance = new MainMenu();
        Scanner myScanner = new Scanner(System.in);
        sout("enter the username and passcode of the account you would like to login to");
        String username = myScanner.nextLine();
        String password = myScanner.nextLine();
        int counter = 0;
        while (counter < 3) {
            for (BankAccount a : bankList) {
                if (a.GetUsername().equals(username)) {
                    for (BankAccount b : bankList) {
                        if (b.GetPassword().equals(password)) {
                            haslogin = true;
                            currentLocation++;
                            menu();
                        } else {
                            sout("not many tries left");
                            counter++;
                        }
                    }
                }
            }
        }
    }

    public void menu() {

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
        bankList.get(currentLocation).ViewAccount();
    }

    public void ViewTransations() {
        Scanner myScanner = new Scanner(System.in);
        sout("enter the username and passcode of the account you would like to view");
        transactionsList.get(currentLocation).GetTransations();
    }


    public void TransferCash() {
        Scanner myScanner = new Scanner(System.in);
        sout("enter the username and passcode of the account you would like to transfer to");
        String username = myScanner.nextLine();
        String password = myScanner.nextLine();
        try {
            for (BankAccount a : bankList) {
                if (a.GetUsername().equals(username)) {
                    for (BankAccount b : bankList) {
                        if (b.GetPassword().equals(password)) {
                            sout("how much you wanna give");
                            int Additor = Integer.parseInt(myScanner.nextLine());
                            b.SetBalence(Additor);

                        }
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("!!!!");
        }
    }

    public void Createacount() {
        String password = "";
        sout("welcome to the account creation tool");
        Scanner myScanner = new Scanner(System.in);
        sout("enter the name, balence, sortcode , acount number");
        String username = myScanner.nextLine();
        int balence = Integer.parseInt(myScanner.nextLine());
        int sortcode = Integer.parseInt(myScanner.nextLine());
        int acountnumber = Integer.parseInt(myScanner.nextLine());
        while (true) {
            sout("enter password");
            String p1 = myScanner.nextLine();
            sout("re enter password");
            String p2 = myScanner.nextLine();
            if (p1.equals(p2)) {
                password = p1;
                break;
            }
        }
        bankList.add(new BankAccount(username, password, balence, sortcode, acountnumber));
    }

    public void DefaultFill() {
        bankList.add ( new BankAccount("Harry", "Accenture123", 10, 231233, 3232323));
        bankList.add ( new BankAccount("Dan", "12345", 10, 231233, 3232323));
        bankList.add ( new BankAccount("Imran", "Karim4Ever", 1120, 231235, 4555445));
    }

    public void RemoveAccount() {

        sout(bankList.get(0).GetUsername());
        Scanner myScanner = new Scanner(System.in);
        sout("would you like to remove you acount ? ");
        String responce = myScanner.nextLine();
        if (responce.equalsIgnoreCase("yes")){
            if((bankList.get(currentLocation).GetBalence()) > 0){
                System.out.println("Enter the acount number then the sort code you wanna transfer to ");
                int acountno = Integer.parseInt(myScanner.nextLine());
                int srtcode = Integer.parseInt(myScanner.nextLine());
                for (BankAccount a : bankList) {
                    if (a.balence == acountno){
                        for (BankAccount b : bankList) {
                            if(b.GetSortcode() == srtcode){
                                b.SetBalence(bankList.get(currentLocation).GetBalence());
                                bankList.get(currentLocation).SetBanence0();
                                bankList.remove(currentLocation);
                            }
                        }
                    }
                }
            }
        }

    }

}


