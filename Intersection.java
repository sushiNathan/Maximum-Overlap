import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Intersection {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of pairs:");
		int n = Integer.parseInt(input.next());
		Vector<time> times = new Vector<time>();
		time[] sortedTimes = new time[n*2];
		for(int i = 0; i<n; i++){
			System.out.println("Enter 1st value");
			time start = new time(Integer.parseInt(input.next()), false);
			times.add(start);
			System.out.println("Enter 2nd value");
			time end = new time(Integer.parseInt(input.next()), true);
			times.add(end);
		}
		input.close();
		for(int i = 0; i<n*2; i++){
			sortedTimes[i] = times.elementAt(i);
		}
		System.out.println(Arrays.toString(sortedTimes));
		sortTime(sortedTimes);
		sortedTimes = overlap(sortedTimes, n);
		int max = maxOverlap(sortedTimes);
		System.out.println("Maximum overlap: " + max);
	}
	
	public static time[] overlap(time[] times, int n){
		int count = 0;
		Vector<time> otherTimes = new Vector<time>();
		for(int i = 0; i < times.length; i++){
			if((count==0)&&(times[i].getType()==false)){
				otherTimes.add(times[i]);
			}
			if(times[i].getType()==false){
				count++;
			}
			else if(times[i].getType()==true){
				count--;
			}
			if((count==0)&&(times[i].getType()==true)){
				otherTimes.add(times[i]);
			}
		}
		time[] overlapTimes = new time[otherTimes.size()];
		for(int i = 0; i<otherTimes.size();i++){
			overlapTimes[i] = otherTimes.elementAt(i);
		}
		return overlapTimes;
	}

	public static int maxOverlap(time[] times){
		int max = 0;
		for(int i = 0; i < times.length-1; i++){
			if(times[i+1].getValue()-times[i].getValue()>max){
				max = times[i+1].getValue()-times[i].getValue();
			}
		}
		return max;
	}
	public static void sortTime(time[] a){
		//Sort a[] into increasing order.
		int N = a.length; //Array length
			for (int i = 0; i < N; i++){
				//Exchange a[i] with smallest entry in a[i+1...N]
				int min = i; //Index of minimal entr.
				for(int j = i+1; j<N; j++){
					if(a[j].getValue()<a[min].getValue()){
						min = j;
						exch(a,i,min);
					}
				}
		}
	}

	private static void exch(time[] a, int i, int j){
		time t = a[i];a[i] = a[j];a[j] = t;
	}
}
