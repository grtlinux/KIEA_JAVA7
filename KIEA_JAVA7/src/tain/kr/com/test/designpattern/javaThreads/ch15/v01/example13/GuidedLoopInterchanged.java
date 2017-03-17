package tain.kr.com.test.designpattern.javaThreads.ch15.v01.example13;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.NumberFormat;

import tain.kr.com.test.designpattern.javaThreads.ch15.v01.GuidedLoopHandler;
import tain.kr.com.test.designpattern.javaThreads.ch15.v01.LoopPrinter;
import tain.kr.com.test.designpattern.javaThreads.ch15.v01.ScaleTester;

public class GuidedLoopInterchanged implements ScaleTester {
    private float lookupValues[][];
    private int nRows, nCols, nThreads;
    private LoopPrinter lp;

    private class GuidedLoopInterchangedHandler
                                    extends GuidedLoopHandler {
        GuidedLoopInterchangedHandler(int nc, int nt) {
            super(0, nc, 10, nt);
        }

        @Override
		public void loopDoRange(int start, int end) {
	    NumberFormat nf = NumberFormat.getInstance();
	    nf.setMaximumFractionDigits(4);
            for (int i = start; i < end; i++) {
                lookupValues[0][i] = 0;
            }
            for (int i = start; i < end; i++) {
                for (int j = 1; j < nRows; j++) {
                    float sinValue =
                                (float)Math.sin((i % 360)*Math.PI/180.0);
                    lookupValues[j][i] = sinValue * i / 180.0f;
                    lookupValues[j][i] +=
                                lookupValues[j-1][i]*j/180.0f;
		    if ((j % 20) == 0)
		        lp.println(j * nCols + i, nf.format(lookupValues[j][i]));
                }  
            }
        }
    }

    @Override
	public void init(int nRows, int nCols, int nThreads) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.nThreads = nThreads;
	lp = new LoopPrinter(nCols*nRows, 0);
        lookupValues = new float[nRows][];
        for (int j = 0; j < nRows; j++) {
            lookupValues[j] = new float[nCols];
        }
    }

    @Override
	public float[][] doCalc() {
        GuidedLoopInterchangedHandler loop =
                    new GuidedLoopInterchangedHandler(nCols, nThreads);
        loop.loopProcess();
	try {
	    lp.send2stream(new PrintStream(new FileOutputStream("/dev/null")));
	} catch (Exception e) {
	    throw new IllegalArgumentException("Can't write to devnull " + e);
	}
        return lookupValues;
    }
}
