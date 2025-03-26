package hexawareTraining;
import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.naming.LinkLoopException;
import javax.swing.event.ListSelectionEvent;
public class Sample {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello world");
//		
//		Integer a= 10;
//		Integer b=11;
//		System.out.println(System.identityHashCode(a)+" "+System.identityHashCode(b));
//		
//		BigDecimal num1 = new BigDecimal("0.1");
//		BigDecimal num2 = new BigDecimal("0.2");
//		BigDecimal sum = num1.add(num2);
//		System.out.println(sum.compareTo(new BigDecimal("0.3"))==0);
//		
//		int []arr= {1,2,4,5};
//		
//		System.out.println((arr instanceof Object)?"Arrays is an Object":"Array is not an Object");
		//System.out.println(arr.getClass().getSuperclass());
	//	List<Integer> list1 = Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new));
		/*
		List<Integer> arrayList= Arrays.asList(12,34,54,23,54,56);
		System.out.println("List : "+arrayList);
		int sum= arrayList.stream().reduce(0,(n1,n2)->n1+n2);
		System.out.println("reduce() -> Sum : "+sum);
		
		List<Integer> reverList = arrayList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sort method->\nAscending"+arrayList+"\nDescending" + reverList);
		
		List<Integer> evenList= arrayList.stream().filter((n1)->n1%2==0).collect(Collectors.toList());
		System.out.println("filter()-> "+evenList);
		
		
		List<Integer> squareList= arrayList.stream().map(n->n*n).collect(Collectors.toList());
		System.out.println("Map() -> "+squareList);
		
		List<Integer> uniqueList =arrayList.stream().distinct().collect(Collectors.toList());
		System.out.println("distinct() ->"+uniqueList);
		
		System.out.println("Count() ->"+arrayList.stream().count());
		
		List<Integer> limitedList= arrayList.stream().limit(3).collect(Collectors.toList());
		
		System.out.println("limit() -> "+limitedList);
		
		List<Integer> skipedList= arrayList.stream().skip(2).collect(Collectors.toList());
		
		System.out.println("skip() -> "+skipedList);
		
		System.out.println("AnyMatch to find Even number- > "+ arrayList.stream().anyMatch((n)->n%2==0));
		
		System.out.println("allMatch() to find Even number- > "+ arrayList.stream().allMatch((n)->n%2==0));
		
		System.out.println("noneMatch() to find negative numbers- > "+ arrayList.stream().noneMatch((n)->n<0));
		
		System.out.println("Find minimum ->"+ arrayList.stream().min(Integer::compare).get());
		System.out.println("find Maximum ->"+ arrayList.stream().max(Integer::compare).get());
		
		
		List<Integer> sol = arrayList.stream().peek(n -> System.out.println("Processing: " + n)).map(n -> n * 2).collect(Collectors.toList());
		
		System.out.println(sol);
		
		*/
		
		
		//Afternoon session - ControlStatement
		
		// labeling loops
		
//		int n=5;
//		
//		outerLoop :
//			for(int i=0;i<n;i++) {
//				innerLoop :
//					for(int j=0;j<n;j++) {
//						System.out.println(i+" "+j);
//						
//						if(i==3) break outerLoop;
//						
//						if(j==4) break innerLoop;
//					}
//			}
//		
		
		// labelling blocks
//		outerBlock: { 
//			
//            System.out.println("Inside outer block");
//            
//            innerBlock: { 
//                System.out.println("Inside inner block");
//                if (Math.random() > 0.5) {
//                    break outerBlock; 
//                }
//                System.out.println("Still inside inner block");
//            }
//            System.out.println("Still inside outer block");
//        }
//        System.out.println("Outside all blocks");
//		
		
        
        
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your Country");
//        String country = sc.next();
//
//        if (country.equalsIgnoreCase("India")) {
//            System.out.println("Enter your city");
//            String city = sc.next();
//
//            if (city.equalsIgnoreCase("Delhi")) {
//                System.out.println("Your center to collect AADhar card is XYZ");
//            } else if (city.equalsIgnoreCase("Mumbai")) {
//                System.out.println("Your center to collect AADhar card is ABC");
//            } else {
//                System.out.println("Location is allocated for Delhi and Mumbai - Try Again!");
//            }
//        } else {
//            System.out.println("Service is only available in India.");
//        }
//		
//        System.out.println(5>3&&5<5?"yes":"false");
//        int key=4;
//        switch (key) {
//		case 1->System.out.println(key);
//		case 2->System.out.println(key);
//		
//		default ->System.out.println("Defalut");
//        }	
        
//        System.out.println("Enter your role");
//        String role=sc.nextLine();
//        
//        role=role.toUpperCase();
//        String grantedAccess = switch (role) {
//        case "STUDEN" -> "Manange course materials,assignments and Feedback";
//        case "TEACHER" -> "Manage courses, grade assignments and view student records";
//        case "LIBRARIAN" -> "Manage library resources, issue and return books";
//        case "ADMIN" -> "Full access to all systems, manage users and permissions";
//        case "GUEST" -> "View public announcements and college information";
//        case "DEAN"->"Manage Hostel Residence and Hostel foodcourt";
//        default -> "Invalid role";
//         };
//        System.out.println("ROLE : "+role+"\nGranted Access : "+grantedAccess);
//        
//        Object choiceObject =sc.next();
//        
//        switch(choiceObject) {
//        case Integer i->System.out.println("Integer " + i);
//        
//        case String s->System.out.println("String " + s);
//        
//        default ->System.out.println("Others"+choiceObject.getClass());
//        
//        
//        }
        
//        loopOne:
//        	for(int i=0;i<10;i++) {
//        		loopTwo:
//        			for(int j=0;j<10;j++) {
//        				loopThree:
//        					for(int k=0;k<10;k++) {
//        						
//        						System.out.println("i : "+i+" j : "+j+" k : "+k);
//        						
//        						if(i==5) break loopOne;
//        						
//        						if(j==7) break loopTwo;
//        						
//        						if(k==4) break loopThree;
//        					}
//        			}
//        	}
//        int count;
//        outerLoop:
//        while(true) {
//        	count=0;
//        	innerLoop:
//        	while(true) {
//        		System.out.println("Enter your choice : ");
//        		String choiceString = sc.next();
//        		if(choiceString.compareToIgnoreCase("outerLoop")==1) {
//        			break outerLoop;
//        			
//        		}
//        		else if(choiceString.compareToIgnoreCase("innerLoop")==1) {
//        			break innerLoop;
//        		}
//        		
//        		else System.out.println("Loop continues , count : "+(++count));
//        		
//        	}
//        }
        
        
        String[][] flights = {
                {"FlightI", "Available", "Booked", "Available", "1,2,3,4,5"},
                {"FlightII", "Booked", "Booked", "Available","65,34,34,65,76,32,43"},
                {"FlightIII", "Available", "Available", "Available","12,54,32,65,76,66,44"}
            };
        String choiceString;
        
//        do {
//        
//        
//
//            System.out.print("Enter Flight Name to Check : ");
//            String flightName = sc.next();
//            boolean found=false;
//            for (int i=0;i<flights.length;i++) {
//            	
//                if (flights[i][0].equalsIgnoreCase(flightName)) {
//                    
//                    System.out.println("Flight " + flightName.toUpperCase()+ " Found");
//                    
//                    System.out.println("Seat Availability : "+flights[i][4]);
//                    found=true;
//                    break;
//                    
//                }
//                
//               
//            }
//            
//            if(!found) {
//            	System.out.println("Flight " + flightName + " Not Found!");
//            	
//            }
//            System.out.println("Do you wish to contine (yes/no)");
//          choiceString =    sc.next();
//         
//        }while(choiceString.equalsIgnoreCase("yes"));
        
        //System.out.println("Program Finished ");
        
        //String choiceString;
        do {
            System.out.print("Enter Flight Name to Check: ");
            String flightName = sc.next();

            String[] matchedFlight = Arrays.stream(flights).filter(flight -> flight[0].equalsIgnoreCase(flightName)).findFirst().orElse(null);
                   
            if(matchedFlight!=null){
            	
                System.out.println("Flight " + flightName.toUpperCase() + " Found");
                System.out.println("Seat Availability: " + matchedFlight[4]);
                
            } else {
            	
                System.out.println("Flight " + flightName + " Not Found!");
                
            }

            System.out.println("Do you wish to continue (yes/no): ");
            choiceString = sc.next();
            

        }while(choiceString.equalsIgnoreCase("yes"));

        System.out.println("Program Finished");
           
			
	}

}


