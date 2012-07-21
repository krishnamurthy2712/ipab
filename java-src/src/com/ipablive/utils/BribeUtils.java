package com.ipablive.utils;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class BribeUtils 
{
	public static final String REGISTRATION_SUBJECT = "Thank you for Registering in ipaidbribe.com";
	
	
    public static String getClientIpAddr(HttpServletRequest request) 
    {  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) 
        {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) 
        {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) 
        {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) 
        {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) 
        {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
    
    public static String getFriendlyTime(Date dateTime)
	{
		StringBuffer sb = new StringBuffer();
		Date current = Calendar.getInstance().getTime();
		long diffInSeconds = (current.getTime() - dateTime.getTime()) / 1000;
		long sec = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
		long min = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60
				: diffInSeconds;
		long hrs = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24
				: diffInSeconds;
		long days = (diffInSeconds = (diffInSeconds / 24)) >= 30 ? diffInSeconds % 30
				: diffInSeconds;
		long months = (diffInSeconds = (diffInSeconds / 30)) >= 12 ? diffInSeconds % 12
				: diffInSeconds;
		long years = (diffInSeconds = (diffInSeconds / 12));
		if (years > 0) 
		{
			if (years == 1) 
			{
				sb.append("a year");
			} 
			else 
			{
				sb.append(years + " years");
			}
			if (years <= 6 && months > 0) 
			{
				if (months == 1)
				{
					sb.append(" and a month");
				} 
				else 
				{
					sb.append(" and " + months + " months");
				}
			}
		} 
		else if (months > 0) 
		{
			if (months == 1) 
			{
				sb.append("a month");
			} 
			else 
			{
				sb.append(months + " months");
			}
			if (months <= 6 && days > 0) 
			{
				if (days == 1) 
				{
					sb.append(" and a day");
				}
				else 
				{
					sb.append(" and " + days + " days");
				}
			}
		} 
		else if (days > 0) 
		{
			if (days == 1) 
			{
				sb.append("a day");
			}
			else 
			{
				sb.append(days + " days");
			}
			
			if (days <= 3 && hrs > 0) 
			{
				if (hrs == 1) 
				{
					sb.append(" and an hour");
				} 
				else 
				{
					sb.append(" and " + hrs + " hours");
				}
			}
		} 
		else if (hrs > 0) 
		{
			if (hrs == 1) 
			{
				sb.append("an hour");
			} 
			else 
			{
				sb.append(hrs + " hours");
			}
			
			if (min > 1) 
			{
				sb.append(" and " + min + " minutes");
			}
		}
		else if (min > 0) 
		{
			if (min == 1) 
			{
				sb.append("a minute");
			} 
			else 
			{
				sb.append(min + " minutes");
			}
			
			if (sec > 1) 
			{
				sb.append(" and " + sec + " seconds");
			}
		} 
		else 
		{
			if (sec <= 1) 
			{
				sb.append("about a second");
			} 
			else 
			{
				sb.append("about " + sec + " seconds");
			}
		}
		sb.append(" ago"); 
		return sb.toString();
	}
}
