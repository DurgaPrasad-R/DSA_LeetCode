class DLL{
    String website;
    DLL next,prev;
    DLL(String url){
        website = url;
        next = null;
        prev = null;
    }
}
class BrowserHistory {
    DLL headTab = null,temp = null,tail = null;
    public BrowserHistory(String homepage) {
        DLL newNode = new DLL(homepage);
        headTab = newNode;
        tail = newNode;
        temp = newNode;
    }
    
    public void visit(String url) {
        DLL newNode = new DLL(url);
        tail = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        temp = newNode;
    }
    
    public String back(int steps) {
        int c = 0;
        String tab = "";
        while(temp!=null && temp.prev!=null){
            tab = temp.website;
            if (c == steps){
                return tab;
            }
            c+=1;
            temp = temp.prev;
        }
        return headTab.website;
    }
    
    public String forward(int steps) {
        int c = 0;
        String tab = "";
        while(temp!=null && temp.next!=null){
            tab = temp.website;
            if (c == steps){
                return tab;
            }
            c+=1;
            temp = temp.next;
        }
        return tail.website;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */