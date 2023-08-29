package eugene.boldyrev._6_basic_data_structures.dictionary;

public class Runner {
    public static void main(String[] args) {
//        AbstractDictionary<String, String> singleDictionary = new SingleDictionary<>();
//        testPut(singleDictionary, 10);
//
//        singleDictionary.del("key0");
//        singleDictionary.print();
//        System.out.println("------------");
//
//
//        singleDictionary.del("key9");
//        singleDictionary.print();
//        System.out.println("------------");
//
//        singleDictionary.del("key5");
//        singleDictionary.print();
//        System.out.println("------------");


//
//        AbstractDictionary<String, String> vectorDictionary = new VectorDictionary<>(10);
//        testPut(vectorDictionary, 10);
//
//        vectorDictionary.del("key0");
//        vectorDictionary.print();
//        System.out.println("------------");
//
//        vectorDictionary.del("key9");
//        vectorDictionary.print();
//        System.out.println("------------");
//
//        vectorDictionary.del("key5");
//        vectorDictionary.print();
//        System.out.println("------------");

//        AbstractDictionary<String, String> factorDictionary = new FactorDictionary<>();
//        testPut(factorDictionary, 10);
//
//        factorDictionary.del("key0");
//        factorDictionary.print();
//        System.out.println("------------");
//
//        factorDictionary.del("key9");
//        factorDictionary.print();
//        System.out.println("------------");
//
//        factorDictionary.del("key5");
//        factorDictionary.print();
//        System.out.println("------------");


//
//
//
        AbstractDictionary<String, String> singleDictionary = new SingleDictionary<>();
        AbstractDictionary<String, String> vectorDictionary = new VectorDictionary<>(100);
        Dictionary<String, String> factorDictionary = new FactorDictionary<>();
        Dictionary<String, String> arrayListDictionary = new ArrayListDictionary<>();

        testPut(singleDictionary, 1_000);
        testPut(singleDictionary, 10_000);
        testPut(singleDictionary, 100_000);
        System.out.println("------------------");

        testPut(vectorDictionary, 1_000);
        testPut(vectorDictionary, 10_000);
        testPut(vectorDictionary, 100_000);
        testPut(vectorDictionary, 1_000_000);
        System.out.println("------------------");
//
        testPut(factorDictionary, 1_000);
        testPut(factorDictionary, 10_000);
        testPut(factorDictionary, 100_000);
        testPut(factorDictionary, 1_000_000);
        System.out.println("------------------");

        testPut(arrayListDictionary, 1_000);
        testPut(arrayListDictionary, 10_000);
        testPut(arrayListDictionary, 100_000);
        testPut(arrayListDictionary, 1_000_000);
    }

    public static void testPut(Dictionary<String, String> dictionary, int count){
        long s = System.nanoTime();
        for (int i = 0; i < count; i++) {
            dictionary.put("key" + i, "val" + i);
        }
        long e = System.nanoTime();
        System.out.printf("%d values added to dictionary for %d ms \n", count, (e - s)/ 1_000_000);
    }


}
