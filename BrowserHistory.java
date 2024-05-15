class Node {
    String url;
    Node prev;
    Node next;

    public Node(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

public class BrowserHistory {
    private Node current;
    
    public BrowserHistory(String homepage) {
        this.current = new Node(homepage);
    }
    
    public void goTo(String url) {
        Node newNode = new Node(url);
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
    }
    
    public boolean goBack() {
        if (current.prev != null) {
            current = current.prev;
            return true;
        }
        return false;
    }
    
    public boolean goForward() {
        if (current.next != null) {
            current = current.next;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("https://www.example.com");

        history.goTo("https://www.google.com");
        history.goTo("https://www.openai.com");

        System.out.println("Current URL: " + history.current.url);

        history.goBack();
        System.out.println("After going back, Current URL: " + history.current.url);

        history.goForward();
        System.out.println("After going forward, Current URL: " + history.current.url);
    }
}

/* Doubly Linked list is suitable because it allows traversal in both directions */
