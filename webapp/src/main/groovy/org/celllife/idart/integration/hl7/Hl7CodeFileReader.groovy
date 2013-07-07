package org.celllife.idart.integration.hl7

import net.sf.jxls.reader.ReaderBuilder
import net.sf.jxls.reader.XLSReadStatus
import net.sf.jxls.reader.XLSReader
import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.xml.sax.SAXException

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 18h29
 */
class Hl7CodeFileReader {

    static CodeFile readFile(String sheetName, InputStream inputStream) {

        XLSReader xlsReader = getXlsReader()
        Map<String, Object> sheetReaders = xlsReader.sheetReaders
        Object sheetReader = sheetReaders.get(null)
        sheetReaders.clear()
        sheetReaders.put(sheetName, sheetReader)

        Map<String, Object> beans = new HashMap<>()

        CodeFile codeFile = new CodeFile()
        beans.put("codeFile", codeFile)

        XLSReadStatus xlsReadStatus = read(xlsReader, inputStream, beans)

        if (xlsReadStatus.statusOK) {
            return codeFile
        }

        return null
    }

    static XLSReadStatus read(XLSReader xlsReader, InputStream inputStream, Map<String, Object> beans) {
        try {
            return xlsReader.read(new BufferedInputStream(inputStream), beans)
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e)
        }
    }

    static XLSReader getXlsReader() {
        InputStream inputXML = Hl7CodeFileReader.class.getResourceAsStream("/META-INF/jxls/hl7.xml")
        return getXlsReader(inputXML)
    }

    static XLSReader getXlsReader(InputStream inputStream) {
        try {
            return ReaderBuilder.buildFromXML(new BufferedInputStream(inputStream))
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e)
        }
    }
}
