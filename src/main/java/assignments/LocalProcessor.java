package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period;// = 10000000000000L;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    //  private LinkedList<String> stringArrayList = new LinkedList<>();
    StringBuilder stringArrayList = new StringBuilder();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, StringBuilder stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        // stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorGenerator(LinkedList<String> stringList) {
//        for (int i = 0; i < stringArrayList.size(); i++) {
//            processorName+=stringList.get(i)+' ';
//        }
        StringBuilder sb = new StringBuilder();
        sb.append(stringList.get(0));
        for (String string : stringList) {
            sb.append(" ").append(string);
        }
        processorName = sb.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (informationScanner.hasNext()) {
            sb.append(informationScanner.nextLine());
            // processorVersion += informationScanner.nextLine();
        }
        processorVersion = sb.toString();
    }
}
