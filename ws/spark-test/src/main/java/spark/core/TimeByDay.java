package spark.core;

import java.io.Serializable;

public class TimeByDay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer timeId;
	private Integer year;
	private String quarter;

	public static TimeByDay parse(String csvLine) {

		TimeByDay tbd = new TimeByDay();
		String[] column = csvLine.split(";");
		tbd.setTimeId(Integer.parseInt(column[0]));

		tbd.setYear(Integer.parseInt(column[4]));
		tbd.setQuarter(column[8]);

		return tbd;
	}

	public Integer getTimeId() {
		return timeId;
	}

	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	@Override
	public String toString() {
		return "TimeByDay [timeId=" + timeId + ", year=" + year + ", quarter=" + quarter + "]";
	}

}
