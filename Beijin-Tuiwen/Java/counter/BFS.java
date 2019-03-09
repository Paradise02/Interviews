package counter;

import java.io.File;
import java.util.ArrayList;

public class BFS {
	/**
	 * 
	 * created 19.3.9
	 * 
	 * use BFS return Dir list
	 */
	
	public String start;
	
	private Queue<String> dirs = new ArrayQueue<>();
	private ArrayList<String> fnames = new ArrayList<>();
	
	public BFS(String start) {
		this.start = start;
		this.dirs.enqueue(start);
		this.search();
	}
	
	private void search() {
		if (! new File(start).isDirectory()) {
			fnames.add(start);
			return;
		}
		while (! this.dirs.isEmpty()) {
			String target = this.dirs.dequeue();
			File dir = new File(target);
			for (String file : dir.list()) {
				file = dir.getAbsolutePath() + "\\" + file;
				if (new File(file).isDirectory()) {
					this.dirs.enqueue(file);
				} else {
					this.fnames.add(file);
				}
			}
		}
	}
	
	public ArrayList<String> getFileNames() {
		return this.fnames;
	}

	public static void main(String[] args) {
		/*System.out.println(new File("C:\\Program Files\\Java\\jre1.8.0_181\\lib\\").list());
		System.out.println(new File("C:\\Program Files\\Java\\jre1.8.0_181\\libamd64").isDirectory());
*/		BFS search = new BFS("C:\\Program Files\\Java\\jre1.8.0_181\\lib\\");
		System.out.println(search.getFileNames());
		System.out.println(search.getFileNames().size());
	}
}
