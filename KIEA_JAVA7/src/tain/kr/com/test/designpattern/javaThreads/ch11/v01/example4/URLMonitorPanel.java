package tain.kr.com.test.designpattern.javaThreads.ch11.v01.example4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("rawtypes")
class TimeoutTask implements Callable {
    @Override
	public Integer call() throws IOException {
        return new Integer(0);
    }
}

@SuppressWarnings({"rawtypes", "unchecked", "unused", "deprecation"})
public class URLMonitorPanel extends JPanel implements URLPingTask.URLUpdate {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	static Future<Integer> futureTaskResult;
    static volatile boolean done = false;
    ScheduledThreadPoolExecutor executor;
    ScheduledFuture cancellable;
    URL url;
    URLPingTask task;
    JPanel status;
    JButton startButton, stopButton;

    public URLMonitorPanel(String url, ScheduledThreadPoolExecutor se)
                          throws MalformedURLException {
	setLayout(new BorderLayout());
        executor = se;
        this.url = new URL(url);
        add(new JLabel(url), BorderLayout.CENTER);
	JPanel temp = new JPanel();
        status = new JPanel();
        status.setSize(20, 20);
        temp.add(status);
        startButton = new JButton("Start");
        startButton.setEnabled(false);
        startButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent ae) {
                makeTask();
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });
        stopButton = new JButton("Stop");
        stopButton.setEnabled(true);
        stopButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent ae) {
                cancellable.cancel(true);
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });
        temp.add(startButton);
        temp.add(stopButton);
	add(temp, BorderLayout.EAST);
        makeTask();
    }

    private void makeTask() {
        task = new URLPingTask(url, this);
        cancellable = executor.scheduleAtFixedRate(task, 0L, 5L, TimeUnit.SECONDS);
    }

    private void checkLicense() {
        if (done) return;
        try {
            Integer I = futureTaskResult.get(0L, TimeUnit.MILLISECONDS);
            JOptionPane.showMessageDialog(null,
                            "Evaluation time period has expired", "Expired",
                        JOptionPane.INFORMATION_MESSAGE);
            done = true;
        } catch (TimeoutException te) {
            // Task hasn't run; just coninue
        } catch (InterruptedException ie) {
            // Task was externally interrupted
        } catch (ExecutionException ee) {
            // Task threw IOException, which can be obtained like
            IOException ioe = (IOException) ee.getCause();
            // Clean up after the exception
        }
    }

    @Override
	public void isAlive(final boolean b) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
				public void run() {
                    checkLicense();
                    if (done) {
                        cancellable.cancel(true);
                        startButton.setEnabled(false);
                        stopButton.setEnabled(false);
                        return;
                    }
                    status.setBackground(b ? Color.GREEN : Color.RED);
                    status.repaint();
                }
            });
        } catch (Exception e) {}
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("URL Monitor");
        Container c = frame.getContentPane();
	c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        ScheduledThreadPoolExecutor se = new ScheduledThreadPoolExecutor((args.length + 1) / 2);
        TimeoutTask tt = new TimeoutTask();
        futureTaskResult = se.schedule(tt, 30, TimeUnit.SECONDS);
        for (int i = 0; i < args.length; i++) {
            c.add(new URLMonitorPanel(args[i], se));
        }
        frame.addWindowListener(new WindowAdapter() {
            @Override
			public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.show();
    }
}
