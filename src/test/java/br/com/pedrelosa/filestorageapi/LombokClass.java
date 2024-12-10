package br.com.pedrelosa.filestorageapi;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class LombokClass {
    private int id;
    private String name;
    private double value;
    private LocalDateTime data1;
    private LocalDateTime data2;
    private LocalDateTime data3;
    private LocalDateTime data4;
    private LocalDateTime data5;
    private Double valor1;
    private Double valor2;
    private Double valor3;
    private Double valor4;
    private Double valor5;
    private Integer inteiro1;
    private Integer inteiro2;
    private Integer inteiro3;
    private Integer inteiro4;
    private Integer inteiro5;
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    private List<String> stringList1;
    private List<String> stringList2;
    private List<String> stringList3;
    private Boolean bool1;
    private Boolean bool2;
    private Boolean bool3;
    private Boolean bool4;
    private Boolean bool5;

    public static LombokClass generateRandom() {
        Random random = new Random();
        LombokClass obj = new LombokClass();

        obj.setId(random.nextInt(1000));
        obj.setName("Name" + random.nextInt(1000));
        obj.setValue(random.nextDouble() * 1000);

        obj.setData1(LocalDateTime.now().minusDays(random.nextInt(1000)));
        obj.setData2(LocalDateTime.now().minusDays(random.nextInt(1000)));
        obj.setData3(LocalDateTime.now().minusDays(random.nextInt(1000)));
        obj.setData4(LocalDateTime.now().minusDays(random.nextInt(1000)));
        obj.setData5(LocalDateTime.now().minusDays(random.nextInt(1000)));

        obj.setValor1(random.nextDouble() * 1000);
        obj.setValor2(random.nextDouble() * 1000);
        obj.setValor3(random.nextDouble() * 1000);
        obj.setValor4(random.nextDouble() * 1000);
        obj.setValor5(random.nextDouble() * 1000);

        obj.setInteiro1(random.nextInt(1000));
        obj.setInteiro2(random.nextInt(1000));
        obj.setInteiro3(random.nextInt(1000));
        obj.setInteiro4(random.nextInt(1000));
        obj.setInteiro5(random.nextInt(1000));

        obj.setString1("String1_" + random.nextInt(1000));
        obj.setString2("String2_" + random.nextInt(1000));
        obj.setString3("String3_" + random.nextInt(1000));
        obj.setString4("String4_" + random.nextInt(1000));
        obj.setString5("String5_" + random.nextInt(1000));

        obj.setStringList1(generateRandomStringList(random, 10));
        obj.setStringList2(generateRandomStringList(random, 10));
        obj.setStringList3(generateRandomStringList(random, 10));

        obj.setBool1(random.nextBoolean());
        obj.setBool2(random.nextBoolean());
        obj.setBool3(random.nextBoolean());
        obj.setBool4(random.nextBoolean());
        obj.setBool5(random.nextBoolean());

        return obj;
    }

    private static List<String> generateRandomStringList(Random random, int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("ListItem_" + random.nextInt(1000));
        }
        return list;
    }
}
