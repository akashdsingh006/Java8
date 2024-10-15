package com.akash.lambda;

/*
 * Here we see example of Lambda Expression 
 * 
 * how to use lambda expression
 *  ( parameters )
 *  -> expression
 *  { body }
 */

@FunctionalInterface
public interface Student{
	public abstract String getStudentName(int roll);
}
public class LambdaExample1 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Normal way using Anonymous Class
//		Student student = new Student() {
//			public String getStudentName(int roll) {
//				return Integer.toString(hashCode()+roll);
//			}
//		};
//		
//		System.out.println(student.getStudentName(12));
		
		
		//Using  Lambda Expression
		lambda();
	}
	
	// (parameters) ->expression { body }
	private static void lambda() {
		
		Student student = (roll)->{
			return ("abc"+roll);
		};
		
		System.out.println(student.getStudentName(12));
	}

}
