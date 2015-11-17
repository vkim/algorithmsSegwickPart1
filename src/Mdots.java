import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Mdots {
  public static void main(String[] args) {
      
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    
    ArrayList<int[]> lines = new ArrayList<>();
    for(int i=0;i<n;i++) {
      
      lines.add(new int[]{s.nextInt(), s.nextInt()});
    }
    
    
    Collections.sort(lines, (a,b) -> a[1] - b[1]);
    
    ArrayList<Integer> dots = new ArrayList<>();
    int lastDot = -1;
    for(int[] line : lines)
        if(! hasDotInLine(lastDot, line)) {
            lastDot = line[1];
            dots.add(lastDot);
        }
    
    System.out.println(dots.size());
    
    List<String> strings = dots.stream().map(Object::toString)
            .collect(Collectors.toList());
    
    System.out.println(String.join(" ",  strings));
  }
  
  public static boolean hasDotInLine(int lastDot, int[] line) {
    
    if(line[0] <= lastDot && lastDot <= line[1]) {
      return true;
    }
    return false;
  }
}

