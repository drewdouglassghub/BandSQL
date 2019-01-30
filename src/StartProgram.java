import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.BandHelper;
import controller.BandMemberHelper;
import model.Band;
import model.BandMember;


public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static BandMemberHelper bmh = new BandMemberHelper();
		static BandHelper bh = new BandHelper();

		private static void addAMember() {
			// TODO Auto-generated method stub
			System.out.print("Enter a first name: ");
			String firstName = in.nextLine();
			System.out.println("Enter a last name: ");
			String lastName = in.nextLine();
			System.out.print("Enter an instrument: ");
			String instrument = in.nextLine();
			System.out.print("Enter a band name the musician plays for: ");
			String bandName = in.nextLine();

			BandMember toAdd = new BandMember(firstName, lastName, instrument, bandName);
			bmh.insertMember(toAdd);
		}
		
		private static void addABand() {
			// TODO Auto-generated method stub
			System.out.print("Enter the band name: ");
			String bandName = in.nextLine();
			System.out.println("Enter the style of music: ");
			String musicStyle = in.nextLine();
			System.out.println("Enter the number of members: ");
			int numMembers = in.nextInt();

			Band toAdd = new Band(bandName, numMembers, musicStyle);
			bh.insertBand(toAdd);
		}

		private static void deleteAMember() {
			// TODO Auto-generated method stub
			System.out.print("Enter a first name: ");
			String firstName = in.nextLine();
			System.out.println("Enter a last name: ");
			String lastName = in.nextLine();
			System.out.print("Enter an instrument: ");
			String instrument = in.nextLine();

			BandMember toDelete = new BandMember(firstName, lastName, instrument);
			bmh.deleteMember(toDelete);
			System.out.println("Band member deleted");
		}
		
		private static void deleteABand() throws SQLException{
			// TODO Auto-generated method stub
			System.out.print("Enter a band name: ");
			String bandName = in.nextLine();
			System.out.print("Enter their music style: ");
			String style = in.nextLine();

			Band toDelete = new Band(bandName, style);
			bh.deleteBand(toDelete);
			System.out.println("Band deleted");
		}

		private static void editAMember() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");	
			System.out.println("2 : Search by Instrument");
			int searchBy = in.nextInt();
			in.nextLine();
			List<BandMember> foundMembers;
			if (searchBy == 1) {
				System.out.print("Enter the member's first name: ");
				String memberFirstName = in.nextLine();
				System.out.println("Enter the member's last name: ");
				String memberLastName = in.nextLine();
				foundMembers = bmh.searchForMemberByName(memberFirstName, memberLastName);
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
				System.out.println("Retrieved " + toEdit.getFirstName() + " who plays " + toEdit.getInstrument());
				System.out.println("1 : Update First Name");
				System.out.println("2 : Update Last Name");
				System.out.println("3 : Update Instrument");
				System.out.println("4 : Update Band");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New First Name: ");
					String newMember = in.nextLine();
					toEdit.setFirstName(newMember);
				} else if (update == 2) {
					System.out.print("New Last Name: ");
					String newMember = in.nextLine();
					toEdit.setLastName(newMember);
				} else if (update == 3) {
					System.out.print("New Instrument: ");
					String newInstrument = in.nextLine();
					toEdit.setInstrument(newInstrument);
				} else if (update == 4) {
					System.out.print("New Band: ");
					String newBand = in.nextLine();
					toEdit.setBandName(newBand);
				}

				bmh.updateMember(toEdit);
				System.out.println("Band member updated");

			} else {
				System.out.println("---- No results found");
			}

		}
		
		private static void editABand() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");	
			System.out.println("2 : Search by Style");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Band> foundBands;
			if (searchBy == 1) {
				System.out.print("Enter the band's name: ");
				String bandName = in.nextLine();
				foundBands = bh.searchForBandByName(bandName);
			} else {
				System.out.print("Enter the item: ");
				String musicStyle = in.nextLine();
				foundBands = bh.searchForBandByStyle(musicStyle);
			}

			if (!foundBands.isEmpty()) {
				System.out.println("Found Results.");
				for (Band b : foundBands) {
					System.out.println(b.getBandId() + " : " + b.bandDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();
				
				Band toEdit = bh.searchForBandById(idToEdit);
				System.out.println("Retrieved " + toEdit.getBandName() + " who plays " + toEdit.getMusicStyle());
				System.out.println("1 : Update Band Name");
				System.out.println("2 : Update Style");
				System.out.println("3 : Update Number of Members");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Band Name: ");
					String newBand = in.nextLine();
					toEdit.setBandName(newBand);
				} else if (update == 2) {
					System.out.print("New Style: ");
					String newBand = in.nextLine();
					toEdit.setMusicStyle(newBand);
				} else if (update == 3) {
					System.out.print("New Number of Members");
					String newNumMembers = in.nextLine();
					toEdit.setMusicStyle(newNumMembers);
				}

				bh.updateBand(toEdit);
				System.out.println("Band member updated");

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) throws SQLException{
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() throws SQLException {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- View the list of band members");
				System.out.println("*  2 -- Add a member");
				System.out.println("*  3 -- Edit a member");
				System.out.println("*  4 -- Delete a member");
				System.out.println("");
				System.out.println("*  5 -- View the list of bands");
				System.out.println("*  6 -- Add a band");
				System.out.println("*  7 -- Edit a band");
				System.out.println("*  8 -- Delete a band");
				System.out.println("*  9 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					viewMemberList();
				} else if (selection == 2) {
					addAMember();
				} else if (selection == 3) {
					editAMember();
				} else if (selection == 4) {
					deleteAMember();
				}else if (selection == 5) {
					viewBandList();
				}else if (selection == 6) {
					addABand();
				}else if (selection == 7) {
					editABand();
				} 
				else if (selection == 8) {
					try{
						deleteABand();
					}
					catch (SQLException e) {
						SQLException sqlException = new SQLException();
						sqlException.initCause(e);
						throw sqlException;
					}finally
					{
						System.out.println("No such band. Try again.");
						runMenu();
					}
					
			}else {
					bmh.cleanUp();
					bh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
					System.exit(0);
				}

			}

		}
		
		private static void viewBandList() {
			List<Band> allBands = bh.showAllBands();
			for(Band singleItem : allBands){
				System.out.println(singleItem.bandDetails());
			}
			System.out.println(" ");
		}
		

		private static void viewMemberList() {
			List<BandMember> allMusicians = bmh.showAllMembers();
			for(BandMember singleItem : allMusicians){
				System.out.println(singleItem.memberDetails());
			}
			System.out.println(" ");
		}

	}


