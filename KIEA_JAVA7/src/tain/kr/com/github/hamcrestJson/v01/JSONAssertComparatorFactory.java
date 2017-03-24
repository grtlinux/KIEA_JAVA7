package tain.kr.com.github.hamcrestJson.v01;


interface JSONAssertComparatorFactory<T> {
	JSONComparator<T> comparatorWith(JSONCompareMode compareMode);
}
