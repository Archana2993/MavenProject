package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility
{
	
	public static String featchDatafromExcelSheet(String sheet,int row,int coloum) throws IOException  
	{	String data;
		File path=new File("src\\test\\resources\\Test Data\\PracticeTestData.xlsx");
		FileInputStream file=new FileInputStream(path);
		Workbook wb= WorkbookFactory.create(file);
		Sheet sheetName=wb.getSheet(sheet);
		Row rowNum=sheetName.getRow(row);
		Cell cellNum=rowNum.getCell(coloum);
		 data=cellNum.getStringCellValue();
	    System.out.println(data);
		return data;
	}
	public static void captureScreenShot(WebDriver driver,int testCaseId) throws IOException
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss");
		LocalDateTime dateAndtime= LocalDateTime.now();
		String datetime =dtf.format(dateAndtime);	
		TakesScreenshot take= (TakesScreenshot) driver;
		File srce= take.getScreenshotAs(OutputType.FILE);
		File dest =new File("test-output\\Fail Test Screenshot\\Test"+ testCaseId+" "+datetime+".png");
		FileHandler.copy(srce, dest);
		
	}
	

}
