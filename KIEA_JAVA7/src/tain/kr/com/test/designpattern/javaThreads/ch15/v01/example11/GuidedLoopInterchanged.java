package tain.kr.com.test.designpattern.javaThreads.ch15.v01.example11;

import tain.kr.com.test.designpattern.javaThreads.ch15.v01.GuidedLoopHandler;
import tain.kr.com.test.designpattern.javaThreads.ch15.v01.ScaleTester;

public class GuidedLoopInterchanged implements ScaleTester {
    private float lookupValues[][];
    private int nRows, nCols, nThreads;
    private float sumValue;
    private Object lock = new Object();

    private class GuidedLoopInterchangedHandler
                                    extends GuidedLoopHandler {
        GuidedLoopInterchangedHandler(int nc, int nt) {
            super(0, nc, 10, nt);
        }

        @Override
		public void loopDoRange(int start, int end) {
	    float partialSum = 0.0f;
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
		    partialSum += lookupValues[j][i];
                }  
            }
	    synchronized(lock) {
		sumValue += partialSum;
	    }
        }
    }

    @Override
	public void init(int nRows, int nCols, int nThreads) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.nThreads = nThreads;
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
	lookupValues[0][0] += sumValue;
        return lookupValues;
    }
}
