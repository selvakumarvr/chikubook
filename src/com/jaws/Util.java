package com.jaws;

import java.util.Date;

public class Util {

	public static String dateDiff(Date start, Date end){
	
	

    long diffInSeconds = (end.getTime() - start.getTime()) / 1000;

    long diff[] = new long[] { 0, 0, 0, 0 };
    /* sec */diff[3] = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
    /* min */diff[2] = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds;
    /* hours */diff[1] = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24 : diffInSeconds;
    /* days */diff[0] = (diffInSeconds = (diffInSeconds / 24));

    if(diff[0] >=1){
    	return String.format(
    	        "%d day%s ago",
    	        diff[0],
    	        diff[0] > 1 ? "s" : "");
    }else if(diff[1] >=1){
    	return String.format(
    	        "%d hour%s ago",
    	        diff[1],
    	        diff[1] > 1 ? "s" : "");
    }else if(diff[2] >=1){
    	return String.format(
    	        "%d min%s ago",
    	        diff[2],
    	        diff[2] > 1 ? "s" : "");
    }else if(diff[3] >=1){
    	return String.format(
    	        "%d sec%s ago",
    	        diff[3],
    	        diff[3] > 1 ? "s" : "");
    }else{
    	return String.format(
    	        "%d sec%s ago",
    	        diff[3],
    	        diff[3] > 1 ? "s" : "");
    }

}}
