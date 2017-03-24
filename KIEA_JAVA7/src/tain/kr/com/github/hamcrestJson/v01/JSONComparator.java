package tain.kr.com.github.hamcrestJson.v01;

import tain.kr.com.github.json.orgJson.v01.JSONException;


/**
 * Compares JSON documents.
 *
 * @param <T> the document type, typically {@code JSONObject} or {@code JSONArray}.
 */
public interface JSONComparator<T> {
	JSONComparisonResult compare(T expected, T actual) throws JSONException;
}
