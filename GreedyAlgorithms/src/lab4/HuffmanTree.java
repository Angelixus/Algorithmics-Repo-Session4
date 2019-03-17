package lab4;

import java.util.HashMap;

public class HuffmanTree {

	private HuffmanNode root;
	public HuffmanTree(HuffmanNode root) {
		this.root = root;
	}
	public HashMap<String, String> generateHashMap() {
		HashMap<String, String> hash = new HashMap<>();
		auxHashMapGenerator(hash, root, new StringBuffer());
		return hash;
	}
	
	// a = 2, b = 2, k = 0 -> O(n)
	private void auxHashMapGenerator(HashMap<String, String> hash, HuffmanNode node, StringBuffer accumulatedPath) {
		if(node == null) {
			return;
		}
		
		StringBuffer currentPath = new StringBuffer();
		currentPath.append(accumulatedPath.toString());
		if(root != node)
			currentPath.append(node.getAssignedBit());
		if(node.getLeft() == null && node.getRight() == null)
			hash.put(node.getCharacter(), currentPath.toString());
		auxHashMapGenerator(hash, node.getLeft(), currentPath);
		auxHashMapGenerator(hash, node.getRight(), currentPath);
		
	}
}
