package com.ehrc.NIMHANSWhatsAppBot.Utilities;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtility {
    public Date getFirstMessageTime() {

        //This needs to be commented, if it goes to production...
        //**************** START FROM HERE ****************
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        Date modifiedDate = new Date(timeInSecs + (2 * 60 * 1000));
        //This needs to be commented, if it goes to production...
        //**************** ENDS HERE ****************


        //This needs to be commented out, if it goes to production...
        //**************** START FROM HERE ****************
//        Calendar date = Calendar.getInstance();
//        date.set(Calendar.HOUR_OF_DAY, 0);
//        date.set(Calendar.MINUTE, 0);
//        date.set(Calendar.SECOND, 0);
//        date.set(Calendar.MILLISECOND, 0);
//        date.add(Calendar.DAY_OF_MONTH, 1);
//        long timeInSecs = date.getTimeInMillis();
//        Date modifiedDate = new Date(timeInSecs);
        //**************** ENDS HERE ****************
        //This needs to be commented out, if it goes to production...

        return modifiedDate;
    }


    public Date getTimeAfterSevenDaysInterval() {

        //This needs to be commented, if it goes to production...
        //**************** START FROM HERE ****************
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        Date modifiedDate = new Date(timeInSecs + (5 * 60 * 1000));
        //This needs to be commented, if it goes to production...
        //**************** ENDS HERE ****************


        //This needs to be commented out, if it goes to production...
        //**************** START FROM HERE ****************
//        Calendar date = Calendar.getInstance();
//        date.set(Calendar.HOUR_OF_DAY, 0);
//        date.set(Calendar.MINUTE, 0);
//        date.set(Calendar.SECOND, 0);
//        date.set(Calendar.MILLISECOND, 0);
//        date.add(Calendar.DAY_OF_MONTH, 7);
//        long timeInSecs = date.getTimeInMillis();
//        Date modifiedDate = new Date(timeInSecs);
        //**************** ENDS HERE ****************
        //This needs to be commented out, if it goes to production...

        return modifiedDate;
    }


}
