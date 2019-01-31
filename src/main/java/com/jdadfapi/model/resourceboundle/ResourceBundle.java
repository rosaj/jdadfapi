package com.jdadfapi.model.resourceboundle;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 03-Jan-18
 * Time: 13:50
 */

public class ResourceBundle {
    private File file;
    private Map<String, String> entries = new LinkedHashMap<>();
    private String name;
    public enum Operation{
        CONTAINS,
        STARTSWITH,
        ENDSWIDTH,
        EQUAL
    }

    public ResourceBundle(File file) {
        this.file = file;
        readFile();
        name = file.getName().replace(".properties", "");
    }

    private void readFile(){

        try (InputStreamReader fin = new InputStreamReader(new FileInputStream(file.getAbsolutePath()), Charset.defaultCharset());

             BufferedReader in = new BufferedReader(fin)) {

            String line;
            while ((line = in.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("#")) {

                    int eqIndex = line.indexOf("=");
                    if(eqIndex>0){

                        String key = line.substring(0, eqIndex);
                        String value = line.substring(eqIndex + 1);
                       // System.out.println(key+"="+value);
                        entries.put(key.trim(), value.trim());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String get(String key){
        return entries.get(key);
    }

    public String getName() {
        return name;
    }

    public List<String> getKeysByText(String text, Operation operation) {
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, String> e : entries.entrySet()) {

            switch (operation) {
                case EQUAL: {
                    if(e.getValue().equals(text))keys.add(e.getKey());
                    break;
                }
                case CONTAINS: {
                    if(e.getValue().contains(text))keys.add(e.getKey());
                    break;
                }
                case ENDSWIDTH: {
                    if(e.getValue().endsWith(text))keys.add(e.getKey());
                    break;
                }
                case STARTSWITH: {
                    if(e.getValue().startsWith(text))keys.add(e.getKey());
                    break;
                }
            }

        }

        return keys;
    }

    public Map<String, String> getEntries() {
        return entries;
    }
    public void setText(String key, String text){
        entries.put(key, text);
    }
    public void save(){

        try (PrintWriter  fos = new PrintWriter (file,Charset.defaultCharset().name())){

            for(Map.Entry entry : entries.entrySet()){
                fos.write(entry.getKey()+"="+entry.getValue()+"\n");
            }
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
