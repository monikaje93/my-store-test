package page.objects.registration;

public enum Title {
    MR ("Mr."),
    MRS ("Mrs.");

    private String titleText;

    private Title(String titleText) {
        this.titleText = titleText;
    }

    public String getTitleText() {
        return titleText;
    }
}
