import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class StudentErrorHandler extends DefaultHandler {

    private Logger logger = Logger.getLogger("UnitXML");

    public StudentErrorHandler(String log) throws IOException{
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e);
    }

    private String getLineAddress(SAXParseException e){
        return e.getLineNumber() + " : " +e.getColumnNumber();
    }
}
