import java.io.*;

public class FileInOut {
    
    public static void main(String[] args) {
        String byteFilePath = "byteFile.dat";
        String charFilePath = "charFile.txt";
        String bufferedFilePath = "bufferedFile.txt";

        writeByteStream(byteFilePath);
        readByteStream(byteFilePath);

        writeCharStream(charFilePath);
        readCharStream(charFilePath);

        writeBufferedWriter(bufferedFilePath);
        readBufferedReader(bufferedFilePath);
    }

    public static void writeByteStream(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            String data = "This is a byte stream example.";
            fos.write(data.getBytes());
            System.out.println("Byte stream: Data written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readByteStream(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int content;
            System.out.print("Byte stream: Data read from " + filePath + ": ");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCharStream(String filePath) {
        try (FileWriter fw = new FileWriter(filePath)) {
            String data = "This is a character stream example.";
            fw.write(data);
            System.out.println("Character stream: Data written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCharStream(String filePath) {
        try (FileReader fr = new FileReader(filePath)) {
            int content;
            System.out.print("Character stream: Data read from " + filePath + ": ");
            while ((content = fr.read()) != -1) {
                System.out.print((char) content);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBufferedWriter(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            String data = "This is a buffered writer example.";
            bw.write(data);
            System.out.println("BufferedWriter: Data written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBufferedReader(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.print("BufferedReader: Data read from " + filePath + ": ");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
