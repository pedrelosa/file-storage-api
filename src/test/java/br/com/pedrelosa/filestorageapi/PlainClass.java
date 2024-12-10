package br.com.pedrelosa.filestorageapi;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PlainClass {
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

    public static PlainClass generateRandom() {
        Random random = new Random();
        PlainClass obj = new PlainClass();

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getData1() {
        return data1;
    }

    public void setData1(LocalDateTime data1) {
        this.data1 = data1;
    }

    public LocalDateTime getData2() {
        return data2;
    }

    public void setData2(LocalDateTime data2) {
        this.data2 = data2;
    }

    public LocalDateTime getData3() {
        return data3;
    }

    public void setData3(LocalDateTime data3) {
        this.data3 = data3;
    }

    public LocalDateTime getData4() {
        return data4;
    }

    public void setData4(LocalDateTime data4) {
        this.data4 = data4;
    }

    public LocalDateTime getData5() {
        return data5;
    }

    public void setData5(LocalDateTime data5) {
        this.data5 = data5;
    }

    public Double getValor1() {
        return valor1;
    }

    public void setValor1(Double valor1) {
        this.valor1 = valor1;
    }

    public Double getValor2() {
        return valor2;
    }

    public void setValor2(Double valor2) {
        this.valor2 = valor2;
    }

    public Double getValor3() {
        return valor3;
    }

    public void setValor3(Double valor3) {
        this.valor3 = valor3;
    }

    public Double getValor4() {
        return valor4;
    }

    public void setValor4(Double valor4) {
        this.valor4 = valor4;
    }

    public Double getValor5() {
        return valor5;
    }

    public void setValor5(Double valor5) {
        this.valor5 = valor5;
    }

    public Integer getInteiro1() {
        return inteiro1;
    }

    public void setInteiro1(Integer inteiro1) {
        this.inteiro1 = inteiro1;
    }

    public Integer getInteiro2() {
        return inteiro2;
    }

    public void setInteiro2(Integer inteiro2) {
        this.inteiro2 = inteiro2;
    }

    public Integer getInteiro3() {
        return inteiro3;
    }

    public void setInteiro3(Integer inteiro3) {
        this.inteiro3 = inteiro3;
    }

    public Integer getInteiro4() {
        return inteiro4;
    }

    public void setInteiro4(Integer inteiro4) {
        this.inteiro4 = inteiro4;
    }

    public Integer getInteiro5() {
        return inteiro5;
    }

    public void setInteiro5(Integer inteiro5) {
        this.inteiro5 = inteiro5;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public String getString4() {
        return string4;
    }

    public void setString4(String string4) {
        this.string4 = string4;
    }

    public String getString5() {
        return string5;
    }

    public void setString5(String string5) {
        this.string5 = string5;
    }

    public List<String> getStringList1() {
        return stringList1;
    }

    public void setStringList1(List<String> stringList1) {
        this.stringList1 = stringList1;
    }

    public List<String> getStringList2() {
        return stringList2;
    }

    public void setStringList2(List<String> stringList2) {
        this.stringList2 = stringList2;
    }

    public List<String> getStringList3() {
        return stringList3;
    }

    public void setStringList3(List<String> stringList3) {
        this.stringList3 = stringList3;
    }

    public Boolean getBool1() {
        return bool1;
    }

    public void setBool1(Boolean bool1) {
        this.bool1 = bool1;
    }

    public Boolean getBool2() {
        return bool2;
    }

    public void setBool2(Boolean bool2) {
        this.bool2 = bool2;
    }

    public Boolean getBool3() {
        return bool3;
    }

    public void setBool3(Boolean bool3) {
        this.bool3 = bool3;
    }

    public Boolean getBool4() {
        return bool4;
    }

    public void setBool4(Boolean bool4) {
        this.bool4 = bool4;
    }

    public Boolean getBool5() {
        return bool5;
    }

    public void setBool5(Boolean bool5) {
        this.bool5 = bool5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlainClass that = (PlainClass) o;
        return id == that.id && Double.compare(that.value, value) == 0 && Objects.equals(name, that.name) && Objects.equals(data1, that.data1) && Objects.equals(data2, that.data2) && Objects.equals(data3, that.data3) && Objects.equals(data4, that.data4) && Objects.equals(data5, that.data5) && Objects.equals(valor1, that.valor1) && Objects.equals(valor2, that.valor2) && Objects.equals(valor3, that.valor3) && Objects.equals(valor4, that.valor4) && Objects.equals(valor5, that.valor5) && Objects.equals(inteiro1, that.inteiro1) && Objects.equals(inteiro2, that.inteiro2) && Objects.equals(inteiro3, that.inteiro3) && Objects.equals(inteiro4, that.inteiro4) && Objects.equals(inteiro5, that.inteiro5) && Objects.equals(string1, that.string1) && Objects.equals(string2, that.string2) && Objects.equals(string3, that.string3) && Objects.equals(string4, that.string4) && Objects.equals(string5, that.string5) && Objects.equals(stringList1, that.stringList1) && Objects.equals(stringList2, that.stringList2) && Objects.equals(stringList3, that.stringList3) && Objects.equals(bool1, that.bool1) && Objects.equals(bool2, that.bool2) && Objects.equals(bool3, that.bool3) && Objects.equals(bool4, that.bool4) && Objects.equals(bool5, that.bool5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, data1, data2, data3, data4, data5, valor1, valor2, valor3, valor4, valor5, inteiro1, inteiro2, inteiro3, inteiro4, inteiro5, string1, string2, string3, string4, string5, stringList1, stringList2, stringList3, bool1, bool2, bool3, bool4, bool5);
    }

    @Override
    public String toString() {
        return "PlainClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", data1=" + data1 +
                ", data2=" + data2 +
                ", data3=" + data3 +
                ", data4=" + data4 +
                ", data5=" + data5 +
                ", valor1=" + valor1 +
                ", valor2=" + valor2 +
                ", valor3=" + valor3 +
                ", valor4=" + valor4 +
                ", valor5=" + valor5 +
                ", inteiro1=" + inteiro1 +
                ", inteiro2=" + inteiro2 +
                ", inteiro3=" + inteiro3 +
                ", inteiro4=" + inteiro4 +
                ", inteiro5=" + inteiro5 +
                ", string1='" + string1 + '\'' +
                ", string2='" + string2 + '\'' +
                ", string3='" + string3 + '\'' +
                ", string4='" + string4 + '\'' +
                ", string5='" + string5 + '\'' +
                ", stringList1=" + stringList1 +
                ", stringList2=" + stringList2 +
                ", stringList3=" + stringList3 +
                ", bool1=" + bool1 +
                ", bool2=" + bool2 +
                ", bool3=" + bool3 +
                ", bool4=" + bool4 +
                ", bool5=" + bool5 +
                '}';
    }
}
