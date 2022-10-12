package asi;


import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class closestthreepoints {
    static List<Point> leftres =  new ArrayList<>();
    static List<Point> rightres =  new ArrayList<>();
   static List<Point> res =  new ArrayList<>();
    static List<Point> temp =  new ArrayList<>();


    static class Point{
        double x;
        double y;
        Point(double x, double y){
            this.x = x;
            this.y =y;
        }
    }
    static class ComparatorByXCoordinate implements Comparator<Point>{
        @Override
        public int compare(Point P1, Point P2) {
            if (P1.x > P2.x) return  1;
            if (P1.x < P2.x) return -1;
            return Double.compare(P1.y, P2.y);
        }
    }

    static class ComparatorByYCoordinate implements Comparator<Point>{
        @Override
        public int compare(Point P1, Point P2) {
            return Double.compare(P1.y, P2.y);
        }
    }
    static double DistanceBetweenPoints(Point P1, Point P2){
        return Math.sqrt((P1.x-P2.x)*(P1.x-P2.x) + (P1.y-P2.y)*(P1.y-P2.y));
    }
    static double ClosestValue(Point A, Point B, Point C){
//        return DistanceBetweenPoints(A, B) + DistanceBetweenPoints(B, C) + DistanceBetweenPoints(C, A);
        return Math.max(Math.max(DistanceBetweenPoints(A, B) , DistanceBetweenPoints(B, C)) , DistanceBetweenPoints(C, A));

    }
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int n = Integer.parseInt(br.readLine());
        Point[] PointsX = new Point[n];
        Point[] PointsY = new Point[n];
        for (int i = 0; i < n; i++){
            String[] st = br.readLine().split(" ");
            double xCoordinate = Double.parseDouble(st[0]);
            double yCoordinate = Double.parseDouble(st[1]);
            Point p = new Point(xCoordinate, yCoordinate);
            PointsX[i] = p;
            PointsY[i] = p;
        }
        Arrays.sort(PointsX, new ComparatorByXCoordinate());
        Arrays.sort(PointsY, new ComparatorByYCoordinate());
        System.out.printf("%.12f", solveNoCross(PointsX, PointsY, 0, n));
    }
    static double solveNoCross(Point[] PointsX, Point[] PointY, int low, int high){
        if (high - low < 3){
            return Double.MAX_VALUE;
        }
        else if (high - low == 3){
            temp.clear();
            temp.add(PointsX[low]);
            temp.add(PointsX[low+1]);
            temp.add(PointsX[low+2]);
            return  ClosestValue(PointsX[low], PointsX[low+1], PointsX[low+2]);
        }
        int mid = low + (high-low)/2; //Overflow Issues :(
        Point midPoint = PointsX[mid];
        Point[] firstHalf = new Point[mid - low];
        Point[] secondHalf = new Point[high - mid];
        int firstHalfPointer = 0;
        int secondHalfPointer = 0;
        for (Point point: PointY){
            double pointX = point.x;
            double pointY = point.y;
            double midX = midPoint.x;
            double midY = midPoint.y;
            if (pointX < midX || (pointX == midX && pointY < midY)){
                firstHalf[firstHalfPointer++] = point;
            }
            else{
                secondHalf[secondHalfPointer++] = point;
            }
        }
        double leftmin = solveNoCross(PointsX, firstHalf, low, mid);
        leftres = new ArrayList<>(temp);
        double rightmin =  solveNoCross(PointsX, secondHalf, mid, high);
//        rightres = new ArrayList<>(temp);
//        if(leftmin < rightmin){
//            res = new ArrayList<>(leftres);
//        } else
//            res = new ArrayList<>(rightres);
//        print();
        double min = Math.min(leftmin, rightmin);
//        return min;
        return Math.min(min, solveCross(PointY, midPoint, min, PointY.length));
    }

     static void print (){
        if(res.size() == 3) {
            System.out.println(res.get(0).x + " , " + res.get(0).y);
            System.out.println(res.get(1).x + " , " + res.get(1).y);
            System.out.println(res.get(2).x + " , " + res.get(2).y);
        }

     }

    private static double solveCross(Point[] pointY, Point midPoint, double min, int pointYLen) {
        // For Solving When There Are Cross Triangles Such That Some Vertices Are in One Half and Some in Other
        double midX = midPoint.x;
        double midY = midPoint.y;
        double MCP = Double.MAX_VALUE; // Minimum Cross ClosestValue
        int boundingFactor = 0;
        double periRange;
        ArrayList<Point> pointsInPeriRange = new ArrayList<>();
        if (min == Double.MAX_VALUE){
            periRange = 2 * 1E9;
        }
        else{
            periRange = min;
        }
        for (int FirstPointIterator = 0; FirstPointIterator < pointYLen; FirstPointIterator++){
            Point Firstpoint = pointY[FirstPointIterator];
            double FirstPointX = Firstpoint.x;
            double FirstPointY = Firstpoint.y;
            if(Math.abs(FirstPointX - midX) > periRange) continue;
            while(boundingFactor < pointsInPeriRange.size() && FirstPointY - pointsInPeriRange.get(boundingFactor).y > periRange) {
                boundingFactor += 1;
            }
            for (int SecondPointIterator = boundingFactor; SecondPointIterator < pointsInPeriRange.size(); SecondPointIterator++){
                for (int ThirdPointIterator = SecondPointIterator + 1; ThirdPointIterator < pointsInPeriRange.size(); ThirdPointIterator++){
                    Point SecondPoint = pointsInPeriRange.get(SecondPointIterator);
                    Point ThirdPoint = pointsInPeriRange.get(ThirdPointIterator);
//                    temp.clear();
//                    temp.add(Firstpoint);
//                    temp.add(SecondPoint);
//                    temp.add(ThirdPoint);
//                    if(ClosestValue(Firstpoint, SecondPoint, ThirdPoint) < MCP){
//                        res = new ArrayList<>(temp);
//                    }
                    MCP = Math.min(MCP, ClosestValue(Firstpoint, SecondPoint, ThirdPoint));
                }
            }
            pointsInPeriRange.add(Firstpoint);
        }
       print();
        return MCP;
    }
}