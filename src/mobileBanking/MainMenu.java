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

        MainMenu instance = new MainMenu();
        instance.DefaultFill();
        instance.initMenu();
    }

    public void initMenu(){
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            sout("would you like to login or create a account ?  or exit ");
            String ans = myScanner.nextLine();
            if (ans.equalsIgnoreCase("create")) {
                Createacount();
            } else if (ans.equalsIgnoreCase("login"))
            {
                Login();
            } else if ( ans.equalsIgnoreCase("exit"))
            {
                System.exit(0);
            }
        }
    }

    public void Login() {
        Scanner myScanner = new Scanner(System.in);
        currentLocation = 0;
        int counter = 0;
        while (counter < 3) {
            sout("enter the username and passcode of the account you would like to login to");
            String username = myScanner.nextLine();
            String password = myScanner.nextLine();
            for (BankAccount a : bankList) {
                if (a.GetUsername().equals(username)) {
                    for (BankAccount b : bankList) {
                        if (b.GetPassword().equals(password)) {
                            haslogin = true;
                            currentLocation = bankList.indexOf(b);
                            menu();
                        } else {
                            counter++;
                        }
                    }
                }
            }
        }
    }

    public void menu() {
        Scanner myScanner = new Scanner(System.in);
        boolean breaker = false;
        while (!breaker) {

            sout("1  || open acount      ||");
            sout("2  || view account     ||");
            sout("3  || view transation  ||");
            sout("4  || transfer cash    ||");
            sout("5  || logout           ||");
            sout("6  || remove acount    ||");
            int choice = Integer.parseInt(myScanner.nextLine());

            switch (choice) {
                case 1:
                    Createacount();
                    break;
                case 2:
                    ViewAccount();
                    break;
                case 3:
                    ViewTransations();
                    break;
                case 4:
                    TransferCash();
                    break;
                case 5:
                    haslogin = false;
                    breaker = true;
                    initMenu();
                    break;
                case 6:
                    RemoveAccount();
                    break;
            }
        }
    }

    public void ViewAccount() {
        bankList.get(currentLocation).ViewAccount();
    }

    public void ViewTransations() {
        Scanner myScanner = new Scanner(System.in);
        sout("enter the username and passcode of the account you would like to view");
        transactionsList.get(currentLocation).GetTransations();
    }

    public void TransferCash() {
        Scanner myScanner = new Scanner(System.in);
        sout("enter the sortnumber and accountnumber of the account you would like to transfer to");
        int sort = Integer.parseInt(myScanner.nextLine());
        int account1 = Integer.parseInt(myScanner.nextLine());
        try {
            for (BankAccount p : bankList) {
                if (p.GetSortcode() == sort) {
                    for (BankAccount q : bankList) {
                        if (q.GetAccountnumber() == account1) {
                            sout("how much you wanna give");
                            int Additor = Integer.parseInt(myScanner.nextLine());
                            if (Additor < bankList.get(currentLocation).GetBalence()){
                                q.SetBalence(Additor);
                                bankList.get(currentLocation).SetBalence(-Additor);
                                sout("it is done");
                            }
                            else {sout("not enough to transfer");}
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
        bankList.add ( new BankAccount("Harry", "123", 10, 231233, 3232323));
        bankList.add ( new BankAccount("Dan", "Accenture12345", 10, 23, 32));
        bankList.add ( new BankAccount("Imran", "Karim4Ever", 1120, 231235, 4555445));

        transactionsList.add ( new Transaction("Harry",23,33,"Dan",23,32));
        transactionsList.add ( new Transaction("Dan",112,33,"Dan",23,32));
        transactionsList.add ( new Transaction("Imran", 12,3,"Harry",231233,3232323));
        transactionsList.add ( new Transaction("Imran", 3,0,"Harry",231233,3232323));
        transactionsList.add ( new Transaction("Harry", 33,300,"Dam",23,32));
        transactionsList.add ( new Transaction("Imran", 12,3,"Harry",231233,3232323));
        transactionsList.add (new Transaction("dan",2,233,"Imarn",231235,4555445));
    }

    public void RemoveAccount() {
        System.out.println("working");
        sout(bankList.get(0).GetUsername());
        Scanner myScanner = new Scanner(System.in);
        sout("would you like to remove you acount ? ");
        String responce = myScanner.nextLine();
        if (responce.equalsIgnoreCase("yes")){
            if((bankList.get(currentLocation).GetBalence()) > 0){
                System.out.println("Enter the account number then the sort code you wanna transfer to ");
                int acountno = Integer.parseInt(myScanner.nextLine());
                int srtcode = Integer.parseInt(myScanner.nextLine());
                for (BankAccount e : bankList) {
                    System.out.println(e.GetAccountnumber());
                    if ((e.GetAccountnumber())== acountno){
                        for (BankAccount y : bankList) {
                            if(y.GetSortcode() == srtcode){
                                sout("poof ...gone");
                                y.SetBalence(bankList.get(currentLocation).GetBalence());
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


