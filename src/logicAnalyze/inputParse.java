package logicAnalyze;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class inputParse {
	
	public static void main(String[] args){
		int UserCommand = 0;
		
		while (UserCommand != -1){
		int segmentNum = 0;
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		
		System.out.print("Enter the number of segment: ");
		segmentNum = scanner.nextInt();
		while (segmentNum <= 0){
			System.out.print("Invalid number! Please re-enter: ");
			segmentNum = scanner.nextInt();
		}
		
		int[][] inputData = new int[segmentNum][3];
		for (int p = 0; p < segmentNum; p++){
			inputData[p][0] = 0;
			inputData[p][1] = 0;
			inputData[p][2] = 0;
		}
		
		int previousEnd = 0;
		//scanner.nextLine();
		System.out.println("Sample input for slope 1 in (0,50) is: 0 50 1");
		System.out.println();
		for (int i = 0; i < segmentNum; i++){
			System.out.print("Enter the Info of segment" + (i + 1) +": ");
			//String temp = scanner.nextLine();
			//write the line info into array
			/*
			inputData[i][0] = Integer.parseInt(temp.substring(temp.indexOf("(") + 1, temp.indexOf(",")));
			inputData[i][1] = Integer.parseInt(temp.substring(temp.indexOf(",") + 1, temp.indexOf(")")));
			inputData[i][2] = Integer.parseInt(temp.substring(temp.indexOf(":") + 1));
			*/
			//System.out.println(inputData[i][0] + " " + inputData[i][1] + " " + inputData[i][2]);
			inputData[i][0] = scanner.nextInt();
			inputData[i][1] = scanner.nextInt();
			inputData[i][2] = scanner.nextInt();
		}
		
		int[] input = new int[200];
		int tempCount = 0;
		for (int m = 0; m < segmentNum; m++){
			for (int n = inputData[m][0]; n < inputData[m][1]; n++){
				input[tempCount++] = inputData[m][2];
				//System.out.print(input[tempCount - 1] + " ");
			}
			//System.out.println();
		}
		
		int [] tempLoca = new int[segmentNum * 2];
		int tempCounter = 0;
		for (int h = 0; h < segmentNum * 2; h++)
			tempLoca[h] = -1;
		for (int z = 1; z < 200; z++){
			if (input[z] != input[z - 1]){
				if (Math.abs(input[z] - input[z - 1]) == 1){
					tempLoca[tempCounter] = z;
					tempCounter++;
				}
				else if (Math.abs(input[z] - input[z - 1]) == 2){
					tempLoca[tempCounter] = z;
					tempCounter++;
					tempLoca[tempCounter] = z;
					tempCounter++;
				}
			}
		}
		
		composerNum = tempCounter;
		int[] formalLoca = new int[tempCounter];
		for (int l = 0; l < tempCounter; l++){
			formalLoca[l] = tempLoca[l];
			//System.out.print(" " + formalLoca[l]);
		}
		
		transit(formalLoca, input);
		resultPrinter();

		System.out.println();
		System.out.print("Press -1 to exit OR 1 continue: ");
		UserCommand = scanner.nextInt();
	
		System.out.println();
		}
	}
	
	public static int[] baseArrayBuilder(int loca, int myType){
		
		int baseArray[] = new int[200];
		for (int p = 0; p < 200; p++)
			baseArray[p] = 0;
		
		switch(myType){
		case 0:
			break;
		case 1:// Long Call
			for (int i = loca; i < 200; i++)
				baseArray[i] = 1;
			break;
		case 2:// Short Call
			for (int i = loca; i < 200; i++)
				baseArray[i] = -1;
			break;
		case 3:// Long Put
			for (int i = 0; i < loca; i++)
				baseArray[i] = -1;
			break;
		case 4:// Short Put
			for (int i = 0; i < loca; i++)
				baseArray[i] = 1;
			break;
		default:
				break;
		}
		
		return baseArray;
	}

	
	public static void transit(int[]TPLocation, int[] checkArray){
		int tempResult[] = new int[200];
		int loopTracker[][] = new int[TPLocation.length][2];
		for (int i = 0; i < TPLocation.length; i++){
			loopTracker[i][0] = TPLocation[i];
			loopTracker[i][1] = 0;
		}
		
		int LocaNum = TPLocation.length;
		
		while(true){
			Checker(checkArray);
			++totalTimes;
			++loopTracker[0][1];
			changeComposer(0,loopTracker[0][0],loopTracker[0][1]);
			if (loopTracker[0][1] > 4){
				if (transitHelper(loopTracker, LocaNum)) break;
			}
		}
	}
	
	public static void changeComposer(int row, int Loca, int myType){
		int [] tempArray = baseArrayBuilder(Loca,myType);
		for (int i = 0; i < 200; i++)
			composer[row][i] = tempArray[i];
	}
	
	public static boolean transitHelper(int[][] loopTracker, int LocaNum){
		int n = LocaNum;
		for (int i = 0; loopTracker[i][1] > 4; i++){
			loopTracker[i][1] = 0;
			resetComposerRow(i);
			if (i == n - 1) 
				return true;
			else{
				loopTracker[i+1][1]++;
				changeComposer(i+1,loopTracker[i+1][0],loopTracker[i+1][1]);
			}
		}
		return false;
	}

	public static void Checker(int[] ToCheck){
		boolean judge = true;
		for (int i = 0; i < ToCheck.length; i++){
			int tempSum = 0;
			for(int j = 0; j < composerNum; j++)
				tempSum += composer[j][i];
			if (tempSum != ToCheck[i]){
				judge = false;
				break;
			}
		}
		if (judge)
			recordSolution();
		
	}
	
	public static void resetComposerRow(int row){
		for (int i = 0; i < 200; i++)
			composer[row][i] = 0;
	}
	
	public static void recordSolution(){
		for (int i = 0; i < composerNum; i++){
			for (int j = 1; j < 200; j++){
				if (composer[i][j-1] != composer[i][j]){
					if (composer[i][j-1] == 0 && composer[i][j] == 1){
						solution[solutionNum] += Integer.toString(j);
						solution[solutionNum] += ",";
						solution[solutionNum] += Integer.toString(1);
						solution[solutionNum] += ",";
					}
					else if (composer[i][j-1] == 0 && composer[i][j] == -1){
						solution[solutionNum] += Integer.toString(j);
						solution[solutionNum] += ",";
						solution[solutionNum] += Integer.toString(2);
						solution[solutionNum] += ",";
					}
					else if (composer[i][j-1] == -1 && composer[i][j] == 0){
						solution[solutionNum] += Integer.toString(j);
						solution[solutionNum] += ",";
						solution[solutionNum] += Integer.toString(3);
						solution[solutionNum] += ",";
					}
					else if (composer[i][j-1] == 1 && composer[i][j] == 0){
						solution[solutionNum] += Integer.toString(j);
						solution[solutionNum] += ",";
						solution[solutionNum] += Integer.toString(4);
						solution[solutionNum] += ",";
					}
					else;
				}
			}
		}
		solutionNum++;
	}
	
	public static void resultPrinter(){
		
		int[][] actualSolution = new int[composerNum * solutionNum][2];
		for (int n = 0; n < composerNum * solutionNum; n++){
			actualSolution[n][0] = 0;
			actualSolution[n][1] = 0;
		}
		
		int actualTotalNum = solutionNum;
		int tempCounter = 0;
		for (int i = 0; i < solutionNum; i++){
			int begin = 4;
			while(begin < solution[i].length()){
				int temp = solution[i].indexOf(",", begin);
				actualSolution[tempCounter][0] = Integer.parseInt(solution[i].substring(begin,temp));
				begin = temp + 1;
				temp = solution[i].indexOf(",", begin);
				actualSolution[tempCounter][1] = Integer.parseInt(solution[i].substring(begin,temp));
				begin = temp + 1;
				tempCounter++;
			}
		}
		
		int[] actualIndex = new int[solutionNum];
		for (int w = 0; w < solutionNum; w++)
			actualIndex[w] = -1;
		actualIndex[0] = 0;
		
		int indexNum = 1;
		
		for (int m = 1; m < solutionNum; m++){
			int count = 0;
			for (int q = 0; q < composerNum ; q++){
				for (int p = 0; p < composerNum; p++){
					if (actualSolution[m * composerNum + q][0] == actualSolution[(m -1) * composerNum + p][0]
							&& actualSolution[m * composerNum + q][1] == actualSolution[(m -1) * composerNum + p][1]){
						count++;
						//System.out.println(Integer.toString(actualSolution[m * composerNum + q][0]) + " " + actualSolution[m * composerNum + q][1]);
						break;
					}
				}
			}
			if (count == composerNum)
				actualTotalNum--;
			else
				actualIndex[indexNum++] = m * composerNum;
		}
		
		// Formally output
		System.out.println();
		int MethodNum = 1;
		if (actualTotalNum == 1)
			System.out.println("There are totally " + actualTotalNum + " way to replicate the payoff.");
		else
			System.out.println("There are totally " + actualTotalNum + " ways to replicate the payoff.");
		System.out.println();
		for (int r = 0; r < indexNum; r++){
			System.out.print("Method" + Integer.toString(MethodNum) + ": ");
			MethodNum++;
			for (int s = 0; s < composerNum; s++){
				if (s <= composerNum - 2 && s > 0)
					System.out.print(", ");
				if (s == composerNum - 1)
					System.out.print(" and ");
				System.out.print(outputHelper(actualSolution[actualIndex[r] + s][0],actualSolution[actualIndex[r] + s][1]));
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public static String outputHelper(int loca, int myType){
		switch(myType){
			case 1:
				return ("Long Call at strike of " + Integer.toString(loca));
			case 2:
				return ("Short Call at strike of " + Integer.toString(loca));
			case 3:
				return ("Long Put at strike of " + Integer.toString(loca));
			case 4:
				return ("Short Put at strike of " + Integer.toString(loca));
		}
		return "";
	}
	
	public static 
		String[] solution = new String[200];
		static int solutionNum = 0;
		static int [][] composer = new int[200][200];
		static int composerNum = 0;
		static int totalTimes = 0;
}
