package Driver;

import java.util.Scanner;

import models.Center;
import models.User;
import models.plan.CenterManager;

public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		CenterManager centerManger = new CenterManager();
		
		int userId = 0;
		int centerId = 0;
		
		String name = "";
		
		while(true) {
			
			String command = sc.nextLine();
			String[] commands = command.split(" ");
			String commandType = commands[0];
			
			switch(commandType) {
			
				case "RegisterUser" :
					name = commands[1];
					centerManger.registerUser(new User(name, ++userId));
				break;
				case "AddCenters" :
					String cname = commands[1];
					centerManger.registerCenter(new Center(cname, ++centerId));
					break;
				case "ShowSlots" :
					String day = commands[1];
					centerManger.showAvailableSlots(day);
					break;
				case "Book" :
					String bookingDay = commands[1];
					int slot = Integer.parseInt(commands[2]);
					String cetername = commands[3];
					centerManger.bookPlans(bookingDay,name,slot,cetername);
					break;
				case "viewMyPlan" :
					String planDay = commands[1];
					centerManger.showMyPlan(name,planDay);
					break;
			}
		}
	}
}
