package Utilities;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilesUtils 

{
   private static final boolean True = false;
private static String sheet1;
Workbook wb;
private String sheetname;
private Row rownum;
private FileOutputStream FileOutputStream;
private Object num;
	public ExcelFilesUtils()
	
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\rahul.rj\\workspace\\Stockaccounting\\Testinputs");
			wb=WorkbookFactory.create(fis);
				
	}
	
	//row count
	
	public int rowCount(String sheetname)
	{
	return wb.getSheet(sheetname).getLastRowNum();
	}
	//Col count
	
	public int ColCount(String sheetname,int row)
	
	{
		return wb.getSheet(sheetname).getRow(row).getLastCellNum();
	}
		//reading data from excel file
		
		
			
			public String getData(String Sheetname,int row,int column)
			{
				String data="";
				
				if(wb.getSheet(Sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					int celldata=(int)wb.getSheet(Sheetname).getRow(row).getCell(column).getNumericCellValue();
					
					data=String.valueOf(celldata);
					
				}else
					{
							data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();

					}
						
				return data;
		
			}
	          
			//Writing data into excel pass or fail and not executed
			
			public void setData(String sheetname,int row,int column,String status, OutputStream fos)throws Throwable
			{
				Sheet sh=wb.getSheet(sheetname);
				Row row1=num=sh.getRow(row1);
				Cell cell=rownum.createCell(column);
				cell.setCellValue(status);
				if(status.equalsIgnoreCase("Pass"))
				{
				
					//Create Cell Style
					
					CellStyle Style=wb.createCellStyle();
					
					//Create Font
					
					Font font=wb.createFont();
					
					//Apply color to the text
					font.setColor(IndexedColors.GREEN);
					//apply bold to the text
					font.setBold(True);
					//Set Font
					Style.setFont(font);
					//set cell style
					rownum.getCell(column).setCellStyle(Style);

				}else
					
					if(status.equalsIgnoreCase("Fail"))
					{
						//Create Cell Style
						CellStyle Style=wb.createCellStyle();
						
						//Create Font
						Font font=wb.createFont();
						//Apply color to the text
						font.setColor(IndexedColors.RED.index);
						//apply bold to the text
						font.setBold(true);
						//Set Font
						Style.setFont(font);
						//set cell style
						rownum.getCell(column).setCellStyle(Style);
						
					}else
						
						if (status.equalsIgnoreCase("Not Executed"))
				
						{
							//Create Cell Style
							
							CellStyle style=wb.createCellStyle();
							//Create Font
							Font font=wb.createFont();
							//Apply color to the text
							font.setColor(IndexedColors.BLUE.index);
							//apply bold to the text
                            font.setBold(True);
                          //Set Font
                            style.setFont(font);
                          //set cell style
                            rownum.getCell(column).setCellStyle(style);
               
						}
				
				FileOutputStream=new FileOutputStream("C:\\Users\\rahul.rj\\workspace\\Stockaccounting\\Testinputs");
				
				wb.write(fos);
				fos.close();
			}
			
			public static void main(String[] args) throws Throwable
			
			{
				ExcelFilesUtils excel = new ExcelFilesUtils();
				
				System.out.println(excel.rowCount("Sheet1"));
				System.out.println(excel.ColCount("sheet1", 1));
				System.out.println(excel.getData(sheet1, 1, 1));
				
				excel.setData(sheet1, 1, 1, "Fail");
				excel.setData(sheet1, 1, 1, "Not Executed");
				
	
				
			}
			
			
	
	}
	
	


