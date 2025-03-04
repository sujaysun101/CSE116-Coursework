package ratings;

import java.util.*;

public class DegreesOfSeparation {
    private ArrayList<Movie> movies;
    public DegreesOfSeparation(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    public int degreesOfSeparation(String mem1, String mem2) {
        HashMap<String, Integer> dist = new HashMap<>();
        HashMap<String, ArrayList<Movie>> castMov = new HashMap<>();
        for (Movie m : movies) {
            for (String cast : m.getCast()) {
                dist.put(cast, -1);
                if (!castMov.containsKey(cast)) {
                    castMov.put(cast, new ArrayList<>());
                }
                castMov.get(cast).add(m);
            }
        }
        if (!dist.containsKey(mem1) || !dist.containsKey(mem2)) {
            return -1;
        }
        if (mem1.equals(mem2)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(mem1);
        visited.add(mem1);
        dist.put(mem1, 0);
        while(!q.isEmpty()) {
            String currentMem = q.poll();
            for (Movie m1 : castMov.get(currentMem)) {
                for (String cast : m1.getCast()) {
                    if (!visited.contains(cast)) {
                        visited.add(cast);
                        dist.put(cast, dist.get(currentMem) + 1);
                        q.offer(cast);
                    }
                }
            }

        }
        return dist.get(mem2);
    }
}
