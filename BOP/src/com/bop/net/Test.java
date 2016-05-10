package com.bop.net;


import com.bop.algorithm.GraphSearch;

import java.util.concurrent.ExecutionException;

/**
 * Created by liuchun on 2016/5/7.
 */
public class Test {
    //static GraphSearch search = new GraphSearch();

    public static void main(String[] args) {
    	
        //pressureTest();
    	simpleTest();
        //long id1 = 2126125555L;
        //long id2 = 2153635508L;  // massive paper has cited this paper
        // paperId, paperId
        //long t = test(id1, id2);

        //id1 = 2175015405L;
        //id2 = 2121939561L;
        //t = test(id1, id2);

    }
    
    public static void pressureTest(){
    	long id1 = 2179036997L;
    	long id2 = 2152770371L;
    	long t = 0;
    	int count = 10;
    	double score = 0;
    	
    	for(int i = 0; i < count; i++){
    		long t0 = test(id1, id2);
    		score += (1 - t0*1.0/1000/300);
    		t += t0;
    	}
    	
    	double avr = t*1.0/count;
    	System.out.println("average time: " + avr);
    	score *= 10;
    	System.out.println("score: " + score);
    	
    	System.out.println("test over\n");
    }
    
    public static void simpleTest(){
    	long id1 = 2179036997L;
        long id2 = 2152770371L;
        //long id2 = 2125838338L;
        long t = 0;
        // test [Id, Id]
        t += test(id1, id2);

        id1 = 2179036997L;
        id2 = 2131087226L;
        // test [Id, AuId]
        t += test(id1, id2);

        id1 = 2131087226L;
        id2 = 2179036997L;
        // test [AuId, Id]
        t += test(id1, id2);

        id1 = 2268927867L;
        id2 = 2179036997L;
        // test [AuId, AuId]
        t += test(id1, id2);

        double avr = t/4.0;
        System.out.println("average time: " + avr);
        
        System.out.println("test over\n");
    }

    public static long test(long id1, long id2){
        long start_time, end_time, elapse_time;

        GraphSearch search = new GraphSearch();
        
        start_time = System.currentTimeMillis();
        System.out.println("start time: " + start_time);     
        try{
            String json = search.search(id1, id2);

            end_time = System.currentTimeMillis();
            System.out.println("end time: " + end_time);
            System.out.println(json);

            elapse_time = end_time - start_time;
            System.out.println(elapse_time);

            return elapse_time;
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        return 0;
    }
}
