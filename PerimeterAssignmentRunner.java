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
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        //I wrote this :)
        int pointCount = 0;
        for (Point p : s.getPoints()){
            pointCount = pointCount + 1;
        }// Put code here
        return pointCount;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        //assuming that number of points equal the number of sides
        double allSides = getPerimeter(s);
        double avgLength = allSides/getNumPoints(s);
        
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double longSide = 0;
        Point prevPt = s.getLastPoint();
        // Find distance from prevPt point to currPt 
            for (Point currPt : s.getPoints()) {
                double currDist = prevPt.distance(currPt);
                if (currDist> longSide){
                    longSide= currDist;
                }
                // Update prevPt to be currPt
                prevPt = currPt;
        
    }
    return longSide;
}
    

    public double getLargestX(Shape s) {
        // I wrote this!
        Point lastPoint = s.getLastPoint();
        double largestX = lastPoint.getX();
        for (Point currPt : s.getPoints()) {
            // Get X value of point
            double currX = currPt.getX();
            // Update largestX with current X if larger
            if (currX > largestX) {
            largestX = currX; // 
            } 
             
}
                    return largestX;
    }


    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        //to test my code
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
       
        //I wrote this to test getNumPoints!! 
        System.out.println("number of points = " + getNumPoints(s));
     
        //I wrote this to test getAverageLength!!
        System.out.println("Average side length = " + getAverageLength(s));
        
        //Largest X
        System.out.println("largest X = " + getLargestX(s));
        
        // Largest side
        System.out.println("largest Side = " + getLargestSide(s));
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
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
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
