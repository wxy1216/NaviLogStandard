package readExcel;

import java.text.SimpleDateFormat;

public class Items {
	
	//���
	private Integer id;

	//ʱ�� ������ʱ����
	private String time;
	
	//γ��
	private String latitude;
	
	//����
	private String longitude;
	
	//����
	private String courseBoat;
	
	//����
	private String speedBoat;
	
	//�ܼ���
	private String visibility;
//	private Double visibility;
	
	//����
	private String courseWave;
	
	//�˸�
	private String heightWave;
	
	//����
	private String courseWind;
	
	//����
	private String speedWind;
	
	//����
	private String dryTemperature;
	
	//ʪ��
	private String wetTemperature;
	
	//��ѹ
	private Double pressure;

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

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	

}