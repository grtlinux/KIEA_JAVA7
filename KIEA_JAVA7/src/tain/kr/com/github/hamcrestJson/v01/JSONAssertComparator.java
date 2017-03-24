package tain.kr.com.github.hamcrestJson.v01;

import tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompareMode;
import tain.kr.com.github.json.orgJson.v01.JSONException;

import static tain.kr.com.github.json.JSONassert.v01.skyscreamer.jsonassert.JSONCompareMode.STRICT;


public final class JSONAssertComparator<T> implements JSONModalComparator<T> {
	private final JSONAssertComparatorFactory<T> factory;
	private final JSONCompareMode compareMode;

	public static <T> JSONModalComparator<T> modalComparatorFor(JSONAssertComparatorFactory<T> factory) {
		return new JSONAssertComparator<T>(factory);
	}
	
	private JSONAssertComparator(JSONAssertComparatorFactory<T> factory) {
		this(factory, STRICT);
	}

	private JSONAssertComparator(JSONAssertComparatorFactory<T> factory, JSONCompareMode compareMode) {
		this.factory = factory;
		this.compareMode = compareMode;
	}

	@Override
	public JSONComparisonResult compare(T expected, T actual) throws JSONException {
		return factory.comparatorWith(compareMode).compare(expected, actual);
	}

	@Override
	public JSONModalComparator<T> butAllowingAnyArrayOrdering() {
		return new JSONAssertComparator<T>(factory, compareMode.withStrictOrdering(false));
	}

	@Override
	public JSONModalComparator<T> butAllowingExtraUnexpectedFields() {
		return new JSONAssertComparator<T>(factory, compareMode.withExtensible(true));
	}
}
