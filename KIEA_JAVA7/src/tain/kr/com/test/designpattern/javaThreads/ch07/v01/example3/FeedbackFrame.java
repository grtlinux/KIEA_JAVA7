package tain.kr.com.test.designpattern.javaThreads.ch07.v01.example3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings({"unused", "deprecation"})
public class FeedbackFrame extends JFrame implements Runnable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SwingTypeTester stt;
    private Thread t;
    private JLabel label;
    private int state;

    static String[] stateMessages = {
        "Connecting to server...",
        "Logging into server...",
        "Waiting for data...",
        "Complete"
    };

    public FeedbackFrame(SwingTypeTester stt) {
        this.stt = stt;
        setupFrame();
        t = new Thread(this);
        t.start();
        pack();
        show();
    }

    private void setupFrame() {
        label = new JLabel();
        label.setPreferredSize(new Dimension(200, 200));
        Container c = getContentPane();
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent ae) {
                error();
            }
        });
        c.add(label, BorderLayout.NORTH);
        c.add(stopButton, BorderLayout.SOUTH);
    }

    private void setText(final String s) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
				public void run() {
                    label.setText(s);
	        }
            });
        } catch (InterruptedException ie) {
            error();
        } catch (InvocationTargetException ite) {
            error();
        }
    }

    private void error() {
        t.interrupt();
        if (SwingUtilities.isEventDispatchThread())
            closeDown();
        else SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                closeDown();
           }
        });
    }

    private void closeDown() {
        stt.setupCancelled();
        hide();
        dispose();
    }

    @Override
	public void run() {
        // Simulate connecting to server
        for (int i = 0; i < stateMessages.length; i++) {
            setText(stateMessages[i]);
            try {
                Thread.sleep(5 * 1000);
	    } catch (InterruptedException ie) {}
	    if (Thread.currentThread().isInterrupted())
	        return;
	}
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
              	stt.setupDone();
                hide();
                dispose();
	    }
        });
    }
}
