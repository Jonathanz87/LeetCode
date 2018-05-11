public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
		int[] wheels = new int[9999];
		int[] wheelIndexQueue = new int[9999];
		int l = 0, r = 0;

		for (String s : deadends) {
			int i = 0;
			for (char c : s.toCharArray()) {
				i = i * 10 + c - 'a'
			}
			wheels[i] = -1;
		}

		
	}
}
