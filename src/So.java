import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class So {

	public static void main(String[] args) {
		List<TimeCount> sf = new ArrayList<TimeCount>();
		List<TimeCount> la = new ArrayList<TimeCount>();
		List<TimeCount> result = new ArrayList<TimeCount>();
		
		TimeCount sf1 = new TimeCount("1:00", 5);
		TimeCount sf2 = new TimeCount("1:05", 8);
		TimeCount sf3 = new TimeCount("2:00", 4);
		sf.add(sf1);
		sf.add(sf2);
		sf.add(sf3);
		
		TimeCount la1 = new TimeCount("1:03", 8);
		TimeCount la2 = new TimeCount("1:15", 10);
		TimeCount la3 = new TimeCount("2:00", 8);
		TimeCount la4 = new TimeCount("3:30", 12);
		la.add(la1);
		la.add(la2);
		la.add(la3);
		la.add(la4);
		
		
		int i = 0;
		int j = 0;
		
		while (i < sf.size() && j < la.size()){
			TimeCount temp = new TimeCount();
			if(sf.get(i).time.compareTo(la.get(i).time) > 0) {
				temp.time = sf.get(i).time;
				if(j > 0 && la.get(j-1).time.compareTo(sf.get(i).time) < 0){
					temp.count = sf.get(i).count + la.get(j-1).count;
					i++;
				}
			} else if(sf.get(i).time.compareTo(la.get(i).time) < 0) {
				temp.time = la.get(i).time;
				if(i > 0 && sf.get(i-1).time.compareTo(la.get(j).time) < 0){
					temp.count = la.get(j).count + sf.get(i-1).count;
					j++;
				}
			} else {
				temp.count = la.get(j).count + sf.get(i).count;
				i++;
				j++;
			}
			result.add(temp);
		}
		for(TimeCount t : result){
			System.out.println(t.time + ":" + t.count);
		}
	}
	
}


class TimeCount{
	
	TimeCount(String time, Integer count){
		this.time = time;
		this.count = count;
	}
	
	TimeCount(){}
	public String time;
	public Integer count;
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}

class Pair<V,T>{
	V value;
	T time;
	
	public Pair(V value, T time){
		this.value = value;
		this.time = time;
	}
}

class TimeMap<K,V,T> {

	Map<K,Pair<V,T>> map;
	
	public TimeMap(){
		this.map = new HashMap<K, Pair<V,T>>();
	}
	
	public void put(K key, V value, T time){
		Pair p = new Pair(value, time);
		map.put(key, p);
	}
	
}