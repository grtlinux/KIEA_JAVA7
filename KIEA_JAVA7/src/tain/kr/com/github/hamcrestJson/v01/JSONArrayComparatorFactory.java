package tain.kr.com.github.hamcrestJson.v01;


/**
 * A {@code JSONComparator} implementation that compares {@code JSONArray}s, backed by SkyScreamer's JSONAssert library.
 */
final class JSONArrayComparatorFactory implements JSONAssertComparatorFactory<JSONArray> {
	private static final JSONAssertComparatorFactory<JSONArray> INSTANCE = new JSONArrayComparatorFactory();

	static JSONAssertComparatorFactory<JSONArray> jsonArrayComparison() {
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
