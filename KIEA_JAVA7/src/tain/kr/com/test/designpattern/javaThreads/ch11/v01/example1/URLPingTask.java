package tain.kr.com.test.designpattern.javaThreads.ch11.v01.example1;

import java.util.*;
import java.net.*;

@SuppressWarnings("unused")
public class URLPingTask extends TimerTask {

    public interface URLUpdate {
        public void isAlive(boolean b);
    }

    URL url;
    URLUpdate updater;

    public URLPingTask(URL url) {
        this(url, null);
    }

    public URLPingTask(URL url, URLUpdate uu) {
        this.url = url;
        updater = uu;
    }

	@Override
	public void run() {
        if (System.currentTimeMillis() - scheduledExecutionTime() > 5000) {
            // Let the next task do it
            return;
        }
        try {
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setConnectTimeout(1000);
            huc.setReadTimeout(1000);
            int code = huc.getResponseCode();
            if (updater != null)
                updater.isAlive(true);
        } catch (Exception e) {
            if (updater != null)
                updater.isAlive(false);
        }
    }
}
