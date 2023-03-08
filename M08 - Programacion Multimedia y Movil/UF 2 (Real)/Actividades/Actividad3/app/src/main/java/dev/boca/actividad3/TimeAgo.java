package dev.boca.actividad3;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeAgo {

    public String getTimeAgo(long duration){
        Date now = new Date();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - duration);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - duration);
        long hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - duration);
        long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - duration);

        if(seconds < 60) return "Hace menos de un minuto";
        else if(minutes == 1) return "Hace un minuto";
        else if(minutes > 1 && minutes < 60) return minutes + ":" + seconds;
        else if(hours > 0 && hours < 24) return hours + ":" + minutes + ":" + seconds;
        else return "Hace " + days + " dias. " + hours + ":" + minutes + ":" + seconds;

    }
}
