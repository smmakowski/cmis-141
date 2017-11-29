import java.awt.Color;

public class HeadPhonesTest {
	public static void main(String[] args) {
		// instantiate 3 Headphones
		HeadPhones case1 = new HeadPhones();
		HeadPhones case2 = new HeadPhones();
		HeadPhones case3 = new HeadPhones();
		// put instances in array array
		HeadPhones[] cases = new HeadPhones[]{case1, case2, case3};
		
		// use setter methods to set fields to arbitrary values
		// not setMethods not used on case1 to test default constructor values
		case2.setIsPluggedIn(true);
		case2.setManufacturer("Audio Technica");
		case2.setHeadPhoneColor(Color.black);
		case2.setHeadPhoneModel("ATH-M50X");
		
		case3.setIsPluggedIn(true); // set to true
		case3.setIsPluggedIn(false); // set back to false
		case3.setManufacturer("Beats by Dr. Dre");
		case3.setHeadPhoneColor(Color.white);
		case3.setHeadPhoneModel("Solo");
		
		System.out.println(">>>>>>>>>> TESTS FOR HeadPhones CLASS<<<<<<<<<<");
		// iterate through instance array 
		for (int i = 0; i < cases.length; i++) {
			System.out.println("*** CASE " + (i + 1) + " ***");// print header
			// print return values for get/toString/changeVolume methods
			System.out.println("getVolume(): " + cases[i].getVolume());
			System.out.println("getPluggedIn(): " + cases[i].getPluggedIn());
			System.out.println("getManufacturer(): " + cases[i].getManufacturer());
			System.out.println("getHeadPhoneColor(): " + cases[i].getHeadPhoneColor());
			System.out.println("getHeadPhoneModel(): " + cases[i].getHeadPhoneModel());
			System.out.println("toString(): " + cases[i].toString());
			cases[i].changeVolume(i); // call .changeVolume with 
		}
		System.out.println("<<<<<<<<<< END TESTS FOR HeadPhones CLASS >>>>>>>>>>");
	}
}
