package org.youdian.springbase.model;

/**
 * 保存一个位置信息
 * @author zhouzhou
 *
 */
public class GeoLocation {
	/**
	 * 位置id
	 */
	private int id;
	/**
	 * 纬度 范围: -90~90
	 */
	private double latitude;
	/**
	 * 经度 范围: -180~180
	 */
	private double longtitude;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "GeoLocation [id=" + id + ", latitude=" + latitude + ", longtitude=" + longtitude + "]";
	}
	
	
}
