public class time {
	private int value;
	private boolean isEnd;
	
	public time(int value, boolean isEnd){
		this.value = value;
		this.isEnd = isEnd;
	}
	
	public String toString(){
		return Integer.toString(value);
	}
	public int getValue(){
		return value;
	}
	
	public boolean getType(){
		return isEnd;
	}

	public int compareTo(time w) {
		if(value<w.getValue()){
			return -1;
		}
		if(value>w.getValue()){
			return 1;
		}
		return 0;
	}
}
