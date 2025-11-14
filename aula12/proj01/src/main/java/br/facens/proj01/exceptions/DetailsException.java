package br.facens.proj01.exceptions;

public class DetailsException {
    private String title;
    private String detail;
    
    public DetailsException(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

}
