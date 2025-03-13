package pages;

import utility.SeleniumBase;

public class AllPages{

    public AllPages(){

    }

    //In Java, every class can have a return type.
    //We created a private instance with each page class return type.

    public SeleniumBase lib=new SeleniumBase();
    private HouseOfTestHomePage houseOfTestHomePage;
    private HouseOfTestServicesPage houseOfTestServicesPage;
    private HouseOfTestBlogsPage houseOfTestBlogsPage;
    private HouseOfTestContactUsPage houseOfTestContactUsPage;

    //We will create a public method and create an object in each page class.

    public HouseOfTestHomePage houseOfTestHomePage(){
        if (houseOfTestHomePage ==null){
            houseOfTestHomePage =new HouseOfTestHomePage();
        }
        return houseOfTestHomePage;
    }

    public HouseOfTestServicesPage houseOfTestServices(){
        if (houseOfTestServicesPage ==null){
            houseOfTestServicesPage =new HouseOfTestServicesPage();
        }

        return houseOfTestServicesPage;
    }

    public HouseOfTestBlogsPage housOfTestBlogsPage(){
        if (houseOfTestBlogsPage ==null){
            houseOfTestBlogsPage =new HouseOfTestBlogsPage();
        }

        return houseOfTestBlogsPage;
    }

    public HouseOfTestContactUsPage houseOfTestContactUsPage(){
        if (houseOfTestContactUsPage ==null){
            houseOfTestContactUsPage =new HouseOfTestContactUsPage();
        }

        return houseOfTestContactUsPage;
    }

}
