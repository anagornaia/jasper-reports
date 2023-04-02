package org.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.example.domain.Item;
import org.springframework.ui.jasperreports.JasperReportsUtils;

public class ReportGenerationService {

    /* User home directory location */
    private final String USER_HOME_DIRECTORY = System.getProperty("user.dir");
    /* Output file location */
    private final String OUTPUT_FILE =
        USER_HOME_DIRECTORY + File.separatorChar + LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")) + "JasperTableExample.pdf";
    private final String TEMPLATE_PATH = USER_HOME_DIRECTORY + "\\src\\main\\resources\\template.jrxml";

    public void printReport(List<Item> listItems) {
        try {
            Map<String, Object> parameters = getParameters(listItems);
            JasperReport jasperReport = getJasperReport();

            /* outputStream to create PDF */
            OutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
            /* Write content to PDF file */
            JasperReportsUtils.renderAsPdf(jasperReport, parameters, new JREmptyDataSource(), outputStream);

            System.out.println("File Generated");
        } catch (JRException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private JasperReport getJasperReport() throws FileNotFoundException, JRException {
        InputStream reportInputStream = new FileInputStream(TEMPLATE_PATH);
        JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);
        return JasperCompileManager.compileReport(jasperDesign);
    }

    private Map<String, Object> getParameters(List<Item> listItems) {
        /* Convert List to JRBeanCollectionDataSource */
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ItemDataSource", itemsJRBean);
        return parameters;
    }

}
