package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.service.impl.ClientSurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class CsvController {


    @Autowired
    private ClientSurveyServiceImpl clientSurveyService;

    @RequestMapping(value= "/surveys/export",method = RequestMethod.GET)

    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=surveys_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<ClientSurvey> listSurveys = clientSurveyService.listAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Survey ID", "Survey Name", "Survey Description",};
        String[] nameMapping = {"surveyId","surveyName","survey_description"};

        csvWriter.writeHeader(csvHeader);

        for (ClientSurvey clientSurvey : listSurveys) {
            csvWriter.write(clientSurvey, nameMapping);
        }

        csvWriter.close();

    }
}
