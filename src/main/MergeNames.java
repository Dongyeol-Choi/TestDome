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
	 * 2개의 배열 중복제거
	 * HashSet사용
	 */
    public static String[] uniqueNames(String[] names1, String[] names2) {
    	
        Set<String> names = new HashSet<>(Arrays.asList(names1));
        names.addAll(Arrays.asList(names2));
        return names.toArray(new String[names.size()]);
    }
    
    /*
	 * 2개의 배열 중복제거
	 * Stream사용
	 */
    public static String[] uniqueNames2(String[] names1, String[] names2) {
    	
        List<String> listNames1 = new ArrayList<>(Arrays.asList(names1));
        List<String> listNames2 = new ArrayList<>(Arrays.asList(names2));
        
        //Collect - 스트림의 아이템들을 List[.collect(Collectors.toList())] 또는 Set[.collect(Collectors.toSet())] 자료형으로 변환
        List<String> names = Stream.concat(listNames1.stream(), listNames2.stream()).distinct().collect(Collectors.toList());
        
        return names.toArray(new String[names.size()]);
    }
    
    public static void main(String[] args) {
    	
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        
        //HashSet사용
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
        
        //Stream사용
        System.out.println(String.join(", ", MergeNames.uniqueNames2(names1, names2))); // should print Ava, Emma, Olivia, Sophia
 
    }
}