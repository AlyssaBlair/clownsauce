import java.util.Arrays;
import java.util.Scanner;
import java.text.NumberFormat;
import java.lang.Math; 

class HousePricer {
    
    public static final int PRICIFIER = 3000000;
	
        String color1;
        String color2;
        String color3;
        String color4;

    public HousePricer(String color1, String color2, String color3, String color4) {
        this.color1 = color1;
	this.color2 = color2;
        this.color3 = color3;
	this.color4 = color4;
    }

    public static final String[] colors = {"grey", "green", "blue", "yellow", "pink", "wild"};

    public static final int grey = 20;
    public static final int green = 16;
    public static final int blue = 14;
    public static final int yellow = 5;
    public static final int pink = 8;
    public static final int wild = 40;

    public static double[] colorValues = {grey, green, blue, yellow, pink, wild}; 

    public double getColorValue(String colorEntered) {
	int index = 0;
	for (int i = 0; i < 6; i++) {
	    if (colorEntered.equals(colors[i])) {
		index = i;
	    }
	}
	return colorValues[index];
    }

    public String roundToTenThousands(double homeValue, int priceNumber) {
	int roundedHomePrice = 0;
	homeValue = homeValue/(Math.pow(2, (priceNumber-1)));
	homeValue = homeValue/10000;
	homeValue = Math.round(homeValue);
	homeValue = homeValue * 10000;
	roundedHomePrice = (int) homeValue;
        String priceString = NumberFormat.getInstance().format(roundedHomePrice);
	return priceString;
    }

    public static void main(String args[]) {

	System.out.println();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter cube color 1");

        String cube1 = myObj.nextLine();  // Read user input
        System.out.println();
        
        Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter cube color 2");

        String cube2 = myObj2.nextLine();  // Read user input
        System.out.println();

        Scanner myObj3 = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter cube color 3");

        String cube3 = myObj3.nextLine();  // Read user input
        System.out.println();

        Scanner myObj4 = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter cube color 4");

        String cube4 = myObj4.nextLine();  // Read user input
        System.out.println();

        HousePricer housePricer = new HousePricer(cube1, cube2, cube3, cube4);

	double homeValue = (PRICIFIER * ((1/(housePricer.getColorValue(cube1)) + (1/housePricer.getColorValue(cube2)) + (1/housePricer.getColorValue(cube3)) + (1/housePricer.getColorValue(cube4))))); 

        System.out.println("Prices for this home:");
	System.out.println();

	//System.out.println(homeValue);

	String maxPrice = housePricer.roundToTenThousands(homeValue, 1);
	System.out.println("Price 1: $" + maxPrice);

        System.out.println();

        String price2 = housePricer.roundToTenThousands(homeValue, 2);
	System.out.println("Price 2: $" + price2);
	
	System.out.println();

        String price3 = housePricer.roundToTenThousands(homeValue, 3);
	System.out.println("Price 3: $" + price3);

	System.out.println();

        String price4 = housePricer.roundToTenThousands(homeValue, 4);
	System.out.println("Price 1: $" + price4);

	System.out.println();
    
    }

}
