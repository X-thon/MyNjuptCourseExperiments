package net.mooctest;


import java.lang.reflect.Field;
import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;import com.fasterxml.jackson.databind.deser.AbstractDeserializer;



public class NaiveBayesClassifierTest{
	
	@Test(timeout = 4000)
	public void test() {
		
            NaiveBayesClassifier<Integer, Integer> naiveBayesClassifier;
            Collection<Integer> featureset0 ;
            Collection<Integer> featureset1 ;
            Collection<Integer> featureset2 ;
            Collection<Integer> featureset3 ;
            Collection<Integer> featureset4 ;
            Classification<Integer, Integer> classification0;
            Classification<Integer, Integer> classification1;
            Classification<Integer, Integer> classification2;
            Classification<Integer, Integer> classification3;
            Classification<Integer, Integer> classification4;


            naiveBayesClassifier = new NaiveBayesClassifier<Integer, Integer>();
            featureset0 = new ArrayList<Integer>();
            for(int i =0;i<5;i++){ featureset0.add(1); }
            classification0 = new Classification<>(featureset0 , 1);
            classification0.toString();
            naiveBayesClassifier.learn(classification0);
            naiveBayesClassifier.learn(1,featureset0);
            naiveBayesClassifier.setMemoryCapacity(0);
            naiveBayesClassifier.learn(classification0);

            
            featureset0 = new ArrayList<Integer>();
            for(int i =0;i<5;i++){ featureset0.add(i); }
            naiveBayesClassifier = new NaiveBayesClassifier<Integer, Integer>();
            naiveBayesClassifier.classify(featureset0);
            classification0 = new Classification<>(featureset0 , 1);
            naiveBayesClassifier.learn(classification0);
            naiveBayesClassifier.getCategories();
            naiveBayesClassifier.getFeatures();
            naiveBayesClassifier.getMemoryCapacity();
            naiveBayesClassifier.featureWeighedAverage(1, 1,naiveBayesClassifier);
            float weight = 0.5f;
            naiveBayesClassifier.featureWeighedAverage(1, 1, naiveBayesClassifier, weight );
            naiveBayesClassifier.classifyDetailed(featureset0);
            
            naiveBayesClassifier = new NaiveBayesClassifier<Integer,Integer>();
            naiveBayesClassifier.classify(new ArrayList<Integer>());
            naiveBayesClassifier.learn(0,new ArrayList<Integer>());
            naiveBayesClassifier.decrementFeature(0, 0);
            naiveBayesClassifier.featureProbability(0, 0);
            naiveBayesClassifier.decrementCategory(0);
            naiveBayesClassifier.featureCount(0, 0);
            

            naiveBayesClassifier = new NaiveBayesClassifier<Integer, Integer>();
            naiveBayesClassifier.decrementCategory(0);
            naiveBayesClassifier.featureWeighedAverage(0, 0);
            
            
            naiveBayesClassifier = new NaiveBayesClassifier<Integer, Integer>();
            featureset0 = new ArrayList<Integer>();
            for(int i =0;i<5;i++){ featureset0.add(1); }
            classification0 = new Classification<>(featureset0 , 1);
            classification0.toString();
//            naiveBayesClassifier.learn(classification0);
//            naiveBayesClassifier.learn(1,featureset0);
            naiveBayesClassifier.setMemoryCapacity(0);
            naiveBayesClassifier.learn(classification0);

            NaiveBayesClassifier<Integer, Integer> naiveBayesClassifier2 = new NaiveBayesClassifier<Integer,Integer>();
            featureset0 = new ArrayList<Integer>();
            for(int i =0;i<5;i++){ featureset0.add(1); }
            featureset1 = new ArrayList<Integer>();
            for(int i =0;i<5;i++){ featureset1.add(1); }
            naiveBayesClassifier2.learn(1, featureset0);
            naiveBayesClassifier2.featureCount(0, 1);
            naiveBayesClassifier.classify(featureset1);
            naiveBayesClassifier.decrementFeature(1, 1);

            
            naiveBayesClassifier = new NaiveBayesClassifier<Integer, Integer>();

            featureset1 = new ArrayList<Integer>();
            for(int i =0;i<4;i++){ featureset0.add(1); }
    		featureset2 = new ArrayList<Integer>();
    		featureset2.add(1);
    		featureset2.add(5);
    		featureset2.add(1);
    		featureset2.add(6);
    		featureset3 = new ArrayList<Integer>();
    		featureset3.add(7);
    		featureset3.add(3);
    		featureset3.add(1);
    		featureset3.add(4);
    		featureset4 = new ArrayList<Integer>(){{add(1); add(7);add(5);add(1);}};
    		featureset4.add(1);
    		featureset4.add(7);
    		featureset4.add(5);
    		featureset4.add(1);
    		classification1 = new Classification<>(featureset1 , 1);
    		classification2 = new Classification<>(featureset2 , 0);
    		classification3 = new Classification<>(featureset3 , 1);
    	    classification4 = new Classification<>(featureset4 , 2);
    		naiveBayesClassifier.learn(classification1);
    		naiveBayesClassifier.learn(classification2);
    		naiveBayesClassifier.learn(classification3);
    		naiveBayesClassifier.learn(classification4);

    		naiveBayesClassifier.classify(new ArrayList<Integer>());

			  
		}
}