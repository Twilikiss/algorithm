package LeetCode;

/**
 * @author cxb
 * @ClassName A2383赢得比赛需要的最少训练时长
 * @date 13/3/2023 下午10:22
 */
public class A2383赢得比赛需要的最少训练时长 {
    public static void main(String[] args) {
        int aws = minNumberOfHours(43, 76, new int[]{11,65,22}, new int[]{85, 29, 22});
        System.out.println(aws);
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int total = energy.length;
        int addEnergy = 0;
        int addEx = 0;
        for (int i = 0; i < total; i++) {
            if (initialEnergy - energy[i] <= 0) {
                int temp = energy[i] - initialEnergy + 1;
                addEnergy += temp;
                initialEnergy = 1;
            } else {
                initialEnergy -= energy[i];
            }
            if (initialExperience - experience[i] <= 0) {
                int temp = experience[i] - initialExperience + 1;
                addEx += temp;
                initialExperience += temp;
            }
            initialExperience += experience[i];

        }
        return addEnergy + addEx;
    }

}
