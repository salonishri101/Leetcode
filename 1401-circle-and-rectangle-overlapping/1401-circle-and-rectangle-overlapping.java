class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter,
                                int x1, int y1, int x2, int y2) {

        // Rectangle ka circle center ke closest X point
        int closestX = Math.max(x1, Math.min(xCenter, x2));

        // Rectangle ka circle center ke closest Y point
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Closest point aur circle center ke beech distance²
        int dx = closestX - xCenter;
        int dy = closestY - yCenter;

        int distance = dx * dx + dy * dy;

        // distance² <= radius² means overlap
        return distance <= radius * radius;
    }
}