package com.company.bai1;

import java.util.*;
import java.util.stream.Collectors;

public class CountHL {
    public ArrayList<ModelBill> modelBills;
    public void add() {
        ModelBill mb1 = new ModelBill(1, "chu văn hiep1", 12304928, "2000-12-12");
        ModelBill mb2 = new ModelBill(2, "chu văn hiep2", 1023318, "2000-2-12");
        ModelBill mb3 = new ModelBill(3, "chu văn hiep3", 1238, "2000-1-12");
        ModelBill mb4 = new ModelBill(4, "chu văn hiep4", 16704928, "2000-12-2");
        ModelBill mb5 = new ModelBill(5, "chu văn hiep5", 1228, "2000-2-1");
        ModelBill mb6 = new ModelBill(6, "chu văn hiep6", 13148, "2000-12-12");
        ModelBill mb7 = new ModelBill(7, "chu văn hiep7", 124928, "2000-12-12");

        modelBills = new ArrayList<>();
        modelBills.add(mb1);
        modelBills.add(mb2);
        modelBills.add(mb3);
        modelBills.add(mb4);
        modelBills.add(mb5);
        modelBills.add(mb6);
        modelBills.add(mb7);

    }

    public void showList(ArrayList<ModelBill> listBIll) {
        for (ModelBill b : listBIll) {
            System.out.print(b.toString());
        }
    }

    public void distinctDate(){
        Set<String> date = new HashSet<>();
        for(ModelBill b : modelBills){
            date.add(b.getDate());
        }
        for(String s : date){
            System.out.print(s);
        }
    }
    public class MoneyComparator implements Comparator<ModelBill> {

        @Override
        public int compare(ModelBill o1, ModelBill o2) {
            if (o1.getMoney() == o2.getMoney()) {
                return 0;
            } else if (o1.getMoney() > o2.getMoney()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public void sortbyMonety() {
        Collections.sort(modelBills, new MoneyComparator());
    }

    public ArrayList<ModelBill> listBillMoney() {
        ArrayList<ModelBill> list = new ArrayList<>();
        for (ModelBill b : modelBills) {
            if (b.getMoney() >= 1000000) {
                list.add(b);
            }
        }
        return list;
    }
    public  void distinIdname(){
        Set<Integer> idset= new HashSet<>();
        Set<String> nameset= new HashSet<>();
        Set<ModelBill> modelBillSet = new HashSet<>();
        for(ModelBill mb :modelBills){
          idset.add(mb.getId());
          nameset.add(mb.getName());
        }
        for(ModelBill mb : modelBills){
            if(idset.contains(mb.getId()) && nameset.contains(mb.getName())){
                   modelBillSet.add(mb);
            }
        }
        System.out.println(modelBillSet);
    }

    public Map<String, List<ModelBill>> datecount() {
        List<ModelBill> list2 = null;
        Map<String, List<ModelBill>> hashMap = new HashMap<>();
         for (ModelBill mb : modelBills){
             if(!hashMap.containsKey(mb.getDate())){
                 list2 = new ArrayList<>();
                 list2.add(mb);
                 hashMap.put(mb.getDate(),list2);
             }else {
                 List<ModelBill> temps = hashMap.get(mb.getDate());
                 temps.add(mb);
                 hashMap.put(mb.getDate(),temps);
             }
         }

        hashMap.forEach((key, value) -> System.out.println(key + " - " + value));
         return hashMap;
    }
    public static void main(String[] args) {
        CountHL countHL = new CountHL();
        countHL.add();
        System.out.println("Sap xep theo thu tu tang dan Money: ");
        countHL.sortbyMonety();
        countHL.showList(countHL.modelBills);
        System.out.println("\nngay lap don: ");
        countHL.distinctDate();
        System.out.println(" \nMoney > 1000000: ");
        countHL.showList(countHL.listBillMoney());
        System.out.println(" \n id and name: ");
        countHL.distinIdname();
        System.out.println(" \n list date trùng ngày: ");
        countHL.datecount();

    }
}
