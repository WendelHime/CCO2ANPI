/**
 * 
 */
package br.com.cco2anpi.tools;

/**
 * @author wotan
 *
 */
public class Searcher {

	public static int binarySearch(Object[] a, Object key)
	{
		return binarySearch(a, 0, a.length, key);
	}
	
	private static <T> int binarySearch(Object[] a, int fromIndex, int toIndex, Object key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			@SuppressWarnings("unchecked")
			Comparable<T> midVal = (Comparable<T>) a[mid];
			@SuppressWarnings("unchecked")
			int cmp = midVal.compareTo((T) key);

			if (cmp < 0)
				low = mid + 1;
			else if (cmp > 0)
				high = mid - 1;
			else
				return mid;
		}
		return -(low + 1);
	}

}