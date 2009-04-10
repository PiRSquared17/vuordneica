package lv.ante.vuordneica.util.properties;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class PropertyFileLineIterator implements Iterator<String> {
	
	private Properties props;
	private List<String> original;
	private int found = 0;
	private int notFound = 0;
	private int comments = 0;
	private int empty = 0;
	private int count;
	
	public PropertyFileLineIterator(Properties props, List<String> original) {
		this.props = props;
		this.original = original;
		count = 0;
	}

	public boolean hasNext() {
		return (count < original.size());
	}

	public String next() {
		String s = original.get(count++);
		int index = s.indexOf("=");
		if (s.startsWith("#")) {
			comments++;
			return s;
		}
		else if (s.equals("")) {
			empty++;
			return s;
		}
		else if (index > -1) {
			
			String key = s.substring(0, index);
			String value = props.getProperty(key);
			if (value == null) {
				notFound++;
				System.err.print("$");
				if ((found+notFound)%100 == 0) {
					System.err.print("\n");
				}
				return s;
			}
			else {
				found++;
				System.err.print(".");
				if ((found+notFound)%100 == 0) {
					System.err.print("\n");
				}
				return key + "=" + value;
			}
		}
		else {
			throw new RuntimeException("Strange source line: '" + s + "'");
		}
	}

	public void remove() {
		throw new UnsupportedOperationException("remove() not supported");
	}

	public int getFound() {
		return found;
	}

	public int getNotFound() {
		return notFound;
	}

	public int getComments() {
		return comments;
	}

	public int getEmpty() {
		return empty;
	}
	
	
}
