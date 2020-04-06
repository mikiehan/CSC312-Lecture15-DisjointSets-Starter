// DisjSets class
//
// CONSTRUCTION: with int representing initial number of sets
//
// ******************PUBLIC OPERATIONS*********************
// void union( root1, root2 ) --> Merge two sets
// int find( x )              --> Return set containing x
// ******************ERRORS********************************
// No error checking is performed

import java.util.*;

/**
 * Disjoint set class, using union by rank and path compression.
 * Elements in the set are numbered starting at 0.
 *
 * @author Mark Allen Weiss
 */
public class DisjointSets {

    private int[] s; //each cell at index i represents parent of element i
    //if the element i is the root then it will have negative value

    /**
     * Construct the disjoint sets object.
     *
     * @param numElements the initial number of disjoint sets.
     */
    public DisjointSets(int numElements) {
        //implement me
    }

    /**
     * Union two disjoint sets using the height heuristic.
     * For simplicity, we assume root1 and root2 are distinct
     * and represent set names.
     *
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void unionByRoot(int root1, int root2) {
        //implement me
    }

    /**
     * Union two disjoint sets using the height heuristic.
     * For simplicity, we assume e1 and e2 are distinct
     * and represent set names.
     *
     * @param e1 any element of set 1.
     * @param e2 any element of set 2.
     */
    public void union(int e1, int e2){
        //implement me
    }

    /**
     * Perform a find with path compression.
     * Error checks omitted again for simplicity.
     *
     * @param x the element being searched for.
     * @return the set containing x.
     */
    public int find(int x) {
        //implement me
        return -1; //replace this code with correct one
    }

    @Override
    public String toString() {
        return Arrays.toString(s);
    }

    // Test main; all finds on same output line should be identical
    public static void main(String[] args) {
        int NumElements = 16;
        int NumInSameSet = 4;

        DisjointSets ds = new DisjointSets(NumElements);
        int set1, set2;

        for (int k = 1; k < NumInSameSet; k *= 2) {
            for (int j = 0; j + k < NumElements; j += 2 * k) {
                set1 = ds.find(j);
                set2 = ds.find(j + k);
                System.out.print("unionByRoot " + set1 + " " + set2 + ", ");
                ds.unionByRoot(set1, set2);
            }
            System.out.println();
        }

        Map<Integer, Set<Integer>> setMapping = new TreeMap<>();
        for (int i = 0; i < NumElements; i++) {
            int setId = ds.find(i);
            if(!setMapping.containsKey(setId)) {
                setMapping.put(setId, new HashSet<>());
            }
            setMapping.get(setId).add(i);
        }
        for(int setId : setMapping.keySet()){
            System.out.println("set " + setId + " : " + setMapping.get(setId));
        }
        System.out.println(ds);
    }
}