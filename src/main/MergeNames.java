package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeNames {

	/*
	 * 2���� �迭 �ߺ�����
	 * HashSet���
	 */
    public static String[] uniqueNames(String[] names1, String[] names2) {
    	
        Set<String> names = new HashSet<>(Arrays.asList(names1));
        names.addAll(Arrays.asList(names2));
        return names.toArray(new String[names.size()]);
    }
    
    /*
	 * 2���� �迭 �ߺ�����
	 * Stream���
	 */
    public static String[] uniqueNames2(String[] names1, String[] names2) {
    	
        List<String> listNames1 = new ArrayList<>(Arrays.asList(names1));
        List<String> listNames2 = new ArrayList<>(Arrays.asList(names2));
        
        //Collect - ��Ʈ���� �����۵��� List[.collect(Collectors.toList())] �Ǵ� Set[.collect(Collectors.toSet())] �ڷ������� ��ȯ
        List<String> names = Stream.concat(listNames1.stream(), listNames2.stream()).distinct().collect(Collectors.toList());
        
        return names.toArray(new String[names.size()]);
    }
    
    public static void main(String[] args) {
    	
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        
        //HashSet���
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
        
        //Stream���
        System.out.println(String.join(", ", MergeNames.uniqueNames2(names1, names2))); // should print Ava, Emma, Olivia, Sophia
 
    }
}