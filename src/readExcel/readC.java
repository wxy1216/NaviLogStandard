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
		//û��
		SimpleDateFormat fmt=new SimpleDateFormat("yyyyMMdd");//���ڸ�ʽ��
		
		try{
			//֧��Excel 2003 2007
			File excelFile = new File("d:\\01.xlsx");//�����ļ�����
			FileInputStream is=new FileInputStream(excelFile);//�ļ���
			Workbook workbook=WorkbookFactory.create(is);//2003 2007 2010�����Դ���
			int sheetCount=workbook.getNumberOfSheets();//Sheet������x
			
			//����ÿ��Sheet
			for(int s=0;s<sheetCount;s++){
				Sheet sheet=workbook.getSheetAt(s);
				int rowCount=sheet.getPhysicalNumberOfRows();//��ȡ������
				
				//����ÿһ��
				for(int r=0;r<rowCount;r++){
					Row row=sheet.getRow(r);
					int cellCount=row.getPhysicalNumberOfCells();//��ȡ������
					
					//����ÿһ��
					for (int c=0;c<cellCount;c++){
						Cell cell=row.getCell(c);
						
//						//
//						String cellValue=null;
//									
//						cellValue=cell.getStringCellValue();
						int cellType=cell.getCellType();//���ﱨ��������ǰ�濪ͷ�����пո�
						
						String cellValue=null;
						//Object cellValue=null;
						
						switch(cellType){
						case Cell.CELL_TYPE_STRING://�ı�
							cellValue=cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC://���֡�����
							if(DateUtil.isCellDateFormatted(cell)){
								cellValue=fmt.format(cell.getDateCellValue());//������
								
							}
							else{
								//ͨ��POIȡ������ֵĬ�϶���double����ʹexcel��Ԫ���д����1��ȡ������ֵҲ��1.0
								cellValue=String.valueOf(cell.getNumericCellValue());//������
								//
								//����ֵ���ͽ��д���??
								//long longVal=Math.round(cell.getNumericCellValue());
								//double doubleVal=cell.getNumericCellValue();//
								//if(Double.parseDouble(longVal+".0")==doubleVal)
									//cellValue=longVal;
								//else
									//cellValue=doubleVal;
								
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN://������
							cellValue=String.valueOf(cell.getBooleanCellValue());
							break;
						case Cell.CELL_TYPE_BLANK://�հ�
							cellValue=cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_ERROR://����
							cellValue="����";
							break;
						case Cell.CELL_TYPE_FORMULA://��ʽ ��δ����
							cellValue="��ʽ";
							break;
						default:
							cellValue="����";

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
