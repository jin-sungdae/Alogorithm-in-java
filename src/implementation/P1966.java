package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1966 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer num = br.read();
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer textNum = br.read();
			Integer indexNum = br.read();
			int count = indexNum , resultCOunt = 0;
			List<Integer> text = Arrays.asList();
			Queue<Integer> queue = new LinkedList<>();
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
			for (int j = 0; j < textNum; j++) {
				Integer exNum = br.read();
				text.add(exNum);
				queue.add(exNum);
				priorityQueue.add(exNum);
			}
			while(true) {
//				Integer maxValue = text.stream().mapToInt(x -> x).max()
//						.orElseThrow(NoSuchElementException::new);
//				Integer value = queue.poll();
//				indexNum--;
//				count--;
//				resultCOunt++;
//				if (maxValue > value) {
//					queue.add(value);
//					indexNum++;
//					resultCOunt--;
//					if (indexNum > 0 && count == 0) {
//						count = queue.size();
//					}
//				}
//				if (indexNum == 0 && count )
//					break;
				
				Integer mV = queue.stream().mapToInt(x->x).max()
						.orElseThrow(NoSuchElementException::new);
				Integer value = queue.poll();
				resultCOunt++;
				if (indexNum == -1 && mV > text.get(count)) {
					indexNum = queue.size();
					queue.add(value);
					resultCOunt--;
				} else if (indexNum != -1 && mV <= text.get(count)){
					
					break;
				}
			}
			result.add(resultCOunt);
		}
		result.forEach(System.out::print);
		
	}

}


