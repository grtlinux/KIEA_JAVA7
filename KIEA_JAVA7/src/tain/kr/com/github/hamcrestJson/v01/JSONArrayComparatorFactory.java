package tain.kr.com.github.hamcrestJson.v01;

import static tain.kr.com.github.hamcrestJson.v01.JSONAssertComparisonResult.resultOf;
import static tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompare.compareJSON;
import tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompareMode;
import tain.kr.com.github.json.orgJson.v01.JSONArray;
import tain.kr.com.github.json.orgJson.v01.JSONException;


/**
 * A {@code JSONComparator} implementation that compares {@code JSONArray}s, backed by SkyScreamer's JSONAssert library.
 */
public final class JSONArrayComparatorFactory implements JSONAssertComparatorFactory<JSONArray> {
	private static final JSONAssertComparatorFactory<JSONArray> INSTANCE = new JSONArrayComparatorFactory();

	public static JSONAssertComparatorFactory<JSONArray> jsonArrayComparison() {
		return INSTANCE;
	}

	private JSONArrayComparatorFactory() { }

	@Override
	public JSONComparator<JSONArray> comparatorWith(final JSONCompareMode compareMode) {
		return new JSONComparator<JSONArray>() {
			@Override
			public JSONComparisonResult compare(JSONArray expected, JSONArray actual) throws JSONException {
				return resultOf(compareJSON(expected, actual, compareMode));
			}
		};
	}
}
