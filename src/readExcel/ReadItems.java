package readExcel;

import java.awt.Desktop.Action;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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



public class ReadItems {

	public List <Items> readItems() throws IOException{
		
		Items item=null;
		List<Items> list=new ArrayList<Items>();
		
		SimpleDateFormat fmt=new SimpleDateFormat("yyyyMMddHHmmss");//���ڸ�ʽ
		
		try{
			//֧��Excel 2003 2007
			
//			JFileChooser chooser = new JFileChooser(); //����ѡ���ļ�����
//			chooser.setDialogTitle("��ѡ���ļ�");//���ñ���
//			chooser.setMultiSelectionEnabled(true);  //����ֻ��ѡ���ļ�
//			FileNameExtensionFilter filter = new FileNameExtensionFilter("xlsx", "xlsx");//�����ѡ���ļ�����
//			chooser.setFileFilter(filter); //���ÿ�ѡ���ļ�����
//			chooser.showOpenDialog(null); //��ѡ���ļ��Ի���,null������Ϊ�㵱ǰ�Ĵ���JFrame��Frame
//			File excelfile = chooser.getSelectedFile(); //fileΪ�û�ѡ���ͼƬ�ļ�
//			String filename=excelfile.getAbsolutePath();
//			
//			System.out.println(filename);//����ļ�����·��
			
			File excelFile = new File("d:/01.xlsx");//�����ļ�����
			FileInputStream is=new FileInputStream(excelFile);//�ļ���
			Workbook workbook=WorkbookFactory.create(is);//2003 2007 2010�����Դ���
			int sheetCount=workbook.getNumberOfSheets();//Sheet������x
			
			//����ÿ��Sheet
			for(int s=0;s<sheetCount;s++){
				Sheet sheet=workbook.getSheetAt(s);
				int rowCount=sheet.getPhysicalNumberOfRows();//��ȡ������
				
				//System.out.println(rowCount);
				
				//����ÿһ��
				for(int r=0;r<rowCount;r++){
					
					Row row=sheet.getRow(r);
					//int cellCount=row.getPhysicalNumberOfCells();//��ȡ������					
					String cellValue=null;
					item=new Items();
					
					
					//���
					Cell cell=row.getCell(0);
					cellValue=String.valueOf(cell.getNumericCellValue());
					Double d=Double.parseDouble(cellValue);
					item.setId(new Double(d).intValue());//תΪ����
					
					//ʱ�� ������ʱ����
					cell=row.getCell(21);
					cellValue=fmt.format(cell.getDateCellValue());//������
					item.setTime(cellValue);
					
					//γ��
					cell=row.getCell(7);
					cellValue=cell.getStringCellValue();
					String str1,str2,str3,str4=null;
					str1=cellValue.substring(0, 2);//str.substring(����,������)
					str2=cellValue.substring(3,5);
					str3=cellValue.substring(6,11);
					str4=cellValue.substring(12);
					
					item.setLatitude(str1+str2+str3+str4);
					
					//����
					cell=row.getCell(6);
					cellValue=cell.getStringCellValue();
					//String str1,str2,str3,str4=null;
					str1=cellValue.substring(0, 3);//str.substring(����,������)
					str2=cellValue.substring(4,6);
					str3=cellValue.substring(7,12);
					str4=cellValue.substring(13);
					
					item.setLongitude(str1+str2+str3+str4);
					
					//����
					cell=row.getCell(8);
					cellValue=cell.getStringCellValue();
					//d=Double.parseDouble(cellValue);
					//item.setCourseBoat(new Double(d).intValue());//תΪ����
					str1=cellValue.substring(0, 3);
					item.setCourseBoat(str1);
					
					//����
					cell=row.getCell(9);
					//cellValue=String.valueOf(cell.getNumericCellValue());
					//d=Double.parseDouble(cellValue);
					cellValue=cell.getStringCellValue();
					str1=cellValue.substring(0, 4);
					item.setSpeedBoat(str1);
					
					//�ܼ���
					cell=row.getCell(11);
//					cellValue=String.valueOf(cell.getNumericCellValue());
//					d=Double.parseDouble(cellValue);
					cellValue=cell.getStringCellValue();
					str1=cellValue.substring(0, 3);
					item.setVisibility(str1);
					
					//����
					cell=row.getCell(19);
					//cellValue=String.valueOf(cell.getNumericCellValue());
					//d=Double.parseDouble(cellValue);
					cellValue=cell.getStringCellValue();
					str1=cellValue.substring(0, 3);
					item.setCourseWave(str1);//תΪ����
					
					//�˸�
					cell=row.getCell(20);
//					cellValue=String.valueOf(cell.getNumericCellValue());
//					d=Double.parseDouble(cellValue);
					cellValue=cell.getStringCellValue();
					str1=cellValue.substring(0, 4);
					item.setHeightWave(str1);
					
					//����
					cell=row.getCell(15);
//					cellValue=String.valueOf(cell.getNumericCellValue());
//					d=Double.parseDouble(cellValue);
					cellValue=cell.getStringCellValue();
					str1=cellValue.substring(0, 3);
					item.setCourseWind(str1);//תΪ����
					
					//����
					cell=row.getCell(16);
					cellValue=cell.getStringCellValue();
					str1=cellValue.substring(0, 4);
					item.setSpeedWind(str1);
					
					//����
					cell=row.getCell(13);
					cellValue=cell.getStringCellValue();
					str1=cellValue.substring(0, 5);
					item.setDryTemperature(str1);
					
					//ʪ��
					cell=row.getCell(14);
					cellValue=cell.getStringCellValue();
					str1=cellValue.substring(0, 5);
					item.setWetTemperature(str1);
					
					//��ѹ
					cell=row.getCell(12);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					item.setPressure(d);
					
					list.add(item);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return list;
	}
}
