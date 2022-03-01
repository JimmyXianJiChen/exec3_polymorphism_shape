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
    public static double computeDistance(Shape s1, Shape s2){
        return Math.sqrt(Math.pow(s1.getX()-s2.getX(),2)+Math.pow(s1.getY()-s2.getY(),2));
    }
    public static void printAllShapesInRange(int x1, int y1, int x2, int y2, Shape[] arr, int len){
        int shape_x, shape_y;
        for(int i=0; i<len; i++){
            shape_x = arr[i].getX();
            shape_y = arr[i].getY();
            if(Math.min(x1,x2)<=shape_x && shape_x<=Math.max(x1,x2) && Math.min(y1,y2)<=shape_y && shape_x<=Math.max(y1,y2)){
                System.out.println(i +": " + arr[i].toString());
                System.out.println("----------------------------");
            }
        }
    }
    public static void main(String[] args) {
        boolean continueToGetCmd = true;
        Scanner sc = new Scanner(System.in);
        int cmd, arrLen = 0, index, index1, x, y, pt1_x, pt1_y, pt2_x, pt2_y;
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
                         6.Compute the distance between the centers of two shapes.
                         7.Print out all the shapes within an area.
                         8.Quit application
                         ============================================""");
            cmd = sc.nextInt();
            sc.nextLine();
            switch (cmd){
                case 1->{
                    System.out.println("Please choose the type of shape you would like to add:(1.Circle/2.Rectangle/3.Square)");
                    cmd = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter the x coordinate of the center point of the shape:");
                    x = sc.nextInt();
                    System.out.println("Please enter the y coordinate of the center point of the shape:");
                    y = sc.nextInt();
                    sc.nextLine();
                    switch (cmd){
                        case 1-> {
                            System.out.println("Please enter the radius of the circle:");
                            radius = sc.nextDouble();
                            if(shapeArrIsFull(arr,arrLen)){
                                arr = doubleArr(arr);
                            }
                            arr[arrLen++] = new Circle(x, y, radius);
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
                            arr[arrLen++] = new Rectangle(x, y, height, width);
                        }
                        case 3-> {
                            System.out.println("Please enter the side length of the square:");
                            width = sc.nextDouble();
                            if(shapeArrIsFull(arr,arrLen)){
                                arr = doubleArr(arr);
                            }
                            arr[arrLen++] = new Square(x, y, width);
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
                    else {
                        System.out.println("Invalid index! Please try again!");
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
                    System.out.println("Please enter index of the first shape:");
                    index = sc.nextInt();
                    System.out.println("Please enter index of the second shape:");
                    index1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Shape1:");
                    System.out.println(arr[index]);
                    System.out.println("Shape2:");
                    System.out.println(arr[index1]);
                    System.out.println("------------------------------------");
                    System.out.println("The distance between these two shapes: "+computeDistance(arr[index], arr[index1]));
                }
                case 7->{
                    System.out.println("Please enter the x coordinate of the top left point:");
                    pt1_x = sc.nextInt();
                    System.out.println("Please enter the y coordinate of the top left point:");
                    pt1_y = sc.nextInt();
                    System.out.println("Please enter the x coordinate of the bottom right point:");
                    pt2_x = sc.nextInt();
                    System.out.println("Please enter the y coordinate of the bottom right point:");
                    pt2_y = sc.nextInt();
                    sc.nextLine();
                    printAllShapesInRange(pt1_x,pt1_y, pt2_x, pt2_y, arr, arrLen);
                }
                case 8->{
                    continueToGetCmd = false;
                    System.out.println("Application exited!");
                }
                default -> {
                    System.out.println("Invalid cmd! Please try again!");
                }
            }
            System.out.println("========================================");
        }
    }
}
