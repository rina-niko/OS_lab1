package lab1;

import lab1.utils.Calc;
import lab1.utils.Host;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static ArrayList<Host> hosts = new ArrayList<>();

    public static void main(String[] args) {
        hosts.add(new Host("46.0.193.82", "255.0.0.0"));
        hosts.add(new Host("120.56.192.245", "255.255.0.0"));
        hosts.add(new Host("35.106.219.138", "255.255.255.0"));
        hosts.add(new Host("140.55.42.107", "255.255.255.0"));
        hosts.add(new Host("154.46.164.86", "255.255.255.248"));

        for (Host host : hosts) {
            Calc thread = new Calc();
            thread.run(host);
        }
    }

}
