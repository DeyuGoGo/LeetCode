public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix ==null ||  matrix.length<1)
                return result;
        int indexX = 0 ,indexY = 0 , endX = matrix[0].length -1 , endY = matrix.length -1 ;
        int loop = 0;
        /**
         * 0 = right , 1 down , 2 = left , 3 = up;
        */
        while(indexX <= endX && indexY <= endY){
            final int gowhere = loop % 4;
            switch(gowhere){
                case 0:{
                    for(int i = indexX ; i <= endX ; i++)
                        result.add(matrix[indexY][i]);
                    indexY++;
                    break;
                }
                 case 1:{
                    for(int i = indexY ; i <= endY ; i++)
                        result.add(matrix[i][endX]);
                    endX--;
                    break;
                }
                 case 2:{
                    for(int i = endX ; indexX <= i; i--)
                        result.add(matrix[endY][i]);
                    endY--;
                    break;
                }
                 case 3:{
                    for(int i = endY ; indexY <= i  ; i--)
                        result.add(matrix[i][indexX]);
                    indexX++;
                    break;
                }
            }
            loop++;
        }
        return result;
    }
}
