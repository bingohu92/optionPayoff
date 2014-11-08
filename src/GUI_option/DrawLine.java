package GUI_option;

import java.awt.*;
import javax.swing.*;

public class DrawLine extends JPanel
{
	public static int[][] lineData;
    private int rowNum = 0;

    public DrawLine(int[][] inputData, int row)
    {
    	rowNum = row;
    	if (row > 0){
    	lineData = new int[row][3];
        for (int i = 0; i < row; i++){
        	lineData[i][0] = inputData[i][0];
        	lineData[i][1] = inputData[i][1];
        	lineData[i][2] = inputData[i][2];
        }
    	}
    }
    /*
    @Override
    public Dimension getPreferredSize()
    {
       // int size = lines * lineGap;
        return new Dimension(size, size);
    } */

    @Override
    public void paintComponent(Graphics g)
    {
    	int start_x = 60;
    	int start_y = 160;
    	
    	if (lineData != null){
        for (int i = 0; i < rowNum; i++){
        	int xIncrease = (lineData[i][1] - lineData[i][0]);
        	int yIncrease = (int)((double)xIncrease / Math.sqrt(2));
        	int type = lineData[i][2];
        	
        	
        	if (type == 0){
        		g.drawLine(start_x,start_y,(start_x + xIncrease),start_y);
        		start_x = start_x + xIncrease;
        	}
        	else if (type == -1){
        		g.drawLine(start_x,start_y,(start_x + xIncrease),start_y + yIncrease);
        		start_x += xIncrease;
        		start_y += yIncrease;
        	}
        	else if (type == 1){
        		g.drawLine(start_x,start_y,(start_x + xIncrease),start_y - yIncrease);
        		start_x += xIncrease;
        		start_y -= yIncrease;
        	}
        }
    	}
    	else
    		g.drawLine(60,160,400,160);
    }

}
