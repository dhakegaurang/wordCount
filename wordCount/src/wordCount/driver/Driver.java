package wordCount.driver;

import wordCount.modules.populateTree.PopulateTree;
import wordCount.modules.wordOperations.TotalCharacters;
import wordCount.modules.wordOperations.TotalWords;
import wordCount.modules.wordOperations.UniqueWords;
import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.FileProcessor;
import wordCount.util.MyLogger;
import wordCount.util.Results;

/**
 * The  program implements an application that
 * shows Total words,Total character and unique characters
 * @author  Gaurang Dhake,Manu Sharma
 * @version 1.0
 * @since   08-03-2018
 */
public class Driver {
	/**
     * This method is used to for main method
     * read file ,and populates a tree data structure with all the words in the file in module 1
     * counts the number of words, number of unique distinct words, and number of characters in the tree
     * Store in output.txt
     * @param args will have inputfile, output file path, NUM_ITERATIONS,debug_value as arguments.
     */
    public static void main(String[] args) {
        String inputFilePath = "";
        String outputFilePath = "";
        int iterations = -1;
        int debugValue = -1;
        Results resultObj = null;
        try {
            if (args.length == 4) {
            	if(args[0] != null && !"".equals(args[0])) {
            		inputFilePath = args[0];
            	}
            	else {
            		throw new IllegalArgumentException("Invalid input file path...");
            	}
            	if(args[1] != null && !"".equals(args[1])) {
            		outputFilePath = args[1];
            	}
            	else {
            		throw new IllegalArgumentException("Invalid output file path...");
            	}
            	if(args[2] != null && !"".equals(args[2])) {
            		try {
            			iterations = Integer.parseInt(args[2]);
            		}
            		catch(NumberFormatException e) {
            			System.out.println("Please enter integer as third argument (number of iterations)");
            			System.err.println("Exiting...");
                    	System.exit(0);
            		}
            	}
            	else {
            		throw new IllegalArgumentException("Please enter number of iterations as third argument");
            	}
            	if(args[3] != null && !"".equals(args[3])) {
            		try {
            			debugValue = Integer.parseInt(args[3]);
            		}
            		catch(NumberFormatException e) {
            			System.out.println("Please enter integer as fourth argument (debug value) ");
            			System.err.println("Exiting...");
                    	System.exit(0);
            		}
            	}
            	else {
            		throw new IllegalArgumentException("Please enter debug value as fourth argument");
            	}
            	
                MyLogger.setDebugValue(debugValue);
                long startTime = System.currentTimeMillis();
                for (int i = 1; i <= iterations; i++) {
                    resultObj = new Results(outputFilePath);
                    FileProcessor fp = new FileProcessor(inputFilePath);
                    TreeBuilder tb = new TreeBuilder();

                    PopulateTree pTree = new PopulateTree(fp, tb);
                    pTree.populateMyTree();

                    TotalWords tw = new TotalWords(resultObj);
                    UniqueWords uw = new UniqueWords(resultObj);
                    TotalCharacters tc = new TotalCharacters(resultObj);
                    tb.accept(tw);
                    tb.accept(uw);
                    tb.accept(tc);
                    resultObj.writeToFile(resultObj.getResultStr());
                }
                long finishTime = System.currentTimeMillis();
                long total_time = (finishTime - startTime) / iterations;
                
                resultObj.writeToStdout("Total Time:" + total_time + "ms");

            } else {
                System.err.println("Please enter four arguments...");
                System.err.println("Exiting...");
            	System.exit(0);
            }

        }
        catch (NumberFormatException z1) {
            System.err.println("Invalid entry");
            System.err.println("Exiting...");
        	System.exit(0);
        }
        catch(IllegalArgumentException e) {
        	System.err.println(e.getMessage());
        	System.err.println("Exiting...");
        	System.exit(0);
        }

    }
}
