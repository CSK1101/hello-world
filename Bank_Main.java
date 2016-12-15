import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Bank_Main {
	public static final String DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";//Date and time codes
	public static String dt;//Date and time codes
	public static String DateTime()//Date and time codes
	{
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	return sdf.format(cal.getTime());
	}
	
	
	public static void main(String[] args){
	Scanner console = new Scanner(System.in);
	String ClientFile = "C:\\Users\\CSK\\Dropbox\\Cheik\\TXT files\\Bank_Client.txt";
	Calendar now = Calendar.getInstance();
	char aChar = 'a';
	Bank_Main dAT = new Bank_Main();//Code for date and time
	dt = dAT.DateTime();//Code for date and time
	
	int sub;
	int add;
	int currentuser = 0;
	int user_send = 0;
	int credit_percentage = 2/100;
	int timestried = 0;
	int dept_increase;
	int time_credit;
	
	Vector<Bank_Client> listClients = new Vector<Bank_Client>();
	
	//Set of booleans
	boolean boo_a = true;
	boolean boo_b = true;
	boolean boo_c = false;
	boolean boo_d = true;
	
	while(boo_a){
	System.out.println("Choose a language:\n==========================================");
	System.out.println("F. Francais \nE. English \n==========================================");
	
	String aString = console.nextLine();
	System.out.println("\n==========================================");
	aChar = aString.charAt(0);
	
	if(aChar == 'F'){
	System.out.println("               Bienvenue dans la Banque de Cheik \nOu vous pourrez deposer, retirer et envoyer de l'argent.\n==========================================");
	break;
	}else if(aChar == 'E' ){
	System.out.println("                Welcome to Cheik's Bank \nWhere you will be able to deposit, withdraw and send your money.\n==========================================");
	break;
	}
	System.out.println("Please choose between the 2 options given to you / S'il vous plait choisissez l'une des 2 options qui vous ai donne.");
	}
	
	//Client setup
	BufferedReader file = null;

	try
	{
		//file = new BufferedReader(new FileReader("\\Sample1.txt"));
		
		//file is now a BufferedReader and reads Bank_Client which in in Temp folder
		file = new BufferedReader(new FileReader(ClientFile));
		String line;
		int num;
		String blankSpace1 = " ";
		
		
		for(int readClient = 0; (line = file.readLine()) != null; readClient++)
			{	
				Bank_Client client0 = new Bank_Client();
				listClients.add(client0);
			
				listClients.get(readClient).firstname = line;
				line = file.readLine();
				listClients.get(readClient).lastname = line;
				line = file.readLine();
				listClients.get(readClient).username = line;
				line = file.readLine();
				listClients.get(readClient).password = line;
				line = file.readLine();
				listClients.get(readClient).accountID = (line);
				line = file.readLine();
				listClients.get(readClient).credit = Integer.parseInt(line);
				line = file.readLine();
				listClients.get(readClient).sold = Integer.parseInt(line);
				line = file.readLine();
				for(int zeros = 0; zeros < 5; zeros++) {
					listClients.get(readClient).space[zeros] = Integer.parseInt(line);
					line = file.readLine();
				}
				blankSpace1 = line;
			}
			
		}
	//If file is not found
	catch (FileNotFoundException e)
	{
	if(aChar == 'F') {
			System.err.println("Ne peut pas ouvrir le document.");
		}
			
		else if(aChar == 'E') { 
			System.err.println("Cannot open file");
		}
	}
	//Exits program if there is an error
	catch (IOException e)
	{
     System.exit(0);
	}
	finally
  	{
	  
	 //?
     try
     {
        if (file != null) file.close();
     }
     catch (IOException e)
     {
        System.err.println(e);
     }
  	}
	
	while(boo_b){

		try {
			if(aChar == 'F') {
	  			System.out.println("A. Creer un compte. \nL. Ouvrez votre compte.\n==========================================");
	  		}
	  			
	  		else if(aChar == 'E') { 
	  			System.out.println("A. Create an account. \nL. Open your account.\n==========================================");
	  		}
	  			
			//Reads what the user wrote
			Scanner input1 = new Scanner(System.in);
	    	String choice1 = input1.nextLine().toUpperCase();
	    	char accountQ1 = choice1.charAt(0);
			
			switch (accountQ1) {
				
				//If the user wants to create an account
				case 'A': {
					
					//Creates a client object	
					Bank_Client client1 = new Bank_Client();
					//Adds a client to the listClients vector
					listClients.add(client1);

					boolean firstNameWrong = true;
					boolean lastNameWrong = true;
					boolean userNameWrong = true;
					boolean passwordWrong = true;
					boolean soldwrong = true;
					
					do {
						//Adds first name
						if(aChar == 'F') {
				  			System.out.println("Quel est votre prenom?");
				  		}
				  			
				  		else if(aChar == 'E') { 
				  			System.out.println("What is your first name?");
				  		}
						
						if (boo_d) {
							client1.firstname = console.nextLine();
							boo_d = false;
						}
						client1.firstname = console.nextLine();
						if (client1.firstname.length() <= 0) {
							if(aChar == 'F') {
								System.out.println("Veuillez ecrire votre prenom s'il vous plait.\n");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("Write your first name please.\n");
						  	}
							continue;
						}
						else {
							firstNameWrong = false;
						}
					} while (firstNameWrong);
					
					do {
						//Adds last name
						if(aChar == 'F') {
				  			System.out.println("Quel est votre nom de famille?");
				  		}
				  			
				  		else if(aChar == 'E') {
							System.out.println("What is your last name?");
				  		}
						client1.lastname = console.nextLine();
						if (client1.lastname.length() <= 0) {
							if(aChar == 'F') {
								System.out.println("Ecrivez votre nom de famille s'il vous plait.\n");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("Write your last name please.\n");
						  	}
							continue;
						}
						else {
							lastNameWrong = false;
						}
					} while (lastNameWrong);
					
					do {
						//Adds username
						if(aChar == 'F') {
				  			System.out.println("S'il vous plait creez un nom d'utilisateur.");
				  		}
				  			
				  		else if(aChar == 'E') {
				  			System.out.println("Please create a username.");
				  		}
						client1.username = console.nextLine();
						if (client1.username.length() <= 0) {
							if(aChar == 'F') {
								System.out.println("Creez un nom d'utilisateur s'il vous plait.\n");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("Write a username please.\n");
						  	}
							continue;
						}
						else {
							userNameWrong = false;
						}
					} while (userNameWrong);
					
					do {
						//Adds password
						if(aChar == 'F') {
				  			System.out.println("S'il vous plait creez un mot-de-passe.");
				  		}
				  			
				  		else if(aChar == 'E') {
				  			System.out.println("Please create a password.");
				  		}
						client1.password = console.nextLine();
						System.out.println("\n==========================================");
						if (client1.password.length() <= 0) {
							if(aChar == 'F') {
								System.out.println("Ecrivez un mot de passe s'il vous plait.\n");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("Write a password please.\n");
						  	}
							continue;
						}
						else {
							passwordWrong = false;
						}
					} while (passwordWrong);
					
					do {
						//Adds sold
						if(aChar == 'F') {
				  			System.out.println("Deposez une somme de depart.");
				  		}
				  			
				  		else if(aChar == 'E') {
				  			System.out.println("Deposit money to begin.");
				  		}
						client1.sold = console.nextInt();
						if (client1.sold < 0) {
							if(aChar == 'F') {
								System.out.println("Deposez une somme plus grande que 0.");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("Deposit an ammount higher than 0.");
						  	}
							continue;
						}
						else {
							soldwrong = false;
						}
					} while (soldwrong);
					
					//Gives the client an ID
					int tempAccountID = listClients.size();
					client1.accountID = Integer.toString(tempAccountID);
					
					//To account for the fact that the first thing in a Vector is equal to 0
					currentuser = tempAccountID - 1;
					
					int START = 1000;
				    int END = 10000;
				    
				    //Uses randInt method
				    int tempRandInt1 = randInt(START, END);  
				    int tempRandInt2 = randInt(START, END);
				    int tempRandInt3 = randInt(START, END);
				      
				    //Adds the three random numbers generated in randInt to the end
				    //of accountID
				    client1.accountID = client1.accountID + " " + tempRandInt1 + " " + tempRandInt2 + " " + tempRandInt3;
					
				    if(aChar == 'F') {
				    	System.out.print("Bienvenue " + client1.username + "!"
								+ "\nTon chiffre ID est " + client1.accountID);
				    	System.out.println("\nVous avez cree un compte et vous estes maintenant connecte.\n==========================================");
			  		}
			  			
			  		else if(aChar == 'E') {
			  			System.out.print("Welcome " + client1.username + "!"
								+ "\nYour ID number is " + client1.accountID);
			  			System.out.println("\nYou have sucessfully created and account and are now logged in.\n==========================================");
			  		}
					
					boo_b = false;
					break;
				}
				
				//If the user wants to login
				case 'L': {
					boo_a = false;
					if(aChar == 'F') {
			  			System.out.println("Quel est votre nom d'utilisateur?");
			  		}
			  			
			  		else if(aChar == 'E') {
			  			System.out.println("What is your username?");
			  		}
					String enteredUserName = console.nextLine();
					if (timestried == 0) {
						enteredUserName = console.nextLine();
					}
					
					for (int lookForUsername = 0; lookForUsername < listClients.size(); lookForUsername++) {
						if (enteredUserName.equals(listClients.get(lookForUsername).username)){
							
							if(aChar == 'F') {
					  			System.out.println("Quel est votre mot-de-passe?");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("What is your password?");
					  		}
							String enteredPassword = console.nextLine();
							System.out.println("\n==========================================");
							
								if (enteredPassword.equals(listClients.get(lookForUsername).password)){
									boo_b = false;
									currentuser = lookForUsername;
									if(aChar == 'F') {
							  			System.out.println("Bienvenue " + listClients.get(currentuser).firstname + " " + listClients.get(currentuser).lastname + "!\n==========================================");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Welcome back " + listClients.get(currentuser).firstname + " " + listClients.get(currentuser).lastname + "!\n==========================================");
							  		}
									break;
								}
						}
					}
					
					if (boo_b == true) {
						
						if(aChar == 'F') {
				  			System.out.println("Le nom d'utilisateur ou mot-de-passe que vous avez inscrit n'est pas valide.");
				  		}
				  			
				  		else if(aChar == 'E') {
				  			System.out.println("The username or password you entered is not valid.");
				  		}
				  		timestried ++;
					}
					
					break;
				}
				
				//If the user does not enter either a, or l.
				default: {
					if(aChar == 'F') {
			  			System.out.println("Pressez 'A' ou 'L' s'il vous plait.");
			  		}
			  			
			  		else if(aChar == 'E') {
			  			System.out.println("Please enter either 'A' or 'L'.");
			  		}
					break;
				}
			}
		} catch (Exception e) {
			if(aChar == 'F') {
	  			System.out.println("Pressez 'A' ou 'L' s'il vous plait.");
	  		}
	  			
	  		else if(aChar == 'E') {
	  			System.out.println("Please enter either 'A' or 'L'.");
	  		}
		}
	
	}//while loop closing bracket boo_b
	
	while(boo_a){
	
		try {
			if(aChar == 'F') {
				System.out.println("\n==========================================");
				System.out.println("                    MENU\n=========================================="
						+ "\nD. Deposez de l'argent."
						+ "\nR. Retirer de l'argent."
						+ "\nS. Envoyer de l'argent."
						+ "\nC. Prendre un credit."
						+ "\nP. Payer votre dette."
						+ "\nI. Montrer les informations sur votre compte."
						+ "\nH. Historique des transactions."
						+ "\nX. Quittez la banque.\n==========================================");
	  		}
	  			
	  		else if(aChar == 'E') {
	  			System.out.println("\n==========================================");
	  			System.out.println("                    MAIN MENU\n=========================================="
	  					+ "\nD. Deposit money."
						+ "\nR. Withdraw money."
						+ "\nS. Send money."
						+ "\nC. Take a credit."
						+ "\nP. Pay your debt."
						+ "\nI. Information on your account."
						+ "\nX. Exit the bank.\n==========================================");
	  		}
		Scanner input2 = new Scanner(System.in);
    	String choice2 = input2.nextLine().toUpperCase();
    	char accountQ2 = choice2.charAt(0);
    	
	switch(accountQ2){
		//If the user wants to exit
	
	//Client wants to deposit money in his account
	case 'D': {
	if(aChar == 'F'){
		System.out.println("Entrez le montant d'argent que vous desirez deposer sur votre compte:\n==========================================");
	 }else if(aChar == 'E'){
		System.out.println("Input the amount of money you wish to deposit on your account:\n=========================================="); 
	 }
	add = console.nextInt();
	System.out.println("\n==========================================");
	int sum = listClients.get(currentuser).sold + add;
	listClients.get(currentuser).sold = sum;
	
	if(aChar == 'F'){
		System.out.println(add + "$ a ete depose avec succes dans votre compte.\n=========================================="); 
	 }else if(aChar == 'E'){
		 System.out.println(add + "$ was succesfully deposited on your account.\n=========================================="); 
	 }
	break;
	}
	
	//Client wants to withdraw money from his account
	case'R': {
	if(aChar == 'F'){
	System.out.println("Entrez le montant d'argent que vous desirez retirer de votre compte:\n==========================================");
	}else if(aChar == 'E'){
	 System.out.println("Input the amount of money you wish to withdraw from your account:\n=========================================="); 
	}
	add = console.nextInt();
	System.out.println("\n==========================================");
	int sum = listClients.get(currentuser).sold - add;
	listClients.get(currentuser).sold = sum;
	
	if(aChar == 'F'){
		System.out.println(add + "$ a ete retire avec succes dans votre compte.\n=========================================="); 
	 }else if(aChar == 'E'){
		 System.out.println(add + "$ was succesfully withdrawned from your account.\n=========================================="); 
	 }
	break;
	}
	
	//Client wants to send money to another account
	case 'S': {
		if(aChar == 'F') {
			System.out.println("Voici la liste des utilisateurs et de leurs nom d'utilisateur:\n==========================================");
		}else if(aChar == 'E'){
			System.out.println("Here is the list of the users and their username:\n==========================================");
		}
	
	for (int lookForUsername = 0; lookForUsername < listClients.size(); lookForUsername++) {
	System.out.println( "Username: "+ listClients.get(lookForUsername).username + "\nAccountID: " + listClients.get(lookForUsername).accountID + "\n==========================================");}
	
	if(aChar == 'F') {
			System.out.println("Choisissez l'utilisateur a qui vous voulez envoyer de l'argent, ecrivez leur nom d'utilisateur et leurs accountID:\n==========================================");
		}else if(aChar == 'E'){
			System.out.println("Choose the user for whom you want to sent money, write their username and their accountID:\n==========================================");
		}
	
	if(aChar == 'F') {
			System.out.println("Ecrivez le nom d'utilisateur:\n==========================================");
		}
			
		else if(aChar == 'E') {
			System.out.println("Write the username:\n==========================================");
		}
	
	String chosen__user = console.nextLine();
	System.out.println("\n==========================================");
	
	for (int lookForUsername = 0; lookForUsername < listClients.size(); lookForUsername++) {
		if (chosen__user.equals(listClients.get(lookForUsername).username)){
			
			if(aChar == 'F') {
	  			System.out.println("Ecrivez le accountID:\n==========================================");
	  		}
	  			
	  		else if(aChar == 'E') {
	  			System.out.println("Write the accountID:\n==========================================");
	  		}
			String accountID_input = console.nextLine();
			System.out.println("\n==========================================");
			
			
				if (accountID_input.equals(listClients.get(lookForUsername).accountID)){
					boo_b = false;
					user_send = lookForUsername;
					
					if(aChar == 'F') {
			  			System.out.println("Entrez la somme que vous desirez envoyer a " + listClients.get(user_send).username + ":\n==========================================");
			  		}
			  			
			  		else if(aChar == 'E') {
			  			System.out.println("Enter the ammount of money you wish to send to " + listClients.get(user_send).username + ":\n==========================================");
			  		}
					
					int ammount_input = console.nextInt();
					System.out.println("\n==========================================");
			  		int sum = listClients.get(currentuser).sold - ammount_input;
			  		int sum_send = listClients.get(user_send).sold + ammount_input;
			  		listClients.get(currentuser).sold = sum;
			  		listClients.get(user_send).sold = sum_send;
				}
		}
	}
	
	if(aChar == 'F') {
			System.out.println("Your sold:" + listClients.get(currentuser).sold + "$\n==========================================");
		}
			
		else if(aChar == 'E') {
			System.out.println("Sold:" + listClients.get(currentuser).sold + "$\n==========================================");
		}
	
	break;
	}
	
	//Client wants to take a credit
	case 'C': {
		if(aChar == 'F'){
			System.out.println("Ecrivez la quantite d'argent dont vous avez besoin (comprenez que ce que vous l'argent que vous nous devrez pourrai etre plus que ce que nous vous avions donne):\n==========================================");
		}else if(aChar == 'E'){
			System.out.println("Enter the ammount of money you need (understand that what you will payback might be higher then what we gave you):\n==========================================");
		}
		
		int loan_input = console.nextInt();
		System.out.println("\n==========================================");
		
		int sum = listClients.get(currentuser).sold + loan_input;
		int cred = listClients.get(currentuser).credit + loan_input;
		
		listClients.get(currentuser).sold = sum;//Sold update
		listClients.get(currentuser).credit = cred;//Credit update
		
		if(aChar == 'F'){
			System.out.println("Solde: " + listClients.get(currentuser).sold + "$");
			System.out.println("Dette: " + listClients.get(currentuser).credit + "$\n==========================================");
		}else if(aChar == 'E'){
			System.out.println("Solde: " + listClients.get(currentuser).sold + "$");
			System.out.println("Dept: " + listClients.get(currentuser).credit + "$\n==========================================");
		}	
	break;	
	}
	
	//Client wants to pay his debt
	case 'P': {
	if(aChar == 'F'){
		System.out.println("Ecrivez la somme que vous desirez utiliser pour payer votre dette:\n==========================================");	
	}else if(aChar == 'E'){
		System.out.println("Write the amount of money you wish to use to pay your debt:\n==========================================");
	}
	
	int debt_money = console.nextInt();
	
	int sum = listClients.get(currentuser).sold - debt_money;
	int cred = listClients.get(currentuser).credit - debt_money;
	
	listClients.get(currentuser).sold = sum;//Update of the client's sold
	listClients.get(currentuser).credit = cred;//Update of the client's credit
	
	if(aChar == 'F'){
		System.out.println("Solde: " + listClients.get(currentuser).sold + "$");
		System.out.println("Credit: " + listClients.get(currentuser).credit + "$\n==========================================");
	}else if(aChar == 'E'){
		System.out.println("Solde: " + listClients.get(currentuser).sold + "$");
		System.out.println("Credit: " + listClients.get(currentuser).credit + "$\n==========================================");
	}
	break;
	}
	
	//Client wants to see the information on his account
	case 'I': {

		if(aChar == 'F') {
			System.out.print("Nom: " + listClients.get(currentuser).firstname + " "
					+ listClients.get(currentuser).lastname
					+ "\nNom d'utilisateur: " + listClients.get(currentuser).username
					+ "\nChiffre ID: " + listClients.get(currentuser).accountID
					+ "\nCredit: " + listClients.get(currentuser).credit + "$"
					+ "\nSold: " + listClients.get(currentuser).sold + "$\n==========================================");
  		}
  			
  		else if(aChar == 'E') {
  			System.out.print("Name: " + listClients.get(currentuser).firstname + " "
					+ listClients.get(currentuser).lastname
					+ "\nUsername: " + listClients.get(currentuser).username
					+ "\nPassword: " + listClients.get(currentuser).password
					+ "\nAccount ID: " + listClients.get(currentuser).accountID
					+ "\nCredit: " + listClients.get(currentuser).credit + "$"
					+ "\nSold: " + listClients.get(currentuser).sold + "$\n==========================================");
  		}
		
		break;	
	
	}
	
	//Client wants to see his historic
	case 'H' : {
		
		
		/*
		System.out.println("=======================================" );
		System.out.println(dt);//Shows when the user withdrawn from his account
		System.out.println("Account:                 " + listClients.get(printClient).sold + "$");
		System.out.println("Withdrawn:              -" + withdraw + "$");
		System.out.println("Rest:                    " + amount + "$");
		System.out.println("=======================================");
		System.out.println("You got " + amount + "$ left on your account." );
		System.out.println("=======================================");
		*/
	
	}
	
	//Client decides to leave
	case 'X': {
		
		//Save the client information
		try {
		    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(ClientFile)));
		 
		    //While there are still clients in the listClients vector,
		    //save the client information to the file
			for(int printClient = 0; printClient < listClients.size(); printClient++)
			{	writer.print(listClients.get(printClient).firstname +
				"\n" + listClients.get(printClient).lastname +
				"\n" + listClients.get(printClient).username +
				"\n" + listClients.get(printClient).password +
				"\n" + listClients.get(printClient).accountID +
				"\n" + listClients.get(printClient).credit +
				"\n" + listClients.get(printClient).sold +
				"\n");
			for(int printBooksTaken = 0; printBooksTaken < 5; printBooksTaken++) {
				writer.println(listClients.get(printClient).space[printBooksTaken]);
			}
			writer.print("\n");
			}
			writer.close();
		}
		//If it doesn't work
		catch(IOException e) {
			if(aChar == 'F') {
				System.out.println("Un erreur s'est produit en essayant d'ecrire l'information de client au document.");
	  		}
	  			
	  		else if(aChar == 'E') {
	  			System.err.println("An error occured while trying to write client information to the file.");
	  		}
			
			break;
		}
		
		boo_a = false;
		//End message
		if(aChar == 'F') {
			System.out.println("\nBonne journee!"
					+ "\nTu est maintenant deconnecte.");
  		}
  			
  		else if(aChar == 'E') {
  			System.out.println("\nHave a nice day!"
					+ "\nYou have been successfully logged out.");
  		}

		break;
			}
		}
	}catch (Exception e) {
			if(aChar == 'F') {
				System.out.println("Pressez b, r, d, i ou x.");
	  		}
	  			
	  		else if(aChar == 'E') {
				System.out.println("Plese enter either b, r, d, i or x.");
	  		}
		}
	
	}
	}//Main bracket
	
	public static int randInt(int min, int max) {
		
		//create a Random
	    Random rand = new Random();

	    //Assigns the Random something between min and max
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    
	    //Returns the Random
	    return randomNum;
	}
}//Class bracket
