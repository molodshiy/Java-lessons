import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
public class ValidatorSAXXSD {
    
    public static void main(String[ ] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "data/students.xml";
        String schemaName = "data/students.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            
            Schema schema = factory.newSchema(schemaLocation);

            Validator validator = schema.newValidator();

            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(filename + " is valid.");
        } catch (SAXException e) {
            System.err.print("validation "+ filename + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            System.err.print(filename + " is not valid because "
                    + e.getMessage());
        }
    }
}
