public class ArrayListDriver
{   //Here we create AL object and test the methods
    public static void main(String[] args)
    {
        DHArrayList<Integer> list = new DHArrayList<Integer>(1);
        //We have an AL created
        list.add(10);
        System.out.println(list);
        list.add(20);
        System.out.println(list);
        list.add(30);
        System.out.println(list);
        list.add(40);
        System.out.println(list);
        list.add(50);
        System.out.println(list);

        list.add(100, 3);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.remove(15);
        System.out.println(list);

        Integer value = list.get(0);
        System.out.println("The value at location 0 is: " + value);
        System.out.println(list);

        list.set(99, 0);
        System.out.println(list);

        System.out.println(list.indexOf(99));
        System.out.println(list.indexOf(30));
        System.out.println(list.indexOf(100));
        System.out.println(list.indexOf(40));
        System.out.println(list.indexOf(50));
        System.out.println(list.indexOf(200));

    }
}
