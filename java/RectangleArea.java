/*
	problem 223
	Find the total area covered by two rectilinear rectangles in a 2D plane.
	Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
	Rectangle Area
	Example:
		Input: -3, 0, 3, 4, 0, -1, 9, 2
		Output: 45
	Note:
		Assume that the total area is never beyond the maximum possible value of int.
*/

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int maxX = Math.max(A, E);
		int minX = Math.min(C, G);
		int maxY = Math.max(B, F);
		int minY = Math.min(D, H);
		return (C - A) * (D - B) +
		       (G - E) * (H - F) -
		       ((minX <= maxX || minY <= maxY) ? 0 : (maxX - minX) * (maxY - minY));
	}
}