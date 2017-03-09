import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

class LongestPrefixMatcherOneDimensional {
	// TODO: Request access token from your student assistant
	public static final String ACCESS_TOKEN = "s1776592_ys2h8";

	public static final String ROUTES_FILE = "routes.txt";
	public static final String LOOKUP_FILE = "lookup.txt";

	protected ArrayList<Integer> p28 = new ArrayList<>();
	protected ArrayList<Integer> p27 = new ArrayList<>();
	protected ArrayList<Integer> p26 = new ArrayList<>();
	protected ArrayList<Integer> p25 = new ArrayList<>();
	protected ArrayList<Integer> p24 = new ArrayList<>();
	protected ArrayList<Integer> p23 = new ArrayList<>();
	protected ArrayList<Integer> p22 = new ArrayList<>();
	protected ArrayList<Integer> p21 = new ArrayList<>();
	protected ArrayList<Integer> p20 = new ArrayList<>();
	protected ArrayList<Integer> p19 = new ArrayList<>();
	protected ArrayList<Integer> p18 = new ArrayList<>();
	protected ArrayList<Integer> p17 = new ArrayList<>();
	protected ArrayList<Integer> p16 = new ArrayList<>();
	protected ArrayList<Integer> p15 = new ArrayList<>();
	protected ArrayList<Integer> p14 = new ArrayList<>();
	protected ArrayList<Integer> p13 = new ArrayList<>();
	protected ArrayList<Integer> p12 = new ArrayList<>();
	protected ArrayList<Integer> p11 = new ArrayList<>();
	protected ArrayList<Integer> p10 = new ArrayList<>();
	protected ArrayList<Integer> p09 = new ArrayList<>();
	protected ArrayList<Integer> p08 = new ArrayList<>();
	protected TreeMap<Integer, Integer> ports28 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports27 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports26 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports25 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports24 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports23 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports22 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports21 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports20 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports19 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports18 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports17 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports16 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports15 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports14 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports13 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports12 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports11 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports10 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports09 = new TreeMap<>();
	protected TreeMap<Integer, Integer> ports08 = new TreeMap<>();
	

	/**
	 * Main entry point
	 */
	public static void main(String[] args) {
		System.out.println(ACCESS_TOKEN);
		new LongestPrefixMatcherOneDimensional();
	}

	/**
	 * Constructs a new LongestPrefixMatcher and starts routing
	 */
	public LongestPrefixMatcherOneDimensional() {
		this.readRoutes();
		this.readLookup();

	}

	/**
	 * Adds a route to the routing tables
	 * 
	 * @param prefixIP
	 *            The IP the block starts at in integer representation
	 * @param prefixLength
	 *            The number of bits indicating the network part of the address
	 *            range (notation ip/prefixLength)
	 * @param portNumber
	 *            The port number the IP block should route to
	 */
	private void addRoute(int ip, byte prefixLength, int portNumber) {
		// Buckets for every prefixlength
		// Binary tree for each bucket
		
		// get Prefix
		int prefixIP = ip >>> (32 - prefixLength);

		switch (prefixLength) {
		case 28:
			p28.add(prefixIP);
			ports28.put(prefixIP, portNumber);
			break;
		case 27:
			p27.add(prefixIP);
			ports27.put(prefixIP, portNumber);
			break;
		case 26:
			p26.add(prefixIP);
			ports26.put(prefixIP, portNumber);
			break;
		case 25:
			p25.add(prefixIP);
			ports25.put(prefixIP, portNumber);
			break;
		case 24:
			p24.add(prefixIP);
			ports24.put(prefixIP, portNumber);
			break;
		case 23:
			p23.add(prefixIP);
			ports23.put(prefixIP, portNumber);
			break;
		case 22:
			p22.add(prefixIP);
			ports22.put(prefixIP, portNumber);
			break;
		case 21:
			p21.add(prefixIP);
			ports21.put(prefixIP, portNumber);
			break;
		case 20:
			p20.add(prefixIP);
			ports20.put(prefixIP, portNumber);
			break;
		case 19:
			p19.add(prefixIP);
			ports19.put(prefixIP, portNumber);
			break;
		case 18:
			p18.add(prefixIP);
			ports18.put(prefixIP, portNumber);
			break;
		case 17:
			p17.add(prefixIP);
			ports17.put(prefixIP, portNumber);
			break;
		case 16:
			p16.add(prefixIP);
			ports16.put(prefixIP, portNumber);
			break;
		case 15:
			p15.add(prefixIP);
			ports15.put(prefixIP, portNumber);
			break;
		case 14:
			p14.add(prefixIP);
			ports14.put(prefixIP, portNumber);
			break;
		case 13:
			p13.add(prefixIP);
			ports13.put(prefixIP, portNumber);
			break;
		case 12:
			p12.add(prefixIP);
			ports12.put(prefixIP, portNumber);
			break;
		case 11:
			p11.add(prefixIP);
			ports11.put(prefixIP, portNumber);
			break;
		case 10:
			p10.add(prefixIP);
			ports10.put(prefixIP, portNumber);
			break;
		case 9:
			p09.add(prefixIP);
			ports09.put(prefixIP, portNumber);
			break;
		case 8:
			p08.add(prefixIP);
			ports08.put(prefixIP, portNumber);
			break;
		default:
			System.err.println("No Bucket for prefix length: " + prefixLength);
		}
	}

	/**
	 * Looks up an IP address in the routing tables
	 * 
	 * @param ip
	 *            The IP address to be looked up in integer representation
	 * @return The port number this IP maps to
	 */
	private int lookup(int ip) {		
		int result = Collections.binarySearch(p28, (ip >>> 4));
		if (result < 0) {
			result = Collections.binarySearch(p27, (ip >>> 5));
		} else {
			return (ports28.get(p28.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p26, (ip >>> 6));
		} else {
			return (ports27.get(p27.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p25, (ip >>> 7));
		} else {
			return (ports26.get(p26.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p24, (ip >>> 8));
		} else {
			return (ports25.get(p25.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p23, (ip >>> 9));
		} else {
			return (ports24.get(p24.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p22, (ip >>> 10));
		} else {
			return (ports23.get(p23.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p21, (ip >>> 11));
		} else {
			return (ports22.get(p22.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p20, (ip >>> 12));
		} else {
			return (ports21.get(p21.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p19, (ip >>> 13));
		} else {
			return (ports20.get(p20.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p18, (ip >>> 14));
		} else {
			return (ports19.get(p19.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p17, (ip >>> 15));
		} else {
			return (ports18.get(p18.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p16, (ip >>> 16));
		} else {
			return (ports17.get(p17.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p15, (ip >>> 17));
		} else {
			return (ports16.get(p16.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p14, (ip >>> 18));
		} else {
			return (ports15.get(p15.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p13, (ip >>> 19));
		} else {
			return (ports14.get(p14.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p12, (ip >>> 20));
		} else {
			return (ports13.get(p13.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p11, (ip >>> 21));
		} else {
			return (ports12.get(p12.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p10, (ip >>> 22));
		} else {
			return (ports11.get(p11.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p09, (ip >>> 23));
		} else {
			return (ports10.get(p10.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p08, (ip >>> 24));
		} else {
			return (ports09.get(p09.get(result)));
		}
		if (result >= 0) {
			return (ports08.get(p08.get(result)));
		} else {
			return -1;
		}
	}

	/**
	 * Converts an integer representation IP to the human readable form
	 * 
	 * @param ip
	 *            The IP address to convert
	 * @return The String representation for the IP (as xxx.xxx.xxx.xxx)
	 */
	private String ipToHuman(int ip) {
		return Integer.toString(ip >> 24 & 0xff) + "." + Integer.toString(ip >> 16 & 0xff) + "."
				+ Integer.toString(ip >> 8 & 0xff) + "." + Integer.toString(ip & 0xff);
	}

	/**
	 * Reads routes from routes.txt and parses each
	 */
	private void readRoutes() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(ROUTES_FILE));
			String line;
			while ((line = br.readLine()) != null) {
				this.parseRoute(line);
			}
		} catch (IOException e) {
			System.err.println("Could not open " + ROUTES_FILE);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * Parses a route and passes it to this.addRoute
	 */
	private void parseRoute(String line) {
		String[] split = line.split("\t");
		int portNumber = Integer.parseInt(split[1]);

		split = split[0].split("/");
		byte prefixLength = Byte.parseByte(split[1]);

		int ip = this.parseIP(split[0]);

		addRoute(ip, prefixLength, portNumber);
	}

	/**
	 * Reads IPs to look up from lookup.bin and passes them to this.lookup
	 */
	private void readLookup() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(LOOKUP_FILE));
			int count = 0;
			StringBuilder sb = new StringBuilder(32768 * 4);
			// writing each lookup result to disk separately is very slow;
			// therefore, we collect up to 1024 results into a string and
			// write that all at once.

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(Integer.toString(this.lookup(this.parseIP(line))) + "\n");
				count++;

				if (count >= 1024) {
					System.out.print(sb);
					sb.delete(0, sb.capacity());
					count = 0;
				}
			}

			System.out.print(sb);
		} catch (IOException e) {
			System.err.println("Could not open " + LOOKUP_FILE);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * Parses an IP
	 * 
	 * @param ip
	 *            The IP address to convert
	 * @return The integer representation for the IP
	 */
	private int parseIP(String ipString) {
		String[] ipParts = ipString.split("\\.");

		int ip = 0;
		for (int i = 0; i < 4; i++) {
			ip |= Integer.parseInt(ipParts[i]) << (24 - (8 * i));
		}

		return ip;
	}
}
