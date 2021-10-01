import java.util.*;
import java.util.regex.Pattern;

public class PhoneBook {
    HashMap<String, String> hashMap = new HashMap<>();
    public static final Pattern PATTERN_NAME = Pattern.compile("[A-zА-я]+");
    public static final Pattern PATTERN_PHONE = Pattern.compile("[0-9]+");
    public static final String ERROR = "Неверный формат ввода";
    public static final String SAVE = "Контакт сохранен!";

    public void addContact(String phone, String name) {
        if (checkName(name) && checkPhone(phone)) {

            if (hashMap.containsValue(phone)) {
                replaceKey(phone);
            }
            if (hashMap.containsKey(name)) {
                phone = addNumber(phone, name);
            }
            hashMap.put(name, phone);
            System.out.println(SAVE);
        } else System.out.println(ERROR);
    }

    public String getContactByPhone(String phone) {
        if (hashMap.containsValue(phone)) {
            String name = "";
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (phone.equals(value)) {
                    name = key;
                    break;
                }
            }
            return name + " - " + phone;
        } else
            return "";
    }

    public Set<String> getContactByName(String name) {
        if (hashMap.containsKey(name)) {
            return new TreeSet<>(Collections.singleton(name + " - " + hashMap.get(name)));
        } else
            return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        TreeSet<String> treeSet = new TreeSet<>();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            treeSet.add(key + " - " + value);
        }
        return treeSet;
    }

    public void replaceKey(String phone) {
        String key = "";
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key2 = entry.getKey();
            String value = entry.getValue();
            if (value.equals(phone)) {
                key = key2;
            }
        }
        hashMap.remove(key);
    }

    public String addNumber(String phone, String name) {
        StringBuilder phoneBuilder = new StringBuilder(phone);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key2 = entry.getKey();
            String value = entry.getValue();
            if (name.equals(key2)) {
                phoneBuilder.insert(0, value + ", ");
            }
        }
        return phoneBuilder.toString();
    }

    public void printAllContacts() {
        for (String s : getAllContacts()) {
            System.out.println(s);
        }
    }

    public boolean checkPhone(String phone) {
        return PATTERN_PHONE.matcher(phone).matches();
    }

    public boolean checkName(String name) {
        return PATTERN_NAME.matcher(name).matches();
    }
}