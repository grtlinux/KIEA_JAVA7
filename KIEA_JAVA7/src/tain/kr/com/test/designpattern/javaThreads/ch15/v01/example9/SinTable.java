package tain.kr.com.test.designpattern.javaThreads.ch15.v01.example9;

import tain.kr.com.test.designpattern.javaThreads.ch15.v01.GuidedLoopHandler;
import tain.kr.com.test.designpattern.javaThreads.ch15.v01.LoopPrinter;

public class SinTable extends GuidedLoopHandler {
    private float lookupValues[];
    private LoopPrinter lp;

    public SinTable() {
        super(0, 360*100, 100, 12);
        lookupValues = new float [360 * 100];
        lp = new LoopPrinter(360*100, 0);
    }

    @Override
	public void loopDoRange(int start, int end) {
        for (int i = start; i < end; i++) {
            float sinValue = (float)Math.sin((i % 360)*Math.PI/180.0);
            lookupValues[i] = sinValue * i / 180.0f;
            lp.println(i, " " + i + " " + lookupValues[i]);
        }
    }    

    public float[] getValues() {
        loopProcess();
        lp.send2stream(System.out);
        return lookupValues;
    }

    public static void main(String args[]) {
        System.out.println("Starting Example 9 (Printing Example)");
        System.out.println("Output: ");

        SinTable st = new SinTable();
        float results[] = st.getValues();

        System.out.println("");
        System.out.println("Results: "+ results[0]+ ", "+
                      results[1]+ ", "+ results[2]+ ", "+ "...");
        System.out.println("Done");
    }
}
