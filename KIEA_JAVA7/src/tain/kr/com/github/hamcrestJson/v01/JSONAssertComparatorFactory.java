package tain.kr.com.github.hamcrestJson.v01;

import tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompareMode;


interface JSONAssertComparatorFactory<T> {
	JSONComparator<T> comparatorWith(JSONCompareMode compareMode);
}
