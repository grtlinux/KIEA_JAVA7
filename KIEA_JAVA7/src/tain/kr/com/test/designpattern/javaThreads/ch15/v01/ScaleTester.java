package tain.kr.com.test.designpattern.javaThreads.ch15.v01;

public interface ScaleTester {
    public void init(int nRows, int nCols, int nThreads);
    public float[][] doCalc();
}
