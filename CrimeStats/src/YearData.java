
public class YearData {
	private int year;
	private int population;
	private int violent;
	private double violentRate;
	private int homicide;
	private double homicideRate;
	private int rape;
	private double rapeRate;
	private int assault;
	private double assaultRate;
	private int property;
	private double propertyRate;
	private int burglary;
	private double burglaryRate;
	private int larceny;
	private double larcenyRate;
	private int motor;
	private double motorRate;
	
	
	public YearData(int y, int pop, int v, double vr, int h, double hr, int r,
	double rr, int a, double ar, int p, double pr, int b, double br, int l, double lr, int m, double mr) {
		year = y;
		population = pop;
		violent = v;
		violentRate = vr;
		homicide = h;
		homicideRate = hr;
		rape = r;
		rapeRate = rr;
		assault = a;
		assaultRate = ar;
		property = p;
		propertyRate = pr;
		burglary = b;
		burglaryRate = br;
		larceny = l;
		larcenyRate = lr;
		motor = m;
		motorRate = mr;
	}
}
