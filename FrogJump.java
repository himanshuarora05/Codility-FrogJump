package com.docasap.allscripts.solutions;

public class FrogJump {

  public static void main(String[] args) {
    FrogJump solution2 = new FrogJump();
    int a[] = {1,1};
    System.out.println(solution2.solution(a));
  }

  public int solution(int[] blocks) {
    if(blocks.length == 1){
      return 1;
    }

    int max = 0;
    for(int i =0; i<blocks.length; i++){
      int distance = findDistance(i, blocks);
      max = distance > max? distance: max;
      if(max == blocks.length){
        break;
      }
    }
    return max;
  }


  private static int findDistance(int startingBlock, int[] blocks) {
    int total = blocks.length;
    int left = startingBlock;
    int right = startingBlock;
    boolean leftSide = false;
    boolean rightSide = false;
    while(!leftSide || !rightSide){
      if(right < (total -1) && canJump(blocks[right], blocks[right+1])   ){
        right++;
      }else{
        rightSide = true;
      }

      if(left>0 && canJump(blocks[left], blocks[left -1])){
        left--;
      }{
        leftSide = true;
      }

    }

    return right - left + 1;
  }

  private static boolean canJump(int block1, int block2) {
    return block2 >= block1;
  }
}

