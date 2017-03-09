import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		int prefixIP = ip >> (32 - prefixLength);

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
			p22.insert(prefixIP);
			break;
		case 21:
			p21.insert(prefixIP);
			break;
		case 20:
			p20.insert(prefixIP);
			break;
		case 19:
			p19.insert(prefixIP);
			break;
		case 18:
			p18.insert(prefixIP);
			break;
		case 17:
			p17.insert(prefixIP);
			break;
		case 16:
			p16.insert(prefixIP);
			break;
		case 15:
			p15.insert(prefixIP);
			break;
		case 14:
			p14.insert(prefixIP);
			break;
		case 13:
			p13.insert(prefixIP);
			break;
		case 12:
			p12.insert(prefixIP);
			break;
		case 11:
			p11.insert(prefixIP);
			break;
		case 10:
			p10.insert(prefixIP);
			break;
		case 9:
			p09.insert(prefixIP);
			break;
		case 8:
			p08.insert(prefixIP);
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

		foundIP = (Integer) p28.find(ip >> 4);
		if (foundIP == null) {
			foundIP = (Integer) p27.find(ip >> 5);
		}
		if (foundIP == null) {
			foundIP = (Integer) p26.find(ip >> 6);
		}
		if (foundIP == null) {
			foundIP = (Integer) p25.find(ip >> 7);
		}
		if (foundIP == null) {
			foundIP = (Integer) p24.find(ip >> 8);
		}
		if (foundIP == null) {
			foundIP = (Integer) p23.find(ip >> 9);
		}
		if (foundIP == null) {
			foundIP = (Integer) p22.find(ip >> 10);
		}
		if (foundIP == null) {
			foundIP = (Integer) p21.find(ip >> 11);
		}
		if (foundIP == null) {
			foundIP = (Integer) p20.find(ip >> 12);
		}
		if (foundIP == null) {
			foundIP = (Integer) p19.find(ip >> 13);
		}
		if (foundIP == null) {
			foundIP = (Integer) p18.find(ip >> 14);
		}
		if (foundIP == null) {
			foundIP = (Integer) p17.find(ip >> 15);
		}
		if (foundIP == null) {
			foundIP = (Integer) p16.find(ip >> 16);
		}
		if (foundIP == null) {
			foundIP = (Integer) p15.find(ip >> 17);
		}
		if (foundIP == null) {
			foundIP = (Integer) p14.find(ip >> 18);
		}
		if (foundIP == null) {
			foundIP = (Integer) p13.find(ip >> 19);
		}
		if (foundIP == null) {
			foundIP = (Integer) p12.find(ip >> 20);
		}
		if (foundIP == null) {
			foundIP = (Integer) p11.find(ip >> 21);
		}
		if (foundIP == null) {
			foundIP = (Integer) p10.find(ip >> 22);
		}
		if (foundIP == null) {
			foundIP = (Integer) p09.find(ip >> 23);
		}
		if (foundIP == null) {
			foundIP = (Integer) p08.find(ip >> 24);
		}

		System.out.println("Found IP: " + foundIP);
		if (foundIP == -1) {
			return -1;
		} else {
			return ports.get(foundIP);
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
