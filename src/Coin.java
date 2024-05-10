public enum Coin{
    THOUSAND(1000), F_HUNDRED(500), HUNDRED(100);

    private int value;
    private Coin(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }
}