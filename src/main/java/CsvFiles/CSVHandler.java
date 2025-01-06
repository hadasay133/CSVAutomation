package CsvFiles;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    private final String filePath;

    // Constructor - מקבל את הנתיב של קובץ ה-CSV
    public CSVHandler(String filePath) {
        this.filePath = filePath;
    }

    // קריאת נתונים מקובץ CSV
    public List<String[]> readCSV() throws IOException, CsvValidationException {
        List<String[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            // קריאה תוך כדי טיפול בשגיאות אם יש
            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        }
        return data;
    }

    public String getWordByNumber(List<String[]>data,int line,int row){
        String [] lines= data.get(line);
        return lines[row];

    }

    // כתיבת נתונים לקובץ CSV
    public void writeCSV(List<String[]> data) throws IOException {
        // הגדרת try-with-resources עם CSVWriter
        try (CSVWriter writer = new CSVWriter(new BufferedWriter(new FileWriter(filePath)))) {
            writer.writeAll(data);
        }
    }

    // הוספת שורה לקובץ CSV
    public void appendToCSV(String[] newRow) throws IOException {
        // הגדרת try-with-resources עם append
        try (CSVWriter writer = new CSVWriter(new BufferedWriter(new FileWriter(filePath, true)))) {
            writer.writeNext(newRow);
        }
    }

    // בדיקה אם קובץ קיים או ריק
    public boolean isFileEmpty() {
        File file = new File(filePath);
        return file.exists() && file.length() == 0;
    }
}