package page.objects;

public enum Country {
    UNITED_STATES("United States");

    private String visibleText;

    private Country(String visibleText) {
        this.visibleText = visibleText;
    }

    public String getVisibleText() {
        return visibleText;
    }
}
