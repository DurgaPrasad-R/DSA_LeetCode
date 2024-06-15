class Pair {
    int first;
    int second;

    Pair(int f,int s) {
        first = f;
        second = s;
    }
}
class StockSpanner {
    Stack<Pair> stocks;
    int idx = 0;
    public StockSpanner() {
        stocks = new Stack<>();
    }
    
    public int next(int price) {
        int c = 1;
        while(!stocks.isEmpty() && stocks.peek().second <= price) {
            stocks.pop();
        }
        if (!stocks.isEmpty()) {
            c = idx - (stocks.peek().first);
        } else {
            c = idx + 1;
        }
        stocks.add(new Pair(idx++,price));
        return c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */