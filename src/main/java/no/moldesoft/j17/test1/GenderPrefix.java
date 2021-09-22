package no.moldesoft.j17.test1;

public enum GenderPrefix {
    MR("Mr."), MS("Ms."), MISS("Miss"), MRS("Mrs.");

    private String displayable;

    GenderPrefix(String displayable) {
        this.displayable = displayable;
    }

    @Override
    public String toString() {
        return displayable;
    }
}
