
/**
 * Min Number of Platforms Required for a Railway Station. At a railway-station,
 * you have time-table for trains arrival and departure. You need to find the
 * minimum number of platforms so that all the trains can be placed as per their
 * schedule. For example consider the below example. All times are in 24hr
 * format. arrival[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00} departure[] =
 * {9:10, 12:00, 11:20, 11:30, 19:00, 20:00} Event Type A = Arrival Event Type D
 * = Departure All events are sorted by time. Total platforms at any time can be
 * obtained by subtracting total departures from total arrivals by that time.
 *
 * Time Event Type Platforms 9:00 A 1 9:10 D 0 9:40 A 1 9:50 A 2 11:00 A 3 11:20
 * D 2 11:30 D 1 12:00 D 0 15:00 A 1 18:00 A 2 19:00 D 1 20:00 D 0
 *
 * Minimum Platforms needed on railway station = Maximum platforms needed at any
 * time = 3
 *
 */
public class PlatformCount {

	/**
	 *
	 * @param arrivals
	 *            : Sorted list of arrival schedules
	 * @param departures
	 *            Sorted list of departures
	 * @return
	 */
	private static int getMinimumPlatformCount(int[] arrivals, int[] departures) {

		int i = 0;
		int j = 0;
		int maxPlatformCount = 0;
		int currentPlatformCount = 0;
		while (i < arrivals.length && j < departures.length) {
			if (arrivals[i] < departures[j]) {
				currentPlatformCount++;
				maxPlatformCount = Math.max(maxPlatformCount, currentPlatformCount);
				i++;
			} else {
				currentPlatformCount--;
				j++;
			}
		}
		return maxPlatformCount;
	}

	public static void main(String[] args) {
		System.out.println(getMinimumPlatformCount(new int[] { 900, 940, 950, 1100, 1500, 1800 },
				new int[] { 910, 1200, 1120, 1130, 1900, 2000 }));
	}
}
