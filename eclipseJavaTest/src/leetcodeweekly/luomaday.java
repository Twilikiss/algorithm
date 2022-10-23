package leetcodeweekly;
/**
 * 87双周赛
 * 6184.统计共同度过的日子
 * @author mlp52
 *
 */
public class luomaday {
	public static void main(String[] args) {
		int out = countDaysTogether("08-15", "08-18", "08-16", "08-19");
	}
	public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		String m01 = String.valueOf(arriveAlice.charAt(0)) + String.valueOf(arriveAlice.charAt(1));
		int mA01 = Integer.valueOf(m01);
		String d01 = String.valueOf(arriveAlice.charAt(3)) + String.valueOf(arriveAlice.charAt(4));
		int dA01 = Integer.valueOf(d01);
		String m02 = String.valueOf(leaveAlice.charAt(0)) + String.valueOf(leaveAlice.charAt(1));
		int mA02 = Integer.valueOf(m02);
		String d02 = String.valueOf(leaveAlice.charAt(3)) + String.valueOf(leaveAlice.charAt(4));
		int dA02 = Integer.valueOf(d02);
		
		String m1 = String.valueOf(arriveBob.charAt(0)) + String.valueOf(arriveBob.charAt(1));
		int mb1 = Integer.valueOf(m1);
		String d1 = String.valueOf(arriveBob.charAt(3)) + String.valueOf(arriveBob.charAt(4));
		int db1 = Integer.valueOf(d1);
		String m2 = String.valueOf(leaveBob.charAt(0)) + String.valueOf(leaveBob.charAt(1));
		int mb2 = Integer.valueOf(m2);
		String d2 = String.valueOf(leaveBob.charAt(3)) + String.valueOf(leaveBob.charAt(4));
		int db2 = Integer.valueOf(d2);
		System.out.println(mA01);
		System.out.println(mb1);
		if (mA02 > mb1 || mb2 > mA01) {
			return 0;
		}
		int mCha = mA01 - mb1;
		if (mCha < 0) {
			mCha = mCha * -1;
		}
		if (mCha == 0) {
			if(db2 > dA01 || dA02 > db1) {
				return 0;
			}
		}
		return -1;
    }
}
