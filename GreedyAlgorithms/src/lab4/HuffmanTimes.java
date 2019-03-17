package lab4;

public class HuffmanTimes {
	
	public static void main(String[] args) {
		System.out.println("Starting test");
		System.out.println("-----------------------------------------");
		for(int i = 0; i < Long.MAX_VALUE; i++) {
			String[] temp = args[0].split("\\.");
			
			temp[0] = temp[0] + String.valueOf(i);
			args[0] = temp[0] + "." + temp[1];
			args[1] = String.valueOf(Integer.parseInt(args[1]) * 2);
			Generator.main(args);
			String filename = args[0];
			Huffman huffman = new Huffman(filename);
			long start = System.currentTimeMillis();
			huffman.run();
			long end = System.currentTimeMillis();
		
			long  elapsed = end - start;
			System.out.println("n = " + args[1] + ", elapsed time: " + elapsed);
		}
	}
}
