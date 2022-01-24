/*
Write a java program that let the user choose his/her username and password. 
The program verifies whether the chosen username and password are valid. 
If either one of them is invalid, it notifies the user and explain the cause of invalidity. 
The rules for choosing valid usernames and passwords are:-
a. A username must be of length 6-15 characters. 
b. A username must start with an uppercase English alphabet A to Z. 
c. A password must not be shorter than 8 characters but must not exceed 256.
d. There cannot be any types of parentheses or whitespaces in a valid username or password.
e. A password cannot contain or be the same as its associated username.
*/
import java.util.*;

class RegexGenerator{
	String u_name,pass;
	Scanner sc = new Scanner(System.in);
	public void getCredentials(){
		System.out.print("\n Enter Username : ");
		u_name = sc.nextLine();
		System.out.print("\n Enter Password : ");
		pass = sc.nextLine();
	}
	public void checkCredentials(){
		int lengthOfUname=u_name.length();
		if(lengthOfUname >= 6 && lengthOfUname <= 15){
			int ascii;
			ascii = u_name.charAt(0);
			if(ascii >= 65 && ascii <=90){
				if(pass.length() < 8 || pass.length() > 256){
					System.out.println("\n Password Must Be More Than 7 characters");
					System.exit(0);
				}
				else{
					if(u_name.equals(pass)){
						System.out.println("\n User Name & Password Cannot Be Same");
						System.exit(0);
					}else{
						for(int i=0;i<lengthOfUname;i++){
							if(u_name.charAt(i) == ' ' || u_name.charAt(i) == '(' || u_name.charAt(i) == ')'){
								System.out.println("\n User Name & Password Must Not Contain Space or Parenthesis");
								System.exit(0);
							}
						}
						for(int i=0;i<pass.length();i++){
							if(pass.charAt(i) == '(' || pass.charAt(i) == ')' || pass.charAt(i) == ' '){
								System.out.println("\n User Name & Password Must Not Contain Space or Parenthesis");
								System.exit(0);
							}
						}
					}					
				}
			}else{
				System.out.println("\n User Name Must Start With An Upper-Case Letter");
				System.exit(0);
			}
		}
		else{
			System.out.println("\n User Name Must Be Between 6-15 Characters");
			System.exit(0);
		}
		System.out.println("\n The Entered Username Password Is Valid");
	}
}
class RegexCreater{
	public static void main(String args[]){
		RegexGenerator assign = new RegexGenerator();
		assign.getCredentials();
		assign.checkCredentials();
	}
}
