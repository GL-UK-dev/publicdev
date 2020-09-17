package mobileBanking;

public class BankAccount {
    String name;
    String password;
    int balence;
    int sortcode;
    int accountNumber;

    public BankAccount(String name, String password, int balence, int sortcode, int accountNumber) {
        this.name = name;
        this.password = password;
        this.balence = balence;
        this.sortcode = sortcode;
        this.accountNumber = accountNumber;
    }

    public void ViewAccount(){
        System.out.println(name);
        System.out.println(password);
        System.out.println(balence);
        System.out.println(sortcode);
        System.out.println(accountNumber);
    }

    public String GetUsername(){
        return name;
    }
    public String GetPassword(){
        return password;
    }
    public void SetBanence0() { balence =0;}
    public int GetBalence(){
        return balence;
    }
    public void SetBalence(int additor){
        balence = balence + additor;
    }
    public int GetAccountnumber(){
        return accountNumber;
    }
    public int GetSortcode(){
        return sortcode;
    }

}
