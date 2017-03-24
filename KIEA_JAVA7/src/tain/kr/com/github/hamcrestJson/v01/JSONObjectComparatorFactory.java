package tain.kr.com.github.hamcrestJson.v01;

import tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompareMode;
import tain.kr.com.github.json.orgJson.v01.JSONException;
import tain.kr.com.github.json.orgJson.v01.JSONObject;

import static tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompare.compareJSON;
import static tain.kr.com.github.hamcrestJson.v01.JSONAssertComparisonResult.resultOf;


/**
 * A {@code JSONComparator} implementation that compares {@code JSONObject}s, backed by SkyScreamer's JSONAssert library.
 */
public final class JSONObjectComparatorFactory implements JSONAssertComparatorFactory<JSONObject> {
	private static final JSONAssertComparatorFactory<JSONObject> INSTANCE = new JSONObjectComparatorFactory();

	public static JSONAssertComparatorFactory<JSONObject> jsonObjectComparison() {
		return INSTANCE;
	}

	private JSONObjectComparatorFactory() { }

	@Override
	public JSONComparator<JSONObject> comparatorWith(final JSONCompareMode compareMode) {
		return new JSONComparator<JSONObject>() {
			@Override
			public JSONComparisonResult compare(JSONObject expected, JSONObject actual) throws JSONException {
				return resultOf(compareJSON(expected, actual, compareMode));
			}
		};
	}
}
