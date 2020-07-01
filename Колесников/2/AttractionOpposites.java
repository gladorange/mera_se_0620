import java.util.Random;

public class AttractionOpposites {

    public static void main(String[] args) {

        int[] nums = new int[10];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt();
        }

        for (int i : nums){
            System.out.println(i);

        }

        boolean cycleFinish = false;
        while(!cycleFinish){
            for (int i = 0; i < nums.length-1; i++){
                if ((nums[i]>0 && nums[i+1]<0) || (nums[i]<0 && nums[i+1]>0)){
                    int summ = nums[i]+nums[i+1];
                    nums[i]=summ;
                    nums[i+1]=summ;
                    break;
                }
                if (i == nums.length-2){
                    cycleFinish = true;
                }
            }
        }

        for (int i : nums){
            System.out.println(i);
        }
    }
}
