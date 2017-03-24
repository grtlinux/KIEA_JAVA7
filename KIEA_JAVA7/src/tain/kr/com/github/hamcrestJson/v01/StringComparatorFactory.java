package tain.kr.com.github.hamcrestJson.v01;

import tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompareMode;
import tain.kr.com.github.json.orgJson.v01.JSONException;

import static tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompare.compareJSON;
import static tain.kr.com.github.hamcrestJson.v01.JSONAssertComparisonResult.resultOf;


public final class StringComparatorFactory implements JSONAssertComparatorFactory<String> {
	private static final JSONAssertComparatorFactory<String> INSTANCE = new StringComparatorFactory();

	public static JSONAssertComparatorFactory<String> stringComparison() {
		return INSTANCE;
	}

	private StringComparatorFactory() { }

	@Override
	public JSONComparator<String> comparatorWith(final JSONCompareMode compareMode) {
		return new JSONComparator<String>() {
			@Override
			public JSONComparisonResult compare(String expected, String actual) throws JSONException {
				return resultOf(compareJSON(expected, actual, compareMode));
			}
		};
	}
}
