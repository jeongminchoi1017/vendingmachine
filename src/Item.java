public enum Item {
    COKE(700), PEPSI(800), SPRITE(900);

    private int price;
    
    private Item(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
