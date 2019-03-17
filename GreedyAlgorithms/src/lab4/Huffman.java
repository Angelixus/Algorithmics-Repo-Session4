package lab4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

	private PriorityQueue<HuffmanNode> priorityQueue;
	
	private HashMap<String, String> codes;
	public Huffman(String filename) {
		HashMap<String, Integer> mappedChars = FileUtil.loadFile(filename);
		priorityQueue = new PriorityQueue<>();
		for (Map.Entry<String, Integer> pair : mappedChars.entrySet()) {
			priorityQueue.add(new HuffmanNode(pair.getKey(), pair.getValue()));
		}
	}
	
	 // O(nlogn)
	private HuffmanTree createHuffmanTree() {
		while(priorityQueue.size() != 1) {
			HuffmanNode left = priorityQueue.poll();
			HuffmanNode right = priorityQueue.poll();
			
			
			left.setAssignedBit(0);
			right.setAssignedBit(1);
			
			HuffmanNode composedNode = new HuffmanNode("", left.getPriority() + right.getPriority(), left, right);
			priorityQueue.add(composedNode);
		}
		
		HuffmanTree res = new HuffmanTree(priorityQueue.poll());
				
		return res;
	}
	
	// O(nlogn)
	public void run() {
		HuffmanTree tree = createHuffmanTree();
		codes = tree.generateHashMap();
	}

	public Map<String, String> getCodes() {
		return codes;
	}
}
