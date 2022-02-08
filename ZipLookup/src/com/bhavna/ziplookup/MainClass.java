package com.bhavna.ziplookup;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ZipServicev1 zipService = ServiceManager.getZipServicev1();
		ZipServicev2 zipService2 = ServiceManager.getZipServicev2();
		
		System.out.println("Welcome to ZipService");
		
		char status = 'Y';
		do {
			System.out.println("Enter Your option");
			System.out.println("1. List all Zipcodes");
			System.out.println("2. Get Zipcode details");
			System.out.println("3. Add Zipcode details");
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
				case 1:
					zipService2.printAll();
					System.out.println("Do you want to return to main menu Y/N");
					status = scanner.nextLine().charAt(0);
					break;
				case 2:
					System.out.println("Enter Zipcode");
					String zipcode = scanner.nextLine().trim().replaceAll("\\s", "");
					if(!zipcode.matches("^[1-9]{1}[0-9]{5}$")) {
						System.out.println("Zipcode should be 6 digit Number");
						break;
					}
					zipService.getZipcodeDetails(zipcode);
					System.out.println("Do you want to return to main menu Y/N");
					status = scanner.nextLine().charAt(0);
					break;
				case 3:
					System.out.println("Enter Zipcode");
					zipcode = scanner.nextLine().trim().replaceAll("\\s", "");
					if(!zipcode.matches("^[1-9]{1}[0-9]{5}$")) {
						System.out.println("Zipcode should be 6 digit Number");
						break;
					}
					if(zipService.hasZipcode(zipcode)) {
						System.out.println("Zipcode is already present");
						System.out.println("Do you want to edit Y/N");
						status = scanner.nextLine().charAt(0);
						if(status != 'Y' && status != 'y') {
							status = 'Y';
							break;
						}
					}
					
					System.out.println("Enter the Area");
					String area = scanner.nextLine().trim();
					
					System.out.println("Enter the State");
					String state = scanner.nextLine().trim();
					
					System.out.println("Enter the Country");
					String country = scanner.nextLine().trim();
					
					zipService.addZipcodeDetails(zipcode, area, state, country);
					System.out.println("Do you want to return to main menu Y/N");
					status = scanner.nextLine().charAt(0);
					break;
				default:
					System.out.println("Invalid Option");
					System.out.println("Choose an option");
					
			}
		}while(status == 'Y' || status == 'y');
		
		scanner.close();
		System.out.println("Thank you");
	}
}
