package com.javarush.test.level28.lesson15.big01.vo;


public class Vacancy

{
    /*
    3. Что есть у вакансии?
Название, зарплата, город, название компании, название сайта, на котором вакансия найдена, ссылка на вакансию.
В классе Vacancy создай соответствующие строковые поля: title, salary, city, companyName, siteName, url.

4. Создай геттеры и сеттеры для всех полей класса Vacancy.

5. В пакете model создай класс HHStrategy от Strategy.
Этот класс будет реализовывать конкретную стратегию работы с сайтом ХэдХантер (http://hh.ua/ и http://hh.ru/).
     */
    private String title;
    private String salary;
    private String city;
    private String companyName;
    private String siteName;
    private String url;

    public String getTitle()
    {
        return title;
    }

    public String getSalary()
    {
        return salary;
    }

    public String getCity()
    {
        return city;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public String getSiteName()
    {
        return siteName;
    }

    public String getUrl()
    {
        return url;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;

        if (title != null ? !title.equals(vacancy.title) : vacancy.title != null) return false;
        if (salary != null ? !salary.equals(vacancy.salary) : vacancy.salary != null) return false;
        if (city != null ? !city.equals(vacancy.city) : vacancy.city != null) return false;
        if (companyName != null ? !companyName.equals(vacancy.companyName) : vacancy.companyName != null) return false;
        if (siteName != null ? !siteName.equals(vacancy.siteName) : vacancy.siteName != null) return false;
        return url != null ? url.equals(vacancy.url) : vacancy.url == null;

    }

    @Override
    public int hashCode()
    {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}