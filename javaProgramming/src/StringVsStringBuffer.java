

public class StringVsStringBuffer {

    // Performance test
    public static String concatUsingString() {
        String str = "Cat";
        for (int i = 0; i < 10000; i++) {
            str = str.concat("Dog");
        }
        return str;
    }

    public static String concatUsingStringBuffer() {
        StringBuffer sb = new StringBuffer("Cat");
//        for (int i = 0; i < 10000; i++) {
//            sb.append("Dog");
//        }
        sb.append("Dog".repeat(10000));
        return sb.toString();
    }

    public static String concatUsingStringBuilder() {
        StringBuilder sb = new StringBuilder("Cat");
        for (int i = 0; i < 10000; i++) {
            sb.append("Dog");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        // Spring is Immutable. oporibortonShil. Tai city variable value change hoinai.
        // city = city.concat(", United States"); evabe abar assign korle then change hobe value.
        // er fole memory te city = "San Francisco" eta toh achei and new city name a arekta Object create hoyeche jjar value San Francisco, United States
        String city = "San Francisco";
        city.concat(", United States");
        System.out.println(city); // San Francisco

        //
        StringBuffer sb = new StringBuffer("Munich");
        sb.append(", Germany");
        System.out.println(sb); // Munich, Germany





        // Performance Test
        long start = System.currentTimeMillis();
        concatUsingString();
        long end = System.currentTimeMillis();
        System.out.println("String took: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        concatUsingStringBuffer();
        end = System.currentTimeMillis();
        System.out.println("StringBuffer took: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        String s = concatUsingStringBuilder();
        end = System.currentTimeMillis();
        System.out.println("StringBuilder took: " + (end - start) + "ms");

        System.out.println(s);
    }
}
