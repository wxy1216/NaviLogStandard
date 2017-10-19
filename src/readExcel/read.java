package readExcel;

import java.awt.Desktop.Action;
import java.text.SimpleDateFormat;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

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


//import org.apache.poi.ss.usermodel.DateUtil; 
public class read {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		readC r=new readC();
//		r.reading();
		
		List<Items> readList = new ReadItems().readItems();
		WriteText wt=new WriteText();
		if (readList != null){
			wt.writeT(readList);
		}
		
//		if (readList != null) {
//			for(Items item:readList){
////				System.out.println(item.getId()+"  "+item.getTime()+"  "+item.getLatitude()
////				+"  "+item.getLongitude()+"  "+item.getCourseBoat()+"  "+item.getSpeedBoat()
////				+"  "+item.getVisibility()+"  "+item.getCourseWave()+"  "+item.getHeightWave()
////				+"  "+item.getCourseWind()+"  "+item.getSpeedWind()+"  "+item.getDryTemperature()
////				+"  "+item.getWetTemperature()+"  "+item.getPressure());
//				
//				System.out.println(item.getCloudAmount()+" "+item.getCloudCategory());
//			}
//		}

	}

	
	
	

	
}


