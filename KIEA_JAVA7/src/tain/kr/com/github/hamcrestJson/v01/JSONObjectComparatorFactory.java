package tain.kr.com.github.hamcrestJson.v01;


/**
 * A {@code JSONComparator} implementation that compares {@code JSONObject}s, backed by SkyScreamer's JSONAssert library.
 */
final class JSONObjectComparatorFactory implements JSONAssertComparatorFactory<JSONObject> {
	private static final JSONAssertComparatorFactory<JSONObject> INSTANCE = new JSONObjectComparatorFactory();

	static JSONAssertComparatorFactory<JSONObject> jsonObjectComparison() {
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
