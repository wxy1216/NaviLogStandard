package readExcel;

import java.awt.Desktop.Action;
import java.text.SimpleDateFormat;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;


public class readC {
		
		
	public void reading() {
		// TODO Auto-generated method stub
		//没用
		SimpleDateFormat fmt=new SimpleDateFormat("yyyyMMdd");//日期格式改
		
		try{
			//支持Excel 2003 2007
			File excelFile = new File("d:\\01.xlsx");//创建文件对象
			FileInputStream is=new FileInputStream(excelFile);//文件流
			Workbook workbook=WorkbookFactory.create(is);//2003 2007 2010都可以处理
			int sheetCount=workbook.getNumberOfSheets();//Sheet的数量x
			
			//遍历每个Sheet
			for(int s=0;s<sheetCount;s++){
				Sheet sheet=workbook.getSheetAt(s);
				int rowCount=sheet.getPhysicalNumberOfRows();//获取总行数
				
				//遍历每一行
				for(int r=0;r<rowCount;r++){
					Row row=sheet.getRow(r);
					int cellCount=row.getPhysicalNumberOfCells();//获取总列数
					
					//遍历每一列
					for (int c=0;c<cellCount;c++){
						Cell cell=row.getCell(c);
						
//						//
//						String cellValue=null;
//									
//						cellValue=cell.getStringCellValue();
						int cellType=cell.getCellType();//这里报错？？？？前面开头不能有空格
						
						String cellValue=null;
						//Object cellValue=null;
						
						switch(cellType){
						case Cell.CELL_TYPE_STRING://文本
							cellValue=cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC://数字、日期
							if(DateUtil.isCellDateFormatted(cell)){
								cellValue=fmt.format(cell.getDateCellValue());//日期型
								
							}
							else{
								//通过POI取出的数值默认都是double，即使excel单元格中存的是1，取出来的值也是1.0
								cellValue=String.valueOf(cell.getNumericCellValue());//数字型
								//
								//对数值类型进行处理??
								//long longVal=Math.round(cell.getNumericCellValue());
								//double doubleVal=cell.getNumericCellValue();//
								//if(Double.parseDouble(longVal+".0")==doubleVal)
									//cellValue=longVal;
								//else
									//cellValue=doubleVal;
								
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN://布尔型
							cellValue=String.valueOf(cell.getBooleanCellValue());
							break;
						case Cell.CELL_TYPE_BLANK://空白
							cellValue=cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_ERROR://错误
							cellValue="错误";
							break;
						case Cell.CELL_TYPE_FORMULA://公式 暂未考虑
							cellValue="公式";
							break;
						default:
							cellValue="错误";

						}
						System.out.print(cellValue+"		");
						
					}
					System.out.println();	
				}
			}
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
