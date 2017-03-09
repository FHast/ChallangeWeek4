import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

class LongestPrefixMatcher {
	// TODO: Request access token from your student assistant
	public static final String ACCESS_TOKEN = "s1234567_abcde";

	public static final String ROUTES_FILE = "src/routes.txt";
	public static final String LOOKUP_FILE = "src/lookup.txt";

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
	protected TreeMap<Integer, Integer> ports = new TreeMap<>();

	/**
	 * Main entry point
	 */
	public static void main(String[] args) {
		System.out.println(ACCESS_TOKEN);
		new LongestPrefixMatcher();
	}

	/**
	 * Constructs a new LongestPrefixMatcher and starts routing
	 */
	public LongestPrefixMatcher() {
		this.readRoutes();
		int ip = parseIP("1.0.19.6");
		System.out.println("looking for: " + ip + ", shortened: " + (ip >>> 9));
		System.out.println("position in p23: " + Collections.binarySearch(p23, ip >>> 9));
		System.out.println("portnumber in map: " + (ports.get((ip >>> 9))));
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
		//System.out.println(ipToHuman(ip) + " is the int: " + ip);
		int prefixIP = ip >>> (32 - prefixLength);
		//System.out.println("shortened: " + prefixIP);
		
		if (prefixIP == 32777) {
			System.out.println("my ip: " + ip + " binary: " + Integer.toBinaryString(ip));
			System.out.println("written: " + ipToHuman(ip) + "/" + prefixLength);
			System.out.println("my portnumber: " + portNumber);
		}

		switch (prefixLength) {
		case 28:
			p28.add(prefixIP);
			break;
		case 27:
			p27.add(prefixIP);
			break;
		case 26:
			p26.add(prefixIP);
			break;
		case 25:
			p25.add(prefixIP);
			break;
		case 24:
			p24.add(prefixIP);
			break;
		case 23:
			p23.add(prefixIP);
			break;
		case 22:
			p22.add(prefixIP);
			break;
		case 21:
			p21.add(prefixIP);
			break;
		case 20:
			p20.add(prefixIP);
			break;
		case 19:
			p19.add(prefixIP);
			break;
		case 18:
			p18.add(prefixIP);
			break;
		case 17:
			p17.add(prefixIP);
			break;
		case 16:
			p16.add(prefixIP);
			break;
		case 15:
			p15.add(prefixIP);
			break;
		case 14:
			p14.add(prefixIP);
			break;
		case 13:
			p13.add(prefixIP);
			break;
		case 12:
			p12.add(prefixIP);
			break;
		case 11:
			p11.add(prefixIP);
			break;
		case 10:
			p10.add(prefixIP);
			break;
		case 9:
			p09.add(prefixIP);
			break;
		case 8:
			p08.add(prefixIP);
			break;
		default:
			System.err.println("No Bucket for prefix length: " + prefixLength);
		}
		// Map for ip -> portnumber
		ports.put(prefixIP, portNumber);
	}

	/**
	 * Looks up an IP address in the routing tables
	 * 
	 * @param ip
	 *            The IP address to be looked up in integer representation
	 * @return The port number this IP maps to
	 */
	private int lookup(int ip) {
		System.out.println("looking for: " + ipToHuman(ip));
		Integer foundIP;
		
		int result = Collections.binarySearch(p28, (ip >>> 4));
		if (result < 0) {
			result = Collections.binarySearch(p27, (ip >>> 5));
		} else {
			return (ports.get(p28.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p26, (ip >>> 6));
		} else {
			return (ports.get(p27.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p25, (ip >>> 7));
		} else {
			return (ports.get(p26.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p24, (ip >>> 8));
		} else {
			return (ports.get(p25.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p23, (ip >>> 9));
		} else {
			return (ports.get(p24.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p22, (ip >>> 10));
		} else {
			return (ports.get(p23.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p21, (ip >>> 11));
		} else {
			return (ports.get(p22.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p20, (ip >>> 12));
		} else {
			return (ports.get(p21.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p19, (ip >>> 13));
		} else {
			return (ports.get(p20.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p18, (ip >>> 14));
		} else {
			return (ports.get(p19.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p17, (ip >>> 15));
		} else {
			return (ports.get(p18.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p16, (ip >>> 16));
		} else {
			return (ports.get(p17.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p15, (ip >>> 17));
		} else {
			return (ports.get(p16.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p14, (ip >>> 18));
		} else {
			return (ports.get(p15.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p13, (ip >>> 19));
		} else {
			return (ports.get(p14.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p12, (ip >>> 20));
		} else {
			return (ports.get(p13.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p11, (ip >>> 21));
		} else {
			return (ports.get(p12.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p10, (ip >>> 22));
		} else {
			return (ports.get(p11.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p09, (ip >>> 23));
		} else {
			return (ports.get(p10.get(result)));
		}
		if (result < 0) {
			result = Collections.binarySearch(p08, (ip >>> 24));
		} else {
			return (ports.get(p09.get(result)));
		}
		if (result >= 0) {
			return (ports.get(p08.get(result)));
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
			StringBuilder sb = new StringBuilder(1024 * 4);
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
