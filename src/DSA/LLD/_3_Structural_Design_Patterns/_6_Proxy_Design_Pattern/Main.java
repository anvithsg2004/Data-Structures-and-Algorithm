package DSA.LLD._3_Structural_Design_Patterns._6_Proxy_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

interface Internet {
    void connectTo(String url);
}

class RealInternet implements Internet {
    public void connectTo(String url) {
        System.out.println("Connecting to " + url);
    }
}

class ProxyInternet implements Internet {
    private Internet realInternet = new RealInternet();
    private static List<String> blockedSites;

    static {
        blockedSites = new ArrayList<>();
        blockedSites.add("facebook.com");
        blockedSites.add("instagram.com");
    }

    public void connectTo(String url) {
        if (blockedSites.contains(url.toLowerCase())) {
            System.out.println("Access Denied to " + url);
        } else {
            realInternet.connectTo(url);  // Calls the real internet
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();

        internet.connectTo("google.com");      // ✅ Allowed
        internet.connectTo("facebook.com");    // ❌ Blocked
    }
}
