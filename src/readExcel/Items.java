package readExcel;

import java.text.SimpleDateFormat;

public class Items {
	
	//编号
	private Integer id;

	//时间 年月日时分秒
	private String time;
	
	//纬度
	private String latitude;
	
	//经度
	private String longitude;
	
	//航向
	private String courseBoat;
	
	//航速
	private String speedBoat;
	
	//能见度
	private String visibility;
//	private Double visibility;
	
	//浪向
	private String courseWave;
	
	//浪高
	private String heightWave;
	
	//风向
	private String courseWind;
	
	//风速
	private String speedWind;
	
	//干温
	private String dryTemperature;
	
	//湿温
	private String wetTemperature;
	
	//气压
	private String pressure;
	
	//云量
	private String cloudAmount;
	
	//云状
	private String cloudCategory;
		
	//天气现象
	private String weatherPhenomenon;
	
	private String timeZone;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCourseBoat() {
		return courseBoat;
	}

	public void setCourseBoat(String courseBoat) {
		this.courseBoat = courseBoat;
	}

	public String getSpeedBoat() {
		return speedBoat;
	}

	public void setSpeedBoat(String speedBoat) {
		this.speedBoat = speedBoat;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getHeightWave() {
		return heightWave;
	}

	public void setHeightWave(String heightWave) {
		this.heightWave = heightWave;
	}

	public String getCourseWave() {
		return courseWave;
	}

	public void setCourseWave(String courseWave) {
		this.courseWave = courseWave;
	}

	public String getCourseWind() {
		return courseWind;
	}

	public void setCourseWind(String courseWind) {
		this.courseWind = courseWind;
	}

	public String getSpeedWind() {
		return speedWind;
	}

	public void setSpeedWind(String speedWind) {
		this.speedWind = speedWind;
	}

	public String getDryTemperature() {
		return dryTemperature;
	}

	public void setDryTemperature(String dryTemperature) {
		this.dryTemperature = dryTemperature;
	}

	public String getWetTemperature() {
		return wetTemperature;
	}

	public void setWetTemperature(String wetTemperature) {
		this.wetTemperature = wetTemperature;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	
	public String getCloudAmount() {
		return cloudAmount;
	}

	public void setCloudAmount(String cloudAmount) {
		this.cloudAmount = cloudAmount;
	}

	public String getCloudCategory() {
		return cloudCategory;
	}

	public void setCloudCategory(String cloudCategory) {
		this.cloudCategory = cloudCategory;
	}
	
	public String getWeatherPhenomenon() {
		return weatherPhenomenon;
	}

	public void setWeatherPhenomenon(String weatherPhenomenon) {
		this.weatherPhenomenon = weatherPhenomenon;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}


}
