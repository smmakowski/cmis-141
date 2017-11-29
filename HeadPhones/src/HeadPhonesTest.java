
public class HeadPhonesTest {
	public void main(String[] args) {
		// instantiate 3 Headphones
		HeadPhones case1 = new HeadPhones();
		HeadPhones case2 = new HeadPhones();
		HeadPhones case3 = new HeadPhones();
		// put instances in array array
		HeadPhones[] cases = new HeadPhones[]{case1, case2, case3};
		
		// use setter methods to set fields to arbitrary values
		// iterate through instance array 
		for (int i = 0; i < cases.length; i++) {
			System.out.println("*** CASE " + (i + 1) + " ***");// print header
			// print return values for get/toString/changeVolume methods
			System.out.println(""); // spacer
		}
	}
}
