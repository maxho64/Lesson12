package com.company;

import java.io.*;

public class Main {
    private static final String ABSOLUTE_PATH = "C:\\Users\\Aleksei_Makhankov\\Desktop\\Lessons\\Lesson12\\files";
    private static final String RELATIVE_PATH = "files";
    private static final String NOT_EXISTS_PATH = "notfiles";

    public static void main(String[] args) {
          Dog dog = new Dog("Zuchka", 3);
          ObjectInputStream inputStream = null;
          ObjectOutputStream outputStream = null;

          try {
              FileOutputStream fileOutputStream =
                      new FileOutputStream(RELATIVE_PATH + "\\" + "serialize.txt");
              outputStream = new ObjectOutputStream(fileOutputStream);
              outputStream.writeObject(dog);
              FileInputStream fileInputStream =
                      new FileInputStream(RELATIVE_PATH + "\\" + "serialize.txt");
              inputStream = new ObjectInputStream(fileInputStream);
              Dog deserializedDog = (Dog) inputStream.readObject();
              System.out.println("Dog name " + deserializedDog.getName());
              System.out.println("Dog age " + deserializedDog.getAge());

          } catch (IOException | ClassNotFoundException ex){
              ex.printStackTrace();
          }  finally {
              try {
                  if (inputStream != null) {
                      inputStream.close();
                  }
                  if (outputStream != null) {
                      outputStream.close();
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
    }

    public static void charStream(){
        try (FileWriter writer =
                     new FileWriter(
                             RELATIVE_PATH + "\\" + "writer.txt")) {
            String text = "This is file writer";
            writer.write(text);
            writer.append("\t");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try(FileReader reader = new FileReader(
                RELATIVE_PATH + "\\" + "writer.txt")){
            int c;
            while ((c = reader.read()) != -1){
                System.out.print(((char) c));
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void bufferedStream() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String data = "This is Byte array input stream.";
        try {
            inputStream = new BufferedInputStream(new ByteArrayInputStream(data.getBytes()));
            outputStream = new BufferedOutputStream(new FileOutputStream(RELATIVE_PATH + "\\" + "from_input"));
            byte[] buffer = new byte[1000];

            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void byteStream() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String data = "This is Byte array input stream.";

        try {
            inputStream = new ByteArrayInputStream(data.getBytes());
            outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1000];

            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }

            int c;
            System.out.println("Input:");
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }

            System.out.println();
            System.out.println("Output:");
            for (byte b : ((ByteArrayOutputStream) outputStream).toByteArray()) {
                System.out.print((char) b);
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void file() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(RELATIVE_PATH + "\\" + "from.txt");
            outputStream = new FileOutputStream(RELATIVE_PATH + "\\" + "to.txt", true);
            byte[] buffer = new byte[1000];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void files() {
        File existAbsoluteDirectory =
                new File(ABSOLUTE_PATH);
        File existAbsoluteFile =
                new File(ABSOLUTE_PATH, "from.txt");
        File existRelativeFile =
                new File(RELATIVE_PATH, "from.txt");
        File notExistRelativeFile =
                new File(NOT_EXISTS_PATH);
        System.out.println("existAbsoluteDirectory = "
                + existAbsoluteDirectory.getName());
        System.out.println("existAbsoluteFile = "
                + existAbsoluteFile.getName());
        System.out.println("existRelativeFile = "
                + existRelativeFile.getName());
        System.out.println("notExistRelativeFile = "
                + notExistRelativeFile.getName());

        System.out.println("existAbsoluteDirectory = "
                + existAbsoluteDirectory.getAbsolutePath());
        System.out.println("existAbsoluteFile = "
                + existAbsoluteFile.getAbsolutePath());
        System.out.println("existRelativeFile = "
                + existRelativeFile.getAbsolutePath());
        System.out.println("notExistRelativeFile = "
                + notExistRelativeFile.getAbsolutePath());
        System.out.println("existAbsoluteDirectory = "
                + existAbsoluteDirectory.getParentFile());
        System.out.println("existAbsoluteFile = "
                + existAbsoluteFile.getParentFile());
        System.out.println("existRelativeFile = "
                + existRelativeFile.getParentFile());
        System.out.println("notExistRelativeFile = "
                + notExistRelativeFile.getParentFile());
        System.out.println("existAbsoluteDirectory = "
                + existAbsoluteDirectory.exists());
        System.out.println("existAbsoluteFile = "
                + existAbsoluteFile.exists());
        System.out.println("existRelativeFile = "
                + existRelativeFile.exists());
        System.out.println("notExistRelativeFile = "
                + notExistRelativeFile.exists());
        System.out.println("existAbsoluteDirectory = "
                + existAbsoluteDirectory.isFile());
        System.out.println("existAbsoluteFile = "
                + existAbsoluteFile.isFile());
        System.out.println("existRelativeFile = "
                + existRelativeFile.isFile());
        System.out.println("notExistRelativeFile = "
                + notExistRelativeFile.isFile());
        System.out.println("existAbsoluteDirectory = "
                + existAbsoluteDirectory.isDirectory());
        System.out.println("existAbsoluteFile = "
                + existAbsoluteFile.isDirectory());
        System.out.println("existRelativeFile = "
                + existRelativeFile.isDirectory());
        System.out.println("notExistRelativeFile = "
                + notExistRelativeFile.isDirectory());
        System.out.println("existAbsoluteDirectory = "
                + existAbsoluteDirectory.isAbsolute());
        System.out.println("existAbsoluteFile = "
                + existAbsoluteFile.isAbsolute());
        System.out.println("existRelativeFile = "
                + existRelativeFile.isAbsolute());
        System.out.println("notExistRelativeFile = "
                + notExistRelativeFile.isAbsolute());
        System.out.println("existAbsoluteDirectory = "
                + existAbsoluteDirectory.isHidden());
        System.out.println("existAbsoluteFile = "
                + existAbsoluteFile.isHidden());
        System.out.println("existRelativeFile = "
                + existRelativeFile.isHidden());
        System.out.println("notExistRelativeFile = "
                + notExistRelativeFile.isHidden());
    }
}

class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
