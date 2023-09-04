import java.util.*;
class TrainingInstitute 
{
		Scanner sc=new Scanner(System.in);

		HashMap <String, ArrayList<Integer>> Students_Data=new HashMap<>();
		HashMap <String, Integer> Students_Auth=new HashMap<>();
		ArrayList <Integer>Marks_Data=new ArrayList<>();
		public void fakedb(){
			ArrayList <Integer>Mark_Data=new ArrayList<>();
			for (int i=40;i<100 ;i=i+10 )
			{
				Mark_Data.add(i);

			}
			Students_Auth.put("1234",1234);
			Students_Auth.put("1235",1234);
			Students_Auth.put("1236",1234);
			Students_Auth.put("1237",1234);
			Students_Auth.put("1238",1234);
			Students_Auth.put("1239",1234);
			Students_Auth.put("1230",1234);
			Students_Data.put("1234",Mark_Data);
			Students_Data.put("1235",Mark_Data);
			Students_Data.put("1236",Mark_Data);
			Students_Data.put("1237",Mark_Data);
			Students_Data.put("1238",Mark_Data);
			Students_Data.put("1239",Mark_Data);
			Students_Data.put("1230",Mark_Data);

		}
		public void entry(){
			System.out.println("Welcome to ABCD Institute Mark Interface");
			System.out.println("Are you a Student or Trainer");
			System.out.println("1.Trainer");
			System.out.println("2.Student");
			int n=sc.nextInt();
			if (n==1)
			{
				trainer();
			}
			else if (n==2)
			{
				student();
			}
			else {
				System.out.println("Invalid Selection");
				entry();
			}

		}

		public void trainer(){
			System.out.println("Enter the Trainer Id");
			String id=sc.next();
			System.out.println("Enter the passcode");
			int passcode=sc.nextInt();
			if (id.equals("Trainer") && passcode == 1234)
			{
				canEnter();
			}
			else{
				System.out.println("Invalid Credentials..! Try again");
				trainer();
			}
		}
		public void canEnter(){
			ArrayList <Integer> Marks =new ArrayList<>();
			System.out.println("Trainer Login Successfully");
			System.out.println("Enter the Student id");
			String n=sc.next();
			System.out.println("Enter the Student passcode");
			int ps=sc.nextInt();
			Students_Auth.put(n,ps);
			System.out.println("Student Account Created Successfully");
			System.out.println("Enter the Total Number of tests attempted by students");
			int a=sc.nextInt();
			for (int i=0;i<a ;i++ )
			{
				System.out.println("Enter the Test"+ (i+1) + "marks ");
				int marks=sc.nextInt();
				Marks.add(marks);
			}

			Students_Data.put(n,Marks);
			getMarks(n);

			
		}
		public void student(){
			System.out.println("Enter the Student Id");
			String id=sc.next();
			System.out.println("Enter the passcode");
			int passcode=sc.nextInt();
			if (Students_Auth.get(id)==passcode)
			{
				getMarks(id);
			}
			else{
				System.out.println("Authentication Failed..! Try again");
				student();
			}
		}
		public void getMarks(String id){
			System.out.println("1. Do you want to display All test Marks" );
			System.out.println("2. Do you want to display any partiular test Marks" );
			int n=sc.nextInt();
			if (n==1)
			{
				displayMarks(id);
			}
			else if (n==2)
			{
				System.out.println("Enter the Test Number");
				int tn=sc.nextInt();
				displayMarks(id,tn);
			}
			else {
				System.out.println("Invalid Selection ! Selection any one from the list ");
			}
		}
		public void displayMarks(String id){
			for (int i=0;i<Students_Data.get(id).size() ;i++ )
			{
				System.out.println("Marks of Test " + (i+1) + " of Student with ID " + id);
				System.out.println(Students_Data.get(id).get(i));
			}
		}

		public void displayMarks(String id, int n){
				
				System.out.println("Marks of Test " + n + " of Student with ID " + id);
				System.out.println(Students_Data.get(id).get(n));
				getMarks(id);
			
		}
}
class NewProject
{
	public static void main(String [] args){
	
	TrainingInstitute TI=new TrainingInstitute();
	TI.fakedb();
	TI.entry();
	
	}
}
