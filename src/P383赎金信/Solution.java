package P383赎金信;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        byte[] ransomBytes = ransomNote.getBytes();
        byte[] magazineBytes = magazine.getBytes();
        int[] map = new int[200];
        for (byte c : magazineBytes) {
            map[c] ++;
        }
        for (byte c : ransomBytes) {
            map[c] --;
        }
        for (int j : map) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }
}