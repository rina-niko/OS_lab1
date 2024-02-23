package lab1.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc extends Thread{

    public void run(Host host){
        host.print();
        host.setIpBin(toBinary(host.getIp().split("\\.")));
        host.setMaskBin(toBinary(host.getMask().split("\\.")));
        host.setAddressNetWork(findAddressNetWork(host.getIpBin(), host.getMaskBin()));
        host.print();
    }
    private static ArrayList<Integer> toBinary(String[] octets) {
        ArrayList<Integer> listBinary = new ArrayList<>();
        int bin;
        for (String octet: octets){
            bin = Integer.parseInt(octet);
            listBinary.add(Integer.parseInt(Integer.toBinaryString(bin)));
        }
        return listBinary;
    }

    private ArrayList<Integer> findAddressNetWork(List<Integer> ip, ArrayList<Integer> mask){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(getBin(ip.get(0), mask.get(0)), 2));
        list.add(Integer.parseInt(getBin(ip.get(1), mask.get(1)), 2));
        list.add(Integer.parseInt(getBin(ip.get(2), mask.get(2)), 2));
        list.add(Integer.parseInt(getBin(ip.get(3), mask.get(3)), 2));

        return list;
    }

    private String getBin(int a, int b){
        if (b != 0) {
            String[] too = new String(String.valueOf(a)).split("");
            String[] fuu = new String(String.valueOf(b)).split("");

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
