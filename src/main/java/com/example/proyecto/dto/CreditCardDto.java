package com.example.proyecto.dto;

public class CreditCardDto {
    private String card_number;
    private String expiration_date;
    private String cvv;
    public CreditCardDto(String card_number, String expiration_date, String cvv) {
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.cvv = cvv;
    }
    public String getCard_number() {
        return card_number;
    }
    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }
    public String getExpiration_date() {
        return expiration_date;
    }
    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
