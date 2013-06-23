package org.celllife.idart.integration.hl7;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 18h29
 */
public final class Hl7CodeFileReader {

    public static CodeFile readFile(String sheetName,
                                    InputStream inputStream) {

        XLSReader xlsReader = getXlsReader();
        Map<String, Object> sheetReaders = xlsReader.getSheetReaders();
        Object sheetReader = sheetReaders.get(null);
        sheetReaders.clear();
        sheetReaders.put(sheetName, sheetReader);

        Map<String, Object> beans = new HashMap<>();

        CodeFile codeFile = new CodeFile();
        beans.put("codeFile", codeFile);

        XLSReadStatus xlsReadStatus = read(xlsReader, inputStream, beans);

        if (xlsReadStatus.isStatusOK()) {
            return codeFile;
        }

        return null;
    }

    private static XLSReadStatus read(XLSReader xlsReader, InputStream inputStream, Map<String, Object> beans) {
        try {
            return xlsReader.read(new BufferedInputStream(inputStream), beans);
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private static XLSReader getXlsReader() {
        InputStream inputXML = Hl7CodeFileReader.class.getResourceAsStream("/META-INF/jxls/hl7.xml");
        return getXlsReader(inputXML);
    }

    private static XLSReader getXlsReader(InputStream inputStream) {
        try {
            return ReaderBuilder.buildFromXML(new BufferedInputStream(inputStream));
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

}
