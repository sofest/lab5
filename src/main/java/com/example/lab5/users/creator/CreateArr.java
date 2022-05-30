package com.example.lab5.users.creator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class CreateArr {

    private String[] arrMNames;
    private String[] arrMMiddle;
    private String[] arrMSurnames;
    private String[] arrProfSurnames;
    private String[] arrWNames;
    private String[] arrWMiddle;

    public String[] getArrProfSurnames() {
        return arrProfSurnames;
    }

    public String[] getArrMNames() {
        return arrMNames;
    }

    public String[] getArrWNames() {
        return arrWNames;
    }

    public String[] getArrMSurnames() {
        return arrMSurnames;
    }

    public String[] getArrMMiddle() {
        return arrMMiddle;
    }

    public String[] getArrWMiddle() {
        return arrWMiddle;
    }

    public void setAll(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        arrMNames = read(workbook, 0);
        arrWNames = read(workbook, 1);
        arrMSurnames = read(workbook, 2);
        arrProfSurnames = read(workbook, 3);
        arrMMiddle = setMMiddle();
        arrWMiddle = setWMiddle();
        workbook.close();
    }

    public String[] read(XSSFWorkbook workbook, int num) {  //массив из данных той страницы, номер которой мы передали
        XSSFSheet sheet = workbook.getSheetAt(num);
        String[] arr = new String[sheet.getLastRowNum() + 1];
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0) != null) {
                arr[i] = sheet.getRow(i).getCell(0).getStringCellValue();
            }
        }
        Collections.shuffle(Collections.singletonList(arr));
        return arr;
    }

    public String[] setMMiddle() {
        String[] arrMMiddle = new String[arrMNames.length];
        int i = 0;
        for (String name : arrMNames) {
            if (name.endsWith("ья")) {
                arrMMiddle[i] = name.substring(0, name.length() - 1) + "ич";
            } else if (name.endsWith("ж") || name.endsWith("ш") || name.endsWith("ч") || name.endsWith("щ") || name.endsWith("ц") || name.endsWith("и") || name.endsWith("э") || name.endsWith("я") || name.endsWith("ю") || name.endsWith("е") || name.endsWith("ё")) {
                arrMMiddle[i] = name + "евич";
            } else if (name.endsWith("н") || name.endsWith("р") || name.endsWith("м") || name.endsWith("л") || name.endsWith("с") || name.endsWith("б")) {
                arrMMiddle[i] = name + "ович";
            } else if (name.endsWith("а") || name.endsWith("у") || name.endsWith("ы")) {
                arrMMiddle[i] = name.substring(0, name.length() - 1) + "ович";
            } else if (name.endsWith("о")) {
                arrMMiddle[i] = name.substring(0, name.length() - 1) + "вич";
            } else if (name.endsWith("ь")) {
                arrMMiddle[i] = name.substring(0, name.length() - 1) + "евич";
            } else if (name.endsWith("й")) {
                arrMMiddle[i] = name.substring(0, name.length() - 1) + "евич";
            } else {
                arrMMiddle[i] = name + "евич";
            }
            i++;
        }
        return arrMMiddle;
    }

    public String[] setWMiddle() {
        String[] arrWMiddle = new String[arrMNames.length];
        int i = 0;
        for (String name : arrMNames) {
            if (name.endsWith("ья")) {
                arrWMiddle[i] = name.substring(0, name.length() - 1) + "инична";
            } else if (name.endsWith("й")) {
                arrWMiddle[i] = name.substring(0, name.length() - 1) + "евна";
            } else if (name.endsWith("ел")) {
                arrWMiddle[i] = name.substring(0, name.length() - 2) + "ловна";
            } else if (name.endsWith("ж") || name.endsWith("ш") || name.endsWith("ч") || name.endsWith("щ") || name.endsWith("ц") || name.endsWith("и") || name.endsWith("э") || name.endsWith("я") || name.endsWith("ю") || name.endsWith("е") || name.endsWith("ё")) {
                arrWMiddle[i] = name + "евна";
            } else if (name.endsWith("н") || name.endsWith("р") || name.endsWith("м") || name.endsWith("л") || name.endsWith("с") || name.endsWith("б") || name.endsWith("к") || name.endsWith("в")) {
                arrWMiddle[i] = name + "овна";
            } else if (name.endsWith("а") || name.endsWith("у") || name.endsWith("ы")) {
                arrWMiddle[i] = name.substring(0, name.length() - 1) + "овна";
            } else if (name.endsWith("о")) {
                arrWMiddle[i] = name.substring(0, name.length() - 1) + "вна";
            } else if (name.endsWith("ь")) {
                arrWMiddle[i] = name.substring(0, name.length() - 1) + "евна";
            } else {
                arrWMiddle[i] = name + "евна";
            }
            i++;
        }
        return arrWMiddle;
    }

    public String randomWSurname(String surname) {
        String wSurname = "";
        if (surname.endsWith("в") || surname.endsWith("н")) {
            wSurname = surname + "а";
        } else if (surname.endsWith("ий")) {
            wSurname = surname.substring(0, surname.length() - 2) + "ая";
        } else {
            wSurname = surname;
        }
        return wSurname;
}
}
