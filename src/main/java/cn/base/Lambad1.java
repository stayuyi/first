package cn.base;

import org.hibernate.annotations.SourceType;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * lambda练习
 * <p>
 * Created by yuyi on 2018/9/20.
 */

public class Lambad1 {
    @Test
    public void threadTest1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8");
            }

        }).start();

        new Thread(()-> System.out.println("In Java8")).start();
    }

    @Test
    public void iteratorList(){
        StringBuilder sb=new StringBuilder();
        List<String> strList = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        for (String s : strList) {
            sb.append(s);
            sb.append(" ");
        }
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);


        StringBuilder sb1=new StringBuilder();
        strList.forEach(temp->sb1.append(temp).append(" "));
        System.out.println(sb1);
    }
    @Test
    public void veryNB(){
        List<String> asList = Arrays.asList("abc", "java", "c++", "shiro", "dobbo", "rabbitMQ", "redis");
        System.out.println("---------------startsWith a");
        filter(asList,(str)->str.startsWith("a"));

        System.out.println("----------------endWith o");
        filter(asList,(str)->str.endsWith("o"));

        System.out.println("----------------print all");
        filter(asList,(str)->true);

        System.out.println("----------------do not print");
        filter(asList,(str)->false);

        System.out.println("----------------length>4");
        filter(asList,str->str.length()>4);
    }

  /*  public static void filter(List<String> names, Predicate<String> condition) {
        //这里要添加泛型类型，否则后面的参数只能用Object的方法，而用不到String的方法
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }*/

    private static void filter(List<String> names,Predicate<String> condition){
        names.stream().filter(name->condition.test(name)).forEach(name-> System.out.println(name+"  "));
    }
    @Test
    public void multiplyby2(){
        int[] arrays=new int[]{1,2,3,4,5,6,7,8};
        for (int array : arrays) {
            System.out.println(array*=2);
        }
        Arrays.stream(arrays).map(a->a*=2).forEach(System.out::print);
        System.out.println("\n------------------------");

       //所有的元素+2,过滤后输出小于10的元素
        IntStream intStream = Arrays.stream(arrays).map(a -> a + 2);
        intStream.filter((a)->a<10).forEach(System.out::print);
    }


    @Test
    public void copyNew(){
        List<Integer> asList = Arrays.asList(11, 12, 13, 12, 13, 11, 2, 3, 4, 5, 6, 9);
        //1.List去重
        List<Integer> new1 = asList.stream().distinct().collect(Collectors.toList());
        System.out.println("List去重:"+new1.toString());
        //2.List里求最大值,最小值,平均数等等,summaryStatistics概括统计量
        IntSummaryStatistics intSummaryStatistics = asList.stream().mapToInt(x->x).summaryStatistics();
        System.out.println("avg:"+intSummaryStatistics.getAverage());
        System.out.println("sum:"+intSummaryStatistics.getSum());
        System.out.println("min:"+intSummaryStatistics.getMin());
        System.out.println("max:"+intSummaryStatistics.getMax());
        System.out.println("count:"+intSummaryStatistics.getCount());
        //3.重复2的方法
        long count = asList.stream().mapToInt(x -> x).count();
        System.out.println("count:"+count);
        //注意这里的返回值类型  optionaInt,  用 getasInt()返回int值
        OptionalInt max = asList.stream().mapToInt(x -> x).max();
        OptionalInt min = asList.stream().mapToInt((x -> x)).min();
        int min1=0;
        if (min.isPresent()){
            min1=min.getAsInt();
        }


        System.out.println("min:"+min1);
        System.out.println("max:"+ max);
        System.out.println("avg:"+ asList.stream().mapToInt(x->x).average());
    }
        @Test
        public void toUpperCaseAndComma(){
            List<String> g7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy","U.K.","Canada");
            Stream<String> stringStream1 = g7.stream().map(x -> x.toUpperCase());
            List<String> list1 =stringStream1 .collect(Collectors.toList());
            System.out.println(list1);
            //注意,一个流只能使用一次,使用后会被关闭,所以这里要在创建一个stringStream2
            Stream<String> stringStream2 = g7.stream().map(x -> x.toUpperCase());
            String list2 = stringStream2.collect(Collectors.joining(","));
            System.out.println(list2);

            //流排序,升序
            Stream<Integer> stream=Stream.of(3,7,9,20,1,2);
            stream.sorted().map(x->x+" ").forEach(System.out::print);
            //注意,stream流已经被关闭了,这里再次使用会报错java.lang.IllegalStateException: stream has already been operated upon or closed
            //流排序,降序
            Stream<Integer> stream1=Stream.of(3,7,9,20,1,2);
            stream1.sorted(Comparator.reverseOrder()).map(x->x+" ").forEach(System.out::print);
            System.out.println("_______________________________________");
            //取流前面3个
            Stream<Integer> stream2=Stream.of(3,7,9,20,1,2);
            stream2.limit(3).map(x->x+" ").forEach(System.out::print);
            //取流后面3个
            Stream<Integer> stream3=Stream.of(3,7,9,20,1,2);
            stream3.skip(3).map(x->x+" ").forEach(System.out::print);

            //stream.toArray()返回一个Object数组
            Stream<Integer> stream4=Stream.of(3,7,9,20,1,2);
            Object[] arrayInt = stream4.toArray();
            System.out.println(Arrays.toString(arrayInt));
            //构造引用,返回制定的类型数组
            Stream<Integer> stream5=Stream.of(3,7,9,20,1,2);
            Integer[] arrayInt1 = stream5.toArray(Integer[]::new);
            System.out.println(Arrays.toString(arrayInt1));

        }


}
