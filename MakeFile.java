import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class MakeFile {
    public static void csv(int number) throws IOException {
        Faker faker = new Faker();
        File file=new File("D://csvByJava.csv");
        FileWriter fw= new FileWriter(file);
        BufferedWriter bWriter = new BufferedWriter(fw);
        int counter=0;
        long var = System.currentTimeMillis();
        while(counter<number){
            bWriter.write(faker.name().firstName());
            bWriter.write(",");
            bWriter.write(faker.name().lastName());
            bWriter.write(",");
            bWriter.write(String.valueOf(faker.number().numberBetween(9000000000L,9999999999L)));
            bWriter.write(",");
            bWriter.write(faker.address().city());
            bWriter.write(",");
            bWriter.write(faker.address().state());
            bWriter.write(",");
            bWriter.write(faker.address().country());
            bWriter.newLine();
            counter++;
        }
        long var2 = System.currentTimeMillis() - var;
        System.out.println(var2);
        bWriter.close();
    }
//    public static void json(int number) throws IOException {
//        long t1 = System.currentTimeMillis();
//        Faker faker = Faker.instance();
//        File filepath = new File("D://jsonByJava.json");
//        FileWriter fw = new FileWriter(filepath);
//        int counter = 0;
//        while(counter < number) {
//            JSONObject jo = new JSONObject();
//            jo.put("FirstName", faker.name().firstName());
//            jo.put("LastName", faker.name().lastName());
//            jo.put("Age", faker.number().numberBetween(20, 80));
//            jo.put("PhoneNo", faker.number().numberBetween(8000000000L, 9999999999L));
//            jo.put("Job", faker.job().position());
//            fw.write(jo.toJSONString());
//            fw.write("\n");
//            counter++;
//        }
//        fw.close();
//        long t2 = System.currentTimeMillis() - t1;
//        System.out.println("JSON File Time: " + t2);
//    }

    public static void json(int number) throws IOException {
        long t1 = System.currentTimeMillis();
        Faker faker = Faker.instance();
        File filepath = new File("D://JSON_people_BW.json");
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter(fw);
        int counter = 0;
        while (counter < number) {
            bw.write("{");
            bw.write("\"FirstName\":\"" + faker.name().firstName() + "\",");
            bw.write("\"LastName\":\"" + faker.name().lastName() + "\",");
            bw.write("\"Age\":" + faker.number().numberBetween(20, 80) + ",");
            bw.write("\"PhoneNo\":" + faker.number().numberBetween(8000000000L, 9999999999L) + ",");
            bw.write("\"Job\":\"" + faker.job().position() + "\"");
            bw.write("}");
            bw.newLine();
            counter++;
        }
        bw.close();
    }

}
