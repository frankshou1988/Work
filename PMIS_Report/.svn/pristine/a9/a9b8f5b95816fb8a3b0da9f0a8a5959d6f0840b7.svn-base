package com.tetrapak.metaclass;

public class PeriodLastTime {
    private int hours;
    private int minutes;
    private int seconds;

    private String humanTime;

    public PeriodLastTime() {
	this.hours = 0;
	this.minutes = 0;
	this.seconds = 0;
	this.humanTime = getHumanTime();
    }

    public PeriodLastTime(String time) {
	this.humanTime = time;
	this.parsePeriodLastTime(humanTime);
    }

    public int getHours() {
	return hours;
    }

    public void setHours(int hours) {
	this.hours = hours;
    }

    public int getMinutes() {
	return minutes;
    }

    public void setMinutes(int minutes) {
	this.minutes = minutes;
    }

    public int getSeconds() {
	return seconds;
    }

    public void setSeconds(int seconds) {
	this.seconds = seconds;
    }

    public String getHumanTime() {
	this.humanTime = "";
	if (this.hours != 0) {
	    humanTime += this.hours + "h ";
	}
	if (this.minutes != 0) {
	    humanTime += this.minutes + "m ";
	}
	if (this.seconds != 0) {
	    humanTime += this.seconds + "s ";
	}
	return this.humanTime;
    }

    public void setHumanTime(String humanTime) {
	this.humanTime = humanTime;
    }

    @Override
    public String toString() {
	String s = null;
	if (humanTime != null && !humanTime.isEmpty()) {
	    s = humanTime;
	} else {
	    s = getHumanTime();
	}
	return s;
    }

    public void add(PeriodLastTime obj) {
	this.hours += obj.getHours();
	this.minutes += obj.getMinutes();
	this.seconds += obj.getSeconds();
	if (this.seconds >= 60) {
	    int addMinute = this.seconds / 60;
	    this.minutes += addMinute;
	    this.seconds = this.seconds % 60;
	}
	if (this.minutes >= 60) {
	    int addHour = this.minutes / 60;
	    this.hours += addHour;
	    this.minutes = this.minutes % 60;
	}
    }

    public void parsePeriodLastTime(String cipLastTime) {
	String[] items = cipLastTime.split(" ");
	int size = items.length;
	if (size == 0) {
	    this.hours = 0;
	    this.minutes = 0;
	    this.seconds = 0;
	} else if (size == 1) {
	    String ss = items[0].trim();
	    int length = ss.length();
	    if (ss.contains("s")) {
		this.seconds = Integer.parseInt(ss.substring(0, length - 1));
	    } else if (ss.contains("m")) {
		this.minutes = Integer.parseInt(ss.substring(0, length - 1));
	    } else if (ss.contains("h")) {
		this.hours = Integer.parseInt(ss.substring(0, length - 1));
	    }
	} else if (size == 2) {
	    String big = items[0];
	    String small = items[1];
	    int bigInt = Integer.parseInt(big.substring(0, big.length() - 1));
	    int smallInt = Integer.parseInt(small.substring(0, small.length() - 1));
	    if (big.contains("h")) {
		this.hours = bigInt;
	    } else if (big.contains("m")) {
		this.minutes = bigInt;
	    }
	    if (small.contains("m")) {
		this.minutes = smallInt;
	    } else if (small.contains("s")) {
		this.seconds = smallInt;
	    }
	} else if (size == 3) {
	    String hh = items[0];
	    String mm = items[1];
	    String ss = items[2];
	    this.hours = Integer.parseInt(hh.substring(0, hh.length() - 1));
	    this.minutes = Integer.parseInt(mm.substring(0, mm.length() - 1));
	    this.seconds = Integer.parseInt(ss.substring(0, ss.length() - 1));
	}
    }

    public long getTimeInSeconds() {
	return toSeconds();
    }

    public long toSeconds() {
	return this.hours * 3600 + this.minutes * 60 + this.seconds;
    }

}
