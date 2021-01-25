package models.plan;

import java.util.HashMap;
import java.util.Map;

import models.Center;
import models.Slot;
import models.User;

public class CenterManager {
	
	Map<String, Map<Integer,Slot>> weeklySlotMap;
	Map<String, Map<String, Map<Integer,Slot>>> centerMap;
	Map<String, Map<String, Map<Integer,Slot>>> userPlan;
	
	public CenterManager() {
		weeklySlotMap = new HashMap<>();
		userPlan = new HashMap<>();
		centerMap = new HashMap<>();
	}

	public void registerCenter(Center center) {
		
		setSlotDetails();
		centerMap.put(center.getName(), weeklySlotMap);
		
	}

	private void setSlotDetails() {
		
		weeklySlotMap.put("Monday", buildSlotMap());
		weeklySlotMap.put("Tuesday", buildSlotMap());
		weeklySlotMap.put("Wednesday", buildSlotMap());
		weeklySlotMap.put("Thrusday", buildSlotMap());
		weeklySlotMap.put("Friday", buildSlotMap());
		weeklySlotMap.put("Saturday", buildSlotMap());
		weeklySlotMap.put("Sunday", buildSlotMap());
		
		
	}

	private Map<Integer, Slot> buildSlotMap() {
		
		Map<Integer, Slot> slotMap = new HashMap<>();
		
		slotMap.put(1, new Slot(1, "Cardio", 4, 4));
		slotMap.put(2, new Slot(2, "Weights", 8, 6));
		slotMap.put(3, new Slot(3, "Cardio", 9, 4));
		slotMap.put(4, new Slot(4, "Weights", 3, 3));
		slotMap.put(5, new Slot(5, "Cardio", 4, 0));
		slotMap.put(6, new Slot(6, "Cardio", 8, 3));
		slotMap.put(7, new Slot(7, "Cardio", 1, 1));
		
		return slotMap;
	}

	public void showAvailableSlots(String day) {
		
		boolean found = false;
		
		for(String center : centerMap.keySet()) {
			
			Map<Integer, Slot> daySlot = weeklySlotMap.get(day);
			
			for(Integer s : daySlot.keySet()) {
				
				if(daySlot.get(s).getFreeSlot() > 0) {
					
					found = true;
					
					System.out.println(center + (day) +" : SlotNumber -> " + s + " Available Slots are " + daySlot.get(s).getFreeSlot() +
							"and variation is "+ daySlot.get(s).getVarition());
					
				}
			}
		}
		
		if(!found) {
			System.out.println("No slots are available");
		}
	}

	public void bookPlans(String day, String name, int slotNum, String cetername) {
		
		Map<String, Map<Integer, Slot>> weelkyMap = centerMap.get(cetername);
		
		Map<Integer, Slot> daily = weelkyMap.get(day);
		
		 Slot slot = daily.get(slotNum);
		
		if(slot.getFreeSlot() > 0) {
			slot.setFreeSlot(slot.getFreeSlot() -1);
			slot.getBookedBy().add(name);
		}
		else {
			System.out.println("No free slots availabl!");
		}
		
		userPlan.put(name, plan(day,slotNum,slot));
	}

	private Map<String, Map<Integer, Slot>> plan(String day, int slotNum, Slot slot) {
		Map<String, Map<Integer, Slot>> dayPlan = new HashMap<>();
		Map<Integer, Slot> slotPlan = new HashMap<>();
		
		slotPlan.put(slotNum, slot);
		
		dayPlan.put(day, slotPlan);
		
		return dayPlan;
	}

	public void showMyPlan(String name, String planDay) {
		
		Map<String, Map<Integer, Slot>> user = userPlan.get(name);
		
		if(user == null || user.isEmpty()) {
			System.out.println("No booked plan for user");
			return;
		}
		
		Map<Integer, Slot> plan = user.get(planDay);
		
		if( plan == null ||plan.size() == 0) {
			System.out.println("No booked plan for the day");
			return;
		}
		
		System.out.println("Booked Plans are ");
		
		
		for(Integer i : plan.keySet()) {
			
			System.out.println((planDay) +" slotNumber : " + i );
		}
		
	}

	public void registerUser(User user) {

		if(userPlan.containsKey(user.getName())){
			System.out.println("User Already Exists!");
			return;
		}
		
		userPlan.put(user.getName(), new HashMap<>());
	}
}
