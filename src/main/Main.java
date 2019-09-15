package main;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by emakarov on 28.01.2016.
 */



public class Main {
    public static void main(String[] args) {
        // put your code here
        try {
        String temp;

        FileReader fr = new FileReader("./test1.txt");
        FileWriter wr = new FileWriter("./test2.txt");

        BufferedWriter  bw = new BufferedWriter(wr);
        BufferedReader br = new BufferedReader(fr);

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> words = new HashMap<String, Integer>();
        ArrayList<String> store = new ArrayList<String>();

            int array_i=0;

            try {
            while ((temp = br.readLine()) != null) {
                while (!temp.isEmpty()) {

                    int pos1 = temp.indexOf("\t");
                    String word = temp.substring(0,pos1);
                    String data = temp.substring(pos1+1,temp.length()-1);

                    if (store.isEmpty() || !store.contains(word)){
                        store.add(word);
                        store.add(data);
                        array_i = array_i+2;
                        words.put(word,1);
                    } else {
                        if (store.contains(word)) {
                            store.add(word);
                            store.add(data);
                            words.put(word,words.get(word)+1);
                        }
                    }
                    temp="";
                }
            }
                for (int i=0;i<store.size();i=i+2){


                     String final_string = store.get(i) + "#" + store.get(i+1).substring(0,store.get(i+1).indexOf(";")) + "\t" +
                             store.get(i+1).substring(store.get(i+1).indexOf(";")+1,store.get(i+1).length()-1) + "\t" + words.get(store.get(i)) + "\n";
                     System.out.println(final_string);
                     bw.write(final_string);
                     bw.flush();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

