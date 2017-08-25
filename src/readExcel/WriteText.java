package readExcel;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteText {
	
	public void writeT(List <Items> writeList) throws IOException{
		
		FileWriter file=new FileWriter("d:/write.txt");//如果不存在就会被创建
		BufferedWriter writer=new BufferedWriter(file);
		
		if (writeList != null) {
			for(Items item:writeList){
				writer.write("22");
				writer.write(item.getTime());
				
				writer.write("0-0800");
				writer.write(item.getLatitude());				
				writer.write("0");
				
				writer.write(item.getLongitude());				
				writer.write("0 3");
				
				writer.write(item.getCourseBoat());				
				writer.write("10");
				
				writer.write(item.getSpeedBoat());				
				writer.write("10999999                      9  9  9999999");
				
//				writer.write(item.getVisibility().toString());
				writer.write(item.getVisibility());
				writer.write("10  9  9");
				
				writer.write(item.getCourseWave());				
				writer.write("30");
				
				writer.write(item.getHeightWave());				
				writer.write("1099.99999 999.9 999.99");//小数位
				
				writer.write(item.getCourseWind());				
				writer.write("30");
				
				writer.write(item.getSpeedWind());				
				writer.write("10");//风速 之前表格整数位     "00"小数位
				
				writer.write(item.getDryTemperature());				
				writer.write("00");
				
				writer.write(item.getWetTemperature());				
				writer.write("00999.9 99999");
				
				writer.write(item.getPressure().toString());
				writer.write("00999.9 999.999 9 999.99999999.99");
				
				
				writer.newLine();
			}
			writer.close();
		}
	}

}
