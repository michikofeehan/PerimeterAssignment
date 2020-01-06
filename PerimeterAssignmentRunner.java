import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        } return totalPerim; // totalPerim is the answer 
    }

    public int getNumPoints (Shape s) {
        //I wrote this :)
        int pointCount = 0;
        for (Point p : s.getPoints()){
            pointCount = pointCount + 1;
        } return pointCount;
    }

    public double getAverageLength(Shape s) { 
        //assuming that number of points equal the number of sides
        double allSides = getPerimeter(s);
        double avgLength = allSides/getNumPoints(s);
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double longSide = 0;
        Point prevPt = s.getLastPoint();
            // Find distance from prevPt point to currPt 
            for (Point currPt : s.getPoints()) {
                double currDist = prevPt.distance(currPt);
                if (currDist > longSide){
                    longSide = currDist;
                }
                // Update prevPt to be currPt
                prevPt = currPt;
        
            } return longSide;
}
    

    public double getLargestX(Shape s) {
        Point lastPoint = s.getLastPoint();
        double largestX = lastPoint.getX();
        for (Point currPt : s.getPoints()) {
            // Get X value of point
            double currX = currPt.getX();
            // Update largestX with current X if larger
            if (currX > largestX) {
            largestX = currX; // 
            } 
        } return largestX;
    }


    public double getLargestPerimeterMultipleFiles() {
        // Jan 6, 2019 by MF; has no parameters. This method creates a Directory Resource  
        DirectoryResource dr = new DirectoryResource(); //select a group of files
        double largestPerim = 0;
        String largestFileName = ""; 
        
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
                String currentFileName = f.getName(); // gets name of current file
                Shape s = new Shape(fr); //current shape
                double currPerim = getPerimeter(s);
                if (currPerim > largestPerim){
                 largestPerim = currPerim; 
                 largestFileName = currentFileName;
                } 
    
} return largestPerim;
}


    public String getFileWithLargestPerimeter() { 
        DirectoryResource dr = new DirectoryResource(); //select a group of files
        double largestPerim = 0;
        String largestFileName = ""; 
            for (File f : dr.selectedFiles()) {
                FileResource fr = new FileResource(f );
                String currentFileName = f.getName(); // gets name of current file
                Shape s = new Shape(fr); //current shape
                double currPerim = getPerimeter(s);
                if (currPerim > largestPerim){
                 largestPerim = currPerim; 
                 largestFileName = currentFileName;
                } 
     
            }  return largestFileName;
     }

    public void testPerimeter () {
        //to test my code
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s); 
        System.out.println("perimeter = " + length); //Perimeter
        System.out.println();
        System.out.println("number of points = " + getNumPoints(s)); //to test getNumPoints 
        System.out.println();
        System.out.println("Average side length = " + getAverageLength(s)); //to test getAverageLength 
        System.out.println();
        System.out.println("largest X = " + getLargestX(s)); //Largest X
        System.out.println();
        System.out.println("largest Side = " + getLargestSide(s)); // Largest side
        System.out.println();
    }
    
    public void testPerimeterMultipleFiles() { //Assignment 2
        double largestPerimeter= getLargestPerimeterMultipleFiles();
        System.out.println("file containing the shape with largest perimeter among multiple files is: " + largestPerimeter);
        System.out.println();
    }

    public void testFileWithLargestPerimeter() {
        String largestFileName = getFileWithLargestPerimeter();
        System.out.println("The file name with shape with largest perimeter is: " + largestFileName); 
        System.out.println();
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+ peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner(); //Test Files
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter(); 
    }
}
