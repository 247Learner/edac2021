package tester;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.core.AccountType;
import com.app.core.BankAccount;

import custom_exception.AccountHandlingException;

import static utils.CollectionUtils.populateSampleData;
import static utils.ValidationUtils.*;
import static com.app.core.BankAccount.sdf;

public class TestAccountList {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			ArrayList<BankAccount> acctList = populateSampleData();
			System.out.println("Bank Accounts-");
			for (BankAccount accn : acctList)
				System.out.println(accn);
			boolean exit = false;
			while (!exit) {
				System.out.println("\nOptions\n1. Add A/C \n"
						+ "2. Search by Account no.\n3. update balance and description(customer name) of acc\n"
						+ "4. Delete an acc using acc no.\n5. Exit\n6. Display all\n");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter acct no");
						int acctNo = sc.nextInt();
						BankAccount a = new BankAccount(acctNo);
						boolean exists =acctList.contains(a);
						if(!exists) {
						System.out
								.println("Enter A/C details : desc(customerName), balance, type(SAVING,CURRENT,LOAN,DMAT), openingDate");
						acctList.add(new BankAccount(acctNo, sc.next(), validateBalance(sc.nextDouble()),
								convertType(sc.next()), sdf.parse(sc.next())));
						System.out.println("\nA/C added successfully!\n");
						}
						else 
							throw new AccountHandlingException("A/C already exists!");
						break;

					case 2:
						System.out.println("Enter acct no");
						int acctNo1 = sc.nextInt();
						BankAccount a1 = new BankAccount(acctNo1);
						int index = acctList.indexOf(a1);
						
						if(index==-1) 
							throw new AccountHandlingException("Entered A/C does not exists.");
							
						System.out.println(acctList.get(index));
						break;
						
					case 3: 
						System.out.println("Enter acct no");
						int acctNo3 = sc.nextInt();
						BankAccount a3 = new BankAccount(acctNo3);
						int index2 = acctList.indexOf(a3);
						if(index2==-1) 
							throw new AccountHandlingException("Entered A/C does not exists.");
						
						System.out.println("Enter balance and desc(customer name)");
						acctList.get(index2).setBalance(sc.nextDouble());
						acctList.get(index2).setCustomerName(sc.next());
						System.out.println("Updated balance and Name of "+acctNo3);
						break;
						
					case 4:
						boolean remAcc = false;
						System.out.println("Enter acct no");
						int acctNo2 = sc.nextInt();
						BankAccount a2 = new BankAccount(acctNo2);
						boolean exists2 =acctList.contains(a2);
						if(!exists2) {
							throw new AccountHandlingException("Entered A/C does not exists.");
						}
						System.out.println("Are you sure you want to delete the account. Please choose y/n .");
						char ans = sc.next().charAt(0);
						if(ans=='y' || ans=='Y')
							remAcc = acctList.remove(a2);
						if(remAcc)
							System.out.println("A/C deleted successfully!");
						break;
						
					case 5:
						exit = true;
						break;
					
					case 6:
						System.out.println("Bank Accounts");
						for (BankAccount accn : acctList)
							System.out.println(accn);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// reading off the pending tokens till new line
				sc.nextLine();
			}

		}

	}

}
