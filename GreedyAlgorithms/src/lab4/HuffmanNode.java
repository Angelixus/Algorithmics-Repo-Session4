package lab4;

public class HuffmanNode implements Comparable<HuffmanNode>{
	
	private String character;
	private int priority;
	
	private HuffmanNode left = null;
	private HuffmanNode right = null;
	
	private int assignedBit;
	public HuffmanNode(String character, int priority) {
		this.character = character;
		this.priority = priority;
	}
	
	public HuffmanNode(String character, int priority, HuffmanNode left, HuffmanNode right) {
		this(character, priority);
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(HuffmanNode other) {
		return this.priority - other.priority;
	}

	public String getCharacter() {
		return character;
	}

	public int getPriority() {
		return priority;
	}

	public int getAssignedBit() {
		return assignedBit;
	}

	public void setAssignedBit(int assignedBit) {
		this.assignedBit = assignedBit;
	}

	public HuffmanNode getLeft() {
		return left;
	}

	public HuffmanNode getRight() {
		return right;
	}
	
}
