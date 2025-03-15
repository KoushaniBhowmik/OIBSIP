import java.util.Scanner;

public class Task_three {
	private static String name, userName, password, accountNo;
	private static float balance = 10000f;
	private static int transactions = 0;
	private static String transactionHistory = "";
		
	public static void register() {
		Scanner sc = new Scanner(System.in);
			
		System.out.println("\nEnter your Name: ");
		name = sc.nextLine();

		System.out.println("\nEnter your Username: ");
		userName = sc.nextLine();
		
		System.out.println("\nEnter your Password: ");
		password = sc.nextLine();
			
		System.out.println("\nEnter your Account Number: ");
		accountNo = sc.nextLine();
			
		System.out.println("\nRegistration Successful. Please Log in to your Bank Account");
	}
			
	public static boolean login() {
		boolean isLogin = false;
		Scanner sc=new Scanner(System.in);
			
		while( !isLogin) {
			System.out.println("\nEnter your username: ");
			String Username = sc.nextLine();

			if (Username.equals(userName)) {
				while(!isLogin) {
					System.out.println("\nEnter your password: ");
					String Password = sc.nextLine();
					if(Password.equals(password)) {
						System.out.println("\nLogin Successful");
						isLogin = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
				
	public static void withdraw() {
	    System.out.println("\nEnter the Amount to Withdraw: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();

		try {
			if(balance >= amount) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdral Successful.");
				String str = amount + "Rs Withdrawn\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("\nInsufficient Balance.");
			}
		}
		catch(Exception e) {
			System.out.println("Exception caught: " + e);
		}
	}
				
	public static void deposit() {
		System.out.println("\nEnter the Amount to Deposit: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();

		try {
			if(amount <= 10000f) {
			    transactions++;
			    balance += amount;
			    System.out.println("\nDeposit Successful.");
			    String str = amount + "Rs deposited\n";
			    transactionHistory = transactionHistory.concat(str);
		    }
		    else {
			    System.out.println("\nSorry. The limit is 10000.");
		    }
		}
		catch(Exception e) {
			System.out.println("Exception caught: " + e);
		}
	}
				
	public static void transfer() {
		Scanner sc=new Scanner(System.in); 
		System.out.println("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.println("\nEnter Amount to transfer: ");
		float amount = sc.nextFloat();

		try {
			if(balance>= amount) {
				if(amount <= 50000f) {
					transactions++;
					balance -= amount;
					System.out.println("\nSuccesfully Transferred to "+ receipent);
					String str = amount + "Rs transferred to " + receipent+"\n";
					transactionHistory = transactionHistory.concat(str);
				}
			    else {
					System.out.println("\nSorry. The limit is 50000.");
				}
			}
		    else{
				System.out.println("\nInsufficient Balance.");
			}
		}
		catch(Exception e) {
			System.out.println("Exception caught: " + e);
		}	
	}
					
	public static void checkBalance() {
		System.out.println("\n"+balance+"Rs");
	}
				
	public static void transHistory() {
		if(transactions ==0) {
			System.out.println("No Transactions happened");
		}
		else {
			System.out.print("\n"+transactionHistory);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\n***WELCOME TO ATM INTERFACE***");
		System.out.println("\n1.Register \n2.Exit");
		System.out.println("Choose one option: ");
		int choose = sc.nextInt();
				
		if(choose == 1) {
			register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.println("Enter your choice: ");
				int ch = sc.nextInt();

				if(ch==1) {
					if(login()) {
						System.out.println("\n***WELCOME BACK "+name +"***");
						boolean isFinished = false;
						while(!isFinished) {
							System.out.println("\n1.Transaction History \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Check balance \n6.Quit");
							System.out.println("Enter your choice: ");
							int c = sc.nextInt();

							switch(c) {
							  case 1:
                                 transHistory();
								 break;
							  case 2:
                                 withdraw();
								 break;
							  case 3:
                                 deposit();
								 break;
							  case 4:
                                 transfer();
								 break;
							  case 5:
                                 checkBalance();
								 break;
							  case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
                else {
					System.exit(0);
				}
			}
		}
        else {
			System.exit(0);
		}
	}
}