package exploreJava.p1;

public class A1 {

	public static void main(String[] args) {

		Parent_A1 parent = new Parent_A1();
		Child_A1 child = new Child_A1();
		
		System.out.println("--------------------------------------------Override test--------------------------------------------\n");
		System.out.println(parent.var);//OUTPUT :- Parent Variable
		System.out.println(child.var);//OUTPUT :- Child Variable
		
		parent.testOverRide();//OUTPUT :- Parent Method
		child.testOverRide();//OUTPUT :- Overrided Child Method
		
		parent = child;
		
		System.out.println(parent.var);//OUTPUT :- Parent Variable
		
		parent.testOverRide();//OUTPUT :- Overrided Child Method
		//method are overrided not variables.

		
		
		
		
		System.out.println("\n\n--------------------------------------------Shift Operators--------------------------------------------\n");
		//Shift Operators
		int i = 5;
		System.out.println(i << 2);//OUTPUT :- 20            (5*(2^2))
		System.out.println(i >> 2);//OUTPUT :- 1			 (5/(2^2))
		System.out.println(i << 3);//OUTPUT :- 40			 (5*(2^3))
		System.out.println(i >> 3);//OUTPUT :- 0			 (5/(2^3))
		
		
		
		
		
		System.out.println("\n\n--------------------------------------------overloading--------------------------------------------\n");
		//test over loading
		Parent_A1 parent1 = new Parent_A1();
		Child_A1 child1 = new Child_A1();
		parent1.testOverLoad("");//OUTPUT :- Parent String testOverLoad
		child1.testOverLoad(3);//OUTPUT :- Parent Integer testOverLoad
		
//		parent1.testOverLoad(null);
		//ERROR --> The method testOverLoad(String) is ambiguous for the type Parent_A1 
		
		
		
		
		
		System.out.println("\n\n--------------------------------------------Overloading with AutoBoxing--------------------------------------------\n");
		//Method Overloading with Autoboxing
		parent1.testOverLoad(5);//OUTPUT :- Parent int testOverLoad
		parent1.testOverLoad(new Integer(5));//OUTPUT :- Parent Integer testOverLoad
		parent1.testOverLoad(new Long(5));//OUTPUT :- Parent long testOverLoad
		
		
		//parent1.testOverLoad(new Short(5));
		//ERROR --> The constructor Short(int) is undefined
		
		
		
		System.out.println("\n\n--------------------------------------------Overloading with Widening--------------------------------------------\n");
		//Method Overloading with Widening
		parent1.testOverLoad(5);//OUTPUT :- Parent int testOverLoad
		parent1.testOverLoad(new Integer(5));//OUTPUT :- Parent Integer testOverLoad
		parent1.testOverLoad(new Long(5));//OUTPUT :- Parent long testOverLoad
				
		
		
		//Integer[] array = new Integer[10000 * 10000]; 
		
		
		
		double d = 1; 
        System.out.println(d/0);//OUTPUT :- Infinity
        int q = 1; 
        System.out.println(q/0);//OUTPUT :- Exception in thread "main" java.lang.ArithmeticException: / by zero
  /*    In case of double/float division, the output is Infinity,
        the basic reason behind that it implements the floating point arithmetic algorithm which specifies a special values
        like “Not a number” OR “infinity” for “divided by zero cases” as per IEEE 754 standards.
        
        In case of integer division, it throws ArithmeticException.
        */
        
        
        
        
        //see how new is used
        Outer_A1 outer = new Outer_A1();
        Outer_A1.Inner inner = outer.new Inner();
        
        Outer_A1.StaticInner staticInner = new Outer_A1.StaticInner();
	}
	
}


class Parent_A1{
	
	String var = "Parent Variable";
	public Parent_A1() {
		System.out.println("Parent no arg COnstructor");
	}
	
	public void testOverRide() {//will be overridden
		System.out.println("Parent Method");
	}
	
	public void testOverLoad(String s) {
		System.out.println("Parent String testOverLoad");
	}
	
	public void testOverLoad(Integer s) {
		System.out.println("Parent Integer testOverLoad");
	}
	
	//primitive
	public void testOverLoad(int s) {
		System.out.println("Parent int testOverLoad");
	}
	//primitive
	public void testOverLoad(long s) {
		System.out.println("Parent long testOverLoad");
	}
	
}

class Child_A1 extends Parent_A1{
	
	String var = "Child Variable";
	public Child_A1() {
		System.out.println("Child Constructor");
	}
	
	public void testOverRide() {//overriding method
		System.out.println("Overrided Child Method");
	}	
}



abstract /*final*/ class AbstractFinalCLass{
	
	/*
	 	The class AbstractFinalCLass can be either abstract or final, not both
	 */
}

abstract class AbstractClass{
	
	//The class AbstractFinalCLass can be either abstract or final, not both
	abstract void method1(); /*{	}*/
}

final class FinalCLass{
	
	//he abstract method method1 in type FinalCLass can only be defined by an abstract class
	//abstract void method1();
}








//NESTED INTERFACES - interfaces can be nested in both class and interface

@SuppressWarnings("unused")
class HavingNestedInterface{
	
//Nested interfaces can be default, public, protected or private
	interface NestedInterface1{void nestedInterface1Method1();}
	
	public interface NestedInterface2{void nestedInterface2Method1();}
	
	protected interface NestedInterface3{void nestedInterface3Method1();}
		
	private interface NestedInterface4{void nestedInterface4Method1();} // Error (when implemented) -->> The type HavingNestedInterface.NestedInterface4 is not visible
		
}

//while inplementing we must use className.interfaceName
class NestedInterfaceImplementor implements HavingNestedInterface.NestedInterface1, HavingNestedInterface.NestedInterface2,
											HavingNestedInterface.NestedInterface3{

	@Override
	public void nestedInterface1Method1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void nestedInterface2Method1() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void nestedInterface3Method1() {
		// TODO Auto-generated method stub
		
	}

}







//INNER CLASSES

class Outer_A1{
	
	class Inner{
		
		int nonFinalInt  = 0;
		final int finalInt  = 0;
		//we can’t have static method in a nested inner class because an inner class is implicitly associated with an object of its outer class
		 //so it cannot define any static method for itself.
		
		public /*static*/ void main(String[] args) {}//ERROR --> The method main cannot be declared static; static methods can only be declared in a static or top level type
		
		
		//Method Local inner classes
		public void methodHavingInnerClass(){
			
			//Method local inner class can’t be marked as private, protected, static and transient but can be marked as abstract and final, but not both at the same time.
			class MethodLocalInnerClass{
				
			}
		}
		
	}
	
	static class StaticInner{
		
		public static void main(String[] args) {}
	}
}
