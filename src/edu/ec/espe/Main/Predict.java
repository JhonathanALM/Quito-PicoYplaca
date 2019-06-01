package edu.ec.espe.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author JhonathanW10
 */
public class Predict {
    /**
     * Calculate if the car's plate can be on the road
     * @param plate This the car's plate. e.g. PLC-0120
     * @param date This date, it must to be in yyy-MM-dd
     * @param time This time, it must to be in hh:mm
     * @return  allowed or not to allow to be on the road
     */
    public String calculateDate(String plate, String date, String time) {
        String lastDigit = plate.charAt(plate.length() - 1) + "";
        String result = "Allowed";
        if (!timeAllowed(time)) {
            String[] parts = plateAllowed(date).split("-");
            if (lastDigit.equals(parts[0]) || lastDigit.equals(parts[1])) {
                result = "Not Allowed";
            } 
        } 
        return result;
    }

    private String plateAllowed(String Date) {
        String day = null;
        String notAllowPlate = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ParsedDate = df.parse(Date);
            GregorianCalendar dayCalendar = new GregorianCalendar();
            dayCalendar.setTime(ParsedDate);
            int weekDay = dayCalendar.get(Calendar.DAY_OF_WEEK);
            switch (weekDay) {
                case 1:
                    day = "Sunday";
                    notAllowPlate = "none";
                    break;
                case 2:
                    day = "Monday";
                    notAllowPlate = "1-2";
                    break;
                case 3:
                    day = "Tuesday";
                    notAllowPlate = "3-4";
                    break;
                case 4:
                    day = "Wednesday";
                    notAllowPlate = "5-6";
                    break;
                case 5:
                    day = "Thursday";
                    notAllowPlate = "7-8";
                    break;
                case 6:
                    day = "Fryday";
                    notAllowPlate = "9-0";
                    break;
                case 7:
                    day = "Saturday";
                    notAllowPlate = "none";
                    break;
            }
        } catch (ParseException e) {
            System.err.println("invalid Date Format");
            e.printStackTrace();
        }

        return notAllowPlate;
    }

    private boolean timeAllowed(String time) {
        boolean isAllowHour = true;
        SimpleDateFormat df = new SimpleDateFormat("hh:mm");
        try {
            Calendar cal = Calendar.getInstance(); 
            Date ParsedDate = df.parse(time);
            cal.setTime(ParsedDate);     
            
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int min = cal.get(Calendar.MINUTE);
            if((hour>=7 && min >=00)&&(hour<=9 && min <=30)){
                isAllowHour=false;
            }
            if((hour>=16 && min >=00)&&(hour<=19 && min <=30)){                
                isAllowHour=false;
            }
        } catch (ParseException e) {
            System.err.println("invalid Hour Format");
            e.printStackTrace();
        }
        return isAllowHour;
    }
}
