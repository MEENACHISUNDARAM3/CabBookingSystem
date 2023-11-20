package training;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class Cab{
	private static int carCount=10;
	private String carId;
	private int first10KmCharge=10;
	private double extraKmCharge=15;
	private int first10Km=10;
	
	public Cab() {
		carCount--;
		carId="CAR"+carCount;
		
	}
	
	public String getcarId() {
		return carId;
	}
	
	public void bookCab(String source,String destination) {
		double distance=calculateDistance(source,destination);
		double fare=calculateFare(distance);
		
		LocalDateTime currentTime=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println("*******************************************");
		System.out.println(formatter.format(currentTime));
		System.out.println("Fast Taxi !");
		System.out.println("Fast And Secure !");
        System.out.println("Contat 9796553612 , 9869365911 ")
		System.out.println("Cab booked Succefully!");
		System.out.println("Cat ID :"+carId);
		System.out.println("Distance traveled :"+distance+"km");
		System.out.println("firt 10 km fare :"+first10KmCharge);
		System.out.println("extra every 1 Km fare :"+extraKmCharge);
		System.out.println("Totl fare :Rs."+fare);
		System.out.println("*******************************************");
	}
	
	private double calculateDistance(String source,String destination) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter distance between "+source+" and "+destination+" in km :");
		double distance=sc.nextDouble();
		return distance;
	}
	
	private double calculateFare(double distance) {
		double totalFare=0;
		if(distance<=10) {
			totalFare=first10KmCharge;
		}else {
			totalFare=first10KmCharge+((distance-first10Km)*extraKmCharge);
		}
		return totalFare;
	}
}
class User{
	private String username;
	private String password;
	
	public User(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getpassword() {
		return password;
	}
}

public class CabBookingSystem {
	private static List<User>users=new ArrayList<>();
	private static List<String>locations=Arrays.asList("Chennai","Coimbatore",
			"Tricy","Madurai","Cuddaloor","Erode","Nagarkovil","Salem","Tiruppur","Dindugul","Pudukottai","Namakkal","Tiruvarur","Tanjoor");
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("Welcome to Cab Booking System!");
			System.out.println("1.Regiter");
			System.out.println("2.Login");
			System.out.println("3.Exit");
			System.out.println("4.Logout");
			System.out.println("Enter your Choice :");
			int choice =sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				register();
				break;
			case 2:
				login();
				break;
			case 3:
				System.out.println("Exit");
				System.exit(0);
				break;
			case 4:
				System.out.println("Logout Succesful!");
				break;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	private static void register() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username :");
		String username=sc.nextLine();
		System.out.println("Enter password :");
		String password=sc.nextLine();
		
		User newUser= new User(username,password);
		users.add(newUser);
		System.out.println("Registration Successful!");
	}
	
	private static void login() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username : ");
		String username=sc.nextLine();
		System.out.println("Enter password :");
		String password=sc.nextLine();
		
		for(User user:users) {
			if(user.getUsername().equals(username)&&user.getpassword().equals(password)) {
				System.out.println("Login Successful!");
				userActions();
				return;
			}
		}
		System.out.println("Invalid username or password!");
	}
	
	private static void userActions() {
		Cab cab=new Cab();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Available Actions:");
		System.out.println("1.Check car Availability");
		System.out.println("2.Book a cab");
		System.out.println("3.view Tamil Nadu loations");
		System.out.println("4.Logout");
		System.out.println("Enter your Choice:");
		int choice=sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			System.out.println("Cars available:");
			break;
		case 2:
			System.out.println("Enter source locations");
			String source=sc.nextLine();
			System.out.println("Enter destination location: ");
			String destination=sc.nextLine();
			
			cab.bookCab(source, destination);
			break;
		case 3:
			System.out.println("Tamil Nadu locations:");
			for(String location:locations) {
				System.out.println(location);
			}
			break;
		case 4:
			System.out.println("Logged out Successfully!");
			break;
			default:
				System.out.println("Invalid Choice");
		}
	}
}