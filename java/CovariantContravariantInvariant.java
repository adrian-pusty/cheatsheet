import java.util.ArrayList;
import java.util.List;

class CovariantContravariantInvariant
{
    public static void main(String[] args) {
        {
            Integer[] source = {1, 2, 3};
            Number[] target = source; // covariant
            target[0] = 4;
            target[0] = 3.14; // compiles // ArrayStoreException at runtime //attempt of heap pollution
            // the type Integer[] can't be used everywhere where its supertype Number[] can be used and that violates the LSP. ->
            // https://stackoverflow.com/questions/42636969/does-java-array-covariance-violate-liskov-substitution-principle
        }
        {
            int[] source = {1, 2, 3};
//            Integer[] target = source; // does not compile
//            target[0] = 4;
        }
        {
            int[] source = {1, 2, 3};
//            long[] target = source; // does not compile
//            target[0] = 4;
//            target[0] = 4L;
        }
        {
            List<Integer> source = new ArrayList<>(List.of(1, 2, 3));
//            List<Number> target = source; // does not compile // java: incompatible types: java.util.List<java.lang.Integer> cannot be converted to java.util.List<java.lang.Number>
//            target.add(4);
//            target.add(3.14);
//            target.set(0, 4);
//            target.set(0, 3.14);
        }
        {
            List<Integer> source = new ArrayList<>(List.of(1, 2, 3));
            List<? extends Number> target = source;     // covariant
//            target.add(4); // does not compile
//            target.add(3.14); // does not compile
//            target.set(0, 4); // does not compile
//            target.set(0, 3.14); // does not compile
        }
        {
            List<Integer> source = new ArrayList<>(List.of(1, 2, 3));
            List<? super Integer> target = source;      // contravariant
            target.add(4);
//            target.add(3.14); // does not compile
            target.set(0, 4);
//            target.set(0, 3.14); // does not compile
        }
        {
//            Integer[] ints1 = new Boolean[] {false, false}; // does not compile
//            int[] ints2 = new boolean[] {false, false}; // does not compile
//            List<Integer> ints3 = new ArrayList<Boolean>(List.of(false, false)); // does not compile
        }
    }
}
