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
import java.text.DecimalFormat;

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
		
		SimpleDateFormat fmt=new SimpleDateFormat("yyyyMMddHHmmss");//日期格式
		
		try{
			//支持Excel 2003 2007
			
			JFileChooser chooser = new JFileChooser(); //创建选择文件对象
			chooser.setDialogTitle("请选择文件");//设置标题
			chooser.setMultiSelectionEnabled(true);  //设置只能选择文件
			FileNameExtensionFilter filter = new FileNameExtensionFilter("xlsx", "xlsx");//定义可选择文件类型
			chooser.setFileFilter(filter); //设置可选择文件类型
			chooser.showOpenDialog(null); //打开选择文件对话框,null可设置为你当前的窗口JFrame或Frame
			File excelFile = chooser.getSelectedFile(); //file为用户选择的图片文件
//			String filename=excelfile.getAbsolutePath();
//			
//			System.out.println(filename);//获得文件绝对路径
			
			
//			File excelFile = new File("d:/01.xlsx");//创建文件对象
			FileInputStream is=new FileInputStream(excelFile);//文件流
			Workbook workbook=WorkbookFactory.create(is);//2003 2007 2010都可以处理
			int sheetCount=workbook.getNumberOfSheets();//Sheet的数量x
			
			//遍历每个Sheet
			for(int s=0;s<sheetCount;s++){
				Sheet sheet=workbook.getSheetAt(s);
				int rowCount=sheet.getPhysicalNumberOfRows();//获取总行数
				
				//System.out.println(rowCount);
				
				//遍历每一行
				for(int r=0;r<rowCount;r++){
					
					Row row=sheet.getRow(r);
					//int cellCount=row.getPhysicalNumberOfCells();//获取总列数						
					String cellValue=null;
					item=new Items();
					
					
					//编号
					Cell cell=row.getCell(0);
					cellValue=String.valueOf(cell.getNumericCellValue());
					Double d=Double.parseDouble(cellValue);
					item.setId(new Double(d).intValue());//转为整型
					
					//时间 年月日时分秒
					cell=row.getCell(21);
					cellValue=fmt.format(cell.getDateCellValue());//日期型
					item.setTime(cellValue);
						
										
					//纬度
					cell=row.getCell(7);
					cellValue=cell.getStringCellValue();
					String str1,str2,str3,str4=null;
					str1=cellValue.substring(0, 2);//str.substring(包括,不包括)
					str2=cellValue.substring(3,5);
					str3=cellValue.substring(6,11);
					str4=cellValue.substring(12);
					
					item.setLatitude(str1+str2+str3+str4);
					
					//经度
					cell=row.getCell(6);
					cellValue=cell.getStringCellValue();
					//String str1,str2,str3,str4=null;
					str1=cellValue.substring(0, 3);//str.substring(包括,不包括)
					str2=cellValue.substring(4,6);
					str3=cellValue.substring(7,12);
					str4=cellValue.substring(13);
					
					item.setLongitude(str1+str2+str3+str4);
					
					
					//航向
					cell=row.getCell(8);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					DecimalFormat df=new DecimalFormat("000");
					str1=df.format(d);
					item.setCourseBoat(str1);
					
					//航速
					cell=row.getCell(9);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("00.0").format(d);
//					cellValue=cell.getStringCellValue();
//					str1=cellValue.substring(0, 4);
					item.setSpeedBoat(str1);
					

					//时区
					cell=row.getCell(5);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					if(d<0)
						str1=new DecimalFormat("00").format(d);
					else
						str1=new DecimalFormat("+00").format(d);
					item.setTimeZone(str1);
					
					//能见度
					cell=row.getCell(11);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("00.0").format(d);					
//					cellValue=cell.getStringCellValue();
//					str1=cellValue.substring(0, 3);
					item.setVisibility(str1);
					
					//浪向
					cell=row.getCell(19);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("000").format(d);
//					cellValue=cell.getStringCellValue();
//					str1=cellValue.substring(0, 3);
					item.setCourseWave(str1);//转为整型
					
					//浪高
					cell=row.getCell(20);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("00.0").format(d);
//					cellValue=cell.getStringCellValue();
//					str1=cellValue.substring(0, 4);
					item.setHeightWave(str1);
					
					//风向
					cell=row.getCell(15);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("000").format(d);
//					cellValue=cell.getStringCellValue();
//					str1=cellValue.substring(0, 3);
					item.setCourseWind(str1);//转为整型
					
					//风速
					cell=row.getCell(16);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("00.0").format(d);
//					cellValue=cell.getStringCellValue();
//					str1=cellValue.substring(0, 4);
					item.setSpeedWind(str1);
					
					//干温
					cell=row.getCell(13);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("000.0").format(d);
//					cellValue=cell.getStringCellValue();
//					str1=cellValue.substring(0, 5);
					item.setDryTemperature(str1);
					
					//湿温
					cell=row.getCell(14);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("000.0").format(d);
//					cellValue=cell.getStringCellValue();
//					str1=cellValue.substring(0, 5);
					item.setWetTemperature(str1);
					
					//气压
					cell=row.getCell(12);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("0000.0").format(d);
					item.setPressure(str1);
					
					//云量
					cell=row.getCell(18);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("00").format(d);
					item.setCloudAmount(str1);
					
					//云状
					cell=row.getCell(17);
					cellValue=cell.getStringCellValue();
					str1="00";
//					str1=cellValue.substring(0, 2);
										
					switch(cellValue){
					case "Fc":str1="02"; break;
					case "St":str1="11"; break;
					case "Fs":str1="12"; break;
					case "Ns":str1="13"; break;
					case "Fn":str1="14"; break;
					case "Cc":str1="29"; break;
					case "Cu":str1="30"; break;
					case "Cb":str1="31"; break;
					case "Sc":str1="32"; break;
					case "As":str1="33"; break;
					case "Ac":str1="34"; break;
					case "Ci":str1="35"; break;
					case "Cs":str1="36"; break;
					default:str1="  ";
										
					}
					item.setCloudCategory(str1);
					
					//天气现象
					cell=row.getCell(10);
					cellValue=String.valueOf(cell.getNumericCellValue());
					d=Double.parseDouble(cellValue);
					str1=new DecimalFormat("00").format(d);
					item.setWeatherPhenomenon(str1);
					
					
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
