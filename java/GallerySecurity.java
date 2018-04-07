public class GallerySecurity {
	public static void main(String[] args){
		char[][] gallery = new char[][]{
			{' ','g',' ',' ',' '},
			{' ',' ','g',' ',' '},
			{' ',' ',' ','g',' '},
			{'g',' ',' ','x',' '},
			{'g',' ',' ',' ',' '},
		};

		System.out.println(isSecure(gallery));
	}

	//O(m^2 + n^2 + 2mn)
	private static boolean isSecure(char[][] gallery) {
		if (gallery == null) {
			throw new NullPointerException("gallery is null");
		}
		int m = gallery.length, n;
		if (m <= 0 || (n = gallery[0].length) <= 0) {
			throw new IllegalArgumentException("gallery must has more than one room");
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (gallery[i][j] == ' ' && !isSecure(gallery, i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isSecure(char[][] gallery, int x, int y) {
		return isSecureUp(gallery, x, y)
		       || isSecureDown(gallery, x, y)
		       || isSecureLeft(gallery, x, y)
		       || isSecureRight(gallery, x, y);
	}

	private static boolean isSecureUp(char[][] gallery, int x, int y) {
		while(--x >= 0 && gallery[x][y] != 'x'){
			if(gallery[x][y] == 'g'){
				return true;
			}
		}
		return false;
	}
	private static boolean isSecureDown(char[][] gallery, int x, int y) {
		int max = gallery.length;
		while(++x < max && gallery[x][y] != 'x'){
			if(gallery[x][y] == 'g'){
				return true;
			}
		}
		return false;
	}
	private static boolean isSecureLeft(char[][] gallery, int x, int y) {
		while(--y >= 0 && gallery[x][y] != 'x'){
			if(gallery[x][y] == 'g'){
				return true;
			}
		}
		return false;

	}
	private static boolean isSecureRight(char[][] gallery, int x, int y) {
		int max = gallery[0].length;
		while(++y < max && gallery[x][y] != 'x'){
			if(gallery[x][y] == 'g'){
				return true;
			}
		}
		return false;
	}
}