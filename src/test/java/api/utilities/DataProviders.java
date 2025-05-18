package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\testdata\\testbook.xlsx";
		ExcelUtility xl=new ExcelUtility(path);
		
		int rownum=xl.getRowCount("sheet1");
		int colcount=xl.getCellCount("sheet1", rownum);
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("sheet1", i, j);
			}
		}
		return apidata;
	}
	
	@DataProvider(name="deletedata")
	public String[] getuserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\testdata\\testbook.xlsx";
		ExcelUtility xl=new ExcelUtility(path);
		int rownum=xl.getRowCount("sheet1");
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("sheet1", i, 1);
		}
		return apidata;
	}
	

}
