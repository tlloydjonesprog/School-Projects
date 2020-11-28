import java.util.*;

public class QuadraticEquation {

    public static Scanner sc = new Scanner(System.in);
    public static double a, b, c;

    public static void main(String[] args) {
        System.out.println("Input A:");
        double a = sc.nextDouble();
        System.out.println("Input B:");
       double b = sc.nextDouble();
        System.out.println("Input C:");
        double c = sc.nextDouble();
		
		

        getDiscriminant(a,b,c);
        System.out.println("Root 1: "+getRoot1(a,b,c)+"Root 2: "+ getRoot2(a,b,c));

    }
    public static double getA() {
        return a;
    }

    public static double getB() {
        return b;
    }

    public static double getC() {
        return c;
    }

    public static double getDiscriminant(double a, double b, double c){
        double discriminant = (Math.pow(b,2))-(4*(a)*c);
        return discriminant;
        
    }
    public static double getRoot1(double a, double b, double c){
        if(getDiscriminant(a, b, c) == 0 || getDiscriminant(a, b, c)>0) {
            double root = ((-(b) + Math.sqrt(getDiscriminant(a, b, c))) / (2 * getA()));
            return root;
        }
        else if(getDiscriminant(a, b, c) < 0){
            return 0;
        }
        else
            return 0;


    }
    public static double getRoot2(double a, double b, double c){
        if(getDiscriminant(a, b, c) >0) {
            double root = ((-(b) - Math.sqrt(getDiscriminant(a, b, c))) / (2 * a));
            return root;
        }
        else if(getDiscriminant(a, b, c) < 0){
            System.out.println("The equation has no roots");
            return 0;
        }
        else{
            System.out.println("/--");
            return 0;
        }

    }
}
