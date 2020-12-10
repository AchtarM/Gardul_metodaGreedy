
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gard {

	public class GardObjects {

		int start;
		int end;

		public GardObjects(int start, int end) {
			start = this.start;
			end = this.end;
		}

		public String toString() {
			return " " + this.start + "," + this.end + " ";
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("gard.in"));
		ArrayList<GardObjects> gardArray = new ArrayList();
		String n = reader.readLine();
		int k = Integer.parseInt(n);
		String line = null;

		int i = 0;

		while (i < k) {
			line = reader.readLine();
			String[] list = line.split(" ");
			int a = Integer.parseInt(list[0]);
			int b = Integer.parseInt(list[1]);
			Gard gard1 = new Gard();
			Gard.GardObjects obj = gard1.new GardObjects(a, b);
			obj.start = a;
			obj.end = b;
			gardArray.add(obj);
			i++;
		}

		Collections.sort(gardArray, new Comparator<GardObjects>() {

			@Override
			public int compare(GardObjects o1, GardObjects o2) {
				if (o1.start == o2.start) {
					return Integer.valueOf(o2.end).compareTo(o1.end);
				}
				return Integer.valueOf(o1.start).compareTo(o2.start);
			}
		});

		int count = 0, t, j = 0;

		for (t = 1; t < k; t++) {

			if (gardArray.get(t).end <= gardArray.get(j).end) {
				if (gardArray.get(t).start >= gardArray.get(j).start) {
					count++;
				}
			} else {
				j = t;
			}
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("gard.out"));
		writer.write(count + "\n");
		writer.close();
		reader.close();

	}

}
