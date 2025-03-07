package com.psksoft;

public class BinaryGap {
    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(5));
    }

    private int solution(int i) {
        String binaryString = Integer.toBinaryString(i);
        System.out.println(binaryString);
        //String binaryString1 = Integer.toString(i, 2);
        boolean started = false;
        int counter=0;
        int maxCount=0;
        for(int k=0; k<binaryString.length(); k++){
            String substring = binaryString.substring(k, k + 1);
            if(substring.equals("1")){
                if(started) {
                    if (counter > maxCount) {
                        maxCount = counter;
                    }
                }
                counter = 0;
                started = true;
            }
            if(substring.equals("0")){
                 counter++;
            }
        }
        return maxCount;
    }
//    private int binaryGap(String binaryString){
//        if(Objects.nonNull(binaryString)){
//            IntStream.of(binaryString.length()).forEach(i->{
//                binaryString.substring(i, i+1);
//            });
//        }
//        return Integer.valueOf(binaryString).intValue();
//    }
}
