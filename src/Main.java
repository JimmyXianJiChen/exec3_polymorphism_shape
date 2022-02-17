import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static boolean shapeArrIsFull(Shape[] arr, int arrLen){
        return (arr.length==arrLen);
    }
    public static Shape[] doubleArr(Shape[] arr){
        Shape[] tmp = new Shape[arr.length*2];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        return tmp;
    }
    public static boolean isValidIndex(int idx, int len){
        return (idx>=0 && idx<len);
    }
    public static void printAllShapes(Shape[] arr, int len){
        for(int i=0; i<len; i++){
            System.out.println(i +": " + arr[i].toString());
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {
        boolean continueToGetCmd = true;
        Scanner sc = new Scanner(System.in);
        int cmd, arrLen = 0, index;
        Shape[] arr = new Shape[1];
        double width, height, radius;
        Comparator<Shape> compareByArea = new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2){
                return (s1.area()<s2.area()) ? -1 : 1;
            }
        };
        Comparator<Shape> compareByPerimeter = new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2){
                return (s1.perimeter()<s2.perimeter()) ? -1 : 1;
            }
        };
        while(continueToGetCmd){
            System.out.println("""
                        Please enter what you would like to do: 
                        (1. Add a new shape.
                         2. Print a shape at specific index.
                         3.Sort the shapes by area.
                         4.Sort the shapes by perimeter.
                         5.Print all shapes in order.
                         6.Quit application
                         ============================================""");
            cmd = sc.nextInt();
            sc.nextLine();
            switch (cmd){
                case 1->{
                    System.out.println("Please choose the type of shape you would like to add:(1.Circle/2.Rectangle/3.Square)");
                    cmd = sc.nextInt();
                    sc.nextLine();
                    
                    switch (cmd){
                        case 1-> {
                            System.out.println("Please enter the radius of the circle:");
                            radius = sc.nextDouble();
                            if(shapeArrIsFull(arr,arrLen)){
                                arr = doubleArr(arr);
                            }
                            arr[arrLen++] = new Circle(radius);
                        }
                        case 2-> {
                            System.out.println("Please enter the width of the circle:");
                            width = sc.nextFloat();
                            System.out.println("Please enter the height of the circle:");
                            height = sc.nextFloat();
                            sc.nextLine();
                            if(shapeArrIsFull(arr,arrLen)){
                                arr = doubleArr(arr);
                            }
                            arr[arrLen++] = new Rectangle(width,height);
                        }
                        case 3-> {
                            System.out.println("Please enter the side length of the square:");
                            width = sc.nextDouble();
                            if(shapeArrIsFull(arr,arrLen)){
                                arr = doubleArr(arr);
                            }
                            arr[arrLen++] = new Square(width);
                        }
                        default -> {
                            System.out.println("Invalid action! Please try again!");
                        }
                    }
                }
                case 2->{
                    System.out.println("Please enter the index of shape that you would like to show:");
                    index = sc.nextInt();
                    sc.nextLine();
                    if(isValidIndex(index, arrLen)){
                        System.out.println(arr[index]);
                    }
                }
                case 3->{
                    Arrays.sort(arr,0, arrLen, compareByArea);
//                    Arrays.sort(arr,0, arrLen, new Comparator<Shape>() {
//                        @Override
//                        public int compare(Shape s1, Shape s2){
//                            return (s1.area()<s2.area())? -1: 1;
//                        }
//                    });
                }
                case 4->{
                    Arrays.sort(arr,0, arrLen,compareByPerimeter);
//                    Arrays.sort(arr,0, arrLen, new Comparator<Shape>() {
//                        @Override
//                        public int compare(Shape s1, Shape s2){
//                            return (s1.perimeter()<s2.perimeter())? -1: 1;
//                        }
//                    });
                }
                case 5->{
                    printAllShapes(arr, arrLen);
                }
                case 6->{
                    continueToGetCmd = false;
                    System.out.println("Application exited!");
                }
                default -> {
                    System.out.println("Invlid cmd! Please try again!");
                }
            }
            System.out.println("========================================");
        }
    }
}
