package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class HtmlView implements View
{
    private Controller controller;
    private final String filePath =
            "./src/" +
            this.getClass().getPackage().getName().replaceAll("\\.", "/") +
            "/vacancies.html";

    public void userCitySelectEmulationMethod() throws IOException
    {
        controller.onCitySelect("kiev");
    }

    @Override
    public void update(List<Vacancy> vacancies)
    {
        updateFile(getUpdatedFileContent(vacancies));
    }

    protected Document getDocument() throws IOException
    {
        File file = new File(filePath);
        return Jsoup.parse(file, "UTF-8");
    }

    private String getUpdatedFileContent(List<Vacancy> list)
    {
        Document document = null;
        String fileContent = null;
        try
        {
            document = getDocument();   //sama stranichka

            Elements elements = document.getElementsByClass("template");    //element documenta s template
            Element templateElement = elements.get(0);
            Element tag = templateElement.clone();      //shablon dlya zapolneniya vakansii

            tag.removeClass("template");
            tag.removeAttr("style");
            document.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : list)
            {
                Element vacancyElement = tag.clone();
                vacancyElement.getElementsByClass("city").get(0).text(vacancy.getCity());
                vacancyElement.getElementsByClass("companyName").get(0).text(vacancy.getCompanyName());
                vacancyElement.getElementsByClass("salary").get(0).text(vacancy.getSalary());

                Element link = vacancyElement.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                templateElement.before(vacancyElement.outerHtml()); // добавляем все вакансии перед templateElement
            }
            fileContent = document.html();  //poluchaem soderzhimoe stranici v stroku
            //System.out.println(fileContent);
        } catch(IOException e)
        {fileContent = "Some exception occurred";}

        return fileContent;
    }

    private void updateFile(String string)
    {
        //Он принимает тело файла в виде строки. Нужно его записать в файл, который находится по пути filePath.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write(string);
            writer.flush();
        }
        catch (IOException e)
        {}
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
}
