package lab1.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc extends Thread {

    public void run(Host host) {
        host.print();
        host.setIpBin(toBinary(host.getIp().split("\\.")));
        host.setMaskBin(toBinary(host.getMask().split("\\.")));
        host.setAddressNetWork(findAddressNetWork(host.getIpBin(), host.getMaskBin()));
        host.setBroadcast(findBroadcast(host.getAddressNetWork(), host.getMaskBin()));
        host.setCountAddress(calcCounterAddress(host.getMaskBin()));
        host.print();
    }

    private static ArrayList<Integer> toBinary(String[] octets) {
        ArrayList<Integer> listBinary = new ArrayList<>();
        int bin;
        for (String octet : octets) {
            bin = Integer.parseInt(octet);
            listBinary.add(Integer.parseInt(Integer.toBinaryString(bin)));
        }
        return listBinary;
    }

    private ArrayList<Integer> findAddressNetWork(List<Integer> ip, ArrayList<Integer> mask) {
        ArrayList<Integer> addressNetWork = new ArrayList<>();
        addressNetWork.add(Integer.parseInt(logicalConjunction(ip.get(0), mask.get(0)), 2));
        addressNetWork.add(Integer.parseInt(logicalConjunction(ip.get(1), mask.get(1)), 2));
        addressNetWork.add(Integer.parseInt(logicalConjunction(ip.get(2), mask.get(2)), 2));
        addressNetWork.add(Integer.parseInt(logicalConjunction(ip.get(3), mask.get(3)), 2));

        return addressNetWork;
    }

    private ArrayList<Integer> findBroadcast(ArrayList<Integer> addressNetWork, ArrayList<Integer> mask) {
        ArrayList<Integer> broadcast = new ArrayList<>();


        for (int i = 0; i < addressNetWork.size(); i++) {
            if (addressNetWork.get(i) != 0 && i != 3)
                broadcast.add(addressNetWork.get(i));

            else if (mask.get(i)==0)broadcast.add(255);
            else{

            broadcast.add(addressNetWork.get(i) + Integer.parseInt(
                    leastSignificantBit(
                            String.valueOf(mask.get(i)).split("")), 2));
            }
        }
        return broadcast;
    }

    private String leastSignificantBit(String[] bit){
        StringBuilder p = new StringBuilder();
        List<String> temp = new ArrayList<>(Arrays.asList(bit));
        for(String lm: temp){
            if (lm.equals("0")) {
                p.append("1");
            }
        }
        return p.toString();
    }
    private int calcCounterAddress(ArrayList<Integer>mask){
   StringBuilder bits = new StringBuilder();
   for(int octet: mask){
       if(octet == 0)
           bits.append("00000000");
       else
       bits.append(octet);
   }
   int degree = leastSignificantBit(bits.toString().split("")).length();

        return (int) Math.pow(2, degree); // )-2; рабочие
    }

    private String logicalConjunction(int a, int b) {
        if (b != 0) {
            String[] too = String.valueOf(a).split("");
            String[] fuu = String.valueOf(b).split("");

            List<String> tooList = new ArrayList<>(Arrays.asList(too));
            while (tooList.size() < 8) {
                tooList.addFirst("0");
            }
            List<String> fuuList = new ArrayList<>(Arrays.asList(fuu));

            List<Integer> con = new ArrayList<>();
            for (int i = 0; i < fuuList.size(); i++) {
                if (Integer.parseInt(tooList.get(i)) == Integer.parseInt(fuuList.get(i))) {
                    if (Integer.parseInt(tooList.get(i)) == 1)
                        con.add(1);
                    else if (!con.isEmpty())
                        con.add(0);
                } else if (!con.isEmpty())
                    con.add(0);
            }
            String subCon = con.toString().substring(1, con.toString().length() - 1);
            return subCon.replaceAll(", ", "");
        } else return "0";
    }
}
