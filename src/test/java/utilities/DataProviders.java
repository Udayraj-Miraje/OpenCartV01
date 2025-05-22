package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Data Provider 1
	
	@DataProvider(name = "LoginData")
	public String [][] getdata() throws IOException
	{
		String path = ".\\testData\\TestData.xlsx";
		
		Excel_Utility xutil = new Excel_Utility(path);	
		
		int totalrows = xutil.getRowCount("Sheet1");
		int totalcols = xutil.getCellCount("Sheet1", 1);
		
		System.out.println(totalrows);
		System.out.println(totalcols);
		
		String logindata[][] = new String [totalrows][totalcols];
		
		for(int i = 1; i <= totalrows; i++) 
		{
			for(int j = 0; j < totalcols; j++)
			{
				
				logindata[i-1][j] = xutil.getCellData("Sheet1", i, j);
			}
			
		}
		
		return logindata;
	}

}
