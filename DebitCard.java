public class DebitCard extends BankCard   //declaring public class Debit_card that is a subclass of Bank_card
{
    //Declaring instance variables
    private int Pin_number;
    private int Withdrawal_amount;
    private String Withdrawal_date;
    private boolean Has_withdrawn;
   
    //Declaring constructor that accepts six parameters
    public DebitCard(int Balance_Amount, int Card_ID, String Bank_Account, String Issuer_Bank, String Client_Name, int Pin_Number)
    {
        super(Card_ID, Issuer_Bank, Bank_Account, Balance_Amount);  //Calling the value of variables from constructor of parent class
        super.setCLIENT_NAME(Client_Name);  
        this.Pin_number=Pin_Number;
        this.Has_withdrawn=false;
       
    }
   
    //Declaring getters or accessor methods
    public int getPin_number()
    {
        return this.Pin_number;
    }
    public int getWithdrawal_amount()
    {
        return this.Withdrawal_amount;
    }
    public String getWithdrawal_date()
    {
        return this.Withdrawal_date;
    }
    public boolean getHas_withdrawan()
    {
        return this.Has_withdrawn;
    }
   
    //Declaring setters or mutator method
    public void setWithdrawal_amount(int withdrawal_amount)
    {
        this.Withdrawal_amount=withdrawal_amount;
    }
   
    public void withdraw(int withdrawal_amount,String Withdrawal_date, int Pin_number)     //Declaring method named Withdrawal that accepts three parameters
    {
        if(this.Pin_number == Pin_number)   //Checking conditions using if else ststement
        {
            if(super.getBalance_amount()>=withdrawal_amount )    //Using nested if else statement
            {  
                int balance = super.getBalance_amount() - withdrawal_amount;    //Calling getters method named BALANCE_AMOUNT from parent class and carrying out arithmatic operation
                super.setBalance_amount(balance);   //Updating the value of BALANCE_AMOUNT
                this.Has_withdrawn=true;
            }
           
            else{
                System.out.println("Insufficient balance");
            }
           
        }
        else{
            System.out.println("Incorrect pin");
        }
    }
   
    public void display()   //Declaring a method having same signature as that of method from parent class
    {
        super.display();    //Calling the method from parent class
       
        if (this.Has_withdrawn == true)  //Checking condition using if else statement
        {
            System.out.println("Pin Number: " +this.Pin_number);
            System.out.println("Withdrawal Amount: " +this.Withdrawal_amount);
            System.out.println("Date of Withdrawal: " + this.Withdrawal_date);
        }
        else
        {
            System.out.println("Transaction has not been carried out yet");
            System.out.println("Balance Amount: "+ getBalance_amount());
        }
    }
}