class Solution {
    static int[] result = new int[2];
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr[0].length);
        return result;
    }
    
    
    static void compress(int[][] arr, int r, int c, int size){
        if(isUniform(arr, r, c, size)){
            result[arr[r][c]]++;
            return;
        }
        
        int half = size/2;
        compress(arr, r, c, half);
        compress(arr, r + half, c, half);
        compress(arr, r, c + half, half);
        compress(arr, r + half, c + half, half);
    }
    
    static boolean isUniform(int[][] arr, int r, int c, int size){
        int value = arr[r][c];
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(arr[i][j] != value)
                    return false;
            }
        }
        return true;
    }
}