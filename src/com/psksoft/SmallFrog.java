package com.psksoft;

public class SmallFrog {
    public static void main(String[] args) {
        SmallFrog smallFrog = new SmallFrog();
        int x=10;
        int y=75;
        int d=30;
        System.out.println(smallFrog.solution(x, y, d));
    }
    public int solution(int X, int Y, int D) {
        int numberOfJumps= 0;
        int distanceToCover = Y-X;
//        numberOfJumps = distanceToCover/Y;
//        if(distanceToCover%Y !=0){
//            numberOfJumps++;
//        }
        double o = distanceToCover/(double)D;
        System.out.println(o);
        int l =(int)Math.ceil(o);
        return l;
    }
}
