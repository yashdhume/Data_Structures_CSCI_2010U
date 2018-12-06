//Yash Dhume
//100653618
//Professor Samaneh Mazaheri
//CSCI 2010U
//2nd October 2018
//Assignment 1 Part 1
package Assignment1;
import java.util.Scanner;

public class a1q1 {
    private double fahrenheit;
    public a1q1(double temperature){//Constructor
        fahrenheit=temperature;
    }
    public  void setFahrenheit(double fahrenheit){//Setter
        this.fahrenheit = fahrenheit;
    }
    public  double getFahrenheit(){//Getter
        return  fahrenheit;
    }
    public double getCelsius(){//getter and convert to Celsius
        return ((fahrenheit-32)*(5.0/9));
    }
    public double getKelvin(){//getter and convert to Kelvin
        return ((fahrenheit+459.67)*(5.0/9));
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        a1q1 temp = new a1q1(scan.nextDouble());
        scan.close();
        System.out.println("Fahrenheit Getter: "+(temp.getFahrenheit()));
        System.out.println("Calsius: "+ temp.getCelsius());
        System.out.println("Kelvin: "+ temp.getKelvin());
        temp.setFahrenheit(10);
        System.out.println((temp.getFahrenheit()));

    }
}