package utils;

import java.text.ParseException;
import java.util.ArrayList;

import com.app.core.BankAccount;

import custom_exception.AccountHandlingException;
import static com.app.core.AccountType.*;
import static utils.ValidationUtils.*;

public class CollectionUtils {
	// add a static method to return hard coded sample data
	public static ArrayList<BankAccount> populateSampleData() {
		ArrayList<BankAccount> list = new ArrayList<>();
		try {

			list.add(new BankAccount(102, "Mohan", 5200, CURRENT, convertDate("2-3-2020")));
			list.add(new BankAccount(109, "Mohit", 8200, SAVING, convertDate("2-12-2001")));
			list.add(new BankAccount(1100, "Priya", 20000, DMAT, convertDate("5-5-2014")));
			list.add(new BankAccount(125, "Lucky", 57800, LOAN, convertDate("1-1-2020")));
			list.add(new BankAccount(2543, "Happy", 52030, CURRENT, convertDate("10-12-2006")));


		} catch (ParseException e) {
			System.out.println("err in sample data " + e);
		}
		return list;
	}

}
