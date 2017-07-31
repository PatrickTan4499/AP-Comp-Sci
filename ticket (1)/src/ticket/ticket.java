package ticket;

 abstract class ticket {
	private int number;
	private int price = 0;
	
	public ticket(int number){
		this.number = number;
	}
	public int getPrice(){
		return this.price;
	}
	public String toString(){
		String answer = ("Price: " + this.price + " " + "Ticket: " + this.number);
		return answer;
	}
	
	public void setPrice(int price){
		this.price = price;
	}

	 public static void main(String args[]){
		 WalkUpTicket a = new WalkUpTicket(5);
		 AdvanceTicket b = new AdvanceTicket(10,15);
		 SuperAdvanceTicket c = new SuperAdvanceTicket(10,20);
		 System.out.println(a.toString());
		 System.out.println(b.toString());
		 System.out.println(c.toString());
	 }
}

class WalkUpTicket extends ticket{
		
	public WalkUpTicket(int number){
		super(number);
		super.setPrice(50);
	}	
}

class AdvanceTicket extends ticket{
	
	public AdvanceTicket(int number, int daysInAdvance){
		super(number);
		if(daysInAdvance >= 10){
			super.setPrice(30);
		}else{
			super.setPrice(40);
		}
	}
 }

 class SuperAdvanceTicket extends AdvanceTicket{
	 public SuperAdvanceTicket(int number, int daysInAdvance){
		 super(number, daysInAdvance);
		 super.setPrice(super.getPrice() / 2);
		 if(daysInAdvance >= 10){
			 super.setPrice(15);
		 }else{
			 super.setPrice(20);
		 }
	}
 }
 

 
