package workshop03;

public class Task2Demo {
	public static void main(String[] args) {
				
		// legal side triangle
		Triangle t1 = new Triangle(2.0, 2.0, 2.0);
		t1.setColor("white");
		t1.setFilled(true);
		
		System.out.println(t1.toString());
		System.out.println("Area: " + t1.getArea());
		System.out.println("Periment: " + t1.getPerimeter());
		System.out.println("Color: " + t1.getColor());
		System.out.println("Filled: " + t1.getFilled());
		System.out.println();
		try {
			
			// illegal side triangle
			TriangleWithException t2 = new TriangleWithException(2.0, 2.0, 7.0);
			//TriangleWithException t2 = new TriangleWithException(2.0, 2.0, 4.0);
			t2.setColor("black");
			t2.setFilled(false);
			
			System.out.println(t2.toString());
			System.out.println("Area: " + t2.getArea());
			System.out.println("Periment: " + t2.getPerimeter());
			System.out.println("Color: " + t2.getColor());
			System.out.println("Filled: " + t2.getFilled());
			
		} catch(TriangleException e) {
			System.out.println(e.getMessage());
		}
	}

}
