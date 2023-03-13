package jsonDTO;

public class NewInvoiceData {
    String companyName;
    String city;
    String adressName;
    String itemName;
    String qty;
    String price;







    public NewInvoiceData(String companyName, String city, String adressName, String itemName, String qty, String price)
    {
        this.companyName = companyName;
        this.city = city;
        this.adressName = adressName;
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCity() {
        return city;
    }

    public String getAdressName() {
        return adressName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getQty() {
        return qty;
    }
    public String getPrice() {
        return price;
    }



}


