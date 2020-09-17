package mobileBanking;

public class Transaction {
    String sendeName;
    int balenceBefor;
    int balenceAfter;
    String recipientName;
    int recipientSortcode;
    int recipientAccountnubmer;

    public Transaction(String sendeName, int balenceBefor, int balenceAfter, String recipientName, int recipientSortcode, int recipientAccountnubmer) {
        this.sendeName = sendeName;
        this.balenceBefor = balenceBefor;
        this.balenceAfter = balenceAfter;
        this.recipientName = recipientName;
        this.recipientSortcode = recipientSortcode;
        this.recipientAccountnubmer = recipientAccountnubmer;
    }

    public void GetTransations(){
        System.out.println(sendeName + " send " + (balenceBefor - balenceAfter) + " to " + recipientName);
        System.out.println(recipientAccountnubmer);
        System.out.println(recipientSortcode);
    }
}
