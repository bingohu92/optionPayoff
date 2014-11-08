package GUI_option;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class option_gui extends JFrame{
	
	public static void main(String[] args) {
		new option_gui();
	}
	
	private option_gui(){
		super("Bingo's Options Payoff GUI");
		setSize(800,600);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		final JPanel group0 = new JPanel(new GridLayout(2,1));
		final JPanel group11 = new JPanel(new GridLayout(1,2));
		add(group0);
		
		JPanel group1 = new JPanel(new GridLayout(3,1));
		
		JLabel label1 = new JLabel("Input inteval and slope info here");
		group1.add(label1);
		
		JPanel group2 = new JPanel(new GridLayout(0,3));
		group2.add(new JLabel("Begin Interval"));
		group2.add(new JLabel("End Interval"));
		group2.add(new JLabel("Slope"));
		
		final JTextField Input1_begin = new JTextField();
		group2.add(Input1_begin);
		final JTextField Input1_end = new JTextField();
		group2.add(Input1_end);
		final JTextField Input1_slope = new JTextField();
		group2.add(Input1_slope);
		
		final JTextField Input2_begin = new JTextField();
		group2.add(Input2_begin);
		final JTextField Input2_end = new JTextField();
		group2.add(Input2_end);
		final JTextField Input2_slope = new JTextField();
		group2.add(Input2_slope);
		
		final JTextField Input3_begin = new JTextField();
		group2.add(Input3_begin);
		final JTextField Input3_end = new JTextField();
		group2.add(Input3_end);
		final JTextField Input3_slope = new JTextField();
		group2.add(Input3_slope);
		
		final JTextField Input4_begin = new JTextField();
		group2.add(Input4_begin);
		final JTextField Input4_end = new JTextField();
		group2.add(Input4_end);
		final JTextField Input4_slope = new JTextField();
		group2.add(Input4_slope);
		
		final JTextField Input5_begin = new JTextField();
		group2.add(Input5_begin);
		final JTextField Input5_end = new JTextField();
		group2.add(Input5_end);
		final JTextField Input5_slope = new JTextField();
		group2.add(Input5_slope);
		
		final JTextField Input6_begin = new JTextField();
		group2.add(Input6_begin);
		final JTextField Input6_end = new JTextField();
		group2.add(Input6_end);
		final JTextField Input6_slope = new JTextField();
		group2.add(Input6_slope);
		
		JButton addMoreTextField = new JButton("Add more");
		group2.add(addMoreTextField);
		JButton calculate = new JButton("Calculate");
		group2.add(calculate);
		final int[][] tempData = new int[6][3];
		
		
		JButton reset = new JButton("Reset");
		group2.add(reset);
		reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Input1_begin.setText("");
				Input1_end.setText("");
				Input1_slope.setText("");
				Input2_begin.setText("");
				Input2_end.setText("");
				Input2_slope.setText("");
				Input2_begin.setText("");
				Input2_end.setText("");
				Input2_slope.setText("");
				Input3_begin.setText("");
				Input3_end.setText("");
				Input3_slope.setText("");
				Input4_begin.setText("");
				Input4_end.setText("");
				Input4_slope.setText("");
				Input5_begin.setText("");
				Input5_end.setText("");
				Input5_slope.setText("");
				Input6_begin.setText("");
				Input6_end.setText("");
				Input6_slope.setText("");
			}
		});
		
				
		group11.add(group2);
		//JPanel group4 = new JPanel(new GridLayout(0,1));
		//JLabel outLogo = new JLabel("Output result:");
		//outLogo.setSize(200, 50);
		final JTextArea outputResult = new JTextArea("");
		outputResult.setName("Output result:");
		final JScrollPane group4 = new JScrollPane (outputResult, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//group4.add(outLogo);
		//group4.add(outputResult);
		
	    group5 = new JPanel(new GridLayout(0,1));
		DrawLine LineGraph = new DrawLine(null,0);
		group5.add(LineGraph);
		
		calculate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				formerDataClear();
				// TODO Auto-generated method stub
				if (!Input1_begin.getText().equals("") && !Input1_begin.getText().equals(null)
						&& !Input1_end.getText().equals("") && !Input1_end.getText().equals(null)
						&& !Input1_slope.getText().equals("") && !Input1_slope.getText().equals(null)){
					tempData[tempCounter][0] = Integer.parseInt(Input1_begin.getText());
					tempData[tempCounter][1] = Integer.parseInt(Input1_end.getText());
					tempData[tempCounter][2] = Integer.parseInt(Input1_slope.getText());
					tempCounter++;
				}
				
				if (!Input2_begin.getText().equals("") && !Input2_begin.getText().equals(null)
						&& !Input2_end.getText().equals("") && !Input2_end.getText().equals(null)
						&& !Input2_slope.getText().equals("") && !Input2_slope.getText().equals(null)){
					tempData[tempCounter][0] = Integer.parseInt(Input2_begin.getText());
					tempData[tempCounter][1] = Integer.parseInt(Input2_end.getText());
					tempData[tempCounter][2] = Integer.parseInt(Input2_slope.getText());
					tempCounter++;
				}
				
				if (!Input3_begin.getText().equals("") && !Input3_begin.getText().equals(null)
						&& !Input3_end.getText().equals("") && !Input3_end.getText().equals(null)
						&& !Input3_slope.getText().equals("") && !Input3_slope.getText().equals(null)){
					tempData[tempCounter][0] = Integer.parseInt(Input3_begin.getText());
					tempData[tempCounter][1] = Integer.parseInt(Input3_end.getText());
					tempData[tempCounter][2] = Integer.parseInt(Input3_slope.getText());
					tempCounter++;
				}
				
				if (!Input4_begin.getText().equals("") && !Input4_begin.getText().equals(null)
						&& !Input4_end.getText().equals("") && !Input4_end.getText().equals(null)
						&& !Input4_slope.getText().equals("") && !Input4_slope.getText().equals(null)){
					tempData[tempCounter][0] = Integer.parseInt(Input4_begin.getText());
					tempData[tempCounter][1] = Integer.parseInt(Input4_end.getText());
					tempData[tempCounter][2] = Integer.parseInt(Input4_slope.getText());
					tempCounter++;
				}
				
				if (!Input5_begin.getText().equals("") && !Input5_begin.getText().equals(null)
						&& !Input5_end.getText().equals("") && !Input5_end.getText().equals(null)
						&& !Input5_slope.getText().equals("") && !Input5_slope.getText().equals(null)){
					tempData[tempCounter][0] = Integer.parseInt(Input5_begin.getText());
					tempData[tempCounter][1] = Integer.parseInt(Input5_end.getText());
					tempData[tempCounter][2] = Integer.parseInt(Input5_slope.getText());
					tempCounter++;
				}
				
				if (!Input6_begin.getText().equals("") && !Input6_begin.getText().equals(null)
						&& !Input6_end.getText().equals("") && !Input6_end.getText().equals(null)
						&& !Input6_slope.getText().equals("") && !Input6_slope.getText().equals(null)){
					tempData[tempCounter][0] = Integer.parseInt(Input6_begin.getText());
					tempData[tempCounter][1] = Integer.parseInt(Input6_end.getText());
					tempData[tempCounter][2] = Integer.parseInt(Input6_slope.getText());
					tempCounter++;
				}
				
				int[] input = new int[200];
				int count1 = 0;
				for (int m = 0; m < tempCounter; m++){
					for (int n = tempData[m][0]; n < tempData[m][1]; n++){
						input[count1++] = tempData[m][2];
					}
				}
				
				int [] tempLoca = new int[tempCounter * 2];
				int temp = 0;
				for (int h = 0; h < tempCounter * 2; h++)
					tempLoca[h] = -1;
				for (int z = 1; z < 200; z++){
					if (input[z] != input[z - 1]){
						if (Math.abs(input[z] - input[z - 1]) == 1){
							tempLoca[temp] = z;
							temp++;
						}
						else if (Math.abs(input[z] - input[z - 1]) == 2){
							tempLoca[temp] = z;
							temp++;
							tempLoca[temp] = z;
							temp++;
						}
					}
				}
				
				composerNum = temp;
				int[] formalLoca = new int[temp];
				for (int l = 0; l < temp; l++){
					formalLoca[l] = tempLoca[l];
					//System.out.print(" " + formalLoca[l]);
				}
				
				transit(formalLoca, input);
				//resultPrinter();
				outputResult.setText("");
				outputResult.setText(myResultPrinter());
				
				realData = new int[tempCounter][3];
				for (int r = 0; r < tempCounter; r++){
					for (int w = 0; w < 3; w++)
					realData[r][w] = tempData[r][w];
				}
				
				group0.removeAll();
				group5 = new JPanel(new GridLayout(0,1));
				DrawLine LineGraph = new DrawLine(realData,tempCounter);
				group5.add(LineGraph);
				group0.add(group11);
				group0.add(group4);
				group0.add(group5);
				group0.revalidate();
				group0.repaint();
				setVisible(true);
			}
			
		});
		
		group0.add(group11);
		group0.add(group4);
		group0.add(group5);
		setVisible(true);
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
	
	public static int getCounter(){
		return tempCounter;
	}
	
	public static String myResultPrinter(){
		
		String myOutput = "";
		int[][] actualSolution = new int[composerNum * solutionNum][2];
		for (int n = 0; n < composerNum * solutionNum; n++){
			actualSolution[n][0] = 0;
			actualSolution[n][1] = 0;
		}
		
		int actualTotalNum = solutionNum;
		int tempCounter = 0;
		for (int i = 0; i < solutionNum; i++){
			int begin = 0;
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
		int MethodNum = 1;
		if (actualTotalNum == 1)
			myOutput = myOutput + "There are totally " + actualTotalNum + " way to replicate the payoff.";
		else
			myOutput = myOutput + "There are totally " + actualTotalNum + " ways to replicate the payoff.";
		myOutput += "\n";
		myOutput += "\n";
		for (int r = 0; r < indexNum; r++){
			myOutput = myOutput + "Method" + Integer.toString(MethodNum) + ": ";
			MethodNum++;
			for (int s = 0; s < composerNum; s++){
				if (s <= composerNum - 2 && s > 0)
					myOutput += ", ";
				if (s == composerNum - 1)
					myOutput += " and ";
				myOutput = myOutput + outputHelper(actualSolution[actualIndex[r] + s][0],actualSolution[actualIndex[r] + s][1]);
			}
			myOutput += "\n";
			myOutput += "\n";
		}
		
		return myOutput;
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
	
	public static void formerDataClear(){
		for (int i = 0; i < 200; i++)
			solution[i] = "";
		
		for (int j = 0; j < composerNum; j++)
			for (int k = 0; k < 200; k++)
				composer[j][k] = 0;
		
		solutionNum = 0;
		composerNum = 0;
		totalTimes = 0;
		tempCounter = 0;
	}
	
	public  
	static String[] solution = new String[200];
	static int solutionNum = 0;
	static int [][] composer = new int[200][200];
	static int composerNum = 0;
	static int totalTimes = 0;
	static int tempCounter = 0;
	static int [][] realData;
	JPanel group5;
}
