import java.util.List;
import java.util.Scanner;

import controller.BandMemberHelper;
import model.BandMember;


public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static BandMemberHelper bmh = new BandMemberHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter an instrument: ");
			String instrument = in.nextLine();

			BandMember toAdd = new BandMember();
			bmh.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the name to delete: ");
			String store = in.nextLine();
			System.out.print("Enter the instrument to delete: ");
			String item = in.nextLine();

			BandMember toDelete = new BandMember();
			bmh.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");	
			System.out.println("2 : Search by Instrument");
			int searchBy = in.nextInt();
			in.nextLine();
			List<BandMember> foundMembers;
			if (searchBy == 1) {
				System.out.print("Enter the member name: ");
				String memberName = in.nextLine();
				foundMembers = bmh.searchForMemberByName(memberName);
			} else {
				System.out.print("Enter the item: ");
				String instrumentName = in.nextLine();
				foundMembers = bmh.searchForMemberByInstrument(instrumentName);
			}

			if (!foundMembers.isEmpty()) {
				System.out.println("Found Results.");
				for (BandMember m : foundMembers) {
					System.out.println(m.getId() + " : " + m.memberDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				BandMember toEdit = bmh.searchForMemberById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getInstrument());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Instrument");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newMember = in.nextLine();
					toEdit.setName(newMember);
				} else if (update == 2) {
					System.out.print("New Instrument: ");
					String newInstrument = in.nextLine();
					toEdit.setInstrument(newInstrument);
				}

				bmh.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					bmh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}
		

		private static void viewTheList() {
			List<BandMember> allItems = bmh.showAllItems();
			for(BandMember singleItem : allItems){
				System.out.println(singleItem.memberDetails());
			}

		}

	}


